package karen.core.crux.session.listener_zk;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpSession;

import karen.core.crux.session.DataCenter;
import karen.core.crux.session.thread.MessageSystemTask;
import lights.seguridad.consume.services.SesionService;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.SessionCleanup;
import org.zkoss.zk.ui.util.SessionInit;
import org.zkoss.zk.ui.util.WebAppCleanup;
import org.zkoss.zk.ui.util.WebAppInit;

public class MySessionListener implements SessionInit, SessionCleanup, WebAppInit, WebAppCleanup {

	private static Map<String, Integer> mapaSesiones;
	
	private static Map<String, MessageSystemTask> mapaTask;
	
	private static volatile ExecutorService executor;
	
	@Override
	public void init(Session sess, Object request) throws Exception {
//		HttpSession session = (HttpSession) sess.getNativeSession();
	}

	@Override
	public void cleanup(Session sess) throws Exception {
		HttpSession session = (HttpSession) sess.getNativeSession();
		
		Integer idSesion = removeIdSesion(session.getId());
		if (idSesion != null) {
			new SesionService().cerrarSesionWeb(idSesion);
			
//			SesionContextHelper.clear();
			DataCenter.removeUserData(session.getId());
			DataCenter.removeUserSecurityData(session.getId());
			mapaTask.remove(session.getId());
		}
	}

	public static void putIdSesion(String idHttpSession, Integer idSesion) {
		mapaSesiones.put(idHttpSession, idSesion);
	}
	
	public static Integer removeIdSesion(String idHttpSession) {
		return mapaSesiones.remove(idHttpSession);
	}
 
	@Override
    public void cleanup(WebApp wapp) throws Exception {
        if (executor != null) {
            executor.shutdown();
        }
    }
 
	@Override
    public void init(WebApp wapp) throws Exception {
    	mapaSesiones = new HashMap<String, Integer>();
    	mapaTask = new HashMap<String, MessageSystemTask>();
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }
    
    public static void addTask(String session, MessageSystemTask sampleTask) {
    	mapaTask.put(session, sampleTask);
    }
    
    public static void removeTask(String session) {
    	mapaTask.remove(session);
    }
    
    public static void execute() {
    	for (MessageSystemTask s : mapaTask.values()) {
			executor.execute(s);
		}
    }
}
