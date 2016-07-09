package karen.core.crux.session;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import karen.core.crux.session.listener_zk.MySessionListener;
import karen.core.crux.session.thread.MessageSystemTask;
import karen.core.util.UtilDialog;
import lights.seguridad.dto.NodoMenu;
import lights.seguridad.dto.Operacion;
import lights.seguridad.dto.Perfil;
import lights.seguridad.enums.OperacionEnum;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

public class DataCenter {

	private static Map<String, UserData> usersData;
	
	private static Map<String, UserSecurityData> usersSecurityData;
	
	private static String messageSystem;

    static {
    	usersData = new HashMap<String, UserData>();
    	usersSecurityData = new HashMap<String, UserSecurityData>();
    	messageSystem = "";
    }
	
	public DataCenter() {
		super();
		
		if (!usersData.containsKey(getZkSession())) {
			usersData.put(getZkSession(), new UserData(Executions.getCurrent().getRemoteAddr()));
		} else {
			MySessionListener.removeTask(DataCenter.getZkSession());
		}
		
		registerThread();
	}
	
	public void registerThread() {
		Desktop desktop = Executions.getCurrent().getDesktop();
		
		desktop.enableServerPush(true);
		
		MySessionListener.addTask(DataCenter.getZkSession(), new MessageSystemTask(desktop, new EventListener<Event>() {

			public void onEvent(Event event) throws Exception {
				UtilDialog.showMessageSystem(DataCenter.getMessageSystem());
			}
		}));
	}
	
	public static void updateSrcPageContent(Object objeto, Operacion operacion, String archivoZul) {
		Map<String, Object> args = new HashMap<String, Object>();
	
		args.put("operacion", operacion);
		args.put("entity", objeto);
		args.put("archivoZul", archivoZul);
	
		BindUtils.postGlobalCommand(null, null, "updateSrcPageContentByOperacion", args);
	}
	
	@GlobalCommand
	@NotifyChange({ "srcPageContent" })
	public void updateSrcPageContentByOperacion(@BindingParam("entity") Object entity,
			@BindingParam("operacion") Operacion operacion, @BindingParam("archivoZul") String archivoZul) {
		
		UserData u = u();
		
		u.setEntity(entity);
		u.setOperacion(operacion);
		u.setSrcPageContent(archivoZul);
	}
	
	public static void updateSrcPageContent(NodoMenu nodoMenu) {
		Map<String, Object> args = new HashMap<String, Object>();
	
		args.put("nodoMenu", nodoMenu);
	
	//	ControladorMensaje.eliminarMensaje();
		
		BindUtils.postGlobalCommand(null, null, "updateSrcPageContentByNodoMenu", args);
	}
	
	@GlobalCommand
	@NotifyChange("srcPageContent")
	public void updateSrcPageContentByNodoMenu(@BindingParam("nodoMenu") NodoMenu nodoMenu) {
//		if (nodoMenu.getFkVista().getNombre().equals(srcPageContent)) {
//			
//			srcPageContent = BASE_PATH + "/viewNothing.zul";
//			
//			BindUtils.postNotifyChange(null, null, this, "srcPageContent");
//		}
		
		UserData u = u();
		
		u.setSrcPageContent(nodoMenu.getFkVista().getArchivoZul());
		
		u.setNodoMenu(nodoMenu);
		u.setEntity(null);
		u.setOperacion(null);
		
		DataCenter.updateTitle(nodoMenu.getNombre());
	}
	
	public static void updateTitle(String title) {
		Map<String, Object> args = new HashMap<String, Object>();

		args.put("title", title);
		
		BindUtils.postGlobalCommand(null, null, "updateTheTitleHeaderCenter", args);
	}

	@GlobalCommand
	@NotifyChange("titleHeaderCenter")
	public void updateTheTitleHeaderCenter(@BindingParam("title") String title) {
		u().setTitle(title);
	}
	
	public void put(String key, Object datoAdicional) {
		u().put(key, datoAdicional);
	}
	
	public Object get(String key) {
		return u().get(key);
	}
	
	public static void reloadCurrentNodoMenu() {
		updateSrcPageContent(getNodoMenu());
	}
	
	public static Object getEntity() {
		return u().getEntity();
	}
	
	public static NodoMenu getNodoMenu() {
		return u().getNodoMenu();
	}

	public static Operacion getOperacion() {
		return u().getOperacion();
	}
	
	public static OperacionEnum getOperacionEnum() {
		return OperacionEnum.values()[u().getOperacion().getIdOperacion()];
	}
	
	public String getSrcPageContent() {
		return u().getSrcPageContent();
	}
	
	public String getTitleHeaderCenter() {
		return u().getTitle();
	}
	
	public static String getZkSession() {
		HttpSession s = (HttpSession) Sessions.getCurrent().getNativeSession();
		
		return s.getId();
	}
	
	public static UserData u() {
		return usersData.get(getZkSession());
	}
	
	public static void setUserData(UserData userData) {
		usersData.put(getZkSession(), userData);
	}
	
	public static UserData removeUserData(String zkSession) {
		return usersData.remove(zkSession);
	}
	
	public static String getIp() {
		return u().getIp();
	}

	public static String getMessageSystem() {
		return messageSystem;
	}

	public static void setMessageSystem(String messageSystem) {
		DataCenter.messageSystem = messageSystem;
	}
	
	public static UserSecurityData removeUserSecurityData(String zkSession) {
		return usersSecurityData.remove(zkSession);
	}
	
	public static void setUserSecurityData(UserSecurityData userSecurityData) {
		usersSecurityData.put(getZkSession(), userSecurityData);
	}
	
	public static UserSecurityData getUserSecurityData() {
		return usersSecurityData.get(getZkSession());
	}
	
	public static Perfil getPerfil() {
		return getUserSecurityData().getPerfil();
	}
	
	public boolean getLogued() {
		return getUserSecurityData() != null;
	}
	
	public boolean getLoguedAndPerfilValid() {
		return getUserSecurityData() != null && getPerfil().getIdPerfil() != null;
	}
	
	public boolean getLoguedAndPerfilNotValid() {
		return getUserSecurityData() != null && getPerfil().getIdPerfil() == null;
	}
	
	public static void putDatoAdicional(String key, Object datoAdicional) {
		u().put(key, datoAdicional);
	}
	
	public static Object getDatoAdicional(String key) {
		return u().get(key);
	}
	
	public static Integer clear() {
		String zkSession = getZkSession();
		
		usersSecurityData.remove(zkSession);
		usersData.remove(zkSession);
		MySessionListener.removeTask(zkSession);
		return MySessionListener.removeIdSesion(zkSession);
	}
	
	public static Integer getIdSesion() {
		return getUserSecurityData().getIdSesion();
	}
	
	public static String getAccessToken() {
		return getUserSecurityData().getAccessToken();
	}
	
	public static String getEndPoint() {
		return "http://localhost:8181/SmileWebService";
	}
}
