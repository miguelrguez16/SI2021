package giis.demo.EmisionRecepcionCobro;

import java.util.List;

import giis.demo.util.Database;

public class EmisionRecepcionModel {
	private Database db = new Database();

	/*
	 * Saca la lista en el caso de que el estado del cobro sea cobrado y la fecha es
	 * la anterior a la del año en curso
	 */
	public List<EmisionRecepcionDTO> getListaEmisionCobro1(String fechaPrimerDía) {
		String sql = "Select p.id as numero, p.dni as dni, p.datosCuenta as numeroCuenta, "
				+ "p.nombre as nombre,p.apellidos as apellidos,p.estadoCobro as estadoRecibos,p.fechaEmision as fechaEmision,p.fechaCobro as fechaCobro,p.fechaReclamacion as fechaReclamacion, "
				+ "case when true THEN 'Precolegiado' "
				+ "END AS tipo "
				+ "from Precolegiado as p "
				+ "where (p.estadoCobro=? and p.fechaEmision<?) OR (p.estadoCobro is null and p.fechaEmision is null) "
				+ "union all "
				+ "Select c.idColegiado as numero, c.dni as dni,c.datosBancarios as numeroCuenta, "
				+ "c.nombre as nombre, c.apellidos as apellidos, c.estadoCobro as estadoRecibos, c.fechaEmision as fechaEmision, c.fechaCobro as fechaCobro, c.fechaReclamacion as fechaReclamacion, "
				+ "case when true THEN 'Colegiado' "
				+ "END AS tipo "
				+ "from Colegiado as c "
				+ "inner join SolicitudColegio as sc on sc.idSolicitud=c.idColegiado "
				+ "where ((c.estadoCobro=? and fechaEmision<?) or (c.estadoCobro is null and fechaEmision is null)) and sc.estado='aprobado' " 
				+ "order by apellidos";
		return db.executeQueryPojo(EmisionRecepcionDTO.class, sql, "cobrado", fechaPrimerDía, "cobrado",
				fechaPrimerDía);
	}

	public List<EmisionRecepcionDTO> getRecibosNoCobradosOCobrados(String fechaIni, String fechaFin) {
		String sql = "Select p.id as numero, p.dni as dni, p.datosCuenta as numeroCuenta, "
				+ "p.nombre as nombre,p.apellidos as apellidos,p.estadoCobro as estadoRecibos,p.fechaEmision as fechaEmision,p.fechaCobro as fechaCobro,p.fechaReclamacion as fechaReclamacion,"
				+ "case when true THEN 'Precolegiado' " 
				+ "END AS tipo  " 
				+ "from Precolegiado as p "
				+ "where (p.estadoCobro='No cobrado' or p.estadoCobro='cobrado') and fechaEmision>? "
				+ "union all  "
				+ "Select c.idColegiado as identificador, c.dni as dni,c.datosBancarios as numeroCuenta, "
				+ "c.nombre as nombre, c.apellidos as apellidos, c.estadoCobro as estadoRecibos, c.fechaEmision as fechaEmision, c.fechaCobro as fechaCobro, c.fechaReclamacion as fechaReclamacion, "
				+ "case when true THEN 'Colegiado' " 
				+ "END AS tipo  " 
				+ "from Colegiado as c "
				+ "inner join SolicitudColegio as sc on sc.idSolicitud=c.idColegiado "
				+ "where (c.estadoCobro='No cobrado' or c.estadoCobro='cobrado') and fechaEmision>? and sc.estado='aprobado' "
				+ "order by apellidos";
		return db.executeQueryPojo(EmisionRecepcionDTO.class, sql, fechaIni, fechaIni);
	}

	public List<EmisionRecepcionDTO> getListaCompleta() {
		String sql = "Select p.id as numero, p.dni as dni, p.datosCuenta as numeroCuenta, "
				+ "p.nombre as nombre, " 
				+ "p.apellidos as apellidos, " 
				+ "p.estadoCobro as estadoRecibos, "
				+ "p.fechaEmision as fechaEmision, " 
				+ "p.fechaCobro as fechaCobro, "
				+ "p.fechaReclamacion as fechaReclamacion," 
				+ "case when true THEN 'Precolegiado' " + "END AS tipo "
				+ "from Precolegiado as p "
				+ "union "
				+ "Select c.idColegiado as numero, c.dni as dni,c.datosBancarios as numeroCuenta, "
				+ "c.nombre as nombre, "
				+ "c.apellidos as apellidos, " 
				+ "c.estadoCobro as estadoRecibos, "
				+ "c.fechaEmision as fechaEmision, " 
				+ "c.fechaCobro as fechaCobro, "
				+ "c.fechaReclamacion as fechaReclamacion," 
				+ "case when true THEN 'Colegiado' " + "END AS tipo "
				+ "from Colegiado as c "
				+ "inner join SolicitudColegio as sc on sc.idSolicitud=c.idColegiado "
				+ "where sc.estado='aprobado'"
				+ "order by apellidos";
		return db.executeQueryPojo(EmisionRecepcionDTO.class, sql);
	}

