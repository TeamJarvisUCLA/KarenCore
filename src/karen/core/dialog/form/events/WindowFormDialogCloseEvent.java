package karen.core.dialog.form.events;

import org.zkoss.zk.ui.event.Event;

import karen.core.dialog.generic.events.DialogCloseEvent;
import karen.core.form.buttons.enums.OperacionFormEnum;

public class WindowFormDialogCloseEvent<T> extends DialogCloseEvent {

	private static final long serialVersionUID = -2139637294855154044L;

	private T entity;
	private OperacionFormEnum operacionFormEnum;
	
	public WindowFormDialogCloseEvent(T entity, OperacionFormEnum operacionFormEnum) {
		super(new Event("windowFormDialogCloseEvent", null, null), null);
		this.entity = entity;
		this.operacionFormEnum = operacionFormEnum;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public OperacionFormEnum getOperacionFormEnum() {
		return operacionFormEnum;
	}

	public void setOperacionFormEnum(OperacionFormEnum operacionFormEnum) {
		this.operacionFormEnum = operacionFormEnum;
	}
	
}
