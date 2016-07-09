package karen.core.dialog.generic.controllers;

import karen.core.dialog.generic.data.DialogData;
import karen.core.dialog.generic.events.DialogCloseEvent;
import karen.core.dialog.generic.viewmodels.VM_WindowDialog;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zk.ui.util.ConventionWires;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class C_WindowDialog extends Window implements AfterCompose {

	private static final long serialVersionUID = 7915506007298613508L;
	
	private C_WindowDialog me;
	
	@SuppressWarnings("unused")
	private Button btnAccept, btnCancel;
	
	protected DialogData dialogData;

	public C_WindowDialog() {
		super();
		me = this;
		this.addEventListener("onCreate", eventListenerControllerWindowDialog);
	}
	
	@Override
	public void afterCompose() {
		ConventionWires.wireVariables(this, this);
		ConventionWires.addForwards(this, this);
	}
	
	
	protected EventListener eventListenerControllerWindowDialog = new EventListener() {
		
		@Override
		public void onEvent(Event event) throws Exception {
			vm().setControllerWindowDialog(me);

			dialogData = vm().getDialogData();
			
			doOnCreate();
		}
	};
	
	public void onClick$btnAccept(Event event) {	
		onAccept(event);
	}

	public void close(DialogCloseEvent dialogCloseEvent) {
		
		if (dialogData != null) {
			dialogData.triggerOnCloseEvent(dialogCloseEvent);
		}
		
		detach();
	}
	
	public void onClick$btnCancel(Event event) {
		onCancel(event);
	}

	public DialogData getDialogData() {
		return dialogData;
	}

	public void setDialogData(DialogData dialogData) {
		this.dialogData = dialogData;
	}

	public C_WindowDialog getMe() {
		return me;
	}

	public void setMe(C_WindowDialog me) {
		this.me = me;
	}
	
	public VM_WindowDialog vm() {
		return ((VM_WindowDialog) getAttributes().get("vm"));
	}
	
	public abstract void onAccept(Event event);
	
	public abstract void onCancel(Event event);
	
	public abstract void doOnCreate();
}
