package giis.demo.EnvioCol;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Font;



public class EnvioColView extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 59272130249980170L;
	/**
	 * 
	 */
	private JFrame frmConsultaInscritos;
	private JTable tabCurso;
	private JLabel lblLbltable;
	private JButton bCerrar;
	private JButton btnEnviar;
	private JButton bActualizar;

	/**
	 * Create the application.
	 */
	public EnvioColView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaInscritos = new JFrame();
		frmConsultaInscritos.setMinimumSize(new Dimension(612, 410));
		frmConsultaInscritos.setTitle("Consulta Inscritos");
		frmConsultaInscritos.setName("Consulta Inscritos");
		frmConsultaInscritos.setBounds(0, 0, 612, 410);
		frmConsultaInscritos.getContentPane().setLayout(null);
		frmConsultaInscritos.setLocationRelativeTo(null);

		
		lblLbltable = new JLabel("Lista de Colegiados");
		lblLbltable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLbltable.setBounds(237, 11, 204, 22);
		frmConsultaInscritos.getContentPane().add(lblLbltable);
		
		//Incluyo la tabla en un JScrollPane y anado este en vez de la tabla para poder ver los headers de la tabla
		tabCurso = new JTable();
		tabCurso.setName("tabCarreras");
		tabCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabCurso.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablaInscritos = new JScrollPane(tabCurso);
		tablaInscritos.setBounds(10, 44, 576, 233);
		frmConsultaInscritos.getContentPane().add(tablaInscritos);
		
		bCerrar = new JButton("Cerrar");
		bCerrar.setBounds(353, 324, 98, 23);
		frmConsultaInscritos.getContentPane().add(bCerrar);
		
		btnEnviar = new JButton("Enviar Lote");
		btnEnviar.setBounds(478, 324, 108, 23);
		frmConsultaInscritos.getContentPane().add(btnEnviar);
		
		bActualizar = new JButton("Actualizar Lista");
		bActualizar.setBounds(10, 324, 149, 23);
		frmConsultaInscritos.getContentPane().add(bActualizar);
	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frmConsultaInscritos; }
	public JTable getTablaCursos() { return this.tabCurso; }
	public JButton getBtnCerrar() {return this.bCerrar;}
	public JButton getBtnEnviar() {return this.btnEnviar;}
	public JButton getBtnActualizar() {return this.bActualizar;}
}

