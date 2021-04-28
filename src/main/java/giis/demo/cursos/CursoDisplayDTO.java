package giis.demo.cursos;

public class CursoDisplayDTO {
	private String idCurso, nombre, fechaInicio;
	private String precio, precioPrecolegiado, precioEstudiante, precioEmpresa, precioExterno, cantidadDevolver;

	public String getCantidadDevolver() {
		return cantidadDevolver;
	}

	public void setCantidadDevolver(String cantidadDevolver) {
		this.cantidadDevolver = cantidadDevolver;
	}

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getPrecioPrecolegiado() {
		return precioPrecolegiado;
	}

	public void setPrecioPrecolegiado(String precioPrecolegiado) {
		this.precioPrecolegiado = precioPrecolegiado;
	}

	public String getPrecioEstudiante() {
		return precioEstudiante;
	}

	public void setPrecioEstudiante(String precioEstudiante) {
		this.precioEstudiante = precioEstudiante;
	}

	public String getPrecioEmpresa() {
		return precioEmpresa;
	}

	public void setPrecioEmpresa(String precioEmpresa) {
		this.precioEmpresa = precioEmpresa;
	}

	public String getPrecioExterno() {
		return precioExterno;
	}

	public void setPrecioExterno(String precioExterno) {
		this.precioExterno = precioExterno;
	}

}
