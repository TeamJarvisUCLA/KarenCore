package karen.core.dialog.form.data;

import ve.smile.seguridad.enums.OperacionEnum;




public class ToCloseWindowFormDialog<T> {

	private Boolean close;
	private T entity;
	private OperacionEnum operacionEnum;
	
	public ToCloseWindowFormDialog(Boolean close, OperacionEnum operacionEnum) {
		super();
		this.close = close;
		this.operacionEnum = operacionEnum;
	}
	
	public ToCloseWindowFormDialog(Boolean close, T entity, OperacionEnum operacionEnum) {
		super();
		this.close = close;
		this.entity = entity;
		this.operacionEnum = operacionEnum;
	}
	public Boolean getClose() {
		return close;
	}
	public void setClose(Boolean close) {
		this.close = close;
	}
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}

	public OperacionEnum getOperacionEnum() {
		return operacionEnum;
	}

	public void setOperacionEnum(OperacionEnum operacionEnum) {
		this.operacionEnum = operacionEnum;
	}
	
	
}
