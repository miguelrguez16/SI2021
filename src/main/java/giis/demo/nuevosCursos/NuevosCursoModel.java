package giis.demo.nuevosCursos;

import java.util.Date;
import java.util.List;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class NuevosCursoModel {

	private Database db = new Database();

	public List<NuevosCursoDisplayDTO> getListaCursosModelo() {
		String sql = "SELECT idCurso, nombre,precio,fechaInicio,fechaFin "
				+ "FROM CURSO " + "WHERE estado ='planificado'";
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
	public void setCursoNuevos(String nombre, double precio, Date fechaInicio, Date fechaFin) {
		String sql = "Insert into Curso (nombre, precio, fechaInicio,fechaFin) VALUES"
				+ "(?,?,?,?)";
		db.executeUpdate(sql, nombre, precio, Util.dateToIsoString(fechaInicio), Util.dateToIsoString(fechaFin));
	}

}
// ("idCurso","nombre","precio","plazasTotales","fechaInicio","fechaFin","fechaInicioInscripcion","fechaFinInscripción","estado","precioPrecolegiado","precioColectivo","profesor","instalacion","sesiones")