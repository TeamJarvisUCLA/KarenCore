package karen.core.dialog.message_system.viewmodels;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

import karen.core.dialog.generic.viewmodels.VM_WindowDialog;
import karen.core.dialog.message_system.data.MessageSystemDialogData;

public class VM_MessageSystemDialog extends VM_WindowDialog {

	protected String text;
	
	@Init(superclass=true)
    public void childInit_VM_GenericMessageBoxDialog() {
		//NOTHING OK!
    }
	
	public VM_MessageSystemDialog() {
		super();
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void afterChildInit() {
		MessageSystemDialogData messageSystemDialogData = (MessageSystemDialogData) getDialogData();
		
		this.text = messageSystemDialogData.getText();
	}
	
	@Command("closed")
	public void closed() {
		getControllerWindowDialog().detach();
	}
}
