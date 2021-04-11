package giis.demo.inscripcionesListaPeritos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import giis.demo.inscripciones.InscripcionesEntity;
import giis.demo.util.Database;

public class inscripcionesListaPeritosModel {

	private Database db = new Database();
	Calendar c1 = Calendar.getInstance();
	String anio = Integer.toString(c1.get(Calendar.YEAR));

	public String getColegiadoNombre(int idColegiado) {
		String nombre = null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT nombre FROM Colegiado WHERE idColegiado=" + idColegiado;
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getColegiadoApellidos(int idColegiado) {
		String apellidos = null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT apellidos FROM Colegiado WHERE idColegiado=" + idColegiado;
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				apellidos = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apellidos;
	}

	public String getColegiadoDNI(int idColegiado) {
		String nombre = null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT dni FROM Colegiado WHERE idColegiado=" + idColegiado;
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getColegiadoDireccion(int idColegiado) {
		String nombre = null;

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT direccion FROM Colegiado WHERE idColegiado=" + idColegiado;
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getColegiadoPoblacion(int idColegiado) {
		String nombre = null;

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT poblacion FROM Colegiado WHERE idColegiado=" + idColegiado;
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getColegiadoTelefono(int idColegiado) {
		String nombre = null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT telefono FROM Colegiado WHERE idColegiado=" + idColegiado;
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getColegiadoDatos(int idColegiado) {
		String nombre = null;

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT datosBancarios FROM Colegiado WHERE idColegiado=" + idColegiado;
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getColegiadoFechaS(int idColegiado) {
		String nombre = null;

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT fechaSolicitudColegiado FROM Colegiado WHERE idColegiado=" + idColegiado;
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getColegiadoTitulacion(int idColegiado) {
		String nombre = null;

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT titulacion FROM Colegiado WHERE idColegiado=" + idColegiado;
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getColegiadoCentro(int idColegiado) {
		String nombre = null;

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT centro FROM Colegiado WHERE idColegiado=" + idColegiado;
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getColegiadoAnioT(int idColegiado) {
		String nombre = null;

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT anioTitulo FROM Colegiado WHERE idColegiado=" + idColegiado;
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getDia() {
		String dia;
		int dianum = c1.get(Calendar.DATE);
		if (dianum < 10) {
			dia = "0" + Integer.toString(dianum);
		} else
			dia = Integer.toString(dianum);
		return dia;
	}

	public String getMes() {
		String mes;
		int mesnum = c1.get(Calendar.MONTH) + 1;
		if (mesnum < 10) {
			mes = "0" + Integer.toString(mesnum);
		} else
			mes = Integer.toString(mesnum);
		return mes;
	}

	String fechahoy = anio + "-" + this.getMes() + "-" + this.getDia();

	public String getFecha() {
		return fechahoy;
	}

	public void setNuevoPerito(int idColegiado) {
		String sql = "INSERT INTO Perito (idColegiado, fecha, turno) " + "VALUES ('" + idColegiado + "','"
				+ this.getFecha() + "','" + 0 + "')";
		db.executeUpdate(sql);
	}

	public String getTurno() {
		String nombre = null;

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT count(idPerito)+1 FROM Perito";
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public void actualizarColegiadoDatos(int idColegiado) {
		String sql = "UPDATE Colegiado SET nombre=?, apellidos=?, direccion=?, poblacion=?, telefono=?, datosBancarios=?,"
				+ " fechaSolicitudColegiado=?, titulacion=?, centro=?, anioTitulo=?, dni=? where idColegiado=?";
		db.executeUpdate(sql, inscripcionesListaPeritosView.getNombre(), inscripcionesListaPeritosView.getApellidos(),
				inscripcionesListaPeritosView.getDireccion(), inscripcionesListaPeritosView.getPoblacion(),
				inscripcionesListaPeritosView.getTelefono(), inscripcionesListaPeritosView.getDatos(),
				inscripcionesListaPeritosView.getFecha(), inscripcionesListaPeritosView.getTitulacion(),
				inscripcionesListaPeritosView.getCentro(), inscripcionesListaPeritosView.getAnio(),
				inscripcionesListaPeritosView.getDNI(), idColegiado);
	}

	public boolean existePerito(int idColegiado) {
		String sql = "SELECT idPerito from Perito where idColegiado=" + idColegiado;
		List<InscripcionesEntity> inscripcionSelect = db.executeQueryPojo(InscripcionesEntity.class, sql);
		if (inscripcionSelect.isEmpty())
			return false;
		else
			return true;
	}

	public String getPeritoId(int idColegiado) {
		String nombre = null;

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT idPerito FROM Perito WHERE idColegiado=" + idColegiado;
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getPeritoTurno(int idColegiado) {
		String nombre = null;

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT turno FROM Perito WHERE idColegiado=" + idColegiado;
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}
}
