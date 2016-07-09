package karen.core.form.viewmodels;

import java.util.ArrayList;
import java.util.List;

import karen.core.crux.session.DataCenter;
import karen.core.form.buttons.data.OperacionForm;
import karen.core.form.controllers.C_WindowForm;
import karen.core.util.payload.UtilPayload;

import org.zkoss.bind.BindUtils;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.util.Clients;

import lights.core.payload.response.IPayloadResponse;
import lights.seguridad.dto.Operacion;
import lights.seguridad.enums.OperacionEnum;

public abstract class VM_WindowForm {
	
	/* Lista Adicional */
	protected List<Object> objectsList;
	protected Object selectedObject;
	/* /Lista Adicional/ */
	
	/* on */
	public void onIncluir() {
		Clients.evalJavaScript("jq('.input-field > label').addClass('active')");
	}
	
	public void onModificar() {
		Clients.evalJavaScript("jq('.input-field > label').addClass('active')");
	}
	
	public void onEliminar() {
		Clients.evalJavaScript("jq('.input-field > label').addClass('active')");
	}
	
	public void onConsultar() {
		Clients.evalJavaScript("jq('.input-field > label').addClass('active')");
	 	Clients.evalJavaScript("jq('input').attr('disabled', 'disabled')");
	 	Clients.evalJavaScript("jq('textarea').attr('disabled', 'disabled')");
	 	Clients.evalJavaScript("jq('.z-combobox-input').next().css('z-index', -1)");
	 	Clients.evalJavaScript("jq('.z-combobox-input').next().next().remove()");
	 	Clients.evalJavaScript("jq('.z-datebox-button').remove()");
	 	Clients.evalJavaScript("jq('.z-calendar').css('opacity', 0.7)");
	 	Clients.evalJavaScript("jq('.z-calendar *').unbind()");
	 	Clients.evalJavaScript("jq('.z-calendar').unbind()");
	 	Clients.evalJavaScript("jq('.z-colorbox').css('opacity', 0.7)");
	 	Clients.evalJavaScript("jq('.z-colorbox *').unbind()");
	 	Clients.evalJavaScript("jq('.z-colorbox').unbind()");
	 	Clients.evalJavaScript("jq('.switch').css('opacity', 0.7)");
	 	Clients.evalJavaScript("jq('.z-slider').click(function(e){if (!e) e = window.event;if (e.stopPropagation) {e.stopPropagation();} else {e.cancelBubble = true;}})");
	 	Clients.evalJavaScript("jq('.z-slider *').unbind()");
	 	Clients.evalJavaScript("jq('.z-spinner-button').unbind()");
	 	Clients.evalJavaScript("jq('.z-doublespinner-button').unbind()");
	 	Clients.evalJavaScript("jq('.z-chosenbox').addClass('z-chosenbox-disabled')");
	 	Clients.evalJavaScript("jq('.z-div-upload').addClass('z-div-upload-disabled')");
	 	Clients.evalJavaScript("jq('.page-content .row button').click(function(e){if (!e) e = window.event;if (e.stopPropagation) {e.stopPropagation();} else {e.cancelBubble = true;}})");
	 	Clients.evalJavaScript("jq('.page-content .row button').css('opacity', 0.7)");
	}
	
	public void onCustom1() {
		Clients.evalJavaScript("jq('.input-field > label').addClass('active')");
	}
	
	public void onCustom2() {
		Clients.evalJavaScript("jq('.input-field > label').addClass('active')");
	}
	
	public void onCustom3() {
		Clients.evalJavaScript("jq('.input-field > label').addClass('active')");
	}
	
	public void onCustom4() {
		Clients.evalJavaScript("jq('.input-field > label').addClass('active')");
	}
	
	public void onCustom5() {
		Clients.evalJavaScript("jq('.input-field > label').addClass('active')");
	}
	
	public void onNone() {
		Clients.evalJavaScript("jq('.input-field > label').addClass('active')");
	}
	/*/on/ */
	
	public boolean actionGuardar(OperacionEnum operacionEnum) {
		return false;
	}
	
	public boolean actionCancelar(OperacionEnum operacionEnum) {
		return false;
	}
	
	public boolean actionSalir(OperacionEnum operacionEnum) {
		return false;
	}
	
