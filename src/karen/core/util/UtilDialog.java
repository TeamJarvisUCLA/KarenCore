package karen.core.util;

import java.util.HashMap;
import java.util.Map;

import karen.core.dialog.generic.controllers.C_WindowDialog;
import karen.core.dialog.generic.data.DialogData;
import karen.core.dialog.message_box.data.MessageBoxConfirmationDialogData;
import karen.core.dialog.message_box.data.MessageBoxErrorDialogData;
import karen.core.dialog.message_box.data.MessageBoxGenericDialogData;
import karen.core.dialog.message_box.data.MessageBoxInformationDialogData;
import karen.core.dialog.message_box.data.MessageBoxSuccessDialogData;
import karen.core.dialog.message_box.data.MessageBoxWarningDialogData;
import karen.core.dialog.message_box.events.listeners.MessageBoxDialogCloseListener;
import karen.core.dialog.message_system.data.MessageSystemDialogData;
import lights.core.payload.response.IPayloadResponse;

import org.zkoss.zk.ui.Executions;

public class UtilDialog {
	
	private static String URL_MESSAGE_BOX_DIALOG = "assets/theme/components/messageBoxGeneric.zul";
	
	private static String URL_MESSAGE_SYSTEM_DIALOG = "assets/theme/components/messageSystem.zul";
	
	public static void showDialog(String uri, DialogData dialogData) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("dialogData", dialogData);
		
		C_WindowDialog windowDialog = (C_WindowDialog) Executions.createComponents(uri, null, parameters);
		
		windowDialog.doModal();
	}
	
	public static C_WindowDialog showSystemDialog(String uri, DialogData dialogData) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("dialogData", dialogData);
		
		C_WindowDialog windowDialog = (C_WindowDialog) Executions.createComponents(uri, null, parameters);
		
		windowDialog.doOverlapped();
		
		return windowDialog;
	}
	
	public static void showMessageBox(MessageBoxGenericDialogData messageBoxGenericDialogData) {
		UtilDialog.showDialog(URL_MESSAGE_BOX_DIALOG, messageBoxGenericDialogData);
	}
	
	public static void showMessage(IPayloadResponse<?> payloadResponse) {
		String message = (String) payloadResponse.getInformacion(IPayloadResponse.MENSAJE);
		
		String tipo = String.valueOf(message.charAt(0));

		int posicion = message.indexOf(":");
		
		message = message.substring(posicion + 1);

		switch (tipo) {
		case "W":
			showMessageBoxWarning(message);
			break;
		case "E":
			showMessageBoxError(message);
			break;
		case "I":
			showMessageBoxInformation(message);
			break;
		case "S":
			showMessageBoxSuccess(message);
			break;
		default:
			break;
		}
	}
	
	public static void showMessage(String message) {
		String tipo = String.valueOf(message.charAt(0));

		int posicion = message.indexOf(":");
		
		message = message.substring(posicion + 1);

		switch (tipo) {
		case "W":
			showMessageBoxWarning(message);
			break;
		case "E":
			showMessageBoxError(message);
			break;
		case "I":
			showMessageBoxInformation(message);
			break;
		case "S":
			showMessageBoxSuccess(message);
			break;
		default:
			break;
		}
	}
	
	public static C_WindowDialog showMessageSystem(IPayloadResponse<?> payloadResponse) {
		MessageSystemDialogData m = new MessageSystemDialogData();
		
		m.setText((String) payloadResponse.getInformacion(IPayloadResponse.MENSAJE));
		return UtilDialog.showSystemDialog(URL_MESSAGE_SYSTEM_DIALOG, m);
	}
	
	public static C_WindowDialog showMessageSystem(String message) {
		MessageSystemDialogData m = new MessageSystemDialogData();
		
		m.setText(message);
		return UtilDialog.showSystemDialog(URL_MESSAGE_SYSTEM_DIALOG, m);
	}
	
	public static void showMessageBoxWarning(String text) {
		MessageBoxWarningDialogData messageBoxWarningDialogData = new MessageBoxWarningDialogData(text);
		
		showMessageBox(messageBoxWarningDialogData);
	}
	
	public static void showMessageBoxError(String text) {
		MessageBoxErrorDialogData messageBoxErrorDialogData = new MessageBoxErrorDialogData(text);
		
		showMessageBox(messageBoxErrorDialogData);
	}
	
	public static void showMessageBoxSuccess(String text) {
		MessageBoxSuccessDialogData messageBoxSuccessDialogData = new MessageBoxSuccessDialogData(text);
		
		showMessageBox(messageBoxSuccessDialogData);
	}
	
	public static void showMessageBoxInformation(String text) {
		MessageBoxInformationDialogData messageBoxInformationDialogData = new MessageBoxInformationDialogData(text);
		
		showMessageBox(messageBoxInformationDialogData);
	}
	
	public static void showMessageBoxConfirmation(String text, MessageBoxDialogCloseListener messageBoxDialogCloseListener) {
		MessageBoxConfirmationDialogData messageBoxConfirmationDialogData = new MessageBoxConfirmationDialogData(text);
		
		messageBoxConfirmationDialogData.addMessageBoxDialogCloseListeners(messageBoxDialogCloseListener);
		
		showMessageBox(messageBoxConfirmationDialogData);
	}
}
