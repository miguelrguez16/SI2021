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

	public ConsultaInscritosController(ConsultaInscritosModel modelo, ConsultaInscritosView vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
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
				vista.getLRecaudacion().setText(String.valueOf(modelo.getRecaudacion(modelo.getIDCurso(ConsultaInscritosView.getNombreCurso()))));
		
			}});
			 
		vista.getBtnCerrar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				vista.getFrame().setVisible(false);
				}
			});
		}
	
	private static void setListaCursosController() {
		List<ConsultaInscritoDisplayDTO> cursos = modelo.getListaCursosModelo();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos,
				new String[] { "apellidos", "nombre", "fecha", "estado", "precio" });
		vista.getTablaCursos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTablaCursos());
	}
	
}