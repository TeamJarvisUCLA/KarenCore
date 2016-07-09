package karen.core.dialog.message_box.controllers;

import org.zkoss.zk.ui.event.Event;

import karen.core.dialog.generic.controllers.C_WindowDialog;
import karen.core.dialog.generic.enums.DialogActionEnum;
import karen.core.dialog.message_box.events.MessageBoxDialogCloseEvent;

public class C_GenericMessageBoxDialog extends C_WindowDialog {

	private static final long serialVersionUID = -2186472185534203665L;

	@Override
	public void doOnCreate() {
		// NOTHING OK!
	}

	@Override
	public void onAccept(Event event) {
		close(new MessageBoxDialogCloseEvent(event, DialogActionEnum.ACEPTAR));
	}

	@Override
	public void onCancel(Event event) {
		close(new MessageBoxDialogCloseEvent(event, DialogActionEnum.CANCELAR));
	}

}
