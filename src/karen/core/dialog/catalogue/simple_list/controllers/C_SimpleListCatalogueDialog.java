package karen.core.dialog.catalogue.simple_list.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import karen.core.dialog.catalogue.generic.controllers.C_GenericCatalogueDialog;
import karen.core.dialog.catalogue.generic.events.CatalogueDialogCloseEvent;
import karen.core.dialog.catalogue.simple_list.viewmodels.VM_SimpleListCatalogueDialog;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

@SuppressWarnings({"unchecked", "rawtypes"})
public class C_SimpleListCatalogueDialog<T> extends C_GenericCatalogueDialog {

	private static final long serialVersionUID = -5941020541969583262L;

	@Wire
	protected Listbox listbox;
	
	public C_SimpleListCatalogueDialog() {
		super();
	}

	@Override
	public String validateData() {
		Object selectedObject = getSelectedObject();
		
		if (!listbox.isMultiple()) {
			if (selectedObject == null) {
				return "Debe seleccionar un registro de la lista";
			}
			
			return "";
		}
		
		if (listbox.getSelectedCount() > 0) {
			return "";
		}
		
		if (selectedObject != null) {
			return "";
		}
		
		return "Debe seleccionar un registro de la lista";
	}
	
	public Object getSelectedObject() {
		return vm().getSelectedObject();
	}
	
	public CatalogueDialogCloseEvent<T> getDialogCloseEventOnAccept(Event event) {
		if (!listbox.isMultiple()) {
			return new CatalogueDialogCloseEvent<T>(event, (T) getSelectedObject());
		}
		
		List<T> listaObjetosSeleccionados = new ArrayList<T>();
		
		if (listbox.getSelectedCount() > 1) {
			Set selectedListbox = listbox.getSelectedItems();
			ListModel listModel = listbox.getModel();

			for (Iterator i = selectedListbox.iterator(); i.hasNext();) {
				Listitem item = (Listitem) i.next();

				if (listModel != null) {
					if (listModel.getElementAt(item.getIndex()) != null) {
						Object valor = listModel.getElementAt(item
								.getIndex());
						listaObjetosSeleccionados.add((T) valor);
					}
				}
			}
			
		} else {
			listaObjetosSeleccionados.add((T) getSelectedObject());
		}
		
		return new CatalogueDialogCloseEvent<T>(event, listaObjetosSeleccionados);
	}
	
	@Override
	public VM_SimpleListCatalogueDialog<T> vm() {
		return ((VM_SimpleListCatalogueDialog<T>) getAttributes().get("vm"));
	}

	@Override
	public void doOnCreate() {
		//NOTHING OK!
	}
}
