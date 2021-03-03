package giis.demo.cursos;

import java.util.Date;
import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;


public class CursoModel {
	
	private Database db=new Database();

	public List<CursoDisplayDTO> getListaCursosModelo() {
		String sql=
				"SELECT idCurso, nombre,fechaInicio "
				+"FROM CURSO "
				+"WHERE estado ='planificado'";
		return db.executeQueryPojo(CursoDisplayDTO.class, sql);
	}

	/*
	 * 
	 */
	public CursoEntity getCursoSelec(int idCurso) {
		String sql="SELECT idCurso,nombre,fechaInicio from curso where idCurso=?";
		List<CursoEntity> cursoSelect=db.executeQueryPojo(CursoEntity.class, sql, idCurso);
		validateCondition(!cursoSelect.isEmpty(),"Id de carrera no encontrado: "+idCurso);
		return cursoSelect.get(0);
	
	}
	
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}

	/*
	 * Guardar los cambios pedidos en la base de datos
	 * cambia el estado del curso a abierto
	 */
	public void setCursoCambios(Date fechaInicio, Date fechaFin, int plazas, int id) {
		String sql="UPDATE Curso SET fechaInicioInscripcion =?, fechaFinInscripción =?, plazasTotales=?, estado='abierto' WHERE idCurso=?";
		db.executeUpdate(sql, Util.dateToIsoString(fechaInicio), Util.dateToIsoString(fechaFin), plazas,id);
	}
}
