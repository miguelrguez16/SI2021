package giis.demo.nuevosCursos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
//<<<<<<< HEAD
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JToggleButton;




public class NuevosCursoView extends JFrame {



	private static final long serialVersionUID = 59272130249980170L;

	private JFrame frmNuevosCursos;
	private JTable tabCurso;
	private JTextField campoInicio;
	private JTextField campoFin;
	private JLabel lblLbltable;
	private JButton btnGuardarCambios;
	private JButton btnRellenarDatos;
	private JButton btnActualizarLista;
	private JTextField nombreCurso;
	private JTextField precioColegiado;
	private JButton btnVaciar;


	/**
	 * Create the application.
	 */
	public NuevosCursoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNuevosCursos = new JFrame();
		frmNuevosCursos.setTitle("Planificar Cursos");
		frmNuevosCursos.setName("Nuevos Cursos");

		frmNuevosCursos.setBounds(0, 0, 486, 678);

		frmNuevosCursos.getContentPane().setLayout(null);
		frmNuevosCursos.setLocationRelativeTo(null);

		
		lblLbltable = new JLabel("Lista de cursos planificados para este año");

		lblLbltable.setBounds(106, 36, 272, 14);

		frmNuevosCursos.getContentPane().add(lblLbltable);
		
		//Incluyo la tabla en un JScrollPane y anado este en vez de la tabla para poder ver los headers de la tabla
		tabCurso = new JTable();
		tabCurso.setName("tabCarreras");
		tabCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabCurso.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablePanel = new JScrollPane(tabCurso);

		tablePanel.setBounds(50, 61, 359, 291);

		frmNuevosCursos.getContentPane().add(tablePanel);
	
		btnGuardarCambios = new JButton("Planificar Cursos");
		btnGuardarCambios.setBounds(277, 483, 132, 20);
		frmNuevosCursos.getContentPane().add(btnGuardarCambios);

		
		campoInicio = new JTextField();

		campoInicio.setBounds(129, 427, 86, 20);
		frmNuevosCursos.getContentPane().add(campoInicio);
		campoInicio.setColumns(10);
		
		campoFin = new JTextField();
		campoFin.setBounds(319, 427, 86, 20);
		frmNuevosCursos.getContentPane().add(campoFin);
		campoFin.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de fin:");
		lblNewLabel_2.setBounds(241, 430, 101, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_2);
		
		btnRellenarDatos = new JButton("pruebas");
		btnRellenarDatos.setBounds(10, 608, 45, 20);
		frmNuevosCursos.getContentPane().add(btnRellenarDatos);
		
		nombreCurso = new JTextField();
		nombreCurso.setBounds(129, 383, 86, 20);
		frmNuevosCursos.getContentPane().add(nombreCurso);
		nombreCurso.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre Curso:");
		lblNewLabel.setBounds(37, 386, 86, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Precio:");
		lblNewLabel_5.setBounds(241, 386, 57, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_5);
		
		precioColegiado = new JTextField();
		precioColegiado.setBounds(330, 383, 71, 20);
		frmNuevosCursos.getContentPane().add(precioColegiado);
		precioColegiado.setColumns(10);
		
		btnActualizarLista = new JButton("Actuallizar lista");
		btnActualizarLista.setBounds(50, 482, 132, 23);
		frmNuevosCursos.getContentPane().add(btnActualizarLista);
		
		btnVaciar = new JButton("vaciar");
		btnVaciar.setBounds(76, 521, 89, 23);
		frmNuevosCursos.getContentPane().add(btnVaciar);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Inicio:");
		lblNewLabel_1.setBounds(37, 430, 71, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_1);

	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frmNuevosCursos; }

	public JTable getTablaCursos() { return this.tabCurso; }
	

	public JTextField getNombreCurso() {return this.nombreCurso;}
	public JTextField getPrecioColegiado() {return this.precioColegiado;}
	public JTextField getFechaInicio() {return this.campoInicio;}
	public JTextField getFechaFin() {return this.campoFin;}
	public JButton getRellenarDatos() { return this.btnRellenarDatos;}
	public JButton getBtnActualizarCurso() {return this.btnGuardarCambios;}
	public JButton getActualizarLista() { return this.btnActualizarLista;}
	public JButton getVaciar() { return this.btnVaciar;}
}