	public boolean actionGenerar(OperacionEnum operacionEnum) {
		return false;
	}
	
	public boolean actionAprobar(OperacionEnum operacionEnum) {
		return false;
	}
	
	public boolean actionRechazar(OperacionEnum operacionEnum) {
		return false;
	}
	
	public boolean actionCustom1(OperacionEnum operacionEnum) {
		return false;
	}
	
	public boolean actionCustom2(OperacionEnum operacionEnum) {
		return false;
	}
	
	public boolean actionCustom3(OperacionEnum operacionEnum) {
		return false;
	}
	
	public boolean actionCustom4(OperacionEnum operacionEnum) {
		return false;
	}
	
	public boolean getIsIncluir() {
		return DataCenter.getOperacionEnum().equals(OperacionEnum.INCLUIR);
	}
	
	public boolean getIsModificar() {
		return DataCenter.getOperacionEnum().equals(OperacionEnum.MODIFICAR);
	}
	
	public boolean getIsEliminar() {
		return DataCenter.getOperacionEnum().equals(OperacionEnum.ELIMINAR);
	}
	
	public boolean getIsConsultar() {
		return DataCenter.getOperacionEnum().equals(OperacionEnum.CONSULTAR);
	}
	
	/* Lista Adicional*/
	public String isValidPreconditionsIncluir() {
		return "";
	}
	
	public String isValidPreconditionsModificar() {
		return "";
	}
	
	public String isValidPreconditionsEliminar() {
		return "";
	}
	
	public String isValidPreconditionsConsultar() {
		return "";
	}
	
	public String isValidPreconditionsCustom1() {
		return "";
	}
	
	public String isValidPreconditionsCustom2() {
		return "";
	}
	
	public String isValidPreconditionsCustom3() {
		return "";
	}
	
	public String isValidPreconditionsCustom4() {
		return "";
	}
	
	public String isValidPreconditionsCustom5() {
		return "";
	}
	
	public void executeIncluir() {
		//NOTHING OK!
	}
	
	public void executeModificar() {
		//NOTHING OK!
	}
	
	public void executeEliminar() {
		//NOTHING OK!
	}

	public void executeConsultar() {
		//NOTHING OK!
	}
	
	public void executeCustom1() {
		//NOTHING OK!
	}
	
	public void executeCustom2() {
		//NOTHING OK!
	}
	
	public void executeCustom3() {
		//NOTHING OK!
	}
	
	public void executeCustom4() {
		//NOTHING OK!
	}
	
	public void executeCustom5() {
		//NOTHING OK!
	}
	
	/**
	 * this can't be used at @init method
	 */
	@SuppressWarnings("unchecked")
	public IPayloadResponse<?> updateListBox(Integer page) {
		IPayloadResponse<?> iPayload = getDataToTable(C_WindowForm.CANTIDAD_REGISTROS_PAGINA_DEFECTO, page);
		
		if (!UtilPayload.isOK(iPayload)) {
			return null;
		}
		
		objectsList = (List<Object>) iPayload.getObjetos();
		selectedObject = null;
		
		BindUtils.postNotifyChange(null, null, this, "objectsList");
		
		return iPayload;
	}
	
	public List<Operacion> getOperationsListBox(OperacionEnum operacionEnum) {
		return new ArrayList<Operacion>();
	}
	
	public IPayloadResponse<?> getDataToTable(Integer cantidadRegistrosPagina, Integer pagina) {
		return null;
	};
	
	public List<Object> getObjectsList() {
		return objectsList;
	}

	public void setObjectsList(List<Object> objectsList) {
		this.objectsList = objectsList;
	}

	public Object getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(Object selectedObject) {
		this.selectedObject = selectedObject;
	}
	/*/Lista Adicional/ */
	
	public abstract List<OperacionForm> getOperationsForm(OperacionEnum operacionEnum);
	
	/* Usados en conjunto con el UploadImage y UploadFile*/
	public void onUploadImageSingle(UploadEvent event, String idUpload) {}
	
	public void onRemoveImageSingle(String idUpload) {}
	
	public void onUploadFileSingle(UploadEvent event, String idUpload) {}
	
	public void onRemoveFileSingle(String idUpload) {}
}
