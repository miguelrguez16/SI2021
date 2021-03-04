package giis.demo.cursos;

import java.util.List;

import giis.demo.colegiados.ColegiadoEntity;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;


public class CursoModel {
	
	private Database db=new Database();

	public List<CursoDisplayDTO> getListaCursosModelo() {
		// TODO Auto-generated method stub
		String sql=
				"SELECT idCurso, nombre,fechaInicio "
				+"FROM CURSO "
				+"WHERE estado ='pendiente'";
		return db.executeQueryPojo(CursoDisplayDTO.class, sql);
	}

	public CursoEntity getCursoSelec(int idCurso) {
		String sql="SELECT idCurso,nombre,fechaInicio from curso where idCurso=?";
		List<CursoEntity> cursoSelect=db.executeQueryPojo(CursoEntity.class, sql, idCurso);
		validateCondition(!cursoSelect.isEmpty(),"Id de curso no encontrado: "+idCurso);
		return cursoSelect.get(0);
	
	}
	
	public CursoEntity getCursoPrecio(int idCurso) {
		String sql="SELECT idCurso, nombre, precio FROM CURSO WHERE idCurso=?";
		List<CursoEntity> cursoSelect=db.executeQueryPojo(CursoEntity.class, sql, idCurso);
		validateCondition(!cursoSelect.isEmpty(),"Id de carrera no encontrado: "+idCurso);
		return cursoSelect.get(2);
	}
	
	
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}
}
