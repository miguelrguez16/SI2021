package giis.demo.solicitud;

import giis.demo.util.Database;

public class SolicitudModel {

	private Database db=new Database();
	
	public void writeSolicitud() {
		
		String query = "INSERT INTO Colegiado (nombre, apellidos, direccion, poblacion, telefono, datosbancarios, fechaSolicitudColegiado, titulacion, centro, añotitulo) "
				+ "VALUES ('"+SolicitudView.getNombre()+"','"+SolicitudView.getApellidos()+"','"+SolicitudView.getDireccion()+"','"+SolicitudView.getPoblacion()+"','"+
				SolicitudView.getTelefono()+"','"+SolicitudView.getCuenta()+"',"+SolicitudView.getYear()+",'"+SolicitudView.getTitulacion()+"','"+SolicitudView.getCentro()+"',"+SolicitudView.getYear()+")";
		
	db.executeUpdate(query);
		
		
	}
	
	
}
