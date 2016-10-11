package karen.core.wizard.viewmodels;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import karen.core.form.controllers.C_WindowForm;
import karen.core.listfoot.enums.HowToSeeEnum;
import karen.core.simple_list_principal.controllers.C_WindowSimpleListPrincipal;
import karen.core.util.payload.UtilPayload;
import karen.core.wizard.buttons.data.OperacionWizard;
import karen.core.wizard.controllers.C_WindowWizard;
import lights.core.payload.response.IPayloadResponse;

import org.zkoss.bind.BindUtils;

public abstract class VM_WindowWizard {

	private C_WindowWizard controllerWindowWizard;

	/* Lista Adicional */
	protected List<Object> objectsList;
	protected Object selectedObject;

	protected C_WindowForm cWindowForm;

	/* /Lista Adicional/ */

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

	public void setControllerWindowWizard(C_WindowWizard controllerWindowWizard) {
		this.controllerWindowWizard = controllerWindowWizard;
	}

	/* Lista Adicional */

	/**
	 * this can't be used at @init method
	 */
	public IPayloadResponse<?> updateListBox(Integer page,
			HowToSeeEnum howToSeeEnum) {
		IPayloadResponse<?> iPayload = getDataToTable(
				C_WindowSimpleListPrincipal.CANTIDAD_REGISTROS_PAGINA_DEFECTO,
				Math.abs(page));

		if (!UtilPayload.isOK(iPayload)) {
			return iPayload;
		}

		if (howToSeeEnum.equals(HowToSeeEnum.NORMAL)) {
			objectsList = new ArrayList<Object>(iPayload.getObjetos());

			selectedObject = null;
		} else {// EXTENDED
			if (objectsList == null) {
				objectsList = new ArrayList<Object>();
			}

			if (page == 1) {
				objectsList = new ArrayList<Object>(iPayload.getObjetos());

				selectedObject = null;
			} else {
				objectsList.addAll(iPayload.getObjetos());
			}
		}

		BindUtils.postNotifyChange(null, null, this, "objectsList");

		return iPayload;
	}

	public IPayloadResponse<?> getDataToTable(Integer cantidadRegistrosPagina,
			Integer pagina) {
		return null;
	};

	public List<?> getObjectsList() {
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

	/* /Lista Adicional/ */

	public abstract Map<Integer, List<OperacionWizard>> getButtonsToStep();

	public abstract List<String> getIconsToStep();

	public abstract List<String> getUrlPageToStep();
}
