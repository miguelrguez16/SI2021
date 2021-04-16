package giis.demo.cursosAnio;

import java.util.List;
import giis.demo.util.Database;

public class ListaCursosAnioModel {
	
	private Database db= new Database();
	/*
	public List<ListaCursosAnioDisplayDTO> getListaCursosAnioModelo() {
		String sql="Select c.idCurso, c.nombre,c.fechaInicio, c.estado,c.plazasTotales, c.plazasTotales-count(i.idInscripcion) as plazasLibres from Curso as c "
				+"left join Inscripcion as i on i.idCurso=c.idCurso "
				+"where c.estado='abierto' group by c.idCurso order by c.fechaInicio";
		return db.executeQueryPojo(ListaCursosAnioDisplayDTO.class, sql);
	}*/
	
	public List<ListaCursosAnioDisplayDTO> getListaCursosAnioModelo(){
		String sql ="Select c.idCurso, c.nombre,c.fechaInicio, c.estado,c.plazasTotales, c.plazasTotales-count(i.idInscripcionCurso) as plazasLibres "
				+ "from Curso as c "
				+ "left join InscripcionCurso as i on i.idCurso=c.idCurso "
				+ "where c.estado='abierto' group by c.idCurso order by c.fechaInicio";
		return db.executeQueryPojo(ListaCursosAnioDisplayDTO.class, sql);
	}
	
}
