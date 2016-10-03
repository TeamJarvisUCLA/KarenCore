package karen.core.simple_list.wizard.buttons.data;

public class OperacionWizard implements Comparable<OperacionWizard> {

	private Integer idOperacion;
	private String label;
	private String nombre;
	private String iconSclass;
	private String sclass;
	private String tooltiptext;
	
	public OperacionWizard() {
		super();
	}

	public OperacionWizard(Integer idOperacion, String label, String nombre, String iconSclass,
			String sclass, String tooltiptext) {
		super();
		this.idOperacion = idOperacion;
		this.label = label;
		this.nombre = nombre;
		this.iconSclass = iconSclass;
		this.sclass = sclass;
		this.tooltiptext = tooltiptext;
	}

	public Integer getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(Integer idOperacion) {
		this.idOperacion = idOperacion;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIconSclass() {
		return iconSclass;
	}

	public void setIconSclass(String iconSclass) {
		this.iconSclass = iconSclass;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getTooltiptext() {
		return tooltiptext;
	}

	public void setTooltiptext(String tooltiptext) {
		this.tooltiptext = tooltiptext;
	}

	@Override
	public int compareTo(OperacionWizard o) {
		return Math.abs(idOperacion) - Math.abs(o.getIdOperacion());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idOperacion == null) ? 0 : idOperacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperacionWizard other = (OperacionWizard) obj;
		if (idOperacion == null) {
			if (other.idOperacion != null)
				return false;
		} else if (!idOperacion.equals(other.idOperacion))
			return false;
		return true;
	}	
}
