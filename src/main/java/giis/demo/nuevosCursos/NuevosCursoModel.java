package giis.demo.nuevosCursos;

import java.util.Date;
import java.util.List;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class NuevosCursoModel {

	private Database db = new Database();

	public List<NuevosCursoDisplayDTO> getListaCursosModelo() {
		String sql = "SELECT idCurso, c.nombre as nombre, precio, fechaInicio, fechaFin, precioPrecolegiado, precioEstudiante, precioEmpresa, precioExterno, p.nombre as profesor, instalacion  "
				+ "FROM CURSO as c "
				+ "LEFT JOIN Profesor as p on p.id=c.idProfesor "
				+ "WHERE c.estado ='planificado'";
		return db.executeQueryPojo(NuevosCursoDisplayDTO.class, sql);
	}
	
	
	public boolean existeCurso(String nombreCurso) {
		String sql = "SELECT idCurso, nombre "
				+ "FROM CURSO " 
				+ "WHERE (estado ='planificado' or estado ='abierto') and nombre= ?";
		List<NuevosCursoDisplayDTO> cursosNombre = db.executeQueryPojo(NuevosCursoDisplayDTO.class, sql, nombreCurso);
		return !cursosNombre.isEmpty();
	}

	/* 
	 * Introduce un nuevo curso en la base de datos
	 */
	public void setCursoNuevos(String nombre, double precio, Date fechaInicio, Date fechaFin, double precioPrecolegiado, double precioEstudiante, double precioExterno, double precioEmpresa, int profesor, String instalacion) {
		String sql = "Insert into Curso (nombre, precio, fechaInicio,fechaFin,precioPrecolegiado,precioEstudiante,precioExterno,precioEmpresa,idProfesor,instalacion) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?)";
		db.executeUpdate(sql, nombre, precio, Util.dateToIsoString(fechaInicio), Util.dateToIsoString(fechaFin),precioPrecolegiado,precioEstudiante,precioExterno,precioEmpresa,profesor,instalacion);
	}
	
	public List<nombreProfesoresDTO> getListaProfesores(){
		String sql="Select nombre, apellidos "
				+ "from Profesor ";
		return db.executeQueryPojo(nombreProfesoresDTO.class, sql);
	}

}
// ("idCurso","nombre","precio","plazasTotales","fechaInicio","fechaFin","fechaInicioInscripcion","fechaFinInscripción","estado","precioPrecolegiado","precioColectivo","profesor","instalacion","sesiones")