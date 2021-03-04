package AsignacionInformes;

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
import javax.swing.SwingConstants;




public class AsignacionInformesView extends JFrame {



	private static final long serialVersionUID = 59272130249980170L;

	private JFrame frame;
	private JTable tabCurso;
	private JTextField NombreCursoSeleccionado;
	private JTextField IdCursoSeleccionado;
	private JTextField campoInicioInscripcion;
	private JTextField campoFinIscripcion;
	private JLabel lblListaInformesPendientes;
	private JLabel lblNewLabel;
	private JButton btnGuardarCambios;

	private JTextField plazasCurso;
	private JButton btnRellenarDatos;


	/**
	 * Create the application.
	 */
	public AsignacionInformesView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cursos Pendientes");
		frame.setName("Cursos Pendientes");

		frame.setBounds(0, 0, 405, 601);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);

		
		lblListaInformesPendientes = new JLabel("Informes Pendientes");
		lblListaInformesPendientes.setHorizontalAlignment(SwingConstants.CENTER);

		lblListaInformesPendientes.setBounds(10, 11, 183, 14);

		frame.getContentPane().add(lblListaInformesPendientes);
		
		//Incluyo la tabla en un JScrollPane y anado este en vez de la tabla para poder ver los headers de la tabla
		tabCurso = new JTable();
		tabCurso.setName("tabCarreras");
		tabCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabCurso.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablePanel = new JScrollPane(tabCurso);

		tablePanel.setBounds(7, 41, 186, 291);

		frame.getContentPane().add(tablePanel);
		
		lblNewLabel = new JLabel("Curso Seleccionado");

		lblNewLabel.setBounds(7, 339, 125, 14);

		frame.getContentPane().add(lblNewLabel);
		
		NombreCursoSeleccionado = new JTextField();
		NombreCursoSeleccionado.setEditable(false);

		NombreCursoSeleccionado.setBounds(142, 336, 75, 20);

		frame.getContentPane().add(NombreCursoSeleccionado);
		NombreCursoSeleccionado.setColumns(10);
		
		IdCursoSeleccionado = new JTextField();
		IdCursoSeleccionado.setEditable(false);

		IdCursoSeleccionado.setBounds(227, 336, 46, 20);

		frame.getContentPane().add(IdCursoSeleccionado);
		IdCursoSeleccionado.setColumns(10);
	
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setBounds(184, 520, 141, 31);
		frame.getContentPane().add(btnGuardarCambios);

		
		campoInicioInscripcion = new JTextField();

		campoInicioInscripcion.setBounds(77, 411, 103, 20);
		frame.getContentPane().add(campoInicioInscripcion);
		campoInicioInscripcion.setColumns(10);
		
		campoFinIscripcion = new JTextField();
		campoFinIscripcion.setBounds(77, 456, 103, 20);
		frame.getContentPane().add(campoFinIscripcion);
		campoFinIscripcion.setColumns(10);
		
		JLabel lblFechaParaInscripciones = new JLabel("Fecha para Inscripciones");
		lblFechaParaInscripciones.setBounds(27, 387, 170, 14);
		frame.getContentPane().add(lblFechaParaInscripciones);
		
		JLabel lblNewLabel_1 = new JLabel("Inicio:");
		lblNewLabel_1.setBounds(27, 414, 34, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fin:");
		lblNewLabel_2.setBounds(27, 459, 26, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nº de plazas:");
		lblNewLabel_3.setBounds(252, 387, 75, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		plazasCurso = new JTextField();
		plazasCurso.setBounds(234, 432, 103, 20);
		frame.getContentPane().add(plazasCurso);
		plazasCurso.setColumns(10);
		
		btnRellenarDatos = new JButton("pruebas");
		btnRellenarDatos.setBounds(27, 524, 89, 23);
		frame.getContentPane().add(btnRellenarDatos);
		
		JScrollPane tablePanelInformes = new JScrollPane((Component) null);
		tablePanelInformes.setBounds(195, 41, 186, 291);
		frame.getContentPane().add(tablePanelInformes);
		
		JLabel lblListaPeritos = new JLabel("Peritos");
		lblListaPeritos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaPeritos.setBounds(203, 11, 183, 14);
		frame.getContentPane().add(lblListaPeritos);

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


	
	public JTextField getPlazasCurso() {return this.plazasCurso;}
	
	public JButton getRellenarDatos() { return this.btnRellenarDatos;}
}

