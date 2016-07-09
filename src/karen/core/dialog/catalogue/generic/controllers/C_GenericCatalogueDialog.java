package karen.core.dialog.catalogue.generic.controllers;

import karen.core.dialog.catalogue.generic.enums.DialogResultEnum;
import karen.core.dialog.catalogue.generic.events.CatalogueDialogCloseEvent;
import karen.core.dialog.catalogue.generic.viewmodels.VM_GenericCatalogueDialog;
import karen.core.dialog.generic.controllers.C_WindowDialog;
import karen.core.dialog.generic.enums.DialogActionEnum;
import karen.core.util.UtilDialog;

import org.zkoss.zk.ui.event.Event;

@SuppressWarnings("unchecked")
public abstract class C_GenericCatalogueDialog<T> extends C_WindowDialog {

	private static final long serialVersionUID = -2673858390482673864L;

	public C_GenericCatalogueDialog() {
		super();
	}
	
	@Override
	public void onAccept(Event event) {
		String message = vm().validateData();
		
		if (message.length() > 0) {
			UtilDialog.showMessageBoxWarning(message);
			return;
		}
		
		close(vm().getDialogCloseEventOnAccept(event));
	}

	@Override
	public void onCancel(Event event) {
		close(new CatalogueDialogCloseEvent<T>(event, DialogActionEnum.CANCELAR, DialogResultEnum.NONE));
	}
	
	@Override
	public VM_GenericCatalogueDialog<T> vm() {
		return ((VM_GenericCatalogueDialog<T>)getAttributes().get("vm"));
	}
	
	public abstract String validateData();
}
