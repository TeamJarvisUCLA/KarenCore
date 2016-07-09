package karen.core.dialog.catalogue.generic.events;

import java.util.List;

import org.zkoss.zk.ui.event.Event;

import karen.core.dialog.catalogue.generic.enums.DialogResultEnum;
import karen.core.dialog.generic.enums.DialogActionEnum;
import karen.core.dialog.generic.events.DialogCloseEvent;

public class CatalogueDialogCloseEvent<T> extends DialogCloseEvent {

	private static final long serialVersionUID = -2139637294855154044L;

	private T entity;
	
	private List<T> entities;
	
	private DialogResultEnum dialogResult;
	
	public CatalogueDialogCloseEvent(Event event, T entity) {
		super(event, DialogActionEnum.ACEPTAR);
		
		dialogResult = DialogResultEnum.ONE;
		this.entity = entity;
	}
	
	public CatalogueDialogCloseEvent(Event event, List<T> entities) {
		super(event, DialogActionEnum.ACEPTAR);
	
		dialogResult = DialogResultEnum.MANY;
		this.entities = entities;
	}
	
	public CatalogueDialogCloseEvent(Event event, DialogActionEnum dialogAction, DialogResultEnum dialogResult) {
		super(event, dialogAction);
		
		this.dialogResult = dialogResult;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public List<T> getEntities() {
		return entities;
	}

	public void setEntities(List<T> entities) {
		this.entities = entities;
	}
	
	public DialogResultEnum getDialogResult() {
		return dialogResult;
	}

	public void setDialogResult(DialogResultEnum dialogResult) {
		this.dialogResult = dialogResult;
	}
}
