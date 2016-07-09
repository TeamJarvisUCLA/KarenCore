package karen.core.form.buttons;

import karen.core.form.buttons.data.OperacionForm;
import karen.core.form.buttons.enums.OperacionFormEnum;
import karen.core.form.buttons.helpers.OperacionFormHelper;

import org.zkoss.zul.Button;

public class ButtonFormulario extends Button {
	
	private static final long serialVersionUID = 6881487192821495408L;
	
	private OperacionForm operacionForm;
	
	private void initControl() {
		setLabel(operacionForm.getLabel());
		setSclass(operacionForm.getSclass() + " waves-effect waves-light btn");
		setIconSclass(operacionForm.getIconSclass());
	}
	
	public ButtonFormulario(OperacionForm operacionForm) {
		super();
		this.operacionForm = operacionForm;
		initControl();
	}
	
	public ButtonFormulario(Integer id) {
		super();
		this.operacionForm = OperacionFormHelper.getPorType(OperacionFormEnum.values()[id]);
		initControl();
	}

	public OperacionForm getOperacionForm() {
		return operacionForm;
	}

}
