package karen.core.toolbar;

import java.util.Collection;

import ve.smile.seguridad.dto.Operacion;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

public class Toolbar extends org.zkoss.zul.Toolbar {

	private static final long serialVersionUID = -3867908381773042135L;
	
	@SuppressWarnings("unchecked")
	public void createButtons(Collection<Operacion> operaciones) {
		this.getChildren().clear();
		this.setSclass("ka-toolbar");
		
		for (Operacion operacion : operaciones) {
			ButtonToolbar button = new ButtonToolbar(operacion);
			
			button.addEventListener(Events.ON_CLICK, funcionesListener);
			this.getChildren().add(button);
		}
	}	
	
	private void lanzarEvento(Operacion operacion) {
		Events.postEvent("onSelectButtonToolbar", this, operacion);
	}	

	@SuppressWarnings("rawtypes")
	private EventListener funcionesListener = new EventListener() {
		
		@Override
		public void onEvent(Event event) throws Exception {
			Object t = event.getTarget();

			if (t instanceof ButtonToolbar) {
				ButtonToolbar buttonToolbar = (ButtonToolbar) t;

				Operacion operacion = buttonToolbar.getOperacion();
				lanzarEvento(operacion);
			} 	
		}		
	};
	
	public void setTooltiptextAUnBoton(Operacion operacion, String tooltiptext) {
		for (Component component : this.getChildren()) {
			if (component instanceof ButtonToolbar) {
				ButtonToolbar button = (ButtonToolbar) component;
				
				if (button.getOperacion().equals(operacion)) {
					button.setTooltiptext(tooltiptext);
					break;
				}
			}
		}
	}
	
	public void setIconSclassAUnBoton(Operacion operacion, String iconSclass) {
		for (Component component : this.getChildren()) {
			if (component instanceof ButtonToolbar) {
				ButtonToolbar button = (ButtonToolbar) component;
				
				if (button.getOperacion().equals(operacion)) {
					button.setIconSclass(iconSclass);
					break;
				}
			}
		}
	}
	
	public void setSclassColorAUnBoton(Operacion operacion, String iconSclass) {
		for (Component component : this.getChildren()) {
			if (component instanceof ButtonToolbar) {
				ButtonToolbar button = (ButtonToolbar) component;
				
				if (button.getOperacion().equals(operacion)) {
					button.setSclass("btn-floating btn-small btn waves-effect waves-light " + iconSclass);
					break;
				}
			}
		}
	}
	
	public void refrescarBoton(Operacion operacion) {
		for (Component component : this.getChildren()) {
			if (component instanceof ButtonToolbar) {
				ButtonToolbar button = (ButtonToolbar) component;
				
				if (button.getOperacion().equals(operacion)) {
					button.setOperacion(operacion);
					button.setSclass("btn-floating btn-small btn waves-effect waves-light " + operacion.getFkSclass().getNombre());
					button.setIconSclass(operacion.getFkIconSclass().getNombre());
					button.setTooltiptext(operacion.getTooltiptext());
					
					break;
				}
			}
		}
	}
}
