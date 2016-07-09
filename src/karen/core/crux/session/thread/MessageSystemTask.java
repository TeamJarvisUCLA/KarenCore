package karen.core.crux.session.thread;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.DesktopUnavailableException;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
 
public class MessageSystemTask implements Runnable {
 
    private final Desktop desktop;
    private final EventListener<Event> eventListener;
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public MessageSystemTask(Desktop desktop, EventListener eventListener) {
        this.desktop = desktop;
        this.eventListener = eventListener;
    }
 
    @Override
    public void run() {
        try {
        	if (desktop.isAlive()) {
        		Executions.schedule(desktop, eventListener, null);
        	}
        } catch (DesktopUnavailableException e) {
            System.err.println("Desktop is no longer available: " + desktop);
        }
    }
 
}