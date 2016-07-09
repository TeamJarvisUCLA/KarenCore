package karen.core.dialog.catalogue.generic.viewmodels;

import karen.core.dialog.catalogue.generic.controllers.C_GenericCatalogueDialog;
import karen.core.dialog.catalogue.generic.events.CatalogueDialogCloseEvent;
import karen.core.dialog.generic.viewmodels.VM_WindowDialog;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.event.Event;

@SuppressWarnings("unchecked")
public abstract class VM_GenericCatalogueDialog<T> extends VM_WindowDialog {

	protected Object selectedObject;
	
	public VM_GenericCatalogueDialog() {
		super();
	}
	
	@Init(superclass=true)
    public void childInit_VM_WindowGenericCatalogueDialog() {
		//NOTHING OK!
    }

	public Object getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(Object selectedObject) {
		this.selectedObject = selectedObject;
	}
	
	public C_GenericCatalogueDialog<T> getControllerWindowGenericCatalogueDialog() {
		return (C_GenericCatalogueDialog<T>) getControllerWindowDialog();
	}

	public abstract String validateData();
	
	public abstract CatalogueDialogCloseEvent<T> getDialogCloseEventOnAccept(Event event);
}
