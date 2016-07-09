package karen.core.crux.session.context;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class SesionContextHelper {
	
	private static ISesionContext getSesionContextActual() {
		
		ISesionContext iSesionContext;
		
		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			
			iSesionContext = (ISesionContext) session.get(ISesionContext.ID_SESION_CONTEXT);
			
			if (iSesionContext == null) {
				throw new NullPointerException("Sesion Context No Creada");
			}
		} catch (Exception e) {
			iSesionContext = new SesionContext();
		}
		
		return iSesionContext;
	}
	
	private static void setSesionContextActual(ISesionContext iSesionContext) {
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		session.put(ISesionContext.ID_SESION_CONTEXT, iSesionContext);	
	}
	
	public static Boolean isLogued() {
		return (getSesionContextActual().getLogued() == null)?false:getSesionContextActual().getLogued();
	}
	
	public static void setLogued(Boolean logued) {
		ISesionContext iSesionContext = SesionContextHelper.getSesionContextActual();
		
        iSesionContext.setLogued(logued);
        
        setSesionContextActual(iSesionContext);
	}
	
	public static void clear() {
		ActionContext.getContext().getSession().clear();
	}
}
