package karen.core.dialog.form.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.ConventionWires;

import karen.core.dialog.form.data.ToCloseWindowFormDialog;
import karen.core.dialog.form.data.WindowFormDialogData;
import karen.core.dialog.form.events.WindowFormDialogCloseEvent;
import karen.core.dialog.form.viewmodels.VM_WindowFormDialog;
import karen.core.dialog.generic.controllers.C_WindowDialog;
import karen.core.form.buttons.containers.DivButtonsForm;
import karen.core.form.buttons.data.OperacionForm;
import karen.core.form.buttons.enums.OperacionFormEnum;

@SuppressWarnings("unchecked")
public class C_WindowFormDialog<T> extends C_WindowDialog implements AfterCompose {

	private static final long serialVersionUID = -2673858390482673864L;
	
	protected DivButtonsForm divButtonsForm;
	
	/* Lista Adicional */
//	protected Toolbar toolbar;
//	protected ListFoot listFoot;
//	protected Listbox lstbox;
	/*/Lista Adicional/ */

	public C_WindowFormDialog() {
		super();
	}
	
	@Override
	public void doOnCreate() {
		List<OperacionForm> operationsForm = vm().getOperationsForm(getWindowFormDialogData().getOperacionEnum());

//		Collections.sort(operationsForm);
		
		divButtonsForm.createButtons(operationsForm);
		
		/* Lista Adicional */
//		if (lstbox != null) {
//			if (toolbar != null) {
//				List<Operacion> operaciones = vm().getOperationsListBox(getWindowFormDialogData().getOperacionEnum());
//				
////				Collections.sort(operaciones);
//				toolbar.createButtons(operaciones);
//			}
//			
//			updateListBoxAndFooter();
//		}
		/*/Lista Adicional/ */
		
		vm().setEntity(getWindowFormDialogData().getEntity());
		
		try {
			vm().getClass().getMethod("on" + getWindowFormDialogData().getOperacionEnum().toString(), new Class<?>[] {}).invoke(vm(),
					new Object[] {});
			
			doOnClientToInitPrincipal();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Override
//	public void onAccept(Event event) {
//		String message = vm().validateData();
//		
//		if (message.length() > 0) {
//			UtilDialog.showMessageBoxWarning(message);
//			return;
//		}
//		
//		close(vm().getDialogCloseEventOnAccept(event));
//	}


	public void doOnClientToInitPrincipal() {
		Clients.evalJavaScript("jq('.btn').hover(function(){jq(this).addClass(\"lighten-2\");},function(){jq(this).removeClass(\"lighten-2\");})");
		//Clients.evalJavaScript("jq('.nano').nanoScroller();");
	}
	
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
		ToCloseWindowFormDialog<T> toCloseWindowFormDialog = vm().actionGuardar(getWindowFormDialogData().getOperacionEnum());
		
		if (toCloseWindowFormDialog == null) {
			return;
		}
		
		if (toCloseWindowFormDialog.getClose()) {
			close(new WindowFormDialogCloseEvent<T>(toCloseWindowFormDialog.getEntity(), OperacionFormEnum.GUARDAR));
		}
	}

	public void actionCancelar() {
		ToCloseWindowFormDialog<T> toCloseWindowFormDialog = vm().actionCancelar(getWindowFormDialogData().getOperacionEnum());
		
		if (toCloseWindowFormDialog == null) {
			return;
		}
		
		if (toCloseWindowFormDialog.getClose()) {
			close(new WindowFormDialogCloseEvent<T>(toCloseWindowFormDialog.getEntity(), OperacionFormEnum.CANCELAR));
		}		
	}
	
	public void actionSalir() {
		ToCloseWindowFormDialog<T> toCloseWindowFormDialog = vm().actionSalir(getWindowFormDialogData().getOperacionEnum());
		
		if (toCloseWindowFormDialog == null) {
			return;
		}
		
		if (toCloseWindowFormDialog.getClose()) {
			close(new WindowFormDialogCloseEvent<T>(toCloseWindowFormDialog.getEntity(), OperacionFormEnum.SALIR));
		}
	}

	public void actionCustom1() {
		ToCloseWindowFormDialog<T> toCloseWindowFormDialog = vm().actionCustom1(getWindowFormDialogData().getOperacionEnum());
		
		if (toCloseWindowFormDialog == null) {
			return;
		}
		
		if (toCloseWindowFormDialog.getClose()) {
			close(new WindowFormDialogCloseEvent<T>(toCloseWindowFormDialog.getEntity(), OperacionFormEnum.CUSTOM1));
		}
	}
	
	public void actionCustom2() {
		ToCloseWindowFormDialog<T> toCloseWindowFormDialog = vm().actionCustom2(getWindowFormDialogData().getOperacionEnum());
		
		if (toCloseWindowFormDialog == null) {
			return;
		}
		
		if (toCloseWindowFormDialog.getClose()) {
			close(new WindowFormDialogCloseEvent<T>(toCloseWindowFormDialog.getEntity(), OperacionFormEnum.CUSTOM2));
		}
	}
	
	public void actionCustom3() {
		ToCloseWindowFormDialog<T> toCloseWindowFormDialog = vm().actionCustom3(getWindowFormDialogData().getOperacionEnum());
		
		if (toCloseWindowFormDialog == null) {
			return;
		}
		
		if (toCloseWindowFormDialog.getClose()) {
			close(new WindowFormDialogCloseEvent<T>(toCloseWindowFormDialog.getEntity(), OperacionFormEnum.CUSTOM3));
		}
	}
	
	public void actionCustom4() {
		ToCloseWindowFormDialog<T> toCloseWindowFormDialog = vm().actionCustom4(getWindowFormDialogData().getOperacionEnum());
		
		if (toCloseWindowFormDialog == null) {
			return;
		}
		
		if (toCloseWindowFormDialog.getClose()) {
			close(new WindowFormDialogCloseEvent<T>(toCloseWindowFormDialog.getEntity(), OperacionFormEnum.CUSTOM4));
		}
	}
	
	public void actionGenerar() {
		ToCloseWindowFormDialog<T> toCloseWindowFormDialog = vm().actionGenerar(getWindowFormDialogData().getOperacionEnum());
		
		if (toCloseWindowFormDialog == null) {
			return;
		}
		
		if (toCloseWindowFormDialog.getClose()) {
			close(new WindowFormDialogCloseEvent<T>(toCloseWindowFormDialog.getEntity(), OperacionFormEnum.GENERAR));
		}
	}
	
	public void actionAprobar() {
		ToCloseWindowFormDialog<T> toCloseWindowFormDialog = vm().actionAprobar(getWindowFormDialogData().getOperacionEnum());
		
		if (toCloseWindowFormDialog == null) {
			return;
		}
		
		if (toCloseWindowFormDialog.getClose()) {
			close(new WindowFormDialogCloseEvent<T>(toCloseWindowFormDialog.getEntity(), OperacionFormEnum.APROBAR));
		}
	}
	
	public void actionRechazar() {
		ToCloseWindowFormDialog<T> toCloseWindowFormDialog = vm().actionRechazar(getWindowFormDialogData().getOperacionEnum());
		
		if (toCloseWindowFormDialog == null) {
			return;
		}
		
		if (toCloseWindowFormDialog.getClose()) {
			close(new WindowFormDialogCloseEvent<T>(toCloseWindowFormDialog.getEntity(), OperacionFormEnum.RECHAZAR));
		}
	}
	
	/* Lista Adicional */
//	public void updateListBoxAndFooter() {
//		HowToSeeEnum howToSeeEnum = HowToSeeEnum.NORMAL;
//		
//		if (listFoot != null) {
//			howToSeeEnum = listFoot.getHowToSeeCurrent();
//		}
//		
//		updateListBoxAndFooter(1, howToSeeEnum);
//	}
//	
//	public void updateListBoxAndFooter(Integer page, HowToSeeEnum howToSeeEnum) {
//		IPayloadResponse iPayload = vm().updateListBox(page, howToSeeEnum);
//		
//		if (iPayload == null) {
//			updateFooter(null);
//			return;
//		}
//		
//		if (!UtilPayload.isOK(iPayload)) {
//			Alert.showMessage(iPayload);
//			updateFooter(null);
//			return;
//		}
//		
//		updateFooter(iPayload);
//	}
//	
//	public void updateFooter(IPayloadResponse iPayload) {
//		if (listFoot != null) {
//			listFoot.updateFooter(iPayload);
//		}
//	}
//	
//	public void onClickPaginacion$listFoot(Event event) throws InterruptedException {
//		if (!(event instanceof ForwardEvent)) {
//			return;
//		}
//		
//		ForwardEvent forwardEvent = (ForwardEvent) event;
//
//		Integer page = (Integer) forwardEvent.getOrigin().getData();
//		
//		updateListBoxAndFooter(page, listFoot.getHowToSeeCurrent());
//	}
//	
//	public void onSelectButtonToolbar$toolbar(Event event) throws InterruptedException {
//		if (!(event instanceof ForwardEvent)) {
//			return;
//		}
//
//		ForwardEvent forwardEvent = (ForwardEvent) event;
//
//		Operacion operacion = (Operacion) forwardEvent.getOrigin().getData();
//		
//		try {
//			this.getClass().getMethod("action", String.class).invoke(this,
//					operacion.getNombre());
//		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
//				| InvocationTargetException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void action(String nombreOperacion) {
//		try {
//			VM_WindowForm viewModel = vm();
//			
//			String isValidPreconditions = (String) viewModel.getClass().getMethod("isValidPreconditions" + nombreOperacion, new Class<?>[] {}).invoke(viewModel, new Object[] {});
//			
//			if (!isValidPreconditions.equals("")) {
//				Alert.showMessage(isValidPreconditions);
//				return;
//			}
//			
//			Alert.hideMessage();
//			
//			viewModel.getClass().getMethod("execute" + nombreOperacion, new Class<?>[] {}).invoke(viewModel, new Object[] {});
//		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
//				| InvocationTargetException e) {
//			mostrarMensajeErrorInesperado();
//			
//			e.printStackTrace();
//		}
//	}
//	
//	private void mostrarMensajeErrorInesperado() {
//		Alert.showMessage("E:Error Code: 101-Ha ocurrido un error inesperado. ");
//	}
	/*/Lista Adicional/ */
	
	@Override
	public VM_WindowFormDialog<T> vm() {
		return ((VM_WindowFormDialog<T>) getAttributes().get("vm"));
	}

	@Override
	public void onAccept(Event event) {
		//NO UTILIZADO
	}
	
	@Override
	public void onCancel(Event event) {
		//NO UTILIZADO
	}

	public WindowFormDialogData<T> getWindowFormDialogData() {
		return (WindowFormDialogData<T>) getDialogData();
	}
}
