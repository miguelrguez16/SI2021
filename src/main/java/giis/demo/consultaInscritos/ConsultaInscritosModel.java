package giis.demo.consultaInscritos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import giis.demo.cursos.CursoDisplayDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;


public class ConsultaInscritosModel {
	
	private Database db=new Database();
	private int idcurso;
	private double recaudacion;
	//private String nombreCurso = ConsultaInscritosView.getNombreCurso();
	
	
	
	public int getIDCurso(String nombre) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT idCurso FROM Curso WHERE nombre=\'"+nombre+"\'";
			ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				idcurso=rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idcurso;

	}
	
	public Double getRecaudacion(int idcurso) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT cu.precio*count(i.idInscripcion) FROM Curso as cu INNER JOIN Inscripcion as i on cu.idCurso=i.idCurso WHERE i.idCurso=\'"+idcurso+"\'";
			ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				recaudacion=rs.getDouble(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(recaudacion);
		return recaudacion;

	}


	public List<ConsultaInscritoDisplayDTO> getListaCursosModelo() {
		String sql=
				"SELECT co.apellidos, co.nombre, i.fecha, i.estado, cu.precio FROM Curso AS cu "
				+ "INNER JOIN Inscripcion AS i ON cu.idCurso=i.idCurso "
				+ "INNER JOIN Colegiado AS co ON i.idColegiado=co.idColegiado WHERE cu.idCurso=\'"+this.getIDCurso(ConsultaInscritosView.getNombreCurso())+"\' Order BY co.apellidos";
		return db.executeQueryPojo(ConsultaInscritoDisplayDTO.class, sql);
	}
	

	
	

}
