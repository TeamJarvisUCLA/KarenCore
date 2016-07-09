package karen.core.dialog.catalogue.simple_list.viewmodels;

import java.util.List;

import karen.core.dialog.catalogue.generic.events.CatalogueDialogCloseEvent;
import karen.core.dialog.catalogue.generic.viewmodels.VM_GenericCatalogueDialog;
import karen.core.dialog.catalogue.simple_list.controllers.C_SimpleListCatalogueDialog;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.event.Event;

@SuppressWarnings("unchecked")
public abstract class VM_SimpleListCatalogueDialog<T> extends VM_GenericCatalogueDialog<T> {

	protected List<T> objectList;
	
	public VM_SimpleListCatalogueDialog() {
		super();
		objectList = getObjectListToLoad();
	}
	
	@Init(superclass=true)
    public void childInit_VM_WindowSimpleListCatalogueDialog() {
		//NOTHING OK!
    }
	
	@Override
	public String validateData() {
		return getControllerWindowSimpleListCatalogueDialog().validateData();
	}

	@Override
	public CatalogueDialogCloseEvent<T> getDialogCloseEventOnAccept(Event event) {
		return getControllerWindowSimpleListCatalogueDialog().getDialogCloseEventOnAccept(event);
	}
	
	public C_SimpleListCatalogueDialog<T> getControllerWindowSimpleListCatalogueDialog() {
		return (C_SimpleListCatalogueDialog<T>) getControllerWindowDialog();
	}
	
	public List<T> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<T> objectList) {
		this.objectList = objectList;
		
		BindUtils.postNotifyChange(null, null, this, "objectList");
	}

	public abstract List<T> getObjectListToLoad();
}
