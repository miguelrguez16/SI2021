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

import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;

public class SolicitudModel {

	private Database db=new Database();
	int idSolicitante;
	int idSolicitud;
	
	
Calendar c1 = Calendar.getInstance();
//Calendar c2 = new GregorianCalendar();

String dia = Integer.toString(c1.get(Calendar.DATE));
String mes = Integer.toString(c1.get(Calendar.MONTH)+1);
String año = Integer.toString(c1.get(Calendar.YEAR));


String fechahoy=dia+"/"+mes+"/"+año;

public String getFecha() {
	return fechahoy;
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

	public void writeSolicitud() {
		
		String query = "INSERT INTO Colegiado (nombre, apellidos, direccion, poblacion, telefono, datosBancarios, fechaSolicitudColegiado, titulacion, centro, anioTitulo) "
				+ "VALUES ('"+SolicitudView.getNombre()+"','"+SolicitudView.getApellidos()+"','"+SolicitudView.getDireccion()+"','"+SolicitudView.getPoblacion()+"','"+
				SolicitudView.getTelefono()+"','"+SolicitudView.getCuenta()+"','"+this.getFecha()+"','"+SolicitudView.getTitulacion()+"','"+SolicitudView.getCentro()+"',"+SolicitudView.getYear()+")";
		
		db.executeUpdate(query);

		String query2 = "INSERT INTO SolicitudColegio (estado, idColegiado) VALUES ('pendiente',"+this.getIDSolicitante()+")";
		db.executeUpdate(query2);
		
		
	}
	
	
}
