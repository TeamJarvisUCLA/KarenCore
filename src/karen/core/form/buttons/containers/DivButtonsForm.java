package karen.core.form.buttons.containers;

import java.util.Collection;

import karen.core.form.buttons.ButtonFormulario;
import karen.core.form.buttons.data.OperacionForm;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

public class DivButtonsForm extends org.zkoss.zul.Div {

	private static final long serialVersionUID = -3867908381773042135L;
	
	@SuppressWarnings("unchecked")
	public void createButtons(Collection<OperacionForm> operaciones) {
		this.getChildren().clear();
		
		DivButtonsForm div = new DivButtonsForm();
		div.setSclass("col s12 div-buttons-form");
		
		for (OperacionForm operacionForm : operaciones) {
			ButtonFormulario button = new ButtonFormulario(operacionForm);
			
			button.addEventListener(Events.ON_CLICK, funcionesListener);
			div.getChildren().add(button);
		}
		
		this.getChildren().add(div);
	}	
	
	private void lanzarEvento(OperacionForm operacion) {
		Events.postEvent("onSelectButtonFormulario", this, operacion);
	}	
	
	@SuppressWarnings("rawtypes")
	private EventListener funcionesListener = new EventListener() {
		
		@Override
		public void onEvent(Event event) throws Exception {
			Object t = event.getTarget();

			if (t instanceof ButtonFormulario) {
				ButtonFormulario buttonFormulario = (ButtonFormulario) t;

				OperacionForm operacion = buttonFormulario.getOperacionForm();
				lanzarEvento(operacion);
			} 	
		}		
	};
}