	public void actualizarPrimeraEmisionColegiado(String dni, String fecha) {
		String sql = "UPDATE Colegiado SET estadoCobro=?, fechaEmision =? WHERE dni=?";
		db.executeUpdate(sql, "emitido", fecha, dni);
	}

	public void actualizarPrimeraEmisionPrecolegiado(String dni, String fecha) {
		String sql = "UPDATE Precolegiado SET estadoCobro=?, fechaEmision =? WHERE dni=?";
		db.executeUpdate(sql, "emitido", fecha, dni);
	}

	public boolean esColegiado(String dni) {
		String sql = "SELECT nombre from Colegiado where dni=?";
		List<PersonaDTO> lista = db.executeQueryPojo(PersonaDTO.class, sql, dni);
		return !lista.isEmpty();
	}

	public void actualizarReciboColegiado1(String dni, String estado, String fecha) {
		String sql = "UPDATE Colegiado SET estadoCobro=?, fechaCobro=? WHERE dni=?";
		db.executeUpdate(sql, estado, fecha, dni);
	}

	public boolean esPrecolegiado(String dni) {
		String sql = "SELECT nombre from Precolegiado where dni=?";
		List<PersonaDTO> lista = db.executeQueryPojo(PersonaDTO.class, sql, dni);
		return !lista.isEmpty();
	}

	public void actualizarReciboPrecolegiado1(String dni, String estado, String fecha) {
		String sql = "UPDATE Precolegiado SET estadoCobro=?, fechaCobro=? WHERE dni=?";
		db.executeUpdate(sql, estado, fecha, dni);
	}

	public List<EmisionRecepcionDTO> getQuedanSinCobrar() {
		String sql = "Select p.id as numero, p.dni as dni, p.datosCuenta as numeroCuenta, "
				+ "p.nombre as nombre, " 
				+ "p.apellidos as apellidos, " 
				+ "p.estadoCobro as estadoRecibos, "
				+ "p.fechaEmision as fechaEmision, " 
				+ "p.fechaCobro as fechaCobro, "
				+ "p.fechaReclamacion as fechaReclamacion," 
				+ "case when true THEN 'Precolegiado' " 
				+ "END AS tipo "
				+ "from Precolegiado as p " 
				+ "where p.estadoCobro='emitido' "
				+ "union "
				+ "Select c.idColegiado as numero, c.dni as dni,c.datosBancarios as numeroCuenta, "
				+ "c.nombre as nombre, " 
				+ "c.apellidos as apellidos, " 
				+ "c.estadoCobro as estadoRecibos, "
				+ "c.fechaEmision as fechaEmision, " 
				+ "c.fechaCobro as fechaCobro, "
				+ "c.fechaReclamacion as fechaReclamacion," 
				+ "case when true THEN 'Colegiado' " 
				+ "END AS tipo "
				+ "from Colegiado as c "
				+ "inner join SolicitudColegio as sc on sc.idSolicitud=c.idColegiado "
				+ "where c.estadoCobro='emitido' and sc.estado='aprobado' "
				+ "order by apellidos";
		return db.executeQueryPojo(EmisionRecepcionDTO.class,sql);
	}

	public boolean getEstadoColegiado(String estado,String dni) {
		String sql = "SELECT estadoCobro as estado from Colegiado where dni=?";
		List<PersonaDTO> lista = db.executeQueryPojo(PersonaDTO.class, sql, dni);
		return !(lista.get(0).getEstado().equals("No cobrado") || lista.get(0).getEstado().equals("cobrado"));
	}
	
	public boolean getEstadoPrecolegiado(String estado,String dni) {
		String sql = "SELECT estadoCobro as estado from Precolegiado where dni=?";
		List<PersonaDTO> lista = db.executeQueryPojo(PersonaDTO.class, sql, dni);
		return !(lista.get(0).getEstado().equals("No cobrado") || lista.get(0).getEstado().equals("cobrado"));
	}

}