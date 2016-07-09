package karen.core.simple_list_principal.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

import karen.core.crux.alert.Alert;
import karen.core.crux.session.DataCenter;
import karen.core.listfoot.ListFoot;
import karen.core.listfoot.enums.HowToSeeEnum;
import karen.core.simple_list_principal.viewmodels.VM_WindowSimpleListPrincipal;
import karen.core.toolbar.Toolbar;
import karen.core.util.payload.UtilPayload;
import lights.core.payload.response.IPayloadResponse;
import lights.seguridad.consume.services.OperacionService;
import lights.seguridad.dto.NodoMenu;
import lights.seguridad.dto.Operacion;
import lights.seguridad.enums.OperacionEnum;
import lights.seguridad.payload.response.PayloadOperacionResponse;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.ConventionWires;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;

@SuppressWarnings({"unchecked","rawtypes"})
public class C_WindowSimpleListPrincipal<T> extends Window implements AfterCompose {

	private static final long serialVersionUID = 1277148899732272894L;

	protected Toolbar toolbar;
	protected ListFoot listFoot;
	private C_WindowSimpleListPrincipal me;
	
	protected Listbox lstbox;
	
	public static final Integer CANTIDAD_REGISTROS_PAGINA_DEFECTO = 10;

	public C_WindowSimpleListPrincipal() {
		super();
		me = this;
		this.addEventListener("onCreate", eventListenerControllerWindowSimpleListPrincipal);
	}
	
	@Override
	public void afterCompose() {
		ConventionWires.wireVariables(this, this);
		ConventionWires.addForwards(this, this);
	}

	protected EventListener eventListenerControllerWindowSimpleListPrincipal = new EventListener() {
		public void onEvent(Event event) throws Exception {
			vm().setControllerWindowSimpleListPrincipal(me);

			NodoMenu nodoMenu = DataCenter.getNodoMenu();
			
			if (nodoMenu == null) {
				return;
			}
			
//			Usuario currentUser = getCurrentUser();

//			if (currentUser == null) { TODO REMOVER COOMENTARIOS
//				return;
//			}

			PayloadOperacionResponse payloadOperacion = 
					new OperacionService().consultarByNodoMenuAndRoles(nodoMenu.getIdNodoMenu(), DataCenter.getUserSecurityData().getIdRoles());
			
			if (!UtilPayload.isOK(payloadOperacion)) {
				Alert.showMessage(payloadOperacion);
				return;
			}
			
			List<Operacion> operaciones = payloadOperacion.getObjetos();
			
//			List<Operacion> operaciones = new ArrayList<Operacion>();
//			List<Rol> roles = SesionContextHelper.getRolesActuales();
//			
//			for (Rol rol : roles) {
//				PayloadPermisoSeguridadResponse payloadPermisoSeguridad = PermisoSeguridadService.consultarPermisoSeguridadPorCriterios(-1, nodoMenu.getIdNodoMenu(), rol.getIdRol(), -1);
//				
//				if (!"OK".equals(payloadPermisoSeguridad.getInformacion("resultado"))) {
//					mostrarMensaje(payloadPermisoSeguridad);
//					continue;
//				}
//				
//				List<PermisoSeguridad> permisos = payloadPermisoSeguridad.getObjetos();
//				
//				if (permisos.size() != 0) {//PARA LAS CLASES OPERACIONES, COLOCAR EL ESTILO CORRECTO. (CUSTOM O NORMAL)TODO
//					
//					for (PermisoSeguridad permisoSeguridad : permisos) {
//						Operacion o = OperacionHelper.getPorId(permisoSeguridad.getOperacion());
//						
//						if (!operaciones.contains(o)) {
//							operaciones.add(o);
//						}
//						
//					}
//					
//					continue;
//				}
//				
//			}

			if (toolbar != null) {
				Collections.sort(operaciones);
				toolbar.createButtons(operaciones);
			}
			
			if (lstbox != null) {
				updateListBoxAndFooter();
			}
			
			vm().setIsScheduleds(vm().getScheduledsTo());
			
			doOnClientToInitPrincipal();
		}
	};
	
