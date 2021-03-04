package giis.demo.colegiados;

import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;


public class ColegiadoModel {
	
	private Database db=new Database();
	
	public List<ColegiadoDisplayDTO> getListaColegiadosModelo(){
		String sql="SELECT	idColegiado, nombre, apellidos FROM COLEGIADO";
		return db.executeQueryPojo(ColegiadoDisplayDTO.class, sql);
	}
	
	public ColegiadoEntity getColegiadoSelec(int idColegiado) {
		String sql="SELECT idColegiado, nombre, apellidos from curso where idColegiado=?";
		List<ColegiadoEntity> colegiadoSelect=db.executeQueryPojo(ColegiadoEntity.class, sql, idColegiado);
		validateCondition(!colegiadoSelect.isEmpty(), "Id de colegiado no encontrado: "+idColegiado);
		return colegiadoSelect.get(0);
	}
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}
}
