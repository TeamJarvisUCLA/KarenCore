package karen.core.toolbar;

import lights.seguridad.dto.Operacion;
import lights.seguridad.enums.OperacionEnum;
import lights.seguridad.enums.helper.OperacionHelper;

import org.zkoss.zul.Button;

public class ButtonToolbar extends Button {
	
	private static final long serialVersionUID = 6881487192821495408L;
	
	private Operacion operacion;
	
	private void initControl() {
		setSclass("btn-floating btn-small btn waves-effect waves-light " + operacion.getSclass());
		setIconSclass(operacion.getIconSclass());
		setTooltiptext(operacion.getTooltiptext());
	}
	
	public ButtonToolbar(Operacion operacion) {
		super();
		this.operacion = operacion;
		initControl();
	}
	
	public ButtonToolbar(Integer id) {
		super();
		this.operacion = OperacionHelper.getPorType(OperacionEnum.values()[id]);
		initControl();
	}

	public Operacion getOperacion() {
		return operacion;
	}

}
