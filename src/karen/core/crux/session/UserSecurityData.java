package karen.core.crux.session;

import lights.seguridad.dto.Usuario;

public class UserSecurityData {
	
	private Usuario usuario;
	
	private String idRoles;
	
	private Integer idSesion;
	
	private String accessToken;

	public UserSecurityData(Usuario usuario, String idRoles, Integer idSesion, String accessToken) {
		super();
		this.usuario = usuario;
		this.idRoles = idRoles;
		this.idSesion = idSesion;
		this.accessToken = accessToken;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getIdRoles() {
		return idRoles;
	}

	public void setIdRoles(String idRoles) {
		this.idRoles = idRoles;
	}

	public Integer getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(Integer idSesion) {
		this.idSesion = idSesion;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
