package giis.demo.consultaInscritos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;



public class ConsultaInscritosView extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 59272130249980170L;
	/**
	 * 
	 */
	private JFrame frame;
	private JTable tabCurso;
	private JLabel lblLbltable;
	private JButton btnGuardarCambios;
	private static JTextField tfCurso;
	private JButton bPrueba;

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
		frame = new JFrame();
		frame.setTitle("Cursos Pendientes");
		frame.setName("Cursos Pendientes");
		frame.setBounds(0, 0, 780, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblLbltable = new JLabel("Seleccionar curso:");
		lblLbltable.setBounds(10, 66, 123, 14);
		frame.getContentPane().add(lblLbltable);
		
		//Incluyo la tabla en un JScrollPane y anado este en vez de la tabla para poder ver los headers de la tabla
		tabCurso = new JTable();
		tabCurso.setName("tabCarreras");
		tabCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabCurso.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablaInscritos = new JScrollPane(tabCurso);
		tablaInscritos.setBounds(10, 118, 747, 284);
		frame.getContentPane().add(tablaInscritos);
		
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setBounds(594, 473, 141, 31);
		frame.getContentPane().add(btnGuardarCambios);
		
		tfCurso = new JTextField();
		tfCurso.setBounds(143, 63, 133, 20);
		frame.getContentPane().add(tfCurso);
		tfCurso.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Recaudación Total:");
		lblNewLabel.setBounds(27, 452, 115, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lTotalDinero = new JLabel("");
		lTotalDinero.setBounds(152, 452, 54, 20);
		frame.getContentPane().add(lTotalDinero);
		
		JLabel lblNewLabel_1 = new JLabel("€");
		lblNewLabel_1.setBounds(230, 452, 46, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		bPrueba = new JButton("Prueba");
		bPrueba.setBounds(485, 477, 89, 23);
		frame.getContentPane().add(bPrueba);
	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frame; }
	public JTable getTablaCursos() { return this.tabCurso; }
	public JButton getBtnActualizarCurso() {return this.btnGuardarCambios;}
	public JButton getBtnPrueba() {return this.bPrueba;}
	public String getNombreCurso() { return tfCurso.getText();}
}

