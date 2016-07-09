package karen.core.dialog.message_box.data;

public class MessageBoxErrorDialogData extends MessageBoxGenericDialogData {

	public MessageBoxErrorDialogData(String text) {
		this.text = text;
		this.icon = "fa fa-times-circle fa-3x";
		this.classIntermittent = "message_box_div_header_color intermittent red darken-1";
		this.tituloHeader = "Error";
		this.visibleAccept = true;
		this.visibleCancel = false;
	}
}
