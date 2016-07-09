package karen.core.struts2.filter;

import karen.core.crux.session.context.SesionContextHelper;

//import luces.delnorte.seguridad.context.SesionContextHelper;

public class Filter {
 
    public String execute() {
    	if (SesionContextHelper.isLogued()) {
    		return "success";
    	}
    	
    	return "error";
    }
 
  
}