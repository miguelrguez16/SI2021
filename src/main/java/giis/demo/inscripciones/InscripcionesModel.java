package giis.demo.inscripciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import giis.demo.colegiados.ColegiadoEntity;
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

	public String getFecha() {
		Calendar c1 = Calendar.getInstance();
		StringBuilder fecha = new StringBuilder();
		String tmp;
		tmp = Integer.toString(c1.get(Calendar.YEAR));
		fecha.append(tmp + "-");
		tmp = "";
		tmp = (c1.get(Calendar.MONTH) + 1 < 10) ? (String) ("0" + Integer.toString(c1.get(Calendar.MONTH) + 1)) : (String) (Integer.toString(c1.get(Calendar.MONTH) + 1));
		fecha.append(tmp + "-");
		tmp = (c1.get(Calendar.DATE) < 10) ? (String) ("0" + Integer.toString(c1.get(Calendar.DATE))) : (String) (Integer.toString(c1.get(Calendar.DATE)));
		fecha.append(tmp);
		return fecha.toString();
	}
	
	public List<CursoDisplayDTO> getListaCursosModelo() {
		String sql="SELECT idCurso, nombre, fechaInicio, precio, precioPrecolegiado, precioEstudiante, precioEmpresa, precioExterno FROM CURSO WHERE estado ='abierto'";
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
	
	public String getPrecolegiadoNombre(int id) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT nombre FROM Precolegiado WHERE id="+id;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getPrecolegiadoApellidos(int id) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT apellidos FROM Precolegiado WHERE id="+id;
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
	
	public String getColectivoNombre(int idColectivo) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT nombre FROM Colectivo WHERE idColectivo="+idColectivo;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getColectivoApellidos(int idColectivo) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT apellidos FROM Colectivo WHERE idColectivo="+idColectivo;
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
	
	public String getCursoPrecioPrecolegiado(int idCurso) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT precioPrecolegiado FROM Curso WHERE idCurso="+idCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getCursoPrecioExterno(int idCurso) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT precioExterno FROM Curso WHERE idCurso="+idCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}

	public String getCursoPrecioEstudiante(int idCurso) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT precioEstudiante FROM Curso WHERE idCurso="+idCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getColectivoTipo(int idColectivo) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT tipoColectivo FROM Colectivo WHERE idColectivo="+idColectivo;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getCursoPrecioEmpresa(int idCurso) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT precioEmpresa FROM Curso WHERE idCurso="+idCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getCursoPlazasTotales(int idCurso) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT plazasTotales FROM Curso WHERE idCurso="+idCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getCursoPlazasOcupadas(int idCurso) {
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT count(idInscripcionCurso) from InscripcionCurso where idCurso="+idCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}

	public void setNuevaInscripcion(int id, int idCurso, String tipo) {
		String sql="INSERT INTO InscripcionCurso (id, idCurso, tipo, estado, fecha) VALUES (?,?,?,?,?)";
		db.executeUpdate(sql, id, idCurso, tipo, "preinscrito", this.getFecha());
	}
	
	public boolean existeInscripcion(int id, int idCurso, String tipo) {
		String sql="SELECT idInscripcionCurso from InscripcionCurso where (id=? and idCurso=? and tipo=?)";
		List<InscripcionCursoEntity> inscripcionSelect=db.executeQueryPojo(InscripcionCursoEntity.class, sql, id, idCurso, tipo);
		if(inscripcionSelect.isEmpty())
			return false;
		else return true;
	}
	
	
	public boolean existeColegiado(int idColegiado) {
		String sql="SELECT nombre from Colegiado where idColegiado=?";
		List<ColegiadoEntity> colegiadoSelect=db.executeQueryPojo(ColegiadoEntity.class, sql, idColegiado);
		if(colegiadoSelect.isEmpty())
			return false;
		else return true;
	}
	
	public boolean existePrecolegiado(int idPrecolegiado) {
		String sql="SELECT nombre from Precolegiado where id=?";
		List<PrecolegiadoEntity> precolegiadoSelect=db.executeQueryPojo(PrecolegiadoEntity.class, sql, idPrecolegiado);
		if(precolegiadoSelect.isEmpty())
			return false;
		else return true;
	}
	
	public boolean existeColectivo(int dni) {
		String sql="SELECT idColectivo from Colectivo where dni=?";
		List<ColectivoEntity> colectivoSelect=db.executeQueryPojo(ColectivoEntity.class, sql, dni);
		if(colectivoSelect.isEmpty())
			return false;
		else return true;
	}
	
	public void setNuevoColectivo(String tipo) {
		String sql="INSERT INTO Colectivo (nombre, apellidos, dni, direccion, poblacion, telefono, tipoColectivo) "
				+ "VALUES ('"+InscripcionesView.getNombre()+"','"+InscripcionesView.getApellidos()+"','"+InscripcionesView.getDni()+"','"+
				InscripcionesView.getDireccion()+"','"+InscripcionesView.getPoblacion()+"','"+InscripcionesView.getTelefono()+"','"+tipo+"')";
		db.executeUpdate(sql);
	}
}