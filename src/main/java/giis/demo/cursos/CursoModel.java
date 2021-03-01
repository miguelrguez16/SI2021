package giis.demo.cursos;

import java.util.List;

import giis.demo.util.Database;


public class CursoModel {
	
	private Database db=new Database();

	public List<CursoDisplayDTO> getListaCursosModelo() {
		// TODO Auto-generated method stub
		String sql=
				"SELECT idcurso, nombre,fechaInicio FROM CURSOS WHERE estado=='planificado'";
		return db.executeQueryPojo(CursoDisplayDTO.class, sql);
	}
}
