package karen.core.dialog.form.viewmodels;

import java.util.List;

import karen.core.dialog.form.data.ToCloseWindowFormDialog;
import karen.core.dialog.form.data.WindowFormDialogData;
import karen.core.dialog.generic.viewmodels.VM_WindowDialog;
import karen.core.form.buttons.data.OperacionForm;
import karen.core.form.controllers.C_WindowForm;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.util.Clients;

import ve.smile.seguridad.enums.OperacionEnum;




@SuppressWarnings("unchecked")
public abstract class VM_WindowFormDialog<T> extends VM_WindowDialog {

	protected T entity;
	
	public VM_WindowFormDialog() {
		super();
	}
	
	@Init(superclass=true)
    public void childInit_VM_WindowFormDialog() {
		//NOTHING OK!
    }

	/* Lista Adicional */
	protected List<T> objectsList;
	protected Object selectedObject;
	
	protected C_WindowForm cWindowForm;
	/* /Lista Adicional/ */
	
	/* on */
	public void onIncluir() {
		Clients.evalJavaScript("jq('.window-form-dialog .input-field > label').addClass('active')");
	}
	
	public void onModificar() {
		Clients.evalJavaScript("jq('.window-form-dialog .input-field > label').addClass('active')");
		Clients.evalJavaScript("jq('.window-form-dialog .materialize-textarea').trigger('autoresize');");
	}
	
	public void onEliminar() {
		Clients.evalJavaScript("jq('.window-form-dialog .input-field > label').addClass('active')");
		Clients.evalJavaScript("jq('.window-form-dialog .materialize-textarea').trigger('autoresize');");
	}
	
