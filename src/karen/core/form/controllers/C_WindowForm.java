package karen.core.form.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import karen.core.crux.alert.Alert;
import karen.core.crux.session.DataCenter;
import karen.core.form.buttons.containers.DivButtonsForm;
import karen.core.form.buttons.data.OperacionForm;
import karen.core.form.viewmodels.VM_WindowForm;
import karen.core.listfoot.ListFoot;
import karen.core.toolbar.Toolbar;
import karen.core.util.payload.UtilPayload;
import lights.core.payload.response.IPayloadResponse;
import ve.smile.seguridad.dto.Operacion;
import ve.smile.seguridad.enums.OperacionEnum;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.ConventionWires;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;

@SuppressWarnings({"unchecked","rawtypes"})
public class C_WindowForm extends Window implements AfterCompose {

	private static final long serialVersionUID = 1277148899732272894L;

	protected DivButtonsForm divButtonsForm;
	
	/* Lista */
	protected Toolbar toolbar;
	protected ListFoot listFoot;
	protected Listbox lstbox;
	/*/Lista/ */
	
	public static final Integer CANTIDAD_REGISTROS_PAGINA_DEFECTO = 10;

	public C_WindowForm() {
		super();
		this.addEventListener("onCreate", createListener);
	}

	protected EventListener createListener = new EventListener() {
		public void onEvent(Event event) throws Exception {

			List<OperacionForm> operationsForm = vm().getOperationsForm(OperacionEnum.valueOf(DataCenter.getOperacion().getNombre().toUpperCase()));

//			Collections.sort(operationsForm);
			
			divButtonsForm.createButtons(operationsForm);
			
			/* Lista */
			if (lstbox != null) {
				if (toolbar != null) {
					List<Operacion> operaciones = vm().getOperationsListBox(OperacionEnum.valueOf(DataCenter.getOperacion().getNombre().toUpperCase()));
					
//					Collections.sort(operaciones);
					toolbar.createButtons(operaciones);
				}
				
				updateListBoxAndFooter(1);
			}
			/*/Lista/ */
			
			Clients.evalJavaScript("jq('.opacity-0').css('opacity', 1);");
			Clients.evalJavaScript("jq('.btn').hover(function(){jq(this).addClass(\"lighten-2\");},function(){jq(this).removeClass(\"lighten-2\");})");
			
			vm().getClass().getMethod("on" + OperacionEnum.values()[DataCenter.getOperacion().getIdOperacion()].toString(), new Class<?>[] {}).invoke(vm(),
					new Object[] {});
		}
	};

	@Override
	public void afterCompose() {
		ConventionWires.wireVariables(this, this);
		ConventionWires.addForwards(this, this);
	}
	
	public void onSelectButtonFormulario$divButtonsForm(Event event) throws InterruptedException {
		if (!(event instanceof ForwardEvent)) {
			return;
		}
		ForwardEvent forwardEvent = (ForwardEvent) event;

		OperacionForm operacionForm = (OperacionForm) forwardEvent.getOrigin().getData();

		try {
			this.getClass().getMethod("action" + operacionForm.getNombre(), new Class<?>[] {}).invoke(this,
					new Object[] {});
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void actionGuardar() {
		if (!vm().actionGuardar(DataCenter.getOperacionEnum())) {
			mostrarMensajeSinProgramar();
			return;
		}
	}

	public void actionCancelar() {
		if (!vm().actionCancelar(DataCenter.getOperacionEnum())) {
			mostrarMensajeSinProgramar();
			return;
		}
	}
	
	public void actionSalir() {
		if (!vm().actionSalir(DataCenter.getOperacionEnum())) {
			mostrarMensajeSinProgramar();
			return;
		}
	}

	public void actionCustom1() {
		if (!vm().actionCustom1(DataCenter.getOperacionEnum())) {
			mostrarMensajeSinProgramar();
			return;
		}
	}
	
	public void actionCustom2() {
		if (!vm().actionCustom2(DataCenter.getOperacionEnum())) {
			mostrarMensajeSinProgramar();
			return;
		}
	}
	
	public void actionCustom3() {
		if (!vm().actionCustom3(DataCenter.getOperacionEnum())) {
			mostrarMensajeSinProgramar();
			return;
		}
	}
	
	public void actionCustom4() {
		if (!vm().actionCustom4(DataCenter.getOperacionEnum())) {
			mostrarMensajeSinProgramar();
			return;
		}
	}
	
	public void actionGenerar() {
		if (!vm().actionGenerar(DataCenter.getOperacionEnum())) {
			mostrarMensajeSinProgramar();
			return;
		}
	}
	
	public void actionAprobar() {
		if (!vm().actionAprobar(DataCenter.getOperacionEnum())) {
			mostrarMensajeSinProgramar();
			return;
		}
	}
	
	public void actionRechazar() {
		if (!vm().actionRechazar(DataCenter.getOperacionEnum())) {
			mostrarMensajeSinProgramar();
			return;
		}
	}
	
	/* Lista */
	public void updateListBoxAndFooter(Integer page) {
		IPayloadResponse iPayload = vm().updateListBox(page);
		
		if (iPayload == null) {
			updateFooter(null);
			return;
		}
		
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
		
		updateListBoxAndFooter(page);
	}
	
	public void onSelectButtonToolbar$toolbar(Event event) throws InterruptedException {
		if (!(event instanceof ForwardEvent)) {
			return;
		}

		ForwardEvent forwardEvent = (ForwardEvent) event;

		Operacion operacion = (Operacion) forwardEvent.getOrigin().getData();
		
		try {
			this.getClass().getMethod("action", String.class).invoke(this,
					operacion.getNombre());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public void action(String nombreOperacion) {
		try {
			VM_WindowForm viewModel = vm();
			
			String isValidPreconditions = (String) viewModel.getClass().getMethod("isValidPreconditions" + nombreOperacion, new Class<?>[] {}).invoke(viewModel, new Object[] {});
			
			if (!isValidPreconditions.equals("")) {
				Alert.showMessage(isValidPreconditions);
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
	
	private void mostrarMensajeErrorInesperado() {
		Alert.showMessage("E:Error Code: 101-Ha ocurrido un error inesperado. ");
	}
	/*/Lista/ */

	private void mostrarMensajeSinProgramar() {
		Alert.showMessage("I:Information Code: 105-Funcion no programada. ");
	}
	
	public VM_WindowForm vm() {
		return ((VM_WindowForm) getAttributes().get("vm"));
	}
}
