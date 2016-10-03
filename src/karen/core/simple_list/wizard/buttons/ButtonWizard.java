package karen.core.simple_list.wizard.buttons;

import karen.core.simple_list.wizard.buttons.data.OperacionWizard;
import karen.core.simple_list.wizard.buttons.enums.OperacionWizardEnum;
import karen.core.simple_list.wizard.buttons.helpers.OperacionWizardHelper;

import org.zkoss.zul.Button;

public class ButtonWizard extends Button {
	
	private static final long serialVersionUID = 6881487192821495408L;
	
	private OperacionWizard operacionWizard;
	
	private void initControl() {
		setLabel(operacionWizard.getLabel());
		setSclass(operacionWizard.getSclass() + " waves-effect waves-light btn");
		setIconSclass(operacionWizard.getIconSclass());
		setTooltiptext(operacionWizard.getTooltiptext());
	}
	
	public ButtonWizard(OperacionWizard operacionWizard) {
		super();
		this.operacionWizard = operacionWizard;
		initControl();
	}
	
	public ButtonWizard(Integer id) {
		super();
		this.operacionWizard = OperacionWizardHelper.getPorType(OperacionWizardEnum.values()[id]);
		initControl();
	}

	public OperacionWizard getOperacionWizard() {
		return operacionWizard;
	}

}
