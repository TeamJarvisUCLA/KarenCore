package karen.core.wizard.buttons.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import karen.core.wizard.buttons.data.OperacionWizard;
import karen.core.wizard.buttons.enums.OperacionWizardEnum;

public class OperacionWizardHelper {

	private static ResourceBundle operacionBundle = ResourceBundle.getBundle("karen.core.wizard.buttons.helpers.OperacionWizard");

	public static List<OperacionWizard> getAll() {
		List<OperacionWizard> all = new ArrayList<OperacionWizard>();
		
		for(OperacionWizardEnum operacionWizardEnum: OperacionWizardEnum.values()) {
			all.add(getPorType(operacionWizardEnum));
		}
		
		return all;
	}

	public static OperacionWizard getPorType(OperacionWizardEnum operacionWizardEnum) {
		String label = operacionBundle.getString(operacionWizardEnum.name() + ".label");
		String nombre = operacionBundle.getString(operacionWizardEnum.name() + ".nombre");
		String iconSclass = operacionBundle.getString(operacionWizardEnum.name() + ".iconSclass");
		String sclass = operacionBundle.getString(operacionWizardEnum.name() + ".sclass");
		String tooltiptext = operacionBundle.getString(operacionWizardEnum.name() + ".tooltiptext");
		
		return new OperacionWizard(operacionWizardEnum.ordinal(), label, nombre, iconSclass, sclass, tooltiptext);
	}

}