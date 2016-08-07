package karen.core.simple_list_elements.viewmodels;

import java.util.List;

import karen.core.simple_list_elements.controllers.C_WindowSimpleListElements;
import karen.core.util.payload.UtilPayload;
import lights.core.payload.response.IPayloadResponse;

import org.zkoss.bind.BindUtils;

public abstract class VM_WindowSimpleListElements<T> {

	protected List<T> objectsList;

	private C_WindowSimpleListElements<T> controllerWindowSimpleListElements;

	/**
	 * No puede ser usado en el @Init
	 */
	public IPayloadResponse<T> updateListBox(Integer page) {
		IPayloadResponse<T> iPayload = getDataToTable(
				C_WindowSimpleListElements.CANTIDAD_REGISTROS_PAGINA_DEFECTO,
				Math.abs(page));

		if (!UtilPayload.isOK(iPayload)) {
			return iPayload;
		}

		objectsList = iPayload.getObjetos();

		BindUtils.postNotifyChange(null, null, this, "objectsList");

		return iPayload;
	}

	public List<T> getObjectsList() {
		return objectsList;
	}

	public void setObjectsList(List<T> objectsList) {
		this.objectsList = objectsList;
	}

	public void refreshSelectedObject() {
		BindUtils.postNotifyChange(null, null, this, "selectedObject");
	}

	public C_WindowSimpleListElements<T> getControllerWindowSimpleListElements() {
		return controllerWindowSimpleListElements;
	}

	public void setControllerWindowSimpleListElements(
			C_WindowSimpleListElements<T> controllerWindowSimpleListElements) {
		this.controllerWindowSimpleListElements = controllerWindowSimpleListElements;
	}

	public void doDelete() {
		// NOTHING OK!
	}

	public abstract IPayloadResponse<T> getDataToTable(
			Integer cantidadRegistrosPagina, Integer pagina);
}
