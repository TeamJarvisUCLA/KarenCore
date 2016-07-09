package karen.core.dialog.catalogue.generic.events.listeners;

import karen.core.dialog.catalogue.generic.events.CatalogueDialogCloseEvent;
import karen.core.dialog.generic.events.DialogCloseEvent;
import karen.core.dialog.generic.events.listeners.DialogCloseListener;

@SuppressWarnings("unchecked")
public abstract class CatalogueDialogCloseListener<T> extends DialogCloseListener {
	
	@Override
	public void onClose(DialogCloseEvent dialogCloseEvent) {
		onClose((CatalogueDialogCloseEvent<T>) dialogCloseEvent);
	}

	public abstract void onClose(CatalogueDialogCloseEvent<T> catalogueDialogCloseEvent);
}
