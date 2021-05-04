package giis.demo.cursosAnio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import giis.demo.colegiados.ColegiadoDisplayDTO;
import giis.demo.consultaInscritos.ConsultaInscritoDisplayDTO;
import giis.demo.inscripciones.InscripcionCursoEntity;
import giis.demo.util.Database;

public class ListaCursosAnioModel {
	
	private Database db= new Database();
	String nombre;
	
	public List<ListaCursosAnioDisplayDTO> getListaCursosAnioModelo(){
		String sql="Select c.idCurso, c.nombre,c.fechaInicio, c.estado,c.plazasTotales, c.plazasTotales-count(i.idInscripcionCurso) as plazasLibres "
				+ "	from Curso as c "
				+ "	left join InscripcionCurso as i on i.idCurso=c.idCurso "
				+ "	where c.estado='abierto' and (i.estado='inscrito' or i.estado='preinscrito') group by c.idCurso order by c.fechaInicio";
		return db.executeQueryPojo(ListaCursosAnioDisplayDTO.class, sql);
	}
	
	public List<ConsultaInscritoDisplayDTO> getListaInscritos(int idCurso){
		String sql ="SELECT co.apellidos as apellidos,co.nombre as nombre ,i.tipo as tipo, i.fecha as fecha, c.precio as precio, i.estado as estado, i.cantidadDevolver as cantidadDevolver From InscripcionCurso AS i "
				+ "INNER JOIN Colegiado AS co ON (co.idColegiado=i.id and i.tipo='colegiado') INNER JOIN Curso as c on c.idCurso=i.idCurso where i.idCurso=? "
				+ "UNION "
				+ "SELECT p.apellidos as apellidos,p.nombre as nombre, i.tipo as tipo,  i.fecha as fecha,  c.precioPrecolegiado as precio, i.estado as estado, i.cantidadDevolver as cantidadDevolver FROM InscripcionCurso AS i "
				+ "INNER JOIN Precolegiado AS p ON (p.id=i.id and i.tipo='precolegiado') INNER JOIN Curso as c on c.idCurso=i.idCurso where i.idCurso=? "
				+ "UNION "
				+ "SELECT cole.apellidos as apellidos,cole.nombre as nombre,i.tipo as tipo, i.fecha as fecha, case when i.tipo ='externo' THEN c.precioExterno when i.tipo ='estudiante' THEN c.precioEstudiante when i.tipo ='empresa' THEN c.precioEmpresa END AS precio,  i.estado as estado, i.cantidadDevolver as cantidadDevolver FROM InscripcionCurso AS i "
				+ "INNER JOIN Colectivo AS cole ON (cole.idColectivo=i.id and (i.tipo='externo' or i.tipo='estudiante' or i.tipo='empresa' )) "
				+ "INNER JOIN Curso as c on c.idCurso=i.idCurso where i.idCurso=? "
				+ "order by Apellidos";
		return db.executeQueryPojo(ConsultaInscritoDisplayDTO.class, sql,idCurso, idCurso,idCurso);
	}
	
	public void setInscripcionInscrita(int id, int idCurso, String tipo) {
		String sql="UPDATE InscripcionCurso SET estado=? where id=? and idCurso=? and tipo=?";
		db.executeUpdate(sql,"inscrito", id, idCurso, tipo);
	}
	
	public void setInscripcionAnulada(int id, int idCurso, String tipo, double cantidad) {
		String sql="UPDATE InscripcionCurso SET estado=?, cantidadDevolver=? where id=? and idCurso=? and tipo=?";
		db.executeUpdate(sql,"anulada", cantidad, id, idCurso, tipo);
	}
	
	public void setInscripcionInscritaDevolver(int id, int idCurso, String tipo, double cantidad) {
		String sql="UPDATE InscripcionCurso SET estado=?, cantidadDevolver=? where id=? and idCurso=? and tipo=?";
		db.executeUpdate(sql,"inscrito", cantidad, id, idCurso, tipo);
	}
	
	public void setInscripcionPreinscritaDevolver(int id, int idCurso, String tipo, double cantidad) {
		String sql="UPDATE InscripcionCurso SET estado=?, cantidadDevolver=? where id=? and idCurso=? and tipo=?";
		db.executeUpdate(sql,"preinscrito", cantidad, id, idCurso, tipo);
	}
	
	
	
