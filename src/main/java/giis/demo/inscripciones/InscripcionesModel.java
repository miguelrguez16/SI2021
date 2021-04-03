package giis.demo.inscripciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import giis.demo.cursos.CursoDisplayDTO;
import giis.demo.cursos.CursoEntity;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class InscripcionesModel {
	private Database db=new Database();
	String nombre;
	Calendar c1=Calendar.getInstance();
	String anio = Integer.toString(c1.get(Calendar.YEAR));
	int idColegiado=-1;
	
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
	
	public String getIdColegiado(int dni) {
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT IdColegiado FROM Colegiado WHERE dni="+dni;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getIdColectivo(int dni) {
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT IdColectivo FROM Colectivo WHERE dni="+dni;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
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
	
	public String getColegiadoTelefono(int idColegiado) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT telefono FROM Colegiado WHERE idColegiado="+idColegiado;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getColegiadoPoblacion(int idColegiado) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT poblacion FROM Colegiado WHERE idColegiado="+idColegiado;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getColegiadoDireccion(int idColegiado) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT direccion FROM Colegiado WHERE idColegiado="+idColegiado;
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
		String sql="INSERT INTO Inscripcion (IdColegiado, IdCurso, fecha) VALUES ("+idColegiado+","+idCurso+",'"+this.getFecha()+"')";
		db.executeUpdate(sql);
	}
	
	public void setNuevaInscripcionColectivo(int idColectivo, int idCurso) {
		String sql="INSERT INTO InscripcionColectivo (IdColectivo, IdCurso, fecha) VALUES ("+idColectivo+","+idCurso+",'"+this.getFecha()+"')";
		db.executeUpdate(sql);
	}
	
	public boolean existeInscripcion(int idColegiado, int idCurso) {
		String sql="SELECT idInscripcion from Inscripcion where idColegiado="+idColegiado+" and idCurso="+idCurso;
		List<InscripcionesEntity> inscripcionSelect=db.executeQueryPojo(InscripcionesEntity.class, sql);
		if(inscripcionSelect.isEmpty())
			return false;
		else return true;
	}
	
	public boolean existeInscripcionColectivo(int idColectivo, int idCurso) {
		String sql="SELECT idInscripcionColectivo from InscripcionColectivo where idColectivo="+idColectivo+" and idCurso="+idCurso;
		List<InscripcionesEntity> inscripcionSelect=db.executeQueryPojo(InscripcionesEntity.class, sql);
		if(inscripcionSelect.isEmpty())
			return false;
		else return true;
	}
	
	public void setNuevoColectivo() {
		String sql="INSERT INTO Colectivo (nombre, apellidos, dni, direccion, poblacion, telefono, datosBancarios) "
				+ "VALUES ('"+InscripcionesView.getNombre()+"','"+InscripcionesView.getApellidos()+"','"+InscripcionesView.getDni()+"','"+
				InscripcionesView.getDireccion()+"','"+InscripcionesView.getPoblacion()+"','"+InscripcionesView.getTelefono()+"','"+InscripcionesView.getDatos()+"')";
		db.executeUpdate(sql);
	}
}
