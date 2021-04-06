package giis.demo.solicitud;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import giis.demo.consultaInscritos.ConsultaInscritoDisplayDTO;
import giis.demo.consultaInscritos.ConsultaInscritosView;
import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;

public class SolicitudColModel {

	private Database db=new Database();
	int idSolicitante;
	int idSolicitantepre;
	int idSolicitud;
	int idSolicitudpre;
	
	
Calendar c1 = Calendar.getInstance();

String anio = Integer.toString(c1.get(Calendar.YEAR));
String aniofin = Integer.toString(c1.get(Calendar.YEAR)+1);



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
String fechaexp=aniofin+"-"+this.getMes()+"-"+this.getDia();

public String getFecha() {
	return fechahoy;
}

public String getFechaExp() {
	return fechaexp;
}




public int getIDSolicitante() {
	
	try {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
		java.sql.Statement s = conn.createStatement();
		String sql = "SELECT MAX(idColegiado) FROM Colegiado";
		ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
		while (rs.next()) {
			idSolicitante=rs.getInt(1);
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return idSolicitante;

}
public int getIDSolicitantepre() {
	
	try {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
		java.sql.Statement s = conn.createStatement();
		String sql = "SELECT MAX(id) FROM Precolegiado";
		ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
		while (rs.next()) {
			idSolicitantepre=rs.getInt(1);
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return idSolicitantepre;

}

public int getIDSolicitud() {
	try {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
		java.sql.Statement s = conn.createStatement();
		String sql = "SELECT MAX(idSolicitud) FROM SolicitudColegio";  
		ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
		while (rs.next()) {
			idSolicitud=rs.getInt(1);
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return idSolicitud;

}

public int getIDSolicitudpre() {
	try {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
		java.sql.Statement s = conn.createStatement();
		String sql = "SELECT MAX(Id) FROM SolicitudPrecolegiado";  
		ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
		while (rs.next()) {
			idSolicitudpre=rs.getInt(1);
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return idSolicitudpre;

}

public String ComprobarDNI(String n) {
	String dni=null;
	try {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
		java.sql.Statement s = conn.createStatement();
		String sql = "SELECT dni FROM Colegiado WHERE dni=\'"+n+"\'";
		ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
		while (rs.next()) {
			dni=rs.getString(1);
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
return dni;
}

public String ComprobarDNIpre(String n) {
	String dni=null;
	try {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
		java.sql.Statement s = conn.createStatement();
		String sql = "SELECT dni FROM Precolegiado WHERE dni=\'"+n+"\'";
		ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
		while (rs.next()) {
			dni=rs.getString(1);
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
return dni;
}


/*public List<ConsultaInscritoDisplayDTO> comprobarDNI() {
	String sql = "SELECT * FROM COlegiado WHERE dni=\'"+SolicitudView.getDNI()+"\'";
	return db.executeQueryPojo(ConsultaInscritoDisplayDTO.class, sql);
	}
*/

	public void writeSolicitud() {
		
		String query = "INSERT INTO Colegiado (nombre, apellidos, direccion, poblacion, telefono, datosBancarios, fechaSolicitudColegiado, titulacion, centro, anioTitulo, dni) "
				+ "VALUES ('"+SolicitudColView.getNombre()+"','"+SolicitudColView.getApellidos()+"','"+SolicitudColView.getDireccion()+"','"+SolicitudColView.getPoblacion()+"','"+
				SolicitudColView.getTelefono()+"','"+SolicitudColView.getCuenta()+"','"+this.getFecha()+"','"+SolicitudColView.getTitulacion()+"','"+SolicitudColView.getCentro()+"',"+SolicitudColView.getYear()+",'"+SolicitudColView.getDNI()+"')";
		
		db.executeUpdate(query);

		String query2 = "INSERT INTO SolicitudColegio (estado, idColegiado, fecha) VALUES ('pendiente',"+this.getIDSolicitante()+",'"+this.getFecha()+"')";
		db.executeUpdate(query2);
		
		
	}
	
public void writeSolicitudpre() {
		
		String query = "INSERT INTO Precolegiado (nombre, apellidos, direccion, poblacion, telefono, datosCuenta, fechaSolicitudPrecolegiado, titulacion, centro, dni) "
				+ "VALUES ('"+SolicitudPreView.getNombrepre()+"','"+SolicitudPreView.getApellidospre()+"','"+SolicitudPreView.getDireccionpre()+"','"+SolicitudPreView.getPoblacionpre()+"','"+
				SolicitudPreView.getTelefonopre()+"','"+SolicitudPreView.getCuentapre()+"','"+this.getFecha()+"','"+SolicitudPreView.getTitulacionpre()+"','"+SolicitudPreView.getCentropre()+"','"+SolicitudPreView.getDNIpre()+"')";
		
		db.executeUpdate(query);

		String query2 = "INSERT INTO SolicitudPrecolegiado (estado, id, fecha) VALUES ('aprobado',"+this.getIDSolicitantepre()+",'"+this.getFecha()+"')";
		db.executeUpdate(query2);
		
		
	}
	
	
}
