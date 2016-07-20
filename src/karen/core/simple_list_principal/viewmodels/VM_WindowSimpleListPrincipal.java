package karen.core.simple_list_principal.viewmodels;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import karen.core.crux.session.DataCenter;
import karen.core.dialog.generic.enums.DialogActionEnum;
import karen.core.dialog.message_box.events.MessageBoxDialogCloseEvent;
import karen.core.dialog.message_box.events.listeners.MessageBoxDialogCloseListener;
import karen.core.listfoot.enums.HowToSeeEnum;
import karen.core.simple_list_principal.controllers.C_WindowSimpleListPrincipal;
import karen.core.util.UtilDialog;
import karen.core.util.payload.UtilPayload;
import lights.core.payload.response.IPayloadResponse;
import lights.seguridad.dto.Operacion;
import lights.seguridad.enums.OperacionEnum;
import lights.seguridad.enums.helper.OperacionHelper;

import org.zkoss.bind.BindUtils;

public abstract class VM_WindowSimpleListPrincipal<T> {

	protected List<T> objectsList;

	protected T selectedObject;
	
	private C_WindowSimpleListPrincipal<T> controllerWindowSimpleListPrincipal;
	
	public String isValidPreconditionsIncluir() {
		return "";
	}
	
	public String isValidPreconditionsModificar() {
		if (selectedObject == null) {
			return "I:Information Code: 102-Debe seleccionar el registro a modificar";
		}
		return "";
	}
	
	public String isValidPreconditionsEliminar() {
		if (selectedObject == null) {
			return "I:Information Code: 103-Debe seleccionar el registro a eliminar";
		}
		return "";
	}
	
	public String isValidPreconditionsConsultar() {
		if (selectedObject == null) {
			return "I:Information Code: 104-Debe seleccionar el registro a consultar";
		}
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
	
	public String isValidSearchDataIncluir() {
		return "";
	}
	
	public String isValidSearchDataModificar() {
		return "";
	}
	
	public String isValidSearchDataEliminar() {
		return "";
	}
	
	public String isValidSearchDataConsultar() {
		return "";
	}
	
	public String isValidSearchDataCustom1() {
		return "";
	}
	
	public String isValidSearchDataCustom2() {
		return "";
	}
	
	public String isValidSearchDataCustom3() {
		return "";
	}
	
	public String isValidSearchDataCustom4() {
		return "";
	}
	
	public String isValidSearchDataCustom5() {
		return "";
	}
	
	@SuppressWarnings("unchecked")
	public void executeIncluir() throws Exception {
		Type superClass = getClass().getGenericSuperclass();

		Type tArgument = ((ParameterizedType) superClass).getActualTypeArguments()[0];

		String className = tArgument.toString().split(" ")[1];

		T object = (T) Class.forName(className).newInstance();

		Operacion operacion = OperacionHelper.getPorType(OperacionEnum.INCLUIR);

		DataCenter.updateSrcPageContent(object, operacion, getSrcFileZulForm(OperacionEnum.INCLUIR));
	}
	
	public void executeModificar() {
		Operacion operacion = OperacionHelper.getPorType(OperacionEnum.MODIFICAR);

		DataCenter.updateSrcPageContent(selectedObject, operacion, getSrcFileZulForm(OperacionEnum.MODIFICAR));
	}
	
	public void executeEliminar() {	
		UtilDialog.showMessageBoxConfirmation("¿Desea eliminar el registro seleccionado?", new MessageBoxDialogCloseListener() {
			
			@Override
			public void onClose(MessageBoxDialogCloseEvent messageBoxDialogCloseEvent) {
				if (messageBoxDialogCloseEvent.getDialogAction().equals(DialogActionEnum.ACEPTAR)) {
					doDelete();
				}
			}
		});
	}

	public void executeConsultar() {
		Operacion operacion = OperacionHelper.getPorType(OperacionEnum.CONSULTAR);

		DataCenter.updateSrcPageContent(selectedObject, operacion, getSrcFileZulForm(OperacionEnum.CONSULTAR));
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
	 * No puede ser usado en el @Init
	 */
	public IPayloadResponse<T> updateListBox(Integer page, HowToSeeEnum howToSeeEnum) {
		IPayloadResponse<T> iPayload = getDataToTable(C_WindowSimpleListPrincipal.CANTIDAD_REGISTROS_PAGINA_DEFECTO, Math.abs(page));
		
		if (!UtilPayload.isOK(iPayload)) {
			return iPayload;
		}
		
		if (howToSeeEnum.equals(HowToSeeEnum.NORMAL)) {
			objectsList = iPayload.getObjetos();
			
			selectedObject = null;
		} else {//EXTENDED
			if (objectsList == null) {
				objectsList = new ArrayList<T>();
			}
			
			if (page == 1) {
				objectsList = iPayload.getObjetos();
				
				selectedObject = null;
			} else {
				objectsList.addAll(iPayload.getObjetos());
			}
		}
		
		BindUtils.postNotifyChange(null, null, this, "objectsList");
		
		return iPayload;
	}
	
	public List<T> getObjectsList() {
		return objectsList;
	}

	public void setObjectsList(List<T> objectsList) {
		this.objectsList = objectsList;
	}

	public T getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(T selectedObject) {
		this.selectedObject = selectedObject;
	}
	
	public void refreshSelectedObject() {
		BindUtils.postNotifyChange(null, null, this, "selectedObject");
	}

	public C_WindowSimpleListPrincipal<T> getControllerWindowSimpleListPrincipal() {
		return controllerWindowSimpleListPrincipal;
	}

	public void setControllerWindowSimpleListPrincipal(C_WindowSimpleListPrincipal<T> controllerWindowSimpleListPrincipal) {
		this.controllerWindowSimpleListPrincipal = controllerWindowSimpleListPrincipal;
	}

	public void doDelete() {
		// NOTHING OK!
	}
	
	public abstract String getSrcFileZulForm(OperacionEnum operacionEnum);
	
	public abstract IPayloadResponse<T> getDataToTable(Integer cantidadRegistrosPagina, Integer pagina);
}
