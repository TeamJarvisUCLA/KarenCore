package karen.core.dialog.catalogue.generic.data;

import karen.core.dialog.catalogue.generic.events.listeners.CatalogueDialogCloseListener;
import karen.core.dialog.generic.data.DialogData;

public class CatalogueDialogData<T> extends DialogData {
	
	public void addCatalogueDialogCloseListeners(CatalogueDialogCloseListener<T> catalogueDialogCloseListener) {
		addDialogCloseListeners(catalogueDialogCloseListener);
	}
	
	public void removeCatalogueDialogCloseListeners(CatalogueDialogCloseListener<T> catalogueDialogCloseListener) {
		addDialogCloseListeners(catalogueDialogCloseListener);
	}
}
