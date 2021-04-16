package giis.demo.inscripciones;

public class InscripcionCursoEntity {
	private int idInscripcionCurso;
	private int id;
	private int idCurso;
	private String estado;
	private String fecha;
	private String tipo;
	
	public int getIdInscripcionCurso() {
		return idInscripcionCurso;
	}
	public void setIdInscripcionCurso(int idInscripcionCurso) {
		this.idInscripcionCurso = idInscripcionCurso;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}