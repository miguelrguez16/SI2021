package giis.demo.solicitud;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import java.awt.Font;

public class SolicitudColView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7758216415701614225L;
	private JFrame frmSolicitud;
	private static JTextField tfNombre;
	private static JTextField tfApellidos;
	private static JTextField tfDireccion;
	private static JTextField tfPoblacion;
	private static JTextField tfTelefono;
	private JLabel lblNewLabel_5;
	private static JTextField tfTitulacion;
	private JLabel lblNewLabel_6;
	private static JTextField tfCentro;
	private JLabel lblNewLabel_7;
	private static JTextField tfYear;
	private JLabel lblNewLabel_8;
	private static JTextField tfCuenta;
	private JLabel lblNewLabel_9;
	private static JTextField tfDNI;
	private JButton bEnviar;
	private JButton bPrueba;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	
	/**
	 * Create the application.
	 */
	public SolicitudColView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSolicitud = new JFrame();
		frmSolicitud.setMinimumSize(new Dimension(630, 385));
		frmSolicitud.setTitle("Solicitud Colegiado");
		frmSolicitud.getContentPane().setLayout(null);
		frmSolicitud.setLocationRelativeTo(null);

		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 125, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(87, 122, 151, 20);
		frmSolicitud.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setBounds(248, 128, 65, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_1);
		
		tfApellidos = new JTextField();
		tfApellidos.setBounds(313, 122, 216, 20);
		frmSolicitud.getContentPane().add(tfApellidos);
		tfApellidos.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dirección");
		lblNewLabel_2.setBounds(10, 156, 67, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_2);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(87, 150, 442, 20);
		frmSolicitud.getContentPane().add(tfDireccion);
		tfDireccion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Población");
		lblNewLabel_3.setBounds(10, 181, 63, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_3);
		
		tfPoblacion = new JTextField();
		tfPoblacion.setBounds(87, 178, 185, 20);
		frmSolicitud.getContentPane().add(tfPoblacion);
		tfPoblacion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Teléfono");
		lblNewLabel_4.setBounds(282, 181, 65, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_4);
		
		tfTelefono = new JTextField();
		tfTelefono.setBounds(347, 178, 182, 20);
		frmSolicitud.getContentPane().add(tfTelefono);
		tfTelefono.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Titulación");
		lblNewLabel_5.setBounds(10, 218, 67, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_5);
		
		tfTitulacion = new JTextField();
		tfTitulacion.setBounds(87, 212, 442, 20);
		frmSolicitud.getContentPane().add(tfTitulacion);
		tfTitulacion.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Centro");
		lblNewLabel_6.setBounds(10, 256, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_6);
		
		tfCentro = new JTextField();
		tfCentro.setBounds(87, 253, 180, 20);
		frmSolicitud.getContentPane().add(tfCentro);
		tfCentro.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Año Titulación");
		lblNewLabel_7.setBounds(282, 256, 88, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_7);
		
		tfYear = new JTextField();
		tfYear.setBounds(381, 253, 148, 20);
		frmSolicitud.getContentPane().add(tfYear);
		tfYear.setColumns(10);
		
		lblNewLabel_8 = new JLabel("IBAN");
		lblNewLabel_8.setBounds(10, 281, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_8);
		
		tfCuenta = new JTextField();
		tfCuenta.setBounds(87, 278, 442, 20);
		frmSolicitud.getContentPane().add(tfCuenta);
		tfCuenta.setColumns(10);
		
		
		lblNewLabel_9 = new JLabel("DNI");
		lblNewLabel_9.setBounds(10, 97, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_9);
		
		tfDNI = new JTextField();
		tfDNI.setBounds(87, 94, 122, 20);
		frmSolicitud.getContentPane().add(tfDNI);
		tfDNI.setColumns(10);
		
		bEnviar = new JButton("Enviar solicitud");
		bEnviar.setBounds(459, 304, 137, 23);
		frmSolicitud.getContentPane().add(bEnviar);
		
		bPrueba = new JButton("Prueba");
		bPrueba.setBounds(360, 304, 89, 23);
		frmSolicitud.getContentPane().add(bPrueba);
		
		lblNewLabel_10 = new JLabel("Proceso de solicitud de Colegiación");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_10.setBounds(156, 11, 313, 23);
		frmSolicitud.getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Rellene los siguientes campos con sus datos personales");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(10, 59, 406, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_11);
	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frmSolicitud; }
	public static String getDNI()  { return tfDNI.getText(); }
	public static String getNombre()  { return tfNombre.getText(); }
	public static String getApellidos()  { return tfApellidos.getText(); }
	public static String getDireccion()  { return tfDireccion.getText(); }
	public static String getPoblacion()  { return tfPoblacion.getText(); }
	public static String getTelefono()  { return tfTelefono.getText(); }
	public static String getTitulacion()  { return tfTitulacion.getText(); }
	public static String getCentro()  { return tfCentro.getText(); }
	public static String getYear()  { return tfYear.getText(); }
	public static String getCuenta()  { return tfCuenta.getText(); }
	public JButton getBtnEnviar() { return this.bEnviar; }
	public JButton getBtnPrueba() { return this.bPrueba; }

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public static void setTfNombre(JTextField tfNombre) {
		SolicitudColView.tfNombre = tfNombre;
	}

	public JTextField getTfApellidos() {
		return tfApellidos;
	}

	public static void setTfApellidos(JTextField tfApellidos) {
		SolicitudColView.tfApellidos = tfApellidos;
	}

	public JTextField getTfDireccion() {
		return tfDireccion;
	}

	public static void setTfDireccion(JTextField tfDireccion) {
		SolicitudColView.tfDireccion = tfDireccion;
	}

	public JTextField getTfPoblacion() {
		return tfPoblacion;
	}

	public static void setTfPoblacion(JTextField tfPoblacion) {
		SolicitudColView.tfPoblacion = tfPoblacion;
	}

	public JTextField getTfTelefono() {
		return tfTelefono;
	}

	public static void setTfTelefono(JTextField tfTelefono) {
		SolicitudColView.tfTelefono = tfTelefono;
	}

	public JTextField getTfTitulacion() {
		return tfTitulacion;
	}

	public static void setTfTitulacion(JTextField tfTitulacion) {
		SolicitudColView.tfTitulacion = tfTitulacion;
	}

	public JTextField getTfCentro() {
		return tfCentro;
	}

	public static void setTfCentro(JTextField tfCentro) {
		SolicitudColView.tfCentro = tfCentro;
	}

	public JTextField getTfYear() {
		return tfYear;
	}

	public static void setTfYear(JTextField tfYear) {
		SolicitudColView.tfYear = tfYear;
	}

	public JTextField getTfCuenta() {
		return tfCuenta;
	}

	public static void setTfCuenta(JTextField tfCuenta) {
		SolicitudColView.tfCuenta = tfCuenta;
	}

	public JTextField getTfDNI() {
		return tfDNI;
	}

	public static void setTfDNI(JTextField tfDNI) {
		SolicitudColView.tfDNI = tfDNI;
	}
	

}

