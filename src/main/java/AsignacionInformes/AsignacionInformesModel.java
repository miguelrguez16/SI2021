package AsignacionInformes;

import java.util.Calendar;
import java.util.List;

import giis.demo.util.Database;

public class AsignacionInformesModel {
	
	private Database db=new Database();
	private Calendar c1 = Calendar.getInstance();
	private String date;

	public List<InformeDisplayDTO> getInfomes(String estado) {
		String sql=
				"SELECT idInformePerito, estado "
				+"FROM idInformesPerito "      //Cuidao que la tabla lleva una "S" al final
				+"WHERE estado =?";
		return db.executeQueryPojo(InformeDisplayDTO.class, sql,estado);
	}
	
	public List<PeritoDisplayDTO> getPeritos() {
		String sql=
				"SELECT idPerito, nombre "
				+ "from Perito p " 
				+ "inner join Colegiado c"
				+ "where c.idColegiado=p.idColegiado";
		return db.executeQueryPojo(PeritoDisplayDTO.class, sql);
	}
	
	public String getFecha() {
		StringBuilder fecha = new StringBuilder();
		String tmp;
		tmp = (c1.get(Calendar.DATE) < 10) ? (String) ("0"+Integer.toString(c1.get(Calendar.DATE))) :  (String) ("0"+Integer.toString(c1.get(Calendar.DATE)));
		fecha.append(tmp + "-");
		
		tmp="";
		tmp=(c1.get(Calendar.MONTH)+1 < 10) ? (String) ("0"+Integer.toString(c1.get(Calendar.MONTH)+1)) :  (String) ("0"+Integer.toString(c1.get(Calendar.MONTH)+1));
		
		fecha.append(tmp+"-"+c1);
		
		
		System.out.println(fecha.toString());
		
		return fecha.toString();
		
	}
	
}
