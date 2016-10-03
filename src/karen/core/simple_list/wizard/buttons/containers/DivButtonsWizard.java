package karen.core.simple_list.wizard.buttons.containers;

import java.util.Collection;

import karen.core.simple_list.wizard.buttons.ButtonWizard;
import karen.core.simple_list.wizard.buttons.data.OperacionWizard;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

public class DivButtonsWizard extends org.zkoss.zul.Div {

	private static final long serialVersionUID = -3867908381773042135L;

	@SuppressWarnings("unchecked")
	public void createButtons(Collection<OperacionWizard> operaciones) {
		this.getChildren().clear();

		DivButtonsWizard div = new DivButtonsWizard();
		div.setSclass("col s12 div-buttons-wizard");

		for (OperacionWizard operacionWizard : operaciones) {
			ButtonWizard button = new ButtonWizard(operacionWizard);

			button.addEventListener(Events.ON_CLICK, funcionesListener);
			div.getChildren().add(button);
		}

		this.getChildren().add(div);
	}

	private void lanzarEvento(OperacionWizard operacion) {
		Events.postEvent("onSelectButtonWizard", this, operacion);
	}

	@SuppressWarnings("rawtypes")
	private EventListener funcionesListener = new EventListener() {
		public void onEvent(Event event) throws Exception {
			Object t = event.getTarget();

			if (t instanceof ButtonWizard) {
				ButtonWizard buttonWizard = (ButtonWizard) t;

				OperacionWizard operacion = buttonWizard.getOperacionWizard();
				lanzarEvento(operacion);
			}
		}
	};
}
