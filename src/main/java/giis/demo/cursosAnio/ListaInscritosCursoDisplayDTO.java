package giis.demo.cursosAnio;

public class ListaInscritosCursoDisplayDTO {

	private String DNI, fechaPago, cantidad;
	private String id, tipo, estado, fecha;
	public String getDNI() {
		return DNI;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEstado() {
		return estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
