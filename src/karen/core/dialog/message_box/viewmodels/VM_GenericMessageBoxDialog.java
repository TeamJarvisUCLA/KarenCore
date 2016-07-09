package karen.core.dialog.message_box.viewmodels;

import org.zkoss.bind.annotation.Init;

import karen.core.dialog.generic.viewmodels.VM_WindowDialog;
import karen.core.dialog.message_box.data.MessageBoxGenericDialogData;

public class VM_GenericMessageBoxDialog extends VM_WindowDialog {

	protected String text;
	
	protected String icon;
	
	protected String classIntermittent;
	
	protected String tituloHeader;
	
	protected Boolean visibleAccept;
	
	protected Boolean visibleCancel;
	
	@Init(superclass=true)
    public void childInit_VM_GenericMessageBoxDialog() {
		//NOTHING OK!
    }
	
	public VM_GenericMessageBoxDialog() {
		super();
	}
	
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

	@Override
	public void afterChildInit() {
		MessageBoxGenericDialogData messageBoxGenericDialogData = (MessageBoxGenericDialogData) getDialogData();
		
		this.text = messageBoxGenericDialogData.getText();
		this.icon = messageBoxGenericDialogData.getIcon();
		this.classIntermittent = messageBoxGenericDialogData.getClassIntermittent();
		this.tituloHeader = messageBoxGenericDialogData.getTituloHeader();
		this.visibleAccept = messageBoxGenericDialogData.getVisibleAccept();
		this.visibleCancel = messageBoxGenericDialogData.getVisibleCancel();
	}
}
