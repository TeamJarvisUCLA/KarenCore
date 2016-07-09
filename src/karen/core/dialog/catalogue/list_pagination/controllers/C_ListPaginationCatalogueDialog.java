package karen.core.dialog.catalogue.list_pagination.controllers;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;

import karen.core.crux.alert.Alert;
import karen.core.dialog.catalogue.list_pagination.viewmodels.VM_ListPaginationCatalogueDialog;
import karen.core.dialog.catalogue.simple_list.controllers.C_SimpleListCatalogueDialog;
import karen.core.listfoot.ListFoot;
import karen.core.listfoot.enums.HowToSeeEnum;
import karen.core.util.payload.UtilPayload;
import lights.core.payload.response.IPayloadResponse;

@SuppressWarnings({"rawtypes", "unchecked"})
public class C_ListPaginationCatalogueDialog<T> extends C_SimpleListCatalogueDialog<T> {

	private static final long serialVersionUID = -7940839132743344124L;
	
	protected ListFoot listFoot;
	
	public static final Integer CANTIDAD_REGISTROS_PAGINA_DEFECTO = 10;
	
	@Override
	public void doOnCreate() {
		super.doOnCreate();
		updateListBoxAndFooter();
	}
	
	public void updateListBoxAndFooter() {
		HowToSeeEnum howToSeeEnum = HowToSeeEnum.NORMAL;
		
		if (listFoot != null) {
			howToSeeEnum = listFoot.getHowToSeeCurrent();
		}
		
		updateListBoxAndFooter(1, howToSeeEnum);
	}
	
	public void updateListBoxAndFooter(Integer page, HowToSeeEnum howToSeeEnum) {
		IPayloadResponse<T> iPayload = getVmListPaginationCatalogueDialog().updateListBox(page, howToSeeEnum);
		
		if (!UtilPayload.isOK(iPayload)) {
			Alert.showMessage(iPayload);
			updateFooter(null);
			return;
		}

		updateFooter(iPayload);
	}
	
	public void updateFooter(IPayloadResponse iPayload) {
		if (listFoot != null) {
			listFoot.updateFooter(iPayload);
		}
	}
	
	public void onClickPaginacion$listFoot(Event event) throws InterruptedException {
		if (!(event instanceof ForwardEvent)) {
			return;
		}
		
		ForwardEvent forwardEvent = (ForwardEvent) event;

		Integer page = (Integer) forwardEvent.getOrigin().getData();
		
		updateListBoxAndFooter(page, listFoot.getHowToSeeCurrent());
	}

	public VM_ListPaginationCatalogueDialog<T> getVmListPaginationCatalogueDialog() {
		return (VM_ListPaginationCatalogueDialog) vm();
	}
}
