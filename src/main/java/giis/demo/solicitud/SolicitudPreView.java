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

public class SolicitudPreView extends JFrame {

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
	private JLabel lblNewLabel_8;
	private static JTextField tfCuenta;
	private JLabel lblNewLabel_9;
	private static JTextField tfDNI;
	private JButton bEnviarPre;
	private JButton bPruebaPre;
	
	/**
	 * Create the application.
	 */
	public SolicitudPreView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSolicitud = new JFrame();
		frmSolicitud.setMinimumSize(new Dimension(630, 385));
		frmSolicitud.setTitle("Solicitud Precolegiado");
		frmSolicitud.getContentPane().setLayout(null);
		frmSolicitud.setLocationRelativeTo(null);

		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 129, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(87, 126, 151, 20);
		frmSolicitud.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setBounds(248, 129, 65, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_1);
		
		tfApellidos = new JTextField();
		tfApellidos.setBounds(313, 126, 216, 20);
		frmSolicitud.getContentPane().add(tfApellidos);
		tfApellidos.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dirección");
		lblNewLabel_2.setBounds(10, 165, 67, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_2);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(87, 159, 442, 20);
		frmSolicitud.getContentPane().add(tfDireccion);
		tfDireccion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Población");
		lblNewLabel_3.setBounds(10, 197, 63, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_3);
		
		tfPoblacion = new JTextField();
		tfPoblacion.setBounds(87, 191, 185, 20);
		frmSolicitud.getContentPane().add(tfPoblacion);
		tfPoblacion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Teléfono");
		lblNewLabel_4.setBounds(282, 197, 65, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_4);
		
		tfTelefono = new JTextField();
		tfTelefono.setBounds(347, 191, 182, 20);
		frmSolicitud.getContentPane().add(tfTelefono);
		tfTelefono.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Cursando");
		lblNewLabel_5.setBounds(10, 222, 67, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_5);
		
		tfTitulacion = new JTextField();
		tfTitulacion.setBounds(87, 216, 442, 20);
		frmSolicitud.getContentPane().add(tfTitulacion);
		tfTitulacion.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Centro");
		lblNewLabel_6.setBounds(10, 247, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_6);
		
		tfCentro = new JTextField();
		tfCentro.setBounds(87, 241, 180, 20);
		frmSolicitud.getContentPane().add(tfCentro);
		tfCentro.setColumns(10);
		
		lblNewLabel_8 = new JLabel("IBAN");
		lblNewLabel_8.setBounds(10, 272, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_8);
		
		tfCuenta = new JTextField();
		tfCuenta.setBounds(87, 269, 442, 20);
		frmSolicitud.getContentPane().add(tfCuenta);
		tfCuenta.setColumns(10);
		
		
		lblNewLabel_9 = new JLabel("DNI");
		lblNewLabel_9.setBounds(10, 104, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_9);
		
		tfDNI = new JTextField();
		tfDNI.setBounds(85, 95, 122, 20);
		frmSolicitud.getContentPane().add(tfDNI);
		tfDNI.setColumns(10);
		
		bEnviarPre = new JButton("Enviar solicitud");
		bEnviarPre.setBounds(459, 304, 137, 23);
		frmSolicitud.getContentPane().add(bEnviarPre);
		
		bPruebaPre = new JButton("Prueba");
		bPruebaPre.setBounds(360, 304, 89, 23);
		frmSolicitud.getContentPane().add(bPruebaPre);
		
		JLabel lblNewLabel_7 = new JLabel("Proceso de solicitud de Precolegiación");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7.setBounds(155, 11, 322, 20);
		frmSolicitud.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_10 = new JLabel("Rellena los siguientes campos con sus datos personales:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(10, 53, 401, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_10);
	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frmSolicitud; }
	public static String getDNIpre()  { return tfDNI.getText(); }
	public static String getNombrepre()  { return tfNombre.getText(); }
	public static String getApellidospre()  { return tfApellidos.getText(); }
	public static String getDireccionpre()  { return tfDireccion.getText(); }
	public static String getPoblacionpre()  { return tfPoblacion.getText(); }
	public static String getTelefonopre()  { return tfTelefono.getText(); }
	public static String getTitulacionpre()  { return tfTitulacion.getText(); }
	public static String getCentropre()  { return tfCentro.getText(); }
	public static String getCuentapre()  { return tfCuenta.getText(); }
	public JButton getBtnEnviarpre() { return this.bEnviarPre; }
	public JButton getBtnPruebapre() { return this.bPruebaPre; }

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public static void setTfNombre(JTextField tfNombre) {
		SolicitudPreView.tfNombre = tfNombre;
	}

	public JTextField getTfApellidos() {
		return tfApellidos;
	}

	public static void setTfApellidos(JTextField tfApellidos) {
		SolicitudPreView.tfApellidos = tfApellidos;
	}

	public JTextField getTfDireccion() {
		return tfDireccion;
	}

	public static void setTfDireccion(JTextField tfDireccion) {
		SolicitudPreView.tfDireccion = tfDireccion;
	}

	public JTextField getTfPoblacion() {
		return tfPoblacion;
	}

	public static void setTfPoblacion(JTextField tfPoblacion) {
		SolicitudPreView.tfPoblacion = tfPoblacion;
	}

	public JTextField getTfTelefono() {
		return tfTelefono;
	}

	public static void setTfTelefono(JTextField tfTelefono) {
		SolicitudPreView.tfTelefono = tfTelefono;
	}

	public JTextField getTfTitulacion() {
		return tfTitulacion;
	}

	public static void setTfTitulacion(JTextField tfTitulacion) {
		SolicitudPreView.tfTitulacion = tfTitulacion;
	}

	public JTextField getTfCentro() {
		return tfCentro;
	}

	public static void setTfCentro(JTextField tfCentro) {
		SolicitudPreView.tfCentro = tfCentro;
	}


	public JTextField getTfCuenta() {
		return tfCuenta;
	}

	public static void setTfCuenta(JTextField tfCuenta) {
		SolicitudPreView.tfCuenta = tfCuenta;
	}

	public JTextField getTfDNI() {
		return tfDNI;
	}

	public static void setTfDNI(JTextField tfDNI) {
		SolicitudPreView.tfDNI = tfDNI;
	}
}

