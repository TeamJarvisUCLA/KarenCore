package karen.core.dialog.generic.viewmodels;

import karen.core.dialog.generic.controllers.C_WindowDialog;
import karen.core.dialog.generic.data.DialogData;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Init;

public abstract class VM_WindowDialog {
	
	private DialogData dialogData;
	
	private C_WindowDialog controllerWindowDialog;
	
	public VM_WindowDialog() {
		super();
	}
	
	@Init
    public void childInit_VM_WindowDialog(@BindingParam("dialogData") DialogData dialogData) {
		this.dialogData = dialogData;
		
		afterChildInit();
    }

	public DialogData getDialogData() {
		return dialogData;
	}

	public void setDialogData(DialogData dialogData) {
		this.dialogData = dialogData;
	}

	public void setControllerWindowDialog(C_WindowDialog controllerWindowDialog) {
		this.controllerWindowDialog = controllerWindowDialog;
	}

	public C_WindowDialog getControllerWindowDialog() {
		return controllerWindowDialog;
	}
	
	public abstract void afterChildInit();
}
