package giis.demo.inscripciones;

public class InscripcionesEntity {
	private String idInscripcion;
	private String idColegiado;
	private String idCurso;
	private String estado;
	
	public String getIdInscripcion() {return idInscripcion;}
	public String getIdColegiado() {return idColegiado;	}
	public String getIdCurso() {return idCurso;}
	public String getEstado() {return estado;}
	
	public void setIdInscripcion(String idInscripcion) {this.idInscripcion = idInscripcion;}
	public void setIdColegiado(String idColegiado) {this.idColegiado = idColegiado;}
	public void setIdCurso(String idCurso) {this.idCurso = idCurso;}
	public void setEstado(String estado) {this.estado = estado;}

}