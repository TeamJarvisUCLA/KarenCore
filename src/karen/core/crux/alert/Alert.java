package karen.core.crux.alert;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import lights.core.payload.response.IPayloadResponse;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;

public class Alert {

	private static ResourceBundle mensajeBundle = ResourceBundle.getBundle("karen.core.crux.alert.Alert");

	private boolean visibleDivAlert = false;

	private String sclassDivAlert;

	private String iconoDivAlert;

	private String message;
	
	public static void showErrorMessage(String code, String message) {
		showMessage("E:Error Code: " + code + "-" + message);
	}
	
	public static void showWarningMessage(String code, String message) {
		showMessage("W:Warning Code: " + code + "-" + message);
	}
	
	public static void showSuccessMessage(String code, String message) {
		showMessage("S:Success Code: " + code + "-" + message);
	}
	
	public static void showInformationMessage(String code, String message) {
		showMessage("I:Information Code: " + code + "-" + message);
	}
	
	public static void showMessage(Object object) {
		if (object instanceof IPayloadResponse) {
			showMessage((IPayloadResponse<?>) object);
			
			return;
		}
		
		showMessage(object.toString());
	}
	
	public static void showMessage(IPayloadResponse<?> payloadResponse) {	
		showMessage((String) payloadResponse.getInformacion(IPayloadResponse.MENSAJE));
	}

	public static void showMessage(String message) {
		Map<String, Object> args = new HashMap<String, Object>();

		String tipo = String.valueOf(message.charAt(0));

		int posicion = message.indexOf(":");

		message = message.substring(posicion + 1);

		args.put("message", message);
		args.put("classDiv", mensajeBundle.getString(tipo + ".classDiv"));
		args.put("classIcono", mensajeBundle.getString(tipo + ".classIcono"));

		BindUtils.postGlobalCommand(null, null, "actualizarMensaje", args);
	}

	public static void hideMessage() {
		BindUtils.postGlobalCommand(null, null, "hideTheMessage", null);
	}

	@GlobalCommand
	@NotifyChange({ "visibleDivAlert", "sclassDivAlert", "iconoDivAlert", "message" })
	public void actualizarMensaje(@BindingParam("message") String message, @BindingParam("classDiv") String classDiv,
			@BindingParam("classIcono") String classIcono) {
		sclassDivAlert = classDiv;
		this.message = message;
		iconoDivAlert = classIcono;
		visibleDivAlert = true;
		
		Clients.evalJavaScript("$('html, body').animate({ scrollTop: 0 }, 'slow')");
	}

	@GlobalCommand
	@NotifyChange({ "visibleDivAlert" })
	public void hideTheMessage() {
		visibleDivAlert = false;
	}

	public boolean getVisibleDivAlert() {
		return visibleDivAlert;
	}

	public String getSclassDivAlert() {
		return sclassDivAlert + " alert-page-header alert";
	}

	public String getIconoDivAlert() {
		return iconoDivAlert + " center-transform-y alert-icon-left";
	}

	public String getMessage() {
		return message;
	}
}
