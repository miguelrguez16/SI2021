package giis.demo.AsignacionInformes;

import java.util.Calendar;
import java.util.List;

import giis.demo.cursos.CursoEntity;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class AsignacionInformesModel {
	
	private Database db=new Database();
	private Calendar c1 = Calendar.getInstance();

	/*
	 * Lista de Informes en con el estado pedido
	 * muestra id y su estado
	 */
	public List<InformeDisplayDTO> getInfomes(String estado) {
		String sql=
				"SELECT idInformePerito, estado "
				+"FROM InformesPerito "      //Cuidao que la tabla lleva una "S" al final
				+"WHERE estado =?";
		return db.executeQueryPojo(InformeDisplayDTO.class, sql,estado);
	}
	
	/*
	 * Lista de peritos
	 * muestra id y el nombre
	 */
	public List<PeritoDisplayDTO> getPeritos() {
		String sql=
				"SELECT idPerito, nombre "
				+ "from Perito p " 
				+ "inner join Colegiado c "
				+ "where c.idColegiado=p.idColegiado";
		return db.executeQueryPojo(PeritoDisplayDTO.class, sql);
	}
	
	/*
	 * Devuelve la fecha actual del sistema
	 * YEAR-MONTH-DAY
	 */
	public String getFecha() {
		StringBuilder fecha = new StringBuilder();
		String tmp;
		tmp = Integer.toString(c1.get(Calendar.YEAR));
		
		fecha.append(tmp+"-");
		
		tmp="";
		tmp=(c1.get(Calendar.MONTH)+1 < 10) ? (String) ("0"+Integer.toString(c1.get(Calendar.MONTH)+1)) :  (String) ("0"+Integer.toString(c1.get(Calendar.MONTH)+1));
		fecha.append(tmp+"-");
	
		tmp = (c1.get(Calendar.DATE) < 10) ? (String) ("0"+Integer.toString(c1.get(Calendar.DATE))) :  (String) ("0"+Integer.toString(c1.get(Calendar.DATE)));
		fecha.append(tmp);
		
		System.out.println(fecha.toString());
		
		return fecha.toString();
	}

	public InformesPeritosEntity getInformeSelected(int idInformePerito) {
		String sql="SELECT idInformePerito FROM InformesPerito WHERE idInformePerito=?";
		List<InformesPeritosEntity> inforSelected=db.executeQueryPojo(InformesPeritosEntity.class, sql, idInformePerito);
		validateCondition(!inforSelected.isEmpty(),"Id del informe no encontrado: "+idInformePerito);
		//System.out.println(inforSelected.get(0).toString());
		return inforSelected.get(0);
	}

	public PeritosEntity getPeritoSelected(int idPerito) {
		String sql="SELECT idPerito FROM Perito WHERE idPerito=?";
		List<PeritosEntity> peritoSelected=db.executeQueryPojo(PeritosEntity.class, sql, idPerito);
		validateCondition(!peritoSelected.isEmpty(),"Id del informe no encontrado: "+idPerito);

		return peritoSelected.get(0);
	}

	public void asignarInforme(int keyInforme, int keyPerito) {
		String sql="UPDATE InformesPerito SET estado=?, idPerito=?, fecha=? where idInformePerito=?";
		db.executeUpdate(sql,"asignado",keyPerito,this.getFecha(),keyInforme);		
	}
	
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}

	

	
	
}