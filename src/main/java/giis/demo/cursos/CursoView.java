package giis.demo.cursos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;



public class CursoView extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 59272130249980170L;
	/**
	 * 
	 */
	private JFrame frame;
	private JTable tabCurso;
	private JTextField NombreCursoSeleccionado;
	private JTextField IdCursoSeleccionado;
	private JTextField campoInicioInscripcion;
	private JTextField campoFinIscripcion;
	private JLabel lblLbltable;
	private JLabel lblNewLabel;
	private JButton btnGuardarCambios;

	/**
	 * Create the application.
	 */
	public CursoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cursos Pendientes");
		frame.setName("Cursos Pendientes");
		frame.setBounds(0, 0, 463, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblLbltable = new JLabel("Lista de cursos pendientes");
		frame.getContentPane().add(lblLbltable);
		
		//Incluyo la tabla en un JScrollPane y anado este en vez de la tabla para poder ver los headers de la tabla
		tabCurso = new JTable();
		tabCurso.setName("tabCarreras");
		tabCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabCurso.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablePanel = new JScrollPane(tabCurso);
		frame.getContentPane().add(tablePanel);
		
		lblNewLabel = new JLabel("Curso Seleccionado");
		frame.getContentPane().add(lblNewLabel);
		
		NombreCursoSeleccionado = new JTextField();
		NombreCursoSeleccionado.setEditable(false);
		frame.getContentPane().add(NombreCursoSeleccionado);
		NombreCursoSeleccionado.setColumns(10);
		
		IdCursoSeleccionado = new JTextField();
		IdCursoSeleccionado.setEditable(false);
		frame.getContentPane().add(IdCursoSeleccionado);
		IdCursoSeleccionado.setColumns(10);
		
		JLabel lblFechaParaInscripciones = new JLabel("Fecha para Inscripciones");
		frame.getContentPane().add(lblFechaParaInscripciones);
		
		campoInicioInscripcion = new JTextField();
		frame.getContentPane().add(campoInicioInscripcion);
		campoInicioInscripcion.setColumns(10);
		
		campoFinIscripcion = new JTextField();
		frame.getContentPane().add(campoFinIscripcion);
		campoFinIscripcion.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Inicio:");
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fin:");
		frame.getContentPane().add(lblNewLabel_2);
		
		btnGuardarCambios = new JButton("Guardar Cambios");
		frame.getContentPane().add(btnGuardarCambios);
	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frame; }
	public JTextField getCursoNombre() {return this.NombreCursoSeleccionado;}
	public JTextField getIDNombre() {return this.IdCursoSeleccionado;}
	public JTextField getInicioInscripcion() {return this.campoInicioInscripcion;}
	public JTextField getFinInscripcion() {return this.campoFinIscripcion;}
	public JTable getTablaCursos() { return this.tabCurso; }
	public JButton getBtnActualizarCurso() {return this.btnGuardarCambios;}
	public void setNombreNoAplicable() {this.NombreCursoSeleccionado.setText("N/A");}
	public void setIdNoAplicable() { this.IdCursoSeleccionado.setText("N/A"); } 
	public void setNombre(String nombre) {this.NombreCursoSeleccionado.setText(nombre);}
	public void setID(String id) {this.IdCursoSeleccionado.setText(id);}


}

