package karen.core.dialog.message_box.data;

public class MessageBoxConfirmationDialogData extends MessageBoxGenericDialogData {

	public MessageBoxConfirmationDialogData(String text) {
		this.text = text;
		this.icon = "fa fa-question-circle fa-3x";
		this.classIntermittent = "message_box_div_header_color intermittent purple darken-2";
		this.tituloHeader = "Confirmación";
		this.visibleAccept = true;
		this.visibleCancel = true;
	}
}
