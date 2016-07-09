package karen.core.crux.session;

import java.util.HashMap;
import java.util.Map;

import lights.seguridad.dto.NodoMenu;
import lights.seguridad.dto.Operacion;
import lights.seguridad.enums.OperacionEnum;
import lights.seguridad.enums.helper.OperacionHelper;

public class UserData {

	private String srcPageContent;
	
	private NodoMenu nodoMenu;
	
	private Object entity;
	
	private Operacion operacion;
	
	private Map<String, Object> datosAdicionales;
	
	private String ip;
	
	private String title;
	
	public UserData() {
		super();
		datosAdicionales = new HashMap<String, Object>();
		title = "";
	}
	
	public UserData(String ip) {
		this();
		
		this.ip = ip;
	}

	public String getSrcPageContent() {
		return srcPageContent;
	}

	public void setSrcPageContent(String srcPageContent) {
		this.srcPageContent = srcPageContent;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public Operacion getOperacion() {
		if (operacion == null) {
			return OperacionHelper.getPorType(OperacionEnum.NONE);
		}
		return operacion;
	}

	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}

	public NodoMenu getNodoMenu() {
		return nodoMenu;
	}

	public void setNodoMenu(NodoMenu nodoMenu) {
		this.nodoMenu = nodoMenu;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public void put(String key, Object datoAdicional) {
		datosAdicionales.put(key, datoAdicional);
	}
	
	public Object get(String key) {
		return datosAdicionales.get(key);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
