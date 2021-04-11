package giis.demo.util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import giis.demo.AsignacionInformes.AsignacionInformesController;
import giis.demo.AsignacionInformes.AsignacionInformesModel;
import giis.demo.AsignacionInformes.AsignacionInformesView;
import giis.demo.EnvioCol.EnvioColController;
import giis.demo.EnvioCol.EnvioColModel;
import giis.demo.EnvioCol.EnvioColView;
import giis.demo.consultaInscritos.ConsultaInscritosController;
import giis.demo.consultaInscritos.ConsultaInscritosModel;
import giis.demo.consultaInscritos.ConsultaInscritosView;
import giis.demo.cursos.CursoController;
import giis.demo.cursos.CursoModel;
import giis.demo.cursos.CursoView;
import giis.demo.cursosAnio.ListaCursosAnioController;
import giis.demo.cursosAnio.ListaCursosAnioModel;
import giis.demo.cursosAnio.ListaCursosAnioView;
import giis.demo.inscripciones.InscripcionesController;
import giis.demo.inscripciones.InscripcionesModel;
import giis.demo.inscripciones.InscripcionesView;
import giis.demo.inscripciones.JustificanteView;
import giis.demo.inscripcionesListaPeritos.inscripcionesListaPeritosController;
import giis.demo.inscripcionesListaPeritos.inscripcionesListaPeritosModel;
import giis.demo.inscripcionesListaPeritos.inscripcionesListaPeritosView;
import giis.demo.inscripcionesListaPeritos.justificanteAltaView;
import giis.demo.nuevosCursos.NuevosCursoController;
import giis.demo.nuevosCursos.NuevosCursoModel;
import giis.demo.nuevosCursos.NuevosCursoView;
import giis.demo.solicitud.JustificanteSolicitudCol;
import giis.demo.solicitud.JustificanteSolicitudPre;
import giis.demo.solicitud.SolicitudColController;
import giis.demo.solicitud.SolicitudColModel;
import giis.demo.solicitud.SolicitudColView;
import giis.demo.solicitud.SolicitudPreView;
import giis.demo.solicitud.Solicitudes;


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


		frame.setBounds(0, 0, 287, 286);


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

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
		
		JButton btnNewButton = new JButton("Realizar Solicitud Fonseca 1 y 3");
		btnNewButton.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				
				SolicitudColController controller3= new SolicitudColController(new SolicitudColModel()
						, new SolicitudColView(), new JustificanteSolicitudCol(), new SolicitudPreView(), new JustificanteSolicitudPre(), new Solicitudes());
				controller3.intiController();			
			
			}
		});
		
		frame.getContentPane().add(btnNewButton);

		JButton btnInscripcionesCursos = new JButton("Inscripciones Cursos Maria 1 y 3");
		frame.getContentPane().add(btnInscripcionesCursos);

		
		btnInscripcionesCursos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				InscripcionesController controller2= new InscripcionesController(new InscripcionesModel()
						, new InscripcionesView(), new JustificanteView());
				controller2.initController();			
			}
		});
	

		JButton btnEjecutarCambiosCursos = new JButton("Modificar Cursos Miguel 1");
		btnEjecutarCambiosCursos.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				CursoController controller1 = new CursoController(new CursoModel(), new CursoView());
				controller1.initController();
				System.out.println("Se pulso carga de curso");

			}
		});
		frame.getContentPane().add(btnEjecutarCambiosCursos);
		
		JButton btnCursosAnio = new JButton("Listado Curso Año Maria 2");
		btnCursosAnio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaCursosAnioController controllerC= new ListaCursosAnioController(new ListaCursosAnioModel()
						, new ListaCursosAnioView());
				controllerC.initController();
			}
		});
		frame.getContentPane().add(btnCursosAnio);
		
		
		JButton btnConsultaInscritos = new JButton("Consultar Inscritos Fonseca 2");
		btnConsultaInscritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaInscritosController controllerinscritos= new ConsultaInscritosController(new ConsultaInscritosModel()
						, new ConsultaInscritosView());
				controllerinscritos.initController();
			}
		});
		
		frame.getContentPane().add(btnConsultaInscritos);
		
		JButton btnAsignarInformesPeritos = new JButton("Asignar Informes Peritos Miguel 2");
		btnAsignarInformesPeritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsignacionInformesController aico = new AsignacionInformesController(new AsignacionInformesModel(),new AsignacionInformesView());
				aico.initController();
			}
		});
		
		frame.getContentPane().add(btnAsignarInformesPeritos);
		
		JButton btnNuevosCursos = new JButton("Nuevos Cursos Miguel 3");
		btnNuevosCursos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevosCursoController ncc = new NuevosCursoController(new NuevosCursoModel(), new NuevosCursoView());
				ncc.initController();
			}
		});
		frame.getContentPane().add(btnNuevosCursos);
		

		JButton bEnviarCol = new JButton("Enviar Lote Colegiados Fonseca 4");
		bEnviarCol.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EnvioColController ecc = new EnvioColController(new EnvioColModel(), new EnvioColView());
				ecc.initController();
			}
		});
		frame.getContentPane().add(bEnviarCol);

		JButton btnInscripcionesListaPeritos = new JButton("Inscripciones Lista Peritos Maria 3");
		btnInscripcionesListaPeritos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inscripcionesListaPeritosController inscripcionesPeritosC= 
          new inscripcionesListaPeritosController(new inscripcionesListaPeritosModel(), new inscripcionesListaPeritosView(), new justificanteAltaView());
				inscripcionesPeritosC.initController();
			}
		});
		frame.getContentPane().add(btnInscripcionesListaPeritos);

		

	}

	public JFrame getFrame() {
		return this.frame;
	}

}

