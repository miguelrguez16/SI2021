package giis.demo.nuevosCursos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JToggleButton;

import java.awt.Font;
import javax.swing.JComboBox;





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
	private JTextField precioPrecolegiado;
	private JTextField textoInstalacion;
	private JComboBox comboBoxProfesores;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField precioestudiante;
	private JLabel lblNewLabel_8;
	private JTextField precioEmpresa;
	private JTextField precioExterno;
	private JLabel lblNewLabel_9;



	/**
	 * Create the application.
	 */
	public NuevosCursoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frmNuevosCursos = new JFrame();
		frmNuevosCursos.setTitle("Planificar Cursos");
		frmNuevosCursos.setName("Nuevos Cursos");


		frmNuevosCursos.setBounds(0, 0, 906, 678);


		frmNuevosCursos.getContentPane().setLayout(null);
		frmNuevosCursos.setLocationRelativeTo(null);

		
		lblLbltable = new JLabel("Lista de cursos planificados para este año");

		lblLbltable.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblLbltable.setBounds(50, 36, 359, 14);


		frmNuevosCursos.getContentPane().add(lblLbltable);
		
		//Incluyo la tabla en un JScrollPane y anado este en vez de la tabla para poder ver los headers de la tabla
		tabCurso = new JTable();
		tabCurso.setName("tabCarreras");
		tabCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabCurso.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablePanel = new JScrollPane(tabCurso);


		tablePanel.setBounds(37, 61, 844, 291);

		frmNuevosCursos.getContentPane().add(tablePanel);
	
		btnGuardarCambios = new JButton("Planificar Cursos");
		btnGuardarCambios.setBounds(703, 580, 132, 20);
		frmNuevosCursos.getContentPane().add(btnGuardarCambios);

		
		campoInicio = new JTextField();

		campoInicio.setBounds(162, 428, 86, 20);
		frmNuevosCursos.getContentPane().add(campoInicio);
		campoInicio.setColumns(10);
		
		campoFin = new JTextField();
		campoFin.setBounds(162, 471, 86, 20);
		frmNuevosCursos.getContentPane().add(campoFin);
		campoFin.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de fin:");
		lblNewLabel_2.setBounds(37, 473, 124, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_2);
		
		btnRellenarDatos = new JButton("pruebas");
		btnRellenarDatos.setBounds(10, 608, 45, 20);
		frmNuevosCursos.getContentPane().add(btnRellenarDatos);
		
		nombreCurso = new JTextField();
		nombreCurso.setBounds(162, 384, 86, 20);
		frmNuevosCursos.getContentPane().add(nombreCurso);
		nombreCurso.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre Curso:");
		lblNewLabel.setBounds(37, 386, 124, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Precio Colegiado:");
		lblNewLabel_5.setBounds(285, 385, 124, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_5);
		
		precioColegiado = new JTextField();
		precioColegiado.setBounds(437, 383, 86, 20);
		frmNuevosCursos.getContentPane().add(precioColegiado);
		precioColegiado.setColumns(10);
		
		btnActualizarLista = new JButton("Actuallizar lista");
		btnActualizarLista.setBounds(498, 579, 132, 23);
		frmNuevosCursos.getContentPane().add(btnActualizarLista);
		
		btnVaciar = new JButton("vaciar");
		btnVaciar.setBounds(270, 579, 89, 23);
		frmNuevosCursos.getContentPane().add(btnVaciar);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Inicio:");
		lblNewLabel_1.setBounds(37, 430, 124, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Precio Precolegiado:");
		lblNewLabel_3.setBounds(285, 430, 124, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_3);
		
		precioPrecolegiado = new JTextField();
		precioPrecolegiado.setBounds(437, 427, 86, 20);
		frmNuevosCursos.getContentPane().add(precioPrecolegiado);
		precioPrecolegiado.setColumns(10);
		
		textoInstalacion = new JTextField();
		textoInstalacion.setBounds(162, 519, 215, 19);
		frmNuevosCursos.getContentPane().add(textoInstalacion);
		textoInstalacion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Instalacion");
		lblNewLabel_4.setBounds(37, 521, 124, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_4);
		
		comboBoxProfesores = new JComboBox();
		comboBoxProfesores.setToolTipText("Seleccionar Profesor");
		comboBoxProfesores.setBounds(703, 470, 150, 21);
		frmNuevosCursos.getContentPane().add(comboBoxProfesores);
		
		lblNewLabel_6 = new JLabel("Seleccionar Profesor:");
		lblNewLabel_6.setBounds(569, 473, 124, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Precio Estudiante:");
		lblNewLabel_7.setBounds(285, 474, 124, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_7);
		
		precioestudiante = new JTextField();
		precioestudiante.setBounds(437, 471, 86, 19);
		frmNuevosCursos.getContentPane().add(precioestudiante);
		precioestudiante.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Precio Empresa: ");
		lblNewLabel_8.setBounds(569, 386, 124, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_8);
		
		precioEmpresa = new JTextField();
		precioEmpresa.setBounds(703, 384, 86, 20);
		frmNuevosCursos.getContentPane().add(precioEmpresa);
		precioEmpresa.setColumns(10);
		
		precioExterno = new JTextField();
		precioExterno.setBounds(703, 428, 86, 20);
		frmNuevosCursos.getContentPane().add(precioExterno);
		precioExterno.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Precio externo: ");
		lblNewLabel_9.setBounds(569, 431, 124, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_9);


	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frmNuevosCursos; }

	public JTable getTablaCursos() { return this.tabCurso; }
	

	public JTextField getNombreCurso() {return this.nombreCurso;}
	public JTextField getPrecioColegiado() {return this.precioColegiado;}
	public JTextField getprecioPrecolegiado() {return this.precioPrecolegiado;}	
	public JTextField getprecioEstudiante() {return this.precioestudiante;}	
	public JTextField getprecioEmpresa() {return this.precioEmpresa;}	
	public JTextField getprecioExterno() {return this.precioExterno;}	
	public JTextField getInstalacion() {return this.textoInstalacion;}
	
	public JTextField getFechaInicio() {return this.campoInicio;}
	public JTextField getFechaFin() {return this.campoFin;}
	public JButton getRellenarDatos() { return this.btnRellenarDatos;}
	public JButton getBtnActualizarCurso() {return this.btnGuardarCambios;}
	public JButton getActualizarLista() { return this.btnActualizarLista;}
	public JButton getVaciar() { return this.btnVaciar;}
	public JComboBox getProfesoresCombo() {return this.comboBoxProfesores; }
	
}

