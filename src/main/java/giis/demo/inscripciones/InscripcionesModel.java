package giis.demo.inscripciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import giis.demo.colegiados.ColegiadoEntity;
import giis.demo.cursos.CursoDisplayDTO;
import giis.demo.cursos.CursoEntity;
import giis.demo.tkrun.CarreraEntity;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class InscripcionesModel {
	private Database db=new Database();
	String nombre;
	Calendar c1=Calendar.getInstance();
	String anio = Integer.toString(c1.get(Calendar.YEAR));
	
	public String getDia() {
		String dia;
		int dianum = c1.get(Calendar.DATE);
		if (dianum<10) {
			dia = "0"+Integer.toString(dianum);
		}
		else dia = Integer.toString(dianum);
		return dia;
	}

	public String getMes() {
		String mes;
		int mesnum = c1.get(Calendar.MONTH)+1;
		if (mesnum<10) {
			mes = "0"+Integer.toString(mesnum);
		}
		else mes = Integer.toString(mesnum);
		return mes;
	}

	String fechahoy=anio+"-"+this.getMes()+"-"+this.getDia();

	public String getFecha() {
		return fechahoy;
	}
	
	public List<CursoDisplayDTO> getListaCursosModelo() {
		String sql="SELECT idCurso, nombre,fechaInicio FROM CURSO WHERE estado ='abierto'";
		return db.executeQueryPojo(CursoDisplayDTO.class, sql);
	}
	
	public String getColegiadoNombre(int idColegiado) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT nombre FROM Colegiado WHERE idColegiado="+idColegiado;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getColegiadoApellidos(int idColegiado) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT apellidos FROM Colegiado WHERE idColegiado="+idColegiado;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getColegiadoDatos(int idColegiado) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT datosBancarios FROM Colegiado WHERE idColegiado="+idColegiado;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getCursoPrecio(int idCurso) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT precio FROM Curso WHERE idCurso="+idCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}

	
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}
	
	public CursoEntity getCurso(int idCurso) {
		String sql="SELECT idCurso,nombre,precio from curso where id=?";
		List<CursoEntity> cursoSelect=db.executeQueryPojo(CursoEntity.class, sql, idCurso);
		validateCondition(!cursoSelect.isEmpty(),"Id de curso no encontrado: "+idCurso);
		return cursoSelect.get(0);
	}

	public void setNuevaInscripcion(int idColegiado, int idCurso) {
		String sql="INSERT INTO Inscripcion (IdColegiado, IdCurso) VALUES ("+idColegiado+","+idCurso+")";
		db.executeUpdate(sql);
	}
}
