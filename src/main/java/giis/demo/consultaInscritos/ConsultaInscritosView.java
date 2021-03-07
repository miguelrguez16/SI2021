package giis.demo.consultaInscritos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.Dimension;



public class ConsultaInscritosView extends JFrame {


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
	private JButton bBuscar;
	private JLabel lTotalDinero;
	private static JTextField tfCurso;

	/**
	 * Create the application.
	 */
	public ConsultaInscritosView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaInscritos = new JFrame();
		frmConsultaInscritos.setMinimumSize(new Dimension(424, 492));
		frmConsultaInscritos.setTitle("Consulta Inscritos");
		frmConsultaInscritos.setName("Consulta Inscritos");
		frmConsultaInscritos.setBounds(0, 0, 424, 492);
		frmConsultaInscritos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultaInscritos.getContentPane().setLayout(null);
		
		lblLbltable = new JLabel("Seleccionar curso:");
		lblLbltable.setBounds(10, 66, 123, 14);
		frmConsultaInscritos.getContentPane().add(lblLbltable);
		
		//Incluyo la tabla en un JScrollPane y anado este en vez de la tabla para poder ver los headers de la tabla
		tabCurso = new JTable();
		tabCurso.setName("tabCarreras");
		tabCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabCurso.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablaInscritos = new JScrollPane(tabCurso);
		tablaInscritos.setBounds(10, 118, 387, 233);
		frmConsultaInscritos.getContentPane().add(tablaInscritos);
		
		bCerrar = new JButton("Cerrar");
		bCerrar.setBounds(299, 377, 98, 20);
		frmConsultaInscritos.getContentPane().add(bCerrar);
		
		tfCurso = new JTextField();
		tfCurso.setBounds(143, 63, 133, 20);
		frmConsultaInscritos.getContentPane().add(tfCurso);
		tfCurso.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Recaudación Total:");
		lblNewLabel.setBounds(10, 377, 115, 20);
		frmConsultaInscritos.getContentPane().add(lblNewLabel);
		
		lTotalDinero = new JLabel("");
		lTotalDinero.setBounds(130, 377, 54, 20);
		frmConsultaInscritos.getContentPane().add(lTotalDinero);
		
		JLabel lblNewLabel_1 = new JLabel("€");
		lblNewLabel_1.setBounds(194, 377, 46, 20);
		frmConsultaInscritos.getContentPane().add(lblNewLabel_1);
		
		bBuscar = new JButton("Buscar");
		bBuscar.setBounds(293, 62, 89, 23);
		frmConsultaInscritos.getContentPane().add(bBuscar);
	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frmConsultaInscritos; }
	public JTable getTablaCursos() { return this.tabCurso; }
	public JButton getBtnCerrar() {return this.bCerrar;}
	public JButton getBtnBuscar() {return this.bBuscar;}
	public JLabel getLRecaudacion() {return this.lTotalDinero;}
	public static String getNombreCurso() { return tfCurso.getText();}
}

