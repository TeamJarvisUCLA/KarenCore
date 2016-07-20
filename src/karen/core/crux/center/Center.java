package karen.core.crux.center;

import karen.core.crux.session.DataCenter;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Div;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Center extends Div {

	private static final long serialVersionUID = -318611469489307546L;
	
	private Center me;

	public Center() {
		super();
		me = this;
		this.addEventListener("onCreate", eventListenerCenter);
	}
	
	protected EventListener eventListenerCenter = new EventListener() {
		
		@Override
		public void onEvent(Event event) throws Exception {
			vm().setCenter(me);
		}
	};
	
	public DataCenter vm() {
		return ((DataCenter) getAttributes().get("vm"));
	}
}