	public void onConsultar() {
		Clients.evalJavaScript("jq('.window-form-dialog .input-field > label').addClass('active')");
	 	Clients.evalJavaScript("jq('.window-form-dialog input').attr('disabled', 'disabled')");
	 	Clients.evalJavaScript("jq('.window-form-dialog textarea').attr('disabled', 'disabled')");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-combobox-input').next().css('z-index', -1)");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-combobox-input').next().next().remove()");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-datebox-button').remove()");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-calendar').css('opacity', 0.7)");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-calendar *').unbind()");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-calendar').unbind()");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-colorbox').css('opacity', 0.7)");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-colorbox *').unbind()");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-colorbox').unbind()");
	 	Clients.evalJavaScript("jq('.window-form-dialog .switch').css('opacity', 0.7)");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-slider').click(function(e){if (!e) e = window.event;if (e.stopPropagation) {e.stopPropagation();} else {e.cancelBubble = true;}})");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-slider *').unbind()");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-spinner-button').unbind()");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-doublespinner-button').unbind()");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-chosenbox').addClass('z-chosenbox-disabled')");
	 	Clients.evalJavaScript("jq('.window-form-dialog .z-div-upload').addClass('z-div-upload-disabled')");
	 	Clients.evalJavaScript("jq('.window-form-dialog .page-content .row button').not('.div-buttons-form > button').click(function(e){if (!e) e = window.event;if (e.stopPropagation) {e.stopPropagation();} else {e.cancelBubble = true;}})");
	 	Clients.evalJavaScript("jq('.window-form-dialog .page-content .row button').not('.div-buttons-form > button').css('opacity', 0.7)");
	 	Clients.evalJavaScript("jq('.window-form-dialog .materialize-textarea').trigger('autoresize');");
	}
	
	public void onCustom1() {
		Clients.evalJavaScript("jq('.window-form-dialog .input-field > label').addClass('active')");
		Clients.evalJavaScript("jq('.window-form-dialog .materialize-textarea').trigger('autoresize');");
	}
	
	public void onCustom2() {
		Clients.evalJavaScript("jq('.window-form-dialog .input-field > label').addClass('active')");
		Clients.evalJavaScript("jq('.window-form-dialog .materialize-textarea').trigger('autoresize');");
	}
	
	public void onCustom3() {
		Clients.evalJavaScript("jq('.window-form-dialog .input-field > label').addClass('active')");
		Clients.evalJavaScript("jq('.window-form-dialog .materialize-textarea').trigger('autoresize');");
	}
	
	public void onCustom4() {
		Clients.evalJavaScript("jq('.window-form-dialog .input-field > label').addClass('active')");
		Clients.evalJavaScript("jq('.window-form-dialog .materialize-textarea').trigger('autoresize');");
	}
	
	public void onCustom5() {
		Clients.evalJavaScript("jq('.window-form-dialog .input-field > label').addClass('active')");
		Clients.evalJavaScript("jq('.window-form-dialog .materialize-textarea').trigger('autoresize');");
	}
	
	public void onNone() {
		Clients.evalJavaScript("jq('.window-form-dialog .input-field > label').addClass('active')");
		Clients.evalJavaScript("jq('.window-form-dialog .materialize-textarea').trigger('autoresize');");
	}
	/*/on/ */
	
	public ToCloseWindowFormDialog<T> actionGuardar(OperacionEnum operacionEnum) {
		return new ToCloseWindowFormDialog<T>(false, operacionEnum);
	}
	
	public ToCloseWindowFormDialog<T> actionCancelar(OperacionEnum operacionEnum) {
		return new ToCloseWindowFormDialog<T>(false, operacionEnum);
	}
	
	public ToCloseWindowFormDialog<T> actionSalir(OperacionEnum operacionEnum) {
		return new ToCloseWindowFormDialog<T>(false, operacionEnum);
	}
	
	public ToCloseWindowFormDialog<T> actionGenerar(OperacionEnum operacionEnum) {
		return new ToCloseWindowFormDialog<T>(false, operacionEnum);
	}
	
	public ToCloseWindowFormDialog<T> actionAprobar(OperacionEnum operacionEnum) {
		return new ToCloseWindowFormDialog<T>(false, operacionEnum);
	}
	
	public ToCloseWindowFormDialog<T> actionRechazar(OperacionEnum operacionEnum) {
		return new ToCloseWindowFormDialog<T>(false, operacionEnum);
	}
	
	public ToCloseWindowFormDialog<T> actionCustom1(OperacionEnum operacionEnum) {
		return new ToCloseWindowFormDialog<T>(false, operacionEnum);
	}
	
	public ToCloseWindowFormDialog<T> actionCustom2(OperacionEnum operacionEnum) {
		return new ToCloseWindowFormDialog<T>(false, operacionEnum);
	}
	
	public ToCloseWindowFormDialog<T> actionCustom3(OperacionEnum operacionEnum) {
		return new ToCloseWindowFormDialog<T>(false, operacionEnum);
	}
	
	public ToCloseWindowFormDialog<T> actionCustom4(OperacionEnum operacionEnum) {
		return new ToCloseWindowFormDialog<T>(false, operacionEnum);
	}
	
	public boolean getIsIncluir() {
		return getWindowFormDialogData().getOperacionEnum().equals(OperacionEnum.INCLUIR);
	}
	
	public boolean getIsModificar() {
		return getWindowFormDialogData().getOperacionEnum().equals(OperacionEnum.MODIFICAR);
	}
	
	public boolean getIsEliminar() {
		return getWindowFormDialogData().getOperacionEnum().equals(OperacionEnum.ELIMINAR);
	}
	
	public boolean getIsConsultar() {
		return getWindowFormDialogData().getOperacionEnum().equals(OperacionEnum.CONSULTAR);
	}
	
	/* Lista Adicional*/
//	public String isValidPreconditionsIncluir() {
//		return "";
//	}
//	
//	public String isValidPreconditionsModificar() {
//		return "";
//	}
//	
//	public String isValidPreconditionsEliminar() {
//		return "";
//	}
//	
//	public String isValidPreconditionsConsultar() {
//		return "";
//	}
//	
//	public String isValidPreconditionsCustom1() {
//		return "";
//	}
//	
//	public String isValidPreconditionsCustom2() {
//		return "";
//	}
//	
//	public String isValidPreconditionsCustom3() {
//		return "";
//	}
//	
//	public String isValidPreconditionsCustom4() {
//		return "";
//	}
//	
//	public String isValidPreconditionsCustom5() {
//		return "";
//	}
//	
//	public void executeIncluir() {
//		//NOTHING OK!
//	}
//	
//	public void executeModificar() {
//		//NOTHING OK!
//	}
//	
//	public void executeEliminar() {
//		//NOTHING OK!
//	}
//
//	public void executeConsultar() {
//		//NOTHING OK!
//	}
//	
//	public void executeCustom1() {
//		//NOTHING OK!
//	}
//	
//	public void executeCustom2() {
//		//NOTHING OK!
//	}
//	
//	public void executeCustom3() {
//		//NOTHING OK!
//	}
//	
//	public void executeCustom4() {
//		//NOTHING OK!
//	}
//	
//	public void executeCustom5() {
//		//NOTHING OK!
//	}
//	
//	/**
//	 * this can't be used at @init method
//	 */
//	public IPayloadResponse<T> updateListBox(Integer page, HowToSeeEnum howToSeeEnum) {
//		IPayloadResponse<T> iPayload = getDataToTable(C_WindowSimpleListPrincipal.CANTIDAD_REGISTROS_PAGINA_DEFECTO, Math.abs(page));
//		
//		if (!UtilPayload.isOK(iPayload)) {
//			return iPayload;
//		}
//		
//		if (howToSeeEnum.equals(HowToSeeEnum.NORMAL)) {
//			objectsList = iPayload.getObjetos();
//			
//			selectedObject = null;
//		} else {//EXTENDED
//			if (objectsList == null) {
//				objectsList = new ArrayList<T>();
//			}
//			
//			if (page == 1) {
//				objectsList = iPayload.getObjetos();
//				
//				selectedObject = null;
//			} else {
//				objectsList.addAll(iPayload.getObjetos());
//			}
//		}
//		
//		BindUtils.postNotifyChange(null, null, this, "objectsList");
//		
//		return iPayload;
//	}
//	
//	public List<Operacion> getOperationsListBox(OperacionEnum operacionEnum) {
//		return new ArrayList<Operacion>();
//	}
//	
//	public IPayloadResponse<T> getDataToTable(Integer cantidadRegistrosPagina, Integer pagina) {
//		return null;
//	};
//	
//	public List<T> getObjectsList() {
//		return objectsList;
//	}
//
//	public void setObjectsList(List<T> objectsList) {
//		this.objectsList = objectsList;
//	}
//
//	public Object getSelectedObject() {
//		return selectedObject;
//	}
//
//	public void setSelectedObject(Object selectedObject) {
//		this.selectedObject = selectedObject;
//	}
	/*/Lista Adicional/ */
	
	public WindowFormDialogData<T> getWindowFormDialogData() {
		return (WindowFormDialogData<T>) getDialogData();
	}
	
	public abstract List<OperacionForm> getOperationsForm(OperacionEnum operacionEnum);
	
//	public C_WindowForm getCWindowForm() {
//		return cWindowForm;
//	}
//
//	public void setCWindowForm(C_WindowForm cWindowForm) {
//		this.cWindowForm = cWindowForm;
//	}

	/* Usados en conjunto con el UploadImage y UploadFile*/
	public void onUploadImageSingle(UploadEvent event, String idUpload) {}
	
	public void onRemoveImageSingle(String idUpload) {}
	
	public void onUploadFileSingle(UploadEvent event, String idUpload) {}
	
	public void onRemoveFileSingle(String idUpload) {}
	/*/Usados en conjunto con el UploadImage y UploadFile/ */
	
	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}
}
