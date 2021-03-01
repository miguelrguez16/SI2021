package giis.demo.cursos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class CursoController {
	
	private CursoModel modelo;
	private CursoView vista;
	private String lastSelectedKey="";

	public CursoController(CursoModel modelo, CursoView vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.initview();
	}

	public void initview() {
		vista.getFrame().setVisible(true); 
		setListaCursosController();
	
	}
	
	//Iniciar los controladore de la vista
	public void initController() {
		
		vista.getBtnActualizarCurso().addActionListener(e -> SwingUtil.exceptionWrapper(() -> updateCursosPendientes()));
		vista.getTablaCursos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//no usa mouseClicked porque al establecer seleccion simple en la tabla de carreras
				//el usuario podria arrastrar el raton por varias filas e interesa solo la ultima
				SwingUtil.exceptionWrapper(() -> updateCursosPendientes());
			}
		});
		
	}
	
	private void setListaCursosController() {
		List<CursoDisplayDTO> cursos=modelo.getListaCursosModelo();
		TableModel tmodel=SwingUtil.getTableModelFromPojos(cursos, new String[] {"id", "nombre", "fecha"});
		//view.getTablaCarreras().setModel(tmodel);
		vista.getTablaCursos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTablaCursos());
		
		//this.restoreDetail();


	}

	/**
	 * Restaura la informacion del detalle de la carrera para visualizar los valores correspondientes
	 * a la ultima clave almacenada.
	 */
	public void restoreDetail() {
		//Utiliza la ultimo valor de la clave (que se reiniciara si ya no existe en la tabla)
		this.lastSelectedKey=SwingUtil.selectAndGetSelectedKey(vista.getTablaCursos(), this.lastSelectedKey);
		//Si hay clave para seleccionar en la tabla muestra el detalle, si no, lo reinicia
		if ("".equals(this.lastSelectedKey)) { 
			/*view.setDescuentoNoAplicable();
			view.getDetalleCarrera().setModel(new DefaultTableModel());		*/
			
			vista.setNombreNoAplicable();
			vista.setIdNoAplicable();
		} else {
			//this.updateDetail();
		}
	}

	public void updateCursosPendientes() {

	} 	
	

}
