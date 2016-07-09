package karen.core.form.buttons.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import karen.core.form.buttons.data.OperacionForm;
import karen.core.form.buttons.enums.OperacionFormEnum;

public class OperacionFormHelper {

	private static ResourceBundle operacionBundle = ResourceBundle.getBundle("karen.core.form.buttons.helpers.OperacionForm");

	public static List<OperacionForm> getAll() {
		List<OperacionForm> all = new ArrayList<OperacionForm>();
		
		for(OperacionFormEnum operacionFormEnum: OperacionFormEnum.values()) {
			all.add(getPorType(operacionFormEnum));
		}
		
		return all;
	}

	public static OperacionForm getPorType(OperacionFormEnum operacionFormEnum) {
		String label = operacionBundle.getString(operacionFormEnum.name() + ".label");
		String nombre = operacionBundle.getString(operacionFormEnum.name() + ".nombre");
		String iconSclass = operacionBundle.getString(operacionFormEnum.name() + ".iconSclass");
		String sclass = operacionBundle.getString(operacionFormEnum.name() + ".sclass");
		
		return new OperacionForm(operacionFormEnum.ordinal(), label, nombre, iconSclass, sclass);
	}

}