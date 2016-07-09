package karen.core.wizard.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import karen.core.crux.alert.Alert;
import karen.core.wizard.buttons.containers.DivButtonsWizard;
import karen.core.wizard.buttons.containers.UlHeaderWizard;
import karen.core.wizard.buttons.data.OperacionWizard;
import karen.core.wizard.viewmodels.VM_WindowWizard;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zk.ui.util.ConventionWires;
import org.zkoss.zul.Window;

@SuppressWarnings({"unchecked","rawtypes"})
public class C_WindowWizard extends Window implements AfterCompose {

	private static final long serialVersionUID = 1277148899732272894L;
	
	private Stack<Integer> stack = new Stack<Integer>();

	protected DivButtonsWizard divButtonsWizard;
	protected UlHeaderWizard ulHeaderWizard;
	
	private C_WindowWizard me;
	
	private Integer currentStep = 1;
	
	private Integer nextStep = 0;

	public C_WindowWizard() {
		super();
		me = this;
		this.addEventListener("onCreate", createListener);
	}

	protected EventListener createListener = new EventListener() {
		
		@Override
		public void onEvent(Event event) throws Exception {
			vm().setControllerWindowWizard(me);
			
			restartWizard();
		}
	};

	@Override
	public void afterCompose() {
		ConventionWires.wireVariables(this, this);
		ConventionWires.addForwards(this, this);
	}
	
	public void goToNextStep() {
		if (nextStep > 0) {
			
			int resultado = nextStep - currentStep;
			
			if (resultado > 0) {
				for(int i = 0; i < resultado; i++) {
					nextIcon();
				}
			} else {
				resultado = Math.abs(resultado);
				
				for(int i = 0; i < resultado; i++) {
					previousIcon();
				}
			}
			
			stack.push(currentStep);
			
			currentStep = nextStep;
			nextStep = 0;
		} else {
			stack.push(currentStep);
			
			currentStep++;
			nextIcon();
		}
		
		vm().comeIn(currentStep);
		updateButtonsAndSrcPageContent();
	}

	public void goToPreviousStep() {
		Integer previousStack = stack.pop();
		
		while (previousStack < currentStep) {
			previousIcon();
			currentStep--;
		}
		
		updateButtonsAndSrcPageContent();
	}
	
	public void updateButtonsAndSrcPageContent() {
		Map<Integer, List<OperacionWizard>> botonesTodosStep = vm().getButtonsToStep();
		
		List<OperacionWizard> buttonsCurrentStep = botonesTodosStep.get(currentStep);
		
//		Collections.sort(botonesStepActual);
		
		if (divButtonsWizard != null) {
			divButtonsWizard.createButtons(buttonsCurrentStep);
		}
		
		String url = vm().getUrlPageToStep().get(currentStep-1);
		
		vm().setSrcPageContent(url);
	}
	
	public void restartWizard() {
		currentStep =  vm().getInitStep();
		
		vm().comeIn(currentStep);
		
		if (ulHeaderWizard != null) {
			ulHeaderWizard.createHeader(vm().getIconsToStep());
		}
		
		updateButtonsAndSrcPageContent();
	}
	
	public void onSelectButtonWizard$divButtonsWizard(Event event) throws InterruptedException {
		if (!(event instanceof ForwardEvent)) {
			return;
		}
		ForwardEvent forwardEvent = (ForwardEvent) event;

		OperacionWizard operacionWizard = (OperacionWizard) forwardEvent.getOrigin().getData();
		
		try {
			this.getClass().getMethod("action", String.class).invoke(this,
					operacionWizard.getNombre());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void action(String nombreOperacion) {
		try {
			VM_WindowWizard viewModel = vm();
			
			String isValidPreconditions = (String) viewModel.getClass().getMethod("isValidPreconditions" + nombreOperacion, Integer.class).invoke(viewModel, currentStep);
			
			if (!isValidPreconditions.equals("")) {
				Alert.showMessage(isValidPreconditions);
				return;
			}
			
			String isValidSearchData = (String) viewModel.getClass().getMethod("isValidSearchData" + nombreOperacion, Integer.class).invoke(viewModel, currentStep);
			
			if (!isValidSearchData.equals("")) {
				Alert.showMessage(isValidSearchData);
				return;
			}
			
			String mensaje = (String) viewModel.getClass().getMethod("execute" + nombreOperacion, Integer.class).invoke(viewModel, currentStep);
			
			Alert.hideMessage();
			
			if (mensaje != null && mensaje.length() != 0) {
				Alert.showMessage(mensaje);
			}
			
//			postExecute(nombreOperacion);
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			mostrarMensajeErrorInesperado();
			
			e.printStackTrace();
		}
	}
	
	private void nextIcon() {
		if (ulHeaderWizard != null) {
			ulHeaderWizard.nextIcon();
		}
	}
	
	private void previousIcon() {
		if (ulHeaderWizard != null) {
			ulHeaderWizard.previousIcon();
		}
	}
	
	private void mostrarMensajeErrorInesperado() {
		Alert.showMessage("E:Error Code: 102-Ha ocurrido un error inesperado. ");
	}

	public Integer getNextStep() {
		return nextStep;
	}

	public void setNextStep(Integer nextStep) {
		this.nextStep = nextStep;
	}
	
	public VM_WindowWizard vm() {
		return ((VM_WindowWizard) getAttributes().get("vm"));
	}
}
