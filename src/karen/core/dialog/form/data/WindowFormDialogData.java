package karen.core.dialog.form.data;


import ve.smile.seguridad.enums.OperacionEnum;
import karen.core.dialog.form.events.listeners.WindowFormDialogCloseListener;
import karen.core.dialog.generic.data.DialogData;

public class WindowFormDialogData<T> extends DialogData {
	
	private OperacionEnum operacionEnum;
	private T entity;
	
	public void addWindowFormDialogCloseListeners(WindowFormDialogCloseListener<T> windowDialogCloseListener) {
		addDialogCloseListeners(windowDialogCloseListener);
	}
	
	public void removeWindowFormDialogCloseListeners(WindowFormDialogCloseListener<T> windowDialogCloseListener) {
		addDialogCloseListeners(windowDialogCloseListener);
	}

	public OperacionEnum getOperacionEnum() {
		return operacionEnum;
	}

	public void setOperacionEnum(OperacionEnum operacionEnum) {
		this.operacionEnum = operacionEnum;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	
}
