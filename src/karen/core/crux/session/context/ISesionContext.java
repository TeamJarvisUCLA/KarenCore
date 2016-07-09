package karen.core.crux.session.context;

public interface ISesionContext {
	
	public static final String ID_SESION_CONTEXT = "SESION_CONTEXT";
	public static final String ID_SESION_TABLE = "SESION_TABLE";
	
	public Boolean getLogued();

	public void setLogued(Boolean logued);
}

