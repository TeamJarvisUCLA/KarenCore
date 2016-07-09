package karen.core.struts2.obelisco.dispatcher;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.RequestUtils;
import org.apache.struts2.dispatcher.StrutsRequestWrapper;


public class Dispatcher extends org.apache.struts2.dispatcher.Dispatcher {

	private String zkuri;
	
	public Dispatcher(ServletContext servletContext,
			Map<String, String> initParams) {
		super(servletContext, initParams);
		zkuri = initParams.get("zk-uri");
	}

	@Override
	public HttpServletRequest wrapRequest(HttpServletRequest request,
			ServletContext servletContext) throws IOException {
		if (request instanceof StrutsRequestWrapper) {
            return request;
        }

		String resourcePath = RequestUtils.getServletPath(request);
        if (resourcePath.indexOf(zkuri) != -1) {
        	return request;
        }
				
		return super.wrapRequest(request, servletContext);
	}

}
