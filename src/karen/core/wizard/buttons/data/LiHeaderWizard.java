package karen.core.wizard.buttons.data;

public class LiHeaderWizard {
	
	private String liStyle; //width: XX% !important
	private String liClass; //disabled || active
	private String aAria;
	private String aTitle;
	private String iClass;
	
	public LiHeaderWizard(String liStyle, String liClass, String aTitle, String iClass) {
		super();
		this.liStyle = liStyle;
		this.liClass = liClass;
		this.aAria = aTitle.replace(" ", "").toLowerCase();
		this.aTitle = aTitle;
		this.iClass = iClass;
	}

	public String getLiStyle() {
		return liStyle;
	}

	public void setLiStyle(String liStyle) {
		this.liStyle = liStyle;
	}

	public String getLiClass() {
		return liClass;
	}

	public void setLiClass(String liClass) {
		this.liClass = liClass;
	}

	public String getaAria() {
		return aAria;
	}

	public void setaAria(String aAria) {
		this.aAria = aAria;
	}

	public String getaTitle() {
		return aTitle;
	}

	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}

	public String getiClass() {
		return iClass;
	}

	public void setiClass(String iClass) {
		this.iClass = iClass;
	}
	
	
}
