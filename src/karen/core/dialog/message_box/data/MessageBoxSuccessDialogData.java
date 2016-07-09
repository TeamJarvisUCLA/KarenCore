package karen.core.dialog.message_box.data;

public class MessageBoxSuccessDialogData extends MessageBoxGenericDialogData {

	public MessageBoxSuccessDialogData(String text) {
		this.text = text;
		this.icon = "fa fa-check-circle fa-3x";
		this.classIntermittent = "message_box_div_header_color intermittent green";
		this.tituloHeader = "Hecho";
		this.visibleAccept = true;
		this.visibleCancel = false;
	}
}
