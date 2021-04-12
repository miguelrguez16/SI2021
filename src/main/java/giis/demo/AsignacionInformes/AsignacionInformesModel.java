package giis.demo.AsignacionInformes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class AsignacionInformesModel {

	private Database db = new Database();
	private Calendar c1 = Calendar.getInstance();

	/*
	 * Lista de Informes en con el estado pedido muestra id y su estado
	 */
	public List<InformeDisplayDTO> getInfomes(String estado) {
		String sql = "SELECT idInformePerito, estado " + "FROM InformesPerito " // Cuidao que la tabla lleva una "S" al
																				// final
				+ "WHERE estado =?";
		return db.executeQueryPojo(InformeDisplayDTO.class, sql, estado);
	}

	/*
	 * Lista de peritos muestra id y el nombre
	 */
	public List<PeritoDisplayDTO> getPeritos() {
		String sql = "Select p.idPerito, c.nombre, p.turno " + "from Perito p "
				+ "inner join Colegiado as c on p.idColegiado = c.idColegiado " + "where p.estado='aprobado' "
				+ "order by p.turno";
		return db.executeQueryPojo(PeritoDisplayDTO.class, sql);
	}

	/*
	 * Devuelve la fecha actual del sistema YEAR-MONTH-DAY
	 */
	public String getFecha() {
		StringBuilder fecha = new StringBuilder();
		String tmp;
		tmp = Integer.toString(c1.get(Calendar.YEAR));
		fecha.append(tmp + "-");
		tmp = "";
		tmp = (c1.get(Calendar.MONTH) + 1 < 10) ? (String) ("0" + Integer.toString(c1.get(Calendar.MONTH) + 1))
				: (String) (Integer.toString(c1.get(Calendar.MONTH) + 1));
		fecha.append(tmp + "-");

		tmp = (c1.get(Calendar.DATE) < 10) ? (String) ("0" + Integer.toString(c1.get(Calendar.DATE)))
				: (String) (Integer.toString(c1.get(Calendar.DATE)));
		fecha.append(tmp);

		//System.out.println(fecha.toString());
		return fecha.toString();
	}

	public InformesPeritosEntity getInformeSelected(int idInformePerito) {
		String sql = "SELECT idInformePerito FROM InformesPerito WHERE idInformePerito=?";
		List<InformesPeritosEntity> inforSelected = db.executeQueryPojo(InformesPeritosEntity.class, sql,
				idInformePerito);
		validateCondition(!inforSelected.isEmpty(), "Id del informe no encontrado: " + idInformePerito);
		// System.out.println(inforSelected.get(0).toString());
		return inforSelected.get(0);
	}

	public PeritosEntity getPeritoSelected(int idPerito) {
		String sql = "SELECT idPerito FROM Perito WHERE idPerito=?";
		List<PeritosEntity> peritoSelected = db.executeQueryPojo(PeritosEntity.class, sql, idPerito);
		validateCondition(!peritoSelected.isEmpty(), "Id del informe no encontrado: " + idPerito);

		return peritoSelected.get(0);
	}

	public void asignarInformeManual(int keyInforme, int keyPerito) {
		String sql = "UPDATE InformesPerito SET estado=?, idPerito=?, fecha=? where idInformePerito=?";
		db.executeUpdate(sql, "asignado", keyPerito, this.getFecha(), keyInforme);
	}

	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}

	public void cambiarTAP(int idPerito, int turno) {
		//System.out.println("perito: "+ idPerito + " --> turno " + turno);
		String sql = "UPDATE Perito SET turno=? where idPerito=?";
		db.executeUpdate(sql, turno, idPerito);
	}

	public int getNumeroPerito() {
		int total = 0;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT count(*) FROM Perito where estado='aprobado'";
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	public int getPerito(int turno) {
		int perito = 0;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT idPerito FROM Perito where turno=\'"+turno+"\'";
			ResultSet rs = ((java.sql.Statement) s).executeQuery(sql);
			while (rs.next()) {
				perito = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return perito;
	}
	
	public String getNombrePerito(int idPerito) {
		String nombre = null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
			java.sql.Statement s = conn.createStatement();
			String sql = "SELECT c.nombre FROM Colegiado as c INNER JOIN Perito as p on p.idColegiado = c.idColegiado where p.idPerito=\'"+idPerito+"\'";
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