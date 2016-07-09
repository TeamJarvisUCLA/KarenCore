package karen.core.dialog.message_box.data;

public class MessageBoxInformationDialogData extends MessageBoxGenericDialogData {

	public MessageBoxInformationDialogData(String text) {
		this.text = text;
		this.icon = "fa fa-info-circle fa-3x";
		this.classIntermittent = "message_box_div_header_color intermittent light-blue";
		this.tituloHeader = "Información";
		this.visibleAccept = true;
		this.visibleCancel = false;
	}
}
