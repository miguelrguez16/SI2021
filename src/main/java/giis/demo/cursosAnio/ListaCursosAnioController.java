package giis.demo.cursosAnio;


import java.util.List;
import javax.swing.table.TableModel;

import giis.demo.util.SwingUtil;


public class ListaCursosAnioController {
	
	private ListaCursosAnioModel modelo;
	private ListaCursosAnioView vista;

	public ListaCursosAnioController(ListaCursosAnioModel m, ListaCursosAnioView v) {
		this.modelo = m;
		this.vista = v;
		this.initView();
	}
	
	private void initView() {
		vista.getFrame().setVisible(true); 
		this.setListaCursosAnioController();
	}
	
	public void initController() {
			
	}
	
	private void setListaCursosAnioController() {
        List<ListaCursosAnioDisplayDTO> cursos = modelo.getListaCursosAnioModelo();
        TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos,new String[] { "idCurso", "nombre", "fechaInicio", "estado", "plazasTotales", "plazasLibres" });
        vista.getTablaCursos().setModel(tmodel);
        SwingUtil.autoAdjustColumns(vista.getTablaCursos());
    }
}
