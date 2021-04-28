package giis.demo.EnvioCol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import giis.demo.cursos.CursoDisplayDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;


public class EnvioColModel {

	private Database db=new Database();
	private int idcurso;
	private double recaudacion;
	private int idColegiado;
	Calendar c1 = Calendar.getInstance();

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

	public String getFechaHoy() {
		return fechahoy;
	}

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

	public String compruebaPendientes() {

		String aux=null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT co.dni FROM Colegiado as co INNER JOIN SolicitudColegio AS so ON co.idColegiado=so.idColegiado WHERE estado='pendiente'";
			ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				aux=rs.getString(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aux;

	}

	public String compruebaEnTramite() {

		String aux=null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT co.dni FROM Colegiado as co INNER JOIN SolicitudColegio AS so ON co.idColegiado=so.idColegiado WHERE estado='En trámite'";
			ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				aux=rs.getString(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aux;

	}

	public int getIDColegiado(String dni) {

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT idColegiado FROM Colegiado WHERE dni= \'"+dni+"\'";
			ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				idColegiado=rs.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return idColegiado;

	}

	public void updateEstadoAprobado(int id, String fecha) {
		String query = "UPDATE SolicitudColegio SET estado='aprobado' WHERE idColegiado=\'"+id+"\'";
		String query2 = "UPDATE Colegiado SET fechaSolicitudColegiado=\'"+fecha+"\' WHERE idColegiado=\'"+id+"\'";
		db.executeUpdate(query);
		db.executeUpdate(query2);
	}

	public void updateEstadoCancelado(int id, String fecha) {
		String query = "UPDATE SolicitudColegio SET estado='Desestimada' WHERE idColegiado=\'"+id+"\'";
		String query2 = "UPDATE Colegiado SET fechaSolicitudColegiado=\'"+fecha+"\' WHERE idColegiado=\'"+id+"\'";
		db.executeUpdate(query);
		db.executeUpdate(query2);
	}


	public void updateEstado() {
		String query = "UPDATE SolicitudColegio SET estado='En trámite' WHERE estado='pendiente'";
		db.executeUpdate(query);
	}

	public void updateFecha (String fecha, int id) {
		String query = "Update SolicitudColegio SET fecha=\'"+fecha+"\' WHERE idColegiado= \'"+id+"\'";
	}



	public List<EnvioColDisplayDTO> getListaCursosModelo() {
		String sql=
				"SELECT co.apellidos, co.nombre, co.dni, co.titulacion, co.fechaSolicitudColegiado, so.estado "
						+ "FROM Colegiado as co "
						+ "INNER JOIN SolicitudColegio AS so ON co.idColegiado=so.idColegiado "
						//+ "WHERE estado='pendiente' "
						+ "ORDER BY so.estado, co.apellidos";

		return db.executeQueryPojo(EnvioColDisplayDTO.class, sql);
	}





}
