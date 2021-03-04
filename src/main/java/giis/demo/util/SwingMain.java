package giis.demo.util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import giis.demo.cursos.CursoController;
import giis.demo.cursos.CursoModel;
import giis.demo.cursos.CursoView;
//<<<<<<< HEAD
import giis.demo.inscripciones.InscripcionesController;
import giis.demo.inscripciones.InscripcionesModel;
import giis.demo.inscripciones.InscripcionesView;
import giis.demo.inscripciones.JustificanteView;
//=======
import giis.demo.solicitud.JustificanteSolicitud;
import giis.demo.solicitud.SolicitudController;
import giis.demo.solicitud.SolicitudModel;
import giis.demo.solicitud.SolicitudView;
//>>>>>>> refs/heads/master
import giis.demo.tkrun.*;

/**
 * Punto de entrada principal que incluye botones para la ejecucion de las
 * pantallas de las aplicaciones de ejemplo y acciones de inicializacion de la
 * base de datos. No sigue MVC pues es solamente temporal para que durante el
 * desarrollo se tenga posibilidad de realizar acciones de inicializacion
 */
public class SwingMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // NOSONAR codigo autogenerado
			public void run() {
				try {
					SwingMain window = new SwingMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); // NOSONAR codigo autogenerado
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingMain() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Main");

		frame.setBounds(0, 0, 287, 231);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnEjecutarTkrun = new JButton("Ejecutar Carreras");
		btnEjecutarTkrun.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				CarrerasController controller = new CarrerasController(new CarrerasModel(), new CarrerasView());
				controller.initController();
				System.out.println("Se pulso carga de carreras");

				// Habria que cambiar CursoController =controllerCur = .....
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarTkrun);

		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db = new Database();
				db.createDatabase(false);
			}
		});
		frame.getContentPane().add(btnInicializarBaseDeDatos);

		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		btnCargarDatosIniciales.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db = new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		frame.getContentPane().add(btnCargarDatosIniciales);
		
		JButton btnNewButton = new JButton("Realizar Solicitud Fonseca");
		btnNewButton.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				SolicitudController controller3= new SolicitudController(new SolicitudModel()
						, new SolicitudView(), new JustificanteSolicitud());
				controller3.intiController();
				Database db=new Database();
				db.createDatabase(false);
				db.loadDatabase();			
			
			}
		});
		
		
		
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Inscripciones Maria Cursos");
		frame.getContentPane().add(btnNewButton_2);

		
		btnNewButton_2.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				InscripcionesController controller2= new InscripcionesController(new InscripcionesModel()
						, new InscripcionesView(), new JustificanteView());
				controller2.initController();
				Database db=new Database();
				db.createDatabase(false);
				db.loadDatabase();			
			
			}
		});
	

		JButton btnEjecutarCambiosCursos = new JButton("Modificar Miguel Cursos");
		btnEjecutarCambiosCursos.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				CursoController controller1 = new CursoController(new CursoModel(), new CursoView());
				controller1.initController();
				System.out.println("Se pulso carga de curso");

			}
		});
		frame.getContentPane().add(btnEjecutarCambiosCursos);

	}

	public JFrame getFrame() {
		return this.frame;
	}

}

