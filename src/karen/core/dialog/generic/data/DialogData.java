package karen.core.dialog.generic.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import karen.core.dialog.generic.events.DialogCloseEvent;
import karen.core.dialog.generic.events.listeners.DialogCloseListener;

public class DialogData {

	private Map<String, Object> data = new HashMap<String, Object>();
	
	private List<DialogCloseListener> dialogCloseListeners = new ArrayList<DialogCloseListener>();

	public void addDialogCloseListeners(DialogCloseListener dialogCloseListener) {
		this.dialogCloseListeners.add(dialogCloseListener);
	}
	
	public void removeDialogCloseListeners(DialogCloseListener dialogCloseListener) {
		this.dialogCloseListeners.remove(dialogCloseListener);
	}

	public void triggerOnCloseEvent(DialogCloseEvent dialogCloseEvent) {
		for (DialogCloseListener listener : dialogCloseListeners) {
			listener.onClose(dialogCloseEvent);
		}
	}
	
	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public void put(String key, Object value) {
		this.data.put(key, value);
	}
	
	public Object get(String key) {
		return this.data.get(key);
	}
}
