package giis.demo.inscripciones;

public class InscripcionDisplayDTO {
	private String id;
	private String descr;
	private String abierta;

	public InscripcionDisplayDTO() {
	}

	public InscripcionDisplayDTO(String rowId, String rowDescripcion, String rowEstado) {
		this.id = rowId;
		this.descr = rowDescripcion;
		this.abierta = rowEstado;
	}

	public String getId() {
		return this.id;
	}

	public String getDescr() {
		return this.descr;
	}

	public String getEstado() {
		return this.abierta;
	}

	public void setId(String value) {
		this.id = value;
	}

	public void setDescr(String value) {
		this.descr = value;
	}

	public void setAbierta(String value) {
		this.abierta = value;
	}
}
