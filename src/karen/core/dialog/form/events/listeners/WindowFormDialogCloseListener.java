package karen.core.dialog.form.events.listeners;

import karen.core.dialog.form.events.WindowFormDialogCloseEvent;
import karen.core.dialog.generic.events.DialogCloseEvent;
import karen.core.dialog.generic.events.listeners.DialogCloseListener;

@SuppressWarnings("unchecked")
public abstract class WindowFormDialogCloseListener<T> extends DialogCloseListener {
	
	@Override
	public void onClose(DialogCloseEvent dialogCloseEvent) {
		onClose((WindowFormDialogCloseEvent<T>) dialogCloseEvent);
	}

	public abstract void onClose(WindowFormDialogCloseEvent<T> catalogueDialogCloseEvent);
}
