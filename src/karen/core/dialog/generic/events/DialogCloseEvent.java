package karen.core.dialog.generic.events;

import java.util.HashMap;
import java.util.Map;

import karen.core.dialog.generic.enums.DialogActionEnum;

import org.zkoss.zk.ui.event.Event;

public class DialogCloseEvent extends Event {

	private static final long serialVersionUID = -4534323049194695822L;
	
	protected DialogActionEnum dialogAction;
	
	protected Map<String, Object> data = new HashMap<String, Object>();
	
	public DialogCloseEvent(Event event, DialogActionEnum dialogActionEnum) {
		super(event.getName(), event.getTarget(), event.getData());
		
		dialogAction = dialogActionEnum;
	}

	public DialogActionEnum getDialogAction() {
		return dialogAction;
	}

	public void setDialogAction(DialogActionEnum dialogAction) {
		this.dialogAction = dialogAction;
	}

	public void put(String key, Object value) {
		data.put(key, value);
	}
	
	public Object get(String key) {
		return data.get(key);
	}
}
