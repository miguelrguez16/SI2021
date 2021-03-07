package giis.demo.cursosAnio;

public class ListaCursosAnioDisplayDTO {

	private String idCurso, plazasTotales, plazasLibres;
	private String precio;
	private String nombre, fechaInicio, fechaFin, fechaInicioInscripcion, fechaFinInscripcion, estado;
	
	public String getIdCurso() {
		return idCurso;
	}
	
	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}
	
	public String getPlazasTotales() {
		return plazasTotales;
	}
	
	public void setPlazasTotales(String plazasTotales) {
		this.plazasTotales = plazasTotales;
	}
	
	public String getPlazasLibres() {
		return plazasLibres;
	}
	
	public void setPlazasLibres(String plazasLibres) {
		this.plazasLibres = plazasLibres;
	}
	
	public String getPrecio() {
		return precio;
	}
	
	public void setPrecio(String precio) {
		this.precio = precio;
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
	
	public String getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}
	
	public void setFechaInicioInscripcion(String fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}
	
	public String getFechaFinInscripcion() {
		return fechaFinInscripcion;
	}
	
	public void setFechaFinInscripcion(String fechaFinInscripcion) {
		this.fechaFinInscripcion = fechaFinInscripcion;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}	
}