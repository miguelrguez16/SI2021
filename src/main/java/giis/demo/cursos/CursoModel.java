package giis.demo.cursos;

//<<<<<<< HEAD
//=======
import java.util.Date;
//>>>>>>> refs/heads/master
import java.util.List;

//<<<<<<< HEAD
import giis.demo.colegiados.ColegiadoEntity;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;


public class CursoModel {
	
	private Database db=new Database();

	public List<CursoDisplayDTO> getListaCursosModeloP() {
		// TODO Auto-generated method stub
		String sql=
				"SELECT idCurso, nombre,fechaInicio "
				+"FROM CURSO "
				+"WHERE estado ='abierto'";
		return db.executeQueryPojo(CursoDisplayDTO.class, sql);
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

	/*
	 * Guardar los cambios pedidos en la base de datos
	 * cambia el estado del curso a abierto
	 */
	public void setCursoCambios(Date fechaInicio, Date fechaFin, int plazas, int id) {
		String sql="UPDATE Curso SET fechaInicioInscripcion =?, fechaFinInscripción =?, plazasTotales=?, estado='abierto' WHERE idCurso=?";
		db.executeUpdate(sql, Util.dateToIsoString(fechaInicio), Util.dateToIsoString(fechaFin), plazas,id);
	}
	
	
}
