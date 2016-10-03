package karen.core.simple_list.wizard.viewmodels;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import karen.core.listfoot.enums.HowToSeeEnum;
import karen.core.simple_list.wizard.buttons.data.OperacionWizard;
import karen.core.simple_list.wizard.controllers.C_WindowWizard;
import karen.core.util.payload.UtilPayload;
import lights.core.payload.response.IPayloadResponse;

import org.zkoss.bind.BindUtils;

public abstract class VM_WindowWizard<T> {

	private C_WindowWizard<T> controllerWindowWizard;
	private String srcPageContent;

	protected List<T> objectsList;

	protected T selectedObject;

	public Integer getInitStep() {
		return 1;
	}

	public void comeIn(Integer currentStep) {
	}

	public String isValidPreconditionsCustom1(Integer currentStep) {
		return "";
	}

	public String isValidPreconditionsCancelar(Integer currentStep) {
		return "";
	}

	public String isValidPreconditionsAtras(Integer currentStep) {
		return "";
	}

	public String isValidPreconditionsCustom2(Integer currentStep) {
		return "";
	}

	public String isValidPreconditionsSiguiente(Integer currentStep) {
		return "";
	}

	public String isValidPreconditionsFinalizar(Integer currentStep) {
		return "";
	}

	public String isValidPreconditionsCustom3(Integer currentStep) {
		return "";
	}

	public String isValidPreconditionsCustom4(Integer currentStep) {
		return "";
	}

	public String isValidPreconditionsCustom5(Integer currentStep) {
		return "";
	}

	public String isValidSearchDataCustom1(Integer currentStep) {
		return "";
	}

	public String isValidSearchDataCancelar(Integer currentStep) {
		return "";
	}

	public String isValidSearchDataAtras(Integer currentStep) {
		return "";
	}

	public String isValidSearchDataCustom2(Integer currentStep) {
		return "";
	}

	public String isValidSearchDataSiguiente(Integer currentStep) {
		return "";
	}

	public String isValidSearchDataFinalizar(Integer currentStep) {
		return "";
	}

	public String isValidSearchDataCustom3(Integer currentStep) {
		return "";
	}

	public String isValidSearchDataCustom4(Integer currentStep) {
		return "";
	}

	public String isValidSearchDataCustom5(Integer currentStep) {
		return "";
	}

	public String executeCustom1(Integer currentStep) {
		return "";
	}

	public String executeCancelar(Integer currentStep) {
		return "";
	}

	public String executeAtras(Integer currentStep) {
		return "";
	}

	public String executeCustom2(Integer currentStep) {
		return "";
	}

	public String executeSiguiente(Integer currentStep) {
		return "";
	}

	public String executeFinalizar(Integer currentStep) {
		return "";
	}

	public String executeCustom3(Integer currentStep) {
		return "";
	}

	public String executeCustom4(Integer currentStep) {
		return "";
	}

	public String executeCustom5(Integer currentStep) {
		return "";
	}

	public void setNextStep(Integer step) {
		if (controllerWindowWizard != null) {
			controllerWindowWizard.setNextStep(step);
		}
	}

	/**
	 * No realiza ningun tipo de validacion.
	 */
	public void goToNextStep() {
		if (controllerWindowWizard != null) {
			controllerWindowWizard.goToNextStep();
		}
	}

	/**
	 * No realiza ningun tipo de validacion.
	 */
	public void goToPreviousStep() {
		if (controllerWindowWizard != null) {
			controllerWindowWizard.goToPreviousStep();
		}
	}

	public void restartWizard() {
		if (controllerWindowWizard != null) {
			controllerWindowWizard.restartWizard();
		}
	}

	public void setControllerWindowWizard(
			C_WindowWizard<T> controllerWindowWizard) {
		this.controllerWindowWizard = controllerWindowWizard;
	}

	public C_WindowWizard<T> getControllerWindowWizard() {
		return controllerWindowWizard;
	}

	public String getSrcPageContent() {
		return srcPageContent;
	}

	public void setSrcPageContent(String srcPageContent) {
		this.srcPageContent = srcPageContent;

		BindUtils.postNotifyChange(null, null, this, "srcPageContent");
	}

	/**
	 * No puede ser usado en el @Init
	 */
	public IPayloadResponse<T> updateListBox(Integer page,
			HowToSeeEnum howToSeeEnum) {
		IPayloadResponse<T> iPayload = getDataToTable(
				C_WindowWizard.CANTIDAD_REGISTROS_PAGINA_DEFECTO,
				Math.abs(page));

		if (!UtilPayload.isOK(iPayload)) {
			return iPayload;
		}

		if (howToSeeEnum.equals(HowToSeeEnum.NORMAL)) {
			objectsList = iPayload.getObjetos();

			selectedObject = null;
		} else {// EXTENDED
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

	public abstract Map<Integer, List<OperacionWizard>> getButtonsToStep();

	public abstract List<String> getIconsToStep();

	public abstract List<String> getUrlPageToStep();

	public abstract IPayloadResponse<T> getDataToTable(
			Integer cantidadRegistrosPagina, Integer pagina);
}
