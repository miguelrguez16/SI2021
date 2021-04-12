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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


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


		frame.setBounds(0, 0, 600, 350);


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		btnInicializarBaseDeDatos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInicializarBaseDeDatos.setBounds(10, 90, 264, 20);
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db = new Database();
				db.createDatabase(false);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnInicializarBaseDeDatos);

		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		btnCargarDatosIniciales.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCargarDatosIniciales.setBounds(10, 120, 264, 20);
		btnCargarDatosIniciales.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db = new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		frame.getContentPane().add(btnCargarDatosIniciales);
		
		JButton btnNewButton = new JButton("Solicitud para pre/colegiarse");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(310, 90, 264, 20);
		btnNewButton.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				
				SolicitudColController controller3= new SolicitudColController(new SolicitudColModel()
						, new SolicitudColView(), new JustificanteSolicitudCol(), new SolicitudPreView(), new JustificanteSolicitudPre(), new Solicitudes());
				controller3.intiController();			
			
			}
		});
		
		frame.getContentPane().add(btnNewButton);

		JButton btnInscripcionesCursos = new JButton("Inscripción a Cursos");
		btnInscripcionesCursos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInscripcionesCursos.setBounds(310, 150, 264, 20);
		frame.getContentPane().add(btnInscripcionesCursos);

		
		btnInscripcionesCursos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				InscripcionesController controller2= new InscripcionesController(new InscripcionesModel()
						, new InscripcionesView(), new JustificanteView());
				controller2.initController();			
			}
		});
	

		JButton btnEjecutarCambiosCursos = new JButton("Modificar Cursos");
		btnEjecutarCambiosCursos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEjecutarCambiosCursos.setBounds(10, 210, 264, 20);
		btnEjecutarCambiosCursos.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				CursoController controller1 = new CursoController(new CursoModel(), new CursoView());
				controller1.initController();
				System.out.println("Se pulso carga de curso");

			}
		});
		frame.getContentPane().add(btnEjecutarCambiosCursos);
		
		JButton btnCursosAnio = new JButton("Lista de Curso este Año");
		btnCursosAnio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCursosAnio.setBounds(10, 240, 264, 20);
		btnCursosAnio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaCursosAnioController controllerC= new ListaCursosAnioController(new ListaCursosAnioModel()
						, new ListaCursosAnioView());
				controllerC.initController();
			}
		});
		frame.getContentPane().add(btnCursosAnio);
		
		
		JButton btnConsultaInscritos = new JButton("Consultar Inscritos a Cursos");
		btnConsultaInscritos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultaInscritos.setBounds(10, 270, 264, 20);
		btnConsultaInscritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaInscritosController controllerinscritos= new ConsultaInscritosController(new ConsultaInscritosModel()
						, new ConsultaInscritosView());
				controllerinscritos.initController();
			}
		});
		
		frame.getContentPane().add(btnConsultaInscritos);
		
		JButton btnAsignarInformesPeritos = new JButton("Asignar Informes a Peritos");
		btnAsignarInformesPeritos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAsignarInformesPeritos.setBounds(310, 240, 264, 20);
		btnAsignarInformesPeritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsignacionInformesController aico = new AsignacionInformesController(new AsignacionInformesModel(),new AsignacionInformesView());
				aico.initController();
			}
		});
		
		frame.getContentPane().add(btnAsignarInformesPeritos);
		
		JButton btnNuevosCursos = new JButton("Planificar Nuevos Cursos");
		btnNuevosCursos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevosCursos.setBounds(10, 180, 264, 20);
		btnNuevosCursos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevosCursoController ncc = new NuevosCursoController(new NuevosCursoModel(), new NuevosCursoView());
				ncc.initController();
			}
		});
		frame.getContentPane().add(btnNuevosCursos);
		

		JButton bEnviarCol = new JButton("Enviar Lote de Colegiados ");
		bEnviarCol.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bEnviarCol.setBounds(310, 270, 264, 20);
		bEnviarCol.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EnvioColController ecc = new EnvioColController(new EnvioColModel(), new EnvioColView());
				ecc.initController();
			}
		});
		frame.getContentPane().add(bEnviarCol);

		JButton btnInscripcionesListaPeritos = new JButton("Inscripción a la Lista de Peritos");
		btnInscripcionesListaPeritos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInscripcionesListaPeritos.setBounds(310, 120, 264, 20);
		btnInscripcionesListaPeritos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inscripcionesListaPeritosController inscripcionesPeritosC= 
          new inscripcionesListaPeritosController(new inscripcionesListaPeritosModel(), new inscripcionesListaPeritosView(), new justificanteAltaView());
				inscripcionesPeritosC.initController();
			}
		});
		frame.getContentPane().add(btnInscripcionesListaPeritos);
		
		JLabel lblNewLabel = new JLabel("COOIPA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 11, 564, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cursos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 150, 264, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Base de datos");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 60, 264, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Informes");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(310, 210, 250, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Solicitudes/Inscripciones");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(310, 60, 264, 20);
		frame.getContentPane().add(lblNewLabel_5);

		

	}

	public JFrame getFrame() {
		return this.frame;
	}
}

