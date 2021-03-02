package giis.demo.solicitud;

import java.util.Calendar;

import giis.demo.util.Database;

public class SolicitudModel {

	private Database db=new Database();
	
Calendar c1 = Calendar.getInstance();
String dia = Integer.toString(c1.get(Calendar.DATE));
String mes = Integer.toString(c1.get(Calendar.MONTH));
String año = Integer.toString(c1.get(Calendar.YEAR));

String fechahoy = dia+"/"+mes+"/"+año;

public String getFecha() {
	return fechahoy;
}

	
	public void writeSolicitud() {
		
		String query = "INSERT INTO Colegiado (nombre, apellidos, direccion, poblacion, telefono, datosbancarios, fechaSolicitudColegiado, titulacion, centro, añotitulo) "
				+ "VALUES ('"+SolicitudView.getNombre()+"','"+SolicitudView.getApellidos()+"','"+SolicitudView.getDireccion()+"','"+SolicitudView.getPoblacion()+"','"+
				SolicitudView.getTelefono()+"','"+SolicitudView.getCuenta()+"',"+this.getFecha()+",'"+SolicitudView.getTitulacion()+"','"+SolicitudView.getCentro()+"',"+SolicitudView.getYear()+")";
		
	db.executeUpdate(query);
		
		
	}
	
	
}
