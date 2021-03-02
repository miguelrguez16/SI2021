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

public class SolicitudView extends JFrame {

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
	
	/**
	 * Create the application.
	 */
	public SolicitudView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSolicitud = new JFrame();
		frmSolicitud.setMinimumSize(new Dimension(644, 407));
		frmSolicitud.setTitle("Solicitud");
		frmSolicitud.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 75, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(66, 72, 164, 20);
		frmSolicitud.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setBounds(240, 75, 65, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_1);
		
		tfApellidos = new JTextField();
		tfApellidos.setBounds(300, 72, 216, 20);
		frmSolicitud.getContentPane().add(tfApellidos);
		tfApellidos.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dirección");
		lblNewLabel_2.setBounds(10, 100, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_2);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(66, 97, 450, 20);
		frmSolicitud.getContentPane().add(tfDireccion);
		tfDireccion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Población");
		lblNewLabel_3.setBounds(10, 125, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_3);
		
		tfPoblacion = new JTextField();
		tfPoblacion.setBounds(66, 122, 189, 20);
		frmSolicitud.getContentPane().add(tfPoblacion);
		tfPoblacion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Teléfono");
		lblNewLabel_4.setBounds(276, 125, 65, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_4);
		
		tfTelefono = new JTextField();
		tfTelefono.setBounds(338, 122, 178, 20);
		frmSolicitud.getContentPane().add(tfTelefono);
		tfTelefono.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Titulación");
		lblNewLabel_5.setBounds(10, 167, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_5);
		
		tfTitulacion = new JTextField();
		tfTitulacion.setBounds(66, 164, 450, 20);
		frmSolicitud.getContentPane().add(tfTitulacion);
		tfTitulacion.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Centro");
		lblNewLabel_6.setBounds(10, 192, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_6);
		
		tfCentro = new JTextField();
		tfCentro.setBounds(66, 189, 201, 20);
		frmSolicitud.getContentPane().add(tfCentro);
		tfCentro.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Año Titulación");
		lblNewLabel_7.setBounds(289, 192, 88, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_7);
		
		tfYear = new JTextField();
		tfYear.setBounds(372, 189, 144, 20);
		frmSolicitud.getContentPane().add(tfYear);
		tfYear.setColumns(10);
		
		lblNewLabel_8 = new JLabel("IBAN");
		lblNewLabel_8.setBounds(10, 242, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_8);
		
		tfCuenta = new JTextField();
		tfCuenta.setBounds(66, 239, 450, 20);
		frmSolicitud.getContentPane().add(tfCuenta);
		tfCuenta.setColumns(10);
		
		
		lblNewLabel_9 = new JLabel("DNI");
		lblNewLabel_9.setBounds(10, 46, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_9);
		
		tfDNI = new JTextField();
		tfDNI.setBounds(66, 43, 122, 20);
		frmSolicitud.getContentPane().add(tfDNI);
		tfDNI.setColumns(10);
		
		bEnviar = new JButton("Enviar solicitud");
		bEnviar.setBounds(459, 304, 137, 23);
		frmSolicitud.getContentPane().add(bEnviar);
		
		bPrueba = new JButton("Prueba");
		bPrueba.setBounds(360, 304, 89, 23);
		frmSolicitud.getContentPane().add(bPrueba);
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
		SolicitudView.tfNombre = tfNombre;
	}

	public JTextField getTfApellidos() {
		return tfApellidos;
	}

	public static void setTfApellidos(JTextField tfApellidos) {
		SolicitudView.tfApellidos = tfApellidos;
	}

	public JTextField getTfDireccion() {
		return tfDireccion;
	}

	public static void setTfDireccion(JTextField tfDireccion) {
		SolicitudView.tfDireccion = tfDireccion;
	}

	public JTextField getTfPoblacion() {
		return tfPoblacion;
	}

	public static void setTfPoblacion(JTextField tfPoblacion) {
		SolicitudView.tfPoblacion = tfPoblacion;
	}

	public JTextField getTfTelefono() {
		return tfTelefono;
	}

	public static void setTfTelefono(JTextField tfTelefono) {
		SolicitudView.tfTelefono = tfTelefono;
	}

	public JTextField getTfTitulacion() {
		return tfTitulacion;
	}

	public static void setTfTitulacion(JTextField tfTitulacion) {
		SolicitudView.tfTitulacion = tfTitulacion;
	}

	public JTextField getTfCentro() {
		return tfCentro;
	}

	public static void setTfCentro(JTextField tfCentro) {
		SolicitudView.tfCentro = tfCentro;
	}

	public JTextField getTfYear() {
		return tfYear;
	}

	public static void setTfYear(JTextField tfYear) {
		SolicitudView.tfYear = tfYear;
	}

	public JTextField getTfCuenta() {
		return tfCuenta;
	}

	public static void setTfCuenta(JTextField tfCuenta) {
		SolicitudView.tfCuenta = tfCuenta;
	}

	public JTextField getTfDNI() {
		return tfDNI;
	}

	public static void setTfDNI(JTextField tfDNI) {
		SolicitudView.tfDNI = tfDNI;
	}
	

}

