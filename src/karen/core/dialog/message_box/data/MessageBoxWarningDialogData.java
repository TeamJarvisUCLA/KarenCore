package karen.core.dialog.message_box.data;

public class MessageBoxWarningDialogData extends MessageBoxGenericDialogData {

	public MessageBoxWarningDialogData(String text) {
		this.text = text;
		this.icon = "fa fa-exclamation-circle fa-3x";
		this.classIntermittent = "message_box_div_header_color intermittent yellow";
		this.tituloHeader = "Advertencia";
		this.visibleAccept = true;
		this.visibleCancel = false;
	}
}
