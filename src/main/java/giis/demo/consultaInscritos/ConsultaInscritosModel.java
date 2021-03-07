package giis.demo.consultaInscritos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;


public class ConsultaInscritosModel {
	
	private Database db=new Database();
	private int idcurso;
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
	
	

}
