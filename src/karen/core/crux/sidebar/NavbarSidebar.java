package karen.core.crux.sidebar;

import java.util.ArrayList;
import java.util.List;

import karen.core.crux.alert.Alert;
import karen.core.crux.breadcrums.Breadcrumbs;
import karen.core.crux.session.DataCenter;
import lights.core.payload.response.IPayloadResponse;
import lights.seguridad.consume.services.NodoMenuService;
import lights.seguridad.dto.NodoMenu;
import lights.seguridad.enums.TipoNodoMenuEnum;
import lights.seguridad.payload.response.PayloadNodoMenuResponse;

import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zkmax.zul.Nav;
import org.zkoss.zkmax.zul.Navbar;
import org.zkoss.zkmax.zul.Navitem;

public class NavbarSidebar extends Navbar implements AfterCompose {

	private static final long serialVersionUID = -2560087684299584265L;
	
	private static final String BREADCRUMBS = "breadcrumbs";

	public void afterCompose() {
		this.getChildren().clear();

		PayloadNodoMenuResponse payloadNodoMenu =
				new NodoMenuService().consultarNodoMenuPorRoles(DataCenter.getUserSecurityData().getIdRoles());
		
		if (!(Boolean) payloadNodoMenu.getInformacion(IPayloadResponse.IS_OK)) {
			Alert.showMessage(payloadNodoMenu);
			return;
		}
		
		createTree(payloadNodoMenu.getObjetos().get(0));
	}

	@SuppressWarnings("rawtypes")
	EventListener selectListener = new EventListener() {
		public void onEvent(Event event) throws UiException {
			if (event.getTarget() instanceof Navitem) {
				Navitem navitem = (Navitem) event.getTarget();
				
				String breadcrumbs = (String) navitem.getAttribute(BREADCRUMBS);
				
				String[] breads = breadcrumbs.split(":");
				
				List<String> breadcrumbsList = new ArrayList<String>();
				
				for (String bread : breads) {
					breadcrumbsList.add(bread);
				}
				
				Breadcrumbs.updateBreads(breadcrumbsList);
				
				Alert.hideMessage();
				
				DataCenter.updateSrcPageContent((NodoMenu) navitem.getAttribute("zul"));
			}
		}
	};

	public void createTree(NodoMenu root) {
		for (NodoMenu nodoMenu : root.getHijos()) {
			
			if (nodoMenu.getTipoNodoMenuEnum().equals(TipoNodoMenuEnum.TRANSACCION)) {
				createNodoMenu(this, nodoMenu);
				continue;
			}

			createFolder(this, nodoMenu);
		}
	}

	@SuppressWarnings("unchecked")
	public Navbar createNodoMenu(Navbar navbar, NodoMenu nodoMenu) {
		Navitem navitem = new Navitem();
		navitem.setAttribute(BREADCRUMBS, "");
		
		navitem.setLabel(nodoMenu.getNombre());
		navitem.setIconSclass(nodoMenu.getFkIconSclass().getNombre());
		navitem.setAttribute("zul", nodoMenu);

		navitem.addEventListener(Events.ON_CLICK, selectListener);

		navbar.getChildren().add(navitem);

		return navbar;
	}

	@SuppressWarnings("unchecked")
	public Nav createNodoMenu(Nav nav, NodoMenu nodoMenu) {
		Navitem navitem = new Navitem();
		navitem.setAttribute(BREADCRUMBS, nav.getAttribute(BREADCRUMBS));
		
		navitem.setLabel(nodoMenu.getNombre());
		navitem.setSclass("waves-effect waves-light");
		navitem.setIconSclass(nodoMenu.getFkIconSclass().getNombre());
		navitem.setAttribute("zul", nodoMenu);
		

		navitem.addEventListener(Events.ON_CLICK, selectListener);

		nav.getChildren().add(navitem);

		return nav;
	}

	public Navbar createFolder(Navbar navbar, NodoMenu nodoMenuPadre) {
		Nav nav = new Nav(nodoMenuPadre.getNombre());
		nav.setClass("waves-effect waves-light");
		nav.setAttribute(BREADCRUMBS, nodoMenuPadre.getNombre());
		
		nav.setIconSclass(nodoMenuPadre.getFkIconSclass().getNombre());

		navbar.getChildren().add(nav);

		for (NodoMenu nodoMenuHijo : nodoMenuPadre.getHijos()) {
			if (nodoMenuHijo.getTipoNodoMenuEnum().equals(TipoNodoMenuEnum.TRANSACCION)) {
				createNodoMenu(nav, nodoMenuHijo);
				continue;
			}

			createFolder(nav, nodoMenuHijo);
		}

		return navbar;
	}

	public Nav createFolder(Nav nav, NodoMenu nodoMenuPadre) {
		Nav navFolder = new Nav(nodoMenuPadre.getNombre());
		navFolder.setSclass("waves-effect waves-light");
		navFolder.setAttribute(BREADCRUMBS, nav.getAttribute(BREADCRUMBS) + ":" + nodoMenuPadre.getNombre());
		
		navFolder.setIconSclass(nodoMenuPadre.getFkIconSclass().getNombre());

		nav.getChildren().add(navFolder);

		for (NodoMenu nodoMenuHijo : nodoMenuPadre.getHijos()) {
			if (nodoMenuHijo.getTipoNodoMenuEnum().equals(TipoNodoMenuEnum.TRANSACCION)) {
				createNodoMenu(navFolder, nodoMenuHijo);
				continue;
			}

			createFolder(navFolder, nodoMenuHijo);
		}

		return nav;
	}
}