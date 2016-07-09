package karen.core.listfoot;

import karen.core.listfoot.enums.HowToSeeEnum;
import lights.core.payload.response.IPayloadResponse;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listfooter;

public class ListFoot extends Listfooter {

	private static final long serialVersionUID = 4288284476361293693L;

	private Button btnFirstPage;
	private Button btnPreviousPage;
	private Label lblPagina;
	private Button btnNextPage;
	private Button btnLastPage;
	private Button btnRefresh;
	private Button btnHowSeeData;
	private Div divButtons;
	
	private Div divRegisters;
	private Label lblRegisters;

	private Integer page = 0;

	private Integer totalPages = 0;
	
	private HowToSeeEnum howToSeeCurrent = HowToSeeEnum.NORMAL;

	public ListFoot() {
		createComponents();
		addComponents();
		addEvents();
	}

	public void createComponents() {
//		this.getChildren().clear();
		
		divButtons = new Div();
		divButtons.setSclass("col s6 left");
		
		btnFirstPage = new Button("");
		btnFirstPage.setIconSclass("fa fa-step-backward");
		btnFirstPage.setSclass("btn-pagination circle");
		btnFirstPage.setTooltiptext("Primera Página");
//		divButtons.getChildren().add(btnFirstPage);
		
		btnPreviousPage = new Button("");
		btnPreviousPage.setIconSclass("fa fa-caret-left");
		btnPreviousPage.setSclass("btn-pagination circle");
		btnPreviousPage.setTooltiptext("Página Anterior");
//		divButtons.getChildren().add(btnPreviousPage);
		
		lblPagina = new Label("");
		lblPagina.setSclass("pagination-letter");
//		divButtons.getChildren().add(lblPagina);
		
		btnNextPage = new Button("");
//		btnNextPage.setIconSclass("fa fa-caret-right");
		btnNextPage.setSclass("btn-pagination circle");
//		divButtons.getChildren().add(btnNextPage);
		
		btnLastPage = new Button("");
		btnLastPage.setIconSclass("fa fa-step-forward");
		btnLastPage.setSclass("btn-pagination circle");
		btnLastPage.setTooltiptext("Última Página");
//		divButtons.getChildren().add(btnLastPage);
			
//		this.getChildren().add(divButtons);
		
		divRegisters = new Div();
		divRegisters.setSclass("col s6 right");
		
		lblRegisters = new Label("");
		lblRegisters.setSclass("pagination-registros");
		divRegisters.getChildren().add(lblRegisters);
		
		btnRefresh = new Button("");
		btnRefresh.setIconSclass("fa fa-refresh");
		btnRefresh.setSclass("btn-listfoot-right circle");
		btnRefresh.setTooltiptext("Actualizar");
		divRegisters.getChildren().add(btnRefresh);
		
		btnHowSeeData = new Button("");	
		btnHowSeeData.setSclass("btn-listfoot-right circle");
		
//		if (howToSeeCurrent.equals(PAGINATION)) {
//			btnHowSeeData.setIconSclass("fa fa-sort-amount-asc");
//			btnHowSeeData.setTooltiptext("Cambiar al modo 'Paginación Extendida'");
//		} else {//EXTENDED
//			btnHowSeeData.setIconSclass("fa fa-list");
//			btnHowSeeData.setTooltiptext("Cambiar al modo 'Paginación Normal'");
//		}
		
		divRegisters.getChildren().add(btnHowSeeData);
	}
	
	private void addComponents() {
		this.getChildren().clear();
		divButtons.getChildren().clear();
		
		if (howToSeeCurrent.equals(HowToSeeEnum.NORMAL)) {
			divButtons.getChildren().add(btnFirstPage);
			divButtons.getChildren().add(btnPreviousPage);
			divButtons.getChildren().add(lblPagina);
			divButtons.getChildren().add(btnNextPage);
			divButtons.getChildren().add(btnLastPage);
			
			btnNextPage.setTooltiptext("Página Siguiente");
			btnNextPage.setIconSclass("fa fa-caret-right");
			btnHowSeeData.setIconSclass("fa fa-sort-amount-asc");
			btnHowSeeData.setTooltiptext("Cambiar al modo 'Paginación Extendida'");
		} else {//EXTENDED
			divButtons.getChildren().add(btnNextPage);
			
			btnNextPage.setTooltiptext("Ver Página Siguiente");
			btnNextPage.setIconSclass("fa fa-caret-down");
			btnHowSeeData.setIconSclass("fa fa-list");
			btnHowSeeData.setTooltiptext("Cambiar al modo 'Paginación Normal'");
		}
		
		this.getChildren().add(divButtons);
		this.getChildren().add(divRegisters);
	}