	public void updateListBoxAndFooter() {
		HowToSeeEnum howToSeeEnum = HowToSeeEnum.NORMAL;
		
		if (listFoot != null) {
			howToSeeEnum = listFoot.getHowToSeeCurrent();
		}
		
		updateListBoxAndFooter(1, howToSeeEnum);
	}
	
	public void updateListBoxAndFooter(Integer page, HowToSeeEnum howToSeeEnum) {
		IPayloadResponse<T> iPayload = vm().updateListBox(page, howToSeeEnum);
		
		if (!UtilPayload.isOK(iPayload)) {
			Alert.showMessage(iPayload);
			updateFooter(null);
			return;
		}

		updateFooter(iPayload);
	}

	public void onClickPaginacion$listFoot(Event event) throws InterruptedException {
		if (!(event instanceof ForwardEvent)) {
			return;
		}
		
		ForwardEvent forwardEvent = (ForwardEvent) event;

		Integer page = (Integer) forwardEvent.getOrigin().getData();
		
		updateListBoxAndFooter(page, listFoot.getHowToSeeCurrent());
	}
	
	public void doOnClientToInitPrincipal() {
		Clients.evalJavaScript("jq('.btn-floating.btn-small').hover(function(){jq(this).addClass(\"lighten-2\");},function(){jq(this).removeClass(\"lighten-2\");})");
	}
	
	public void updateFooter(IPayloadResponse<T> iPayload) {
		if (listFoot != null) {
			listFoot.updateFooter(iPayload);
		}
	}
	
	public void onSelectButtonToolbar$toolbar(Event event) throws InterruptedException {
		if (!(event instanceof ForwardEvent)) {
			return;
		}

		ForwardEvent forwardEvent = (ForwardEvent) event;

		Operacion operacion = (Operacion) forwardEvent.getOrigin().getData();
		
		try {
			this.getClass().getMethod("action", String.class).invoke(this,
					OperacionEnum.values()[operacion.getIdOperacion()].toString());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public void action(String nombreOperacion) {
		try {
			OperacionEnum operacionEnum = OperacionEnum.valueOf(nombreOperacion.toUpperCase());
			
			VM_WindowSimpleListPrincipal<T> viewModel = ((VM_WindowSimpleListPrincipal<T>) getAttributes().get("vm"));
			
			if (!viewModel.isScheduled(operacionEnum)) {
				mostrarMensajeSinProgramar();
				return;
			}
			
			String isValidPreconditions = (String) viewModel.getClass().getMethod("isValidPreconditions" + nombreOperacion, new Class<?>[] {}).invoke(viewModel, new Object[] {});
			
			if (!isValidPreconditions.equals("")) {
				Alert.showMessage(isValidPreconditions);
				return;
			}
			
			String isValidSearchData = (String) viewModel.getClass().getMethod("isValidSearchData" + nombreOperacion, new Class<?>[] {}).invoke(viewModel, new Object[] {});
			
			if (!isValidSearchData.equals("")) {
				Alert.showMessage(isValidSearchData);
				return;
			}
			
			Alert.hideMessage();
			
			viewModel.getClass().getMethod("execute" + nombreOperacion, new Class<?>[] {}).invoke(viewModel, new Object[] {});
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			mostrarMensajeErrorInesperado();
			
			e.printStackTrace();
		}
	}

	private void mostrarMensajeSinProgramar() {
		Alert.showMessage("I:Information Code: 101-Funcion no programada. ");
	}
	
	private void mostrarMensajeErrorInesperado() {
		Alert.showMessage("E:Error Code: 101-Ha ocurrido un error inesperado. ");
	}
	
	public VM_WindowSimpleListPrincipal<T> vm() {
		return ((VM_WindowSimpleListPrincipal<T>) getAttributes().get("vm"));
	}
}
