package karen.core.form.buttons.data;

public class OperacionForm implements Comparable<OperacionForm> {

	private Integer idOperacion;
	private String label;
	private String nombre;
	private String iconSclass;
	private String sclass;
	
	public OperacionForm() {
		super();
	}

	public OperacionForm(Integer idOperacion, String label,
			String nombre,
			String iconSclass,
			String sclass) {
		super();
		this.idOperacion = idOperacion;
		this.label = label;
		this.nombre = nombre;
		this.iconSclass = iconSclass;
		this.sclass = sclass;
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

	public int compareTo(OperacionForm o) {
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
		OperacionForm other = (OperacionForm) obj;
		if (idOperacion == null) {
			if (other.idOperacion != null)
				return false;
		} else if (!idOperacion.equals(other.idOperacion))
			return false;
		return true;
	}	
}
