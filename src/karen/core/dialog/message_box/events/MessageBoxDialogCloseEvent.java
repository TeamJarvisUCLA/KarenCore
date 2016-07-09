package karen.core.dialog.message_box.events;

import karen.core.dialog.generic.enums.DialogActionEnum;
import karen.core.dialog.generic.events.DialogCloseEvent;

import org.zkoss.zk.ui.event.Event;

public class MessageBoxDialogCloseEvent extends DialogCloseEvent {

	private static final long serialVersionUID = -9201622502277100991L;

	public MessageBoxDialogCloseEvent(Event event, DialogActionEnum dialogActionEnum) {
		super(event, dialogActionEnum);
	}

}
