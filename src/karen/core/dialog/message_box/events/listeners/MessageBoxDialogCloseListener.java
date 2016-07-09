package karen.core.dialog.message_box.events.listeners;

import karen.core.dialog.generic.events.DialogCloseEvent;
import karen.core.dialog.generic.events.listeners.DialogCloseListener;
import karen.core.dialog.message_box.events.MessageBoxDialogCloseEvent;

public abstract class MessageBoxDialogCloseListener extends DialogCloseListener {
	
	@Override
	public void onClose(DialogCloseEvent dialogCloseEvent) {
		onClose((MessageBoxDialogCloseEvent) dialogCloseEvent);
	}

	public abstract void onClose(MessageBoxDialogCloseEvent messageBoxDialogCloseEvent);
}
