package karen.core.toolbar;

import ve.smile.seguridad.dto.Operacion;
import ve.smile.seguridad.enums.OperacionEnum;
import ve.smile.seguridad.enums.helper.OperacionHelper;

import org.zkoss.zul.Button;

public class ButtonToolbar extends Button {
	
	private static final long serialVersionUID = 6881487192821495408L;
	
	private Operacion operacion;
	
	private void initControl() {
		setSclass("btn-floating btn-small btn waves-effect waves-light " + operacion.getFkSclass().getNombre());
		setIconSclass(operacion.getFkIconSclass().getNombre());
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

	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}
	
	

}