	public int getIdColegiado(String dni) {
		int id = 0;
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT idColegiado FROM Colegiado WHERE dni='"+dni+"'";
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            id=rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return id;
	}
	
	public int getIdPrecolegiado(String dni) {
		int id = 0;
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT id FROM Precolegiado WHERE dni='"+dni+"'";
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            id=rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return id;
	}
	
	public boolean esColegiado(String dni) {
		String sql = "SELECT idColegiado from Colegiado where dni=?";
		List<ColegiadoDisplayDTO> lista = db.executeQueryPojo(ColegiadoDisplayDTO.class, sql, dni);
		return !lista.isEmpty();
	}
	
	public boolean esPrecolegiado(String dni) {
		String sql = "SELECT id from Precolegiado where dni=?";
		List<ColegiadoDisplayDTO> lista = db.executeQueryPojo(ColegiadoDisplayDTO.class, sql, dni);
		return !lista.isEmpty();
	}
	
	public boolean esColectivo(String dni) {
		String sql = "SELECT idColectivo from Colectivo where dni=?";
		List<ColegiadoDisplayDTO> lista = db.executeQueryPojo(ColegiadoDisplayDTO.class, sql, dni);
		return !lista.isEmpty();
	}
	
	public int getIdColectivo(String dni) {
		int id = 0;
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT idColectivo FROM Colectivo WHERE dni='"+dni+"'";
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            id=rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return id;
	}
	
	public String getColectivoTipo(int id) {
		String tipo = "";
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT tipoColectivo FROM Colectivo WHERE idColectivo="+id;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            tipo=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return tipo;
	}
	
	
	public String getFechaInscripcion(int id, int idCurso) {
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT fecha FROM InscripcionCurso WHERE id="+id+" and idCurso="+idCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public String getEstado(int id, int idCurso, String tipo) {
		String nombre="";
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT estado FROM InscripcionCurso WHERE id="+id+" and idCurso="+idCurso+" and tipo='"+tipo+"'";
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            nombre=rs.getString(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombre;
	}
	
	public double getPrecioColegiado(int idCurso) {
		double precio=0;
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT precio FROM Curso WHERE idCurso="+idCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            precio=rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return precio;
	}
	
	public double getPrecioPrecolegiado(int idCurso) {
		double precio=0;
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT precioPrecolegiado FROM Curso WHERE idCurso="+idCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            precio=rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return precio;
	}
	
	public double getPrecioEstudiante(int idCurso) {
		double precio=0;
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT precioEstudiante FROM Curso WHERE idCurso="+idCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            precio=rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return precio;
	}
	
	public double getPrecioEmpresa(int idCurso) {
		double precio=0;
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT precioEmpresa FROM Curso WHERE idCurso="+idCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            precio=rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return precio;
	}
	
	public double getPrecioExterno(int idCurso) {
		double precio=0;
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT precioExterno FROM Curso WHERE idCurso="+idCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            precio=rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return precio;
	}
	
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
	
	public double getPrecioDevolver(int idInscripcionCurso) {
		double precio=0;
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT cantidadDevolver FROM InscripcionCurso WHERE idInscripcionCurso="+idInscripcionCurso;
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            precio=rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return precio;
	}
	
	public int getIdInscripcionCurso(int id, int idCurso, String tipo) {
		int idInscripcion=0;
		try {
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:IS2021.db");
	        java.sql.Statement s = conn.createStatement();
	        String sql = "SELECT idInscripcionCurso FROM InscripcionCurso WHERE id="+id+" and idCurso="+idCurso+" and tipo='"+tipo+"'";
	        ResultSet rs =((java.sql.Statement) s).executeQuery(sql);
	        while (rs.next()) {
	            idInscripcion=rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return idInscripcion;
	}
	
	public boolean existeInscripcion(int id, int idCurso, String tipo) {
		String sql="SELECT idInscripcionCurso from InscripcionCurso where (id=? and idCurso=? and tipo=?)";
		List<InscripcionCursoEntity> inscripcionSelect=db.executeQueryPojo(InscripcionCursoEntity.class, sql, id, idCurso, tipo);
		if(inscripcionSelect.isEmpty())
			return false;
		else return true;
	}
	
}