	private void addEvents() {
		btnFirstPage.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event event) throws Exception {
				firstPage();
			}
		});
		
		btnRefresh.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event event) throws Exception {
				firstPage();
			}
		});
		
		btnNextPage.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event event) throws Exception {
				nextPage();
			}
		});
		
		btnPreviousPage.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event event) throws Exception {
				previousPage();
			}
		});
		
		btnLastPage.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event event) throws Exception {
				lastPage();
			}
		});
		
		btnHowSeeData.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event event) throws Exception {
				changeHowToSeeData();
			}
		});
	}
	
	public void changeHowToSeeData() {
		if (howToSeeCurrent.equals(HowToSeeEnum.NORMAL)) {
			howToSeeCurrent = HowToSeeEnum.EXTENDED;
		} else {//EXTENDED
			howToSeeCurrent = HowToSeeEnum.NORMAL;
		}
		
		addComponents();
		firstPageOnChangeHowToSeeData();
	}

	private void lanzarEvento() {
		Events.postEvent("onClickPaginacion", this, page);
	}

	public void nextPage() {
		page = page + 1;
		
		lanzarEvento();
	}

	public void previousPage() {
		page = page - 1;
		
		lanzarEvento();
	}

	public void firstPage() {
		page = 1;

		lanzarEvento();
	}

	public void lastPage() {
		page = totalPages;
		
		lanzarEvento();
	}
	
	public void firstPageOnChangeHowToSeeData() {
		if (page == 1) {
			return;
		}
		
		page = 1;

		lanzarEvento();
	}
	
	@SuppressWarnings("rawtypes")
	public void updateFooter(IPayloadResponse payload) {
		try {
			
			totalPages = ((Double) payload.getInformacion("totalPaginas")).intValue();
			Integer totalElementsInTable = 0;
			Integer totalElementsReturned = 0;
			Integer totalElementsByPage = 0;
			Boolean firstPage = true;
			Boolean lastPage = true;
			page = 0;
	
			if (totalPages == null) {
				totalPages = new Integer(0);
			}
			
			if (totalPages > 0) {
				page = ((Double) payload.getInformacion("page")).intValue();
	
				totalElementsReturned = ((Double) payload.getInformacion("totalElementsReturned")).intValue();
	
				totalElementsInTable = ((Double) payload.getInformacion("totalElementsInTable")).intValue();
	
				firstPage = new Boolean(String.valueOf(payload.getInformacion("firstPage")));
	
				lastPage = new Boolean(String.valueOf(payload.getInformacion("lastPage")));
				
				totalElementsByPage = ((Double) payload.getInformacion("totalElementsByPage")).intValue();
			}
			
			if (howToSeeCurrent.equals(HowToSeeEnum.NORMAL)) {
				if (totalElementsReturned == 0) {
					btnFirstPage.setVisible(false);
					btnPreviousPage.setVisible(false);
					btnLastPage.setVisible(false);
					btnNextPage.setVisible(false);
					lblPagina.setValue("");
					
					lblRegisters.setValue("La consulta no ha devuelto registros");
					return;
				} else {
					btnFirstPage.setVisible(true);
					btnPreviousPage.setVisible(true);
					btnLastPage.setVisible(true);
					btnNextPage.setVisible(true);
				}
		
				btnFirstPage.setDisabled(firstPage);
				btnPreviousPage.setDisabled(firstPage);
				
				btnLastPage.setDisabled(lastPage);
				btnNextPage.setDisabled(lastPage);
				
				lblPagina.setValue(page + "/ " + totalPages);
				
				lblRegisters.setValue("");
				
				if (page > 0) {
					lblRegisters.setValue((page * totalElementsByPage - totalElementsByPage + 1) 
							+ " - " + (page * totalElementsByPage - totalElementsByPage + totalElementsReturned) 
							+ " de " + totalElementsInTable + " registros");
				}
			} else {//EXTENDED
				if (totalElementsReturned == 0) {
					btnNextPage.setVisible(false);
					
					lblRegisters.setValue("La consulta no ha devuelto registros");
					return;
				} else {
					btnNextPage.setVisible(true);
				}
				
				btnNextPage.setDisabled(lastPage);
				
				if (page > 0) {
					lblRegisters.setValue("1" 
							+ " - " + (page * totalElementsByPage - totalElementsByPage + totalElementsReturned) 
							+ " de " + totalElementsInTable + " registros");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			btnFirstPage.setVisible(false);
			btnPreviousPage.setVisible(false);
			btnLastPage.setVisible(false);
			btnNextPage.setVisible(false);
			lblPagina.setValue("");
			btnRefresh.setVisible(false);
			btnHowSeeData.setVisible(false);
			
			lblRegisters.setValue("Ha ocurrido un error. La consulta no ha devuelto registros");
		}
	}

	public HowToSeeEnum getHowToSeeCurrent() {
		return howToSeeCurrent;
	}

	public void setHowToSeeCurrent(HowToSeeEnum howToSeeCurrent) {
		this.howToSeeCurrent = howToSeeCurrent;
	}
	
}
