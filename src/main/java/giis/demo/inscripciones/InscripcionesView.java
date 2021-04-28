package giis.demo.inscripciones;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;


public class InscripcionesView {

	private static final long serialVersionUID = 1476210718996663912L;
	private JFrame frame;
	private JTable table;
	private JButton bInscripcionColectivo;
	private JButton bInscripcionColegiado;
	private JButton bInscripcionPrecolegiado;
	private static JTextField TFnombre;
	private static JTextField TFapellidos;
	private JLabel lblNewLabel_7;
	private static JTextField TFdireccion;
	private static JTextField TFpoblacion;
	private static JTextField TFtelefono;
	private JTextField TFdniColegiado;
	private static JTextField TFdniColectivo;
	private JLabel lblNewLabel_5;
	private JRadioButton RBempresa;
	private JRadioButton RBestudiante;
	private JRadioButton RBexterno;
	private JTextField TFidPre;
	
	
	public InscripcionesView() {
		initialize();
	}

	private void initialize() {
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(0,0,660,603);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Inscripciones en cursos");
		frame.setName("Inscripciones en cursos");

		
		JLabel lblNewLabel = new JLabel("Lista de cursos con inscripción abierta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 46, 624, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane tablePanel = new JScrollPane((Component) null);
		tablePanel.setBounds(10, 83, 624, 100);
		frame.getContentPane().add(tablePanel);
		
		table = new JTable();
		tablePanel.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 410, 150, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		TFnombre = new JTextField();
		TFnombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFnombre.setBounds(170, 410, 150, 20);
		frame.getContentPane().add(TFnombre);
		TFnombre.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Apellidos :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 440, 150, 20);
		frame.getContentPane().add(lblNewLabel_6);
		
		TFapellidos = new JTextField();
		TFapellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFapellidos.setBounds(170, 440, 150, 20);
		frame.getContentPane().add(TFapellidos);
		TFapellidos.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Direccion :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 470, 150, 20);
		frame.getContentPane().add(lblNewLabel_7);
		
		TFdireccion = new JTextField();
		TFdireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFdireccion.setBounds(170, 470, 150, 20);
		frame.getContentPane().add(TFdireccion);
		TFdireccion.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Población :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 500, 150, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_8 = new JLabel("Teléfono :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(10, 530, 150, 20);
		frame.getContentPane().add(lblNewLabel_8);
		
		TFpoblacion = new JTextField();
		TFpoblacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFpoblacion.setBounds(170, 500, 150, 20);
		frame.getContentPane().add(TFpoblacion);
		TFpoblacion.setColumns(10);
		
		TFtelefono = new JTextField();
		TFtelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFtelefono.setBounds(170, 530, 150, 20);
		frame.getContentPane().add(TFtelefono);
		TFtelefono.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Inscripciones en cursos");
		lblNewLabel_9.setForeground(Color.BLACK);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9.setBounds(10, 10, 624, 25);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Inscribirse a un curso como Colegiado");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(10, 194, 624, 20);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Introduzca el idColegiado :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(10, 226, 200, 20);
		frame.getContentPane().add(lblNewLabel_11);
		
		TFdniColegiado = new JTextField();
		TFdniColegiado.setBounds(213, 226, 107, 20);
		frame.getContentPane().add(TFdniColegiado);
		TFdniColegiado.setColumns(10);
		
		bInscripcionColegiado = new JButton("Inscripción como colegiado");
		bInscripcionColegiado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bInscripcionColegiado.setBounds(393, 226, 241, 20);
		frame.getContentPane().add(bInscripcionColegiado);
		
		JLabel lblNewLabel_12 = new JLabel("Inscribirse a un curso como Colectivo");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(10, 322, 624, 20);
		frame.getContentPane().add(lblNewLabel_12);
		
		bInscripcionColectivo = new JButton("Inscripción como colectivo");
		bInscripcionColectivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bInscripcionColectivo.setBounds(393, 354, 241, 20);
		frame.getContentPane().add(bInscripcionColectivo);
		
		TFdniColectivo = new JTextField();
		TFdniColectivo.setBounds(213, 354, 107, 20);
		frame.getContentPane().add(TFdniColectivo);
		TFdniColectivo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Introduzca el DNI:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 354, 200, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo Colectivo: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(393, 410, 120, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Datos del nuevo colectivo a inscribir");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 386, 624, 20);
		frame.getContentPane().add(lblNewLabel_5);
		
		RBempresa = new JRadioButton("Empresa");
		RBempresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RBempresa.setBounds(393, 440, 109, 23);
		frame.getContentPane().add(RBempresa);
		
		RBestudiante = new JRadioButton("Estudiante");
		RBestudiante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RBestudiante.setBounds(393, 470, 109, 23);
		frame.getContentPane().add(RBestudiante);
		
		RBexterno = new JRadioButton("Externo");
		RBexterno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RBexterno.setBounds(393, 500, 109, 23);
		frame.getContentPane().add(RBexterno);
		
		ButtonGroup grupo=new ButtonGroup();
		grupo.add(RBexterno);
		grupo.add(RBestudiante);
		grupo.add(RBempresa);
		
		JLabel lblNewLabel_13 = new JLabel("Inscribirse a un curso como Precolegiado");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13.setBounds(10, 258, 624, 20);
		frame.getContentPane().add(lblNewLabel_13);
		
		TFidPre = new JTextField();
		TFidPre.setBounds(213, 290, 107, 20);
		frame.getContentPane().add(TFidPre);
		TFidPre.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Introduzca el idPreColegiado :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(10, 290, 200, 20);
		frame.getContentPane().add(lblNewLabel_14);
		
		bInscripcionPrecolegiado = new JButton("Inscripción como precolegiado");
		bInscripcionPrecolegiado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bInscripcionPrecolegiado.setBounds(393, 288, 241, 20);
		frame.getContentPane().add(bInscripcionPrecolegiado);
	}

	public JFrame getFrame() { return this.frame;}
	public JTable getTablaCursos() {return this.table;}

	public JTextField getTFnombre() {return TFnombre;}

	public JTextField getTFapellidos() {return TFapellidos;}
	public JTextField getTFdireccion() {return TFdireccion;}
	public JTextField getTFpoblacion() {return TFpoblacion;}
	public JTextField getTFtelefono() {return TFtelefono;}
	public JButton getbInscripcionColegiado() { return this.bInscripcionColegiado;}
	public JButton getbInscripcionPrecolegiado() { return this.bInscripcionPrecolegiado;}
	public JTextField getTFdniColegiado() {return TFdniColegiado;}
	public JTextField getTFdniColectivo() {return TFdniColectivo;}
	public JButton getbInscripcionColectivo() {return bInscripcionColectivo;}
	public JRadioButton getRBempresa() { return RBempresa;}
	public JRadioButton getRBestudiante() { return RBestudiante;}
	public JRadioButton getRBexterno() { return RBexterno;}
	public JTextField getTFidPre() {return TFidPre;}
	
	public static String getNombre() {return TFnombre.getText();}
	public static String getApellidos() { return TFapellidos.getText();}
	public static String getDireccion() { return TFdireccion.getText();}
	public static String getPoblacion() { return TFpoblacion.getText();}
	public static String getTelefono() { return TFtelefono.getText();}
	public static String getDni() { return TFdniColectivo.getText();}
}