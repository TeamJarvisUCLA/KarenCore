package karen.core.dialog.message_box.data;

import karen.core.dialog.generic.data.DialogData;
import karen.core.dialog.message_box.events.listeners.MessageBoxDialogCloseListener;

public abstract class MessageBoxGenericDialogData extends DialogData {
	
	protected String text;
	
	protected String icon;
	
	protected String classIntermittent;
	
	protected String tituloHeader;
	
	protected Boolean visibleAccept;
	
	protected Boolean visibleCancel;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getClassIntermittent() {
		return classIntermittent;
	}

	public void setClassIntermittent(String classIntermittent) {
		this.classIntermittent = classIntermittent;
	}

	public String getTituloHeader() {
		return tituloHeader;
	}

	public void setTituloHeader(String tituloHeader) {
		this.tituloHeader = tituloHeader;
	}

	public Boolean getVisibleAccept() {
		return visibleAccept;
	}

	public void setVisibleAccept(Boolean visibleAccept) {
		this.visibleAccept = visibleAccept;
	}

	public Boolean getVisibleCancel() {
		return visibleCancel;
	}

	public void setVisibleCancel(Boolean visibleCancel) {
		this.visibleCancel = visibleCancel;
	}

	public void addMessageBoxDialogCloseListeners(MessageBoxDialogCloseListener messageBoxDialogCloseListener) {
		addDialogCloseListeners(messageBoxDialogCloseListener);
	}
	
	public void removeMessageBoxDialogCloseListeners(MessageBoxDialogCloseListener messageBoxDialogCloseListener) {
		addDialogCloseListeners(messageBoxDialogCloseListener);
	}
}
