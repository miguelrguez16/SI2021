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
	private JTextField nombreProfesor;
	private JTextField nombreInstalacion;
	private JTextField numeroSesiones;
	private JTextField precioColegiado;
	private JTextField precioPrecolegiado;
	private JTextField precioColectivo;
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
		frmNuevosCursos.setTitle("Nuevos Cursos");
		frmNuevosCursos.setName("Nuevos Cursos");

		frmNuevosCursos.setBounds(0, 0, 804, 698);

		frmNuevosCursos.getContentPane().setLayout(null);
		frmNuevosCursos.setLocationRelativeTo(null);

		
		lblLbltable = new JLabel("Lista de cursos añadidos este año");

		lblLbltable.setBounds(130, 299, 234, 14);

		frmNuevosCursos.getContentPane().add(lblLbltable);
		
		//Incluyo la tabla en un JScrollPane y anado este en vez de la tabla para poder ver los headers de la tabla
		tabCurso = new JTable();
		tabCurso.setName("tabCarreras");
		tabCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabCurso.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablePanel = new JScrollPane(tabCurso);

		tablePanel.setBounds(31, 355, 725, 291);

		frmNuevosCursos.getContentPane().add(tablePanel);
	
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setBounds(508, 70, 141, 31);
		frmNuevosCursos.getContentPane().add(btnGuardarCambios);

		
		campoInicio = new JTextField();

		campoInicio.setBounds(130, 138, 77, 20);
		frmNuevosCursos.getContentPane().add(campoInicio);
		campoInicio.setColumns(10);
		
		campoFin = new JTextField();
		campoFin.setBounds(387, 138, 86, 20);
		frmNuevosCursos.getContentPane().add(campoFin);
		campoFin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de inicio:");
		lblNewLabel_1.setBounds(10, 141, 101, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de fin:");
		lblNewLabel_2.setBounds(232, 141, 101, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_2);
		
		btnRellenarDatos = new JButton("pruebas");
		btnRellenarDatos.setBounds(538, 137, 89, 23);
		frmNuevosCursos.getContentPane().add(btnRellenarDatos);
		
		nombreCurso = new JTextField();
		nombreCurso.setBounds(130, 38, 77, 20);
		frmNuevosCursos.getContentPane().add(nombreCurso);
		nombreCurso.setColumns(10);
		
		nombreProfesor = new JTextField();
		nombreProfesor.setBounds(387, 38, 86, 20);
		frmNuevosCursos.getContentPane().add(nombreProfesor);
		nombreProfesor.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre del Curso:");
		lblNewLabel.setBounds(10, 41, 116, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel);
		
		JLabel lblNombreDelProfesor = new JLabel("Nombre del Profesor:");
		lblNombreDelProfesor.setBounds(232, 41, 123, 14);
		frmNuevosCursos.getContentPane().add(lblNombreDelProfesor);
		
		nombreInstalacion = new JTextField();
		nombreInstalacion.setBounds(130, 87, 77, 20);
		frmNuevosCursos.getContentPane().add(nombreInstalacion);
		nombreInstalacion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Instalación:");
		lblNewLabel_3.setBounds(10, 90, 101, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("N.º  de sesiones:");
		lblNewLabel_4.setBounds(232, 90, 101, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_4);
		
		numeroSesiones = new JTextField();
		numeroSesiones.setBounds(387, 81, 86, 20);
		frmNuevosCursos.getContentPane().add(numeroSesiones);
		numeroSesiones.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Precio Colegiado:");
		lblNewLabel_5.setBounds(10, 192, 116, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Precio Precolegiado:");
		lblNewLabel_6.setBounds(232, 192, 132, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Precio Colectivo:");
		lblNewLabel_7.setBounds(10, 244, 101, 14);
		frmNuevosCursos.getContentPane().add(lblNewLabel_7);
		
		precioColegiado = new JTextField();
		precioColegiado.setBounds(136, 189, 71, 20);
		frmNuevosCursos.getContentPane().add(precioColegiado);
		precioColegiado.setColumns(10);
		
		precioPrecolegiado = new JTextField();
		precioPrecolegiado.setBounds(387, 189, 86, 20);
		frmNuevosCursos.getContentPane().add(precioPrecolegiado);
		precioPrecolegiado.setColumns(10);
		
		precioColectivo = new JTextField();
		precioColectivo.setBounds(136, 241, 71, 20);
		frmNuevosCursos.getContentPane().add(precioColectivo);
		precioColectivo.setColumns(10);
		
		btnActualizarLista = new JButton("Actuallizar lista");
		btnActualizarLista.setBounds(443, 295, 132, 23);
		frmNuevosCursos.getContentPane().add(btnActualizarLista);
		
		btnVaciar = new JButton("vaciar");
		btnVaciar.setBounds(538, 188, 89, 23);
		frmNuevosCursos.getContentPane().add(btnVaciar);

	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frmNuevosCursos; }

	public JTable getTablaCursos() { return this.tabCurso; }
	

	public JTextField getNombreCurso() {return this.nombreCurso;}
	public JTextField getNombreProfesor() {return this.nombreProfesor;}
	public JTextField getInstalacion() {return this.nombreInstalacion;}
	public JTextField getNumeroSesiones() {return this.numeroSesiones;}
	public JTextField getPrecioColegiado() {return this.precioColegiado;}
	public JTextField getPrecioPrecolegiado() {return this.precioPrecolegiado;}
	public JTextField getPrecioColectivo() {return this.precioColectivo;}
	public JTextField getFechaInicio() {return this.campoInicio;}
	public JTextField getFechaFin() {return this.campoFin;}
	
	
	
	public JButton getRellenarDatos() { return this.btnRellenarDatos;}
	public JButton getBtnActualizarCurso() {return this.btnGuardarCambios;}
	public JButton getActualizarLista() { return this.btnActualizarLista;}
	public JButton getVaciar() { return this.btnVaciar;}

	
}

