package giis.demo.consultaInscritos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.table.TableModel;

import giis.demo.cursos.CursoDisplayDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class ConsultaInscritosController {

	private static ConsultaInscritosModel modelo;
	private static ConsultaInscritosView vista;
	private String lastSelectedKey = "";
	private static double recaudacion;

	public ConsultaInscritosController(ConsultaInscritosModel modelo, ConsultaInscritosView vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		recaudacion = 0.0;
	}

	public static void initview() {
	
		vista.getFrame().setVisible(true);
		
	}

	// Iniciar los controladore de la vista
	public void initController() {
		initview();
		vista.getBtnBuscar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setListaCursosController();
				vista.getLRecaudacion().setText(String.valueOf(recaudacion));
		
			}});
			 
		vista.getBtnCerrar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				vista.getFrame().setVisible(false);
				}
			});
		}
	
	private static void setListaCursosController() {
		//List<ConsultaInscritoDisplayDTO> cursos = modelo.getListaCursosModelo();
		List<ConsultaInscritoDisplayDTO> cursos = modelo.getListaCursos(modelo.getIDCurso(vista.getNombreCurso()));
		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos,
				new String[] { "apellidos", "nombre", "estado", "fecha","tipo", "precio" });
		vista.getTablaCursos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTablaCursos());
		recaudacion = totalRecaudacion(cursos);
	}
	
	private static double totalRecaudacion(List<ConsultaInscritoDisplayDTO> data) {
		double tmp = 0.0;
		for (int i = 0; i < data.size(); i++) {
			tmp=tmp+ Double.parseDouble(data.get(i).getPrecio());
		}
		return tmp;
	}
	
}