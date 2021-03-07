package giis.demo.consultaInscritos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.table.TableModel;

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
	public static void initController() {
		initview();
		
		vista.getBtnPrueba().addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.out.print(modelo.getIDCurso(vista.getNombreCurso()));
			}
		});
	}
}