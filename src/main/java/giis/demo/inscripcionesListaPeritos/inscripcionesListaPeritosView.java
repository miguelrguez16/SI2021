package giis.demo.inscripcionesListaPeritos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JScrollPane;
import java.awt.Component;



public class inscripcionesListaPeritosView {

	
	private JFrame frame;
	private JTextField TFidColegiado;
	private JButton btnVerDatos;
	private JButton btnInscripcionPerito;
	private JButton btnReset;
	private static JTextField TFnombre;
	private static JTextField TFapellidos;
	private static JTextField TFdireccion;
	private static JTextField TFpoblacion;
	private static JTextField TFtelefono;
	private static JTextField TFdatos;
	private static JTextField TFfecha;
	private static JTextField TFtitulacion;
	private static JTextField TFcentro;
	private static JTextField TFanio;
	private static JTextField TFdni;
	private JLabel Lid;
	
	public inscripcionesListaPeritosView() {
		initialize();
	}

	private void initialize() {
		frame=new JFrame();
		frame.setBounds(0,0,550,369);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Inscripción a la Lista de Peritos");
		
		JLabel lblNewLabel = new JLabel("Inscripción en las listas de peritos privados del COIIPA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 514, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduzca el idColegiado :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 66, 180, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		TFidColegiado = new JTextField();
		TFidColegiado.setBounds(189, 66, 100, 20);
		frame.getContentPane().add(TFidColegiado);
		TFidColegiado.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Datos personales y de contacto del idColegiado");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 109, 340, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		btnVerDatos = new JButton("Visualizar datos del colegiado");
		btnVerDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerDatos.setBounds(312, 66, 212, 20);
		frame.getContentPane().add(btnVerDatos);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 140, 100, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Apellidos :");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(10, 170, 100, 20);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Direccion :");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(10, 200, 100, 20);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Población :");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2_1.setBounds(10, 230, 100, 20);
		frame.getContentPane().add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Teléfono :");
		lblNewLabel_3_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2_2.setBounds(10, 260, 100, 20);
		frame.getContentPane().add(lblNewLabel_3_2_2);
		
		JLabel lblNewLabel_3_2_3 = new JLabel("Datos bancarios :");
		lblNewLabel_3_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2_3.setBounds(10, 290, 116, 20);
		frame.getContentPane().add(lblNewLabel_3_2_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha solicitud colegiado :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(250, 140, 160, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_2_2_1 = new JLabel("Titulación :");
		lblNewLabel_3_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2_2_1.setBounds(250, 170, 100, 20);
		frame.getContentPane().add(lblNewLabel_3_2_2_1);
		
		JLabel lblNewLabel_3_2_2_2 = new JLabel("Centro :");
		lblNewLabel_3_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2_2_2.setBounds(250, 200, 100, 20);
		frame.getContentPane().add(lblNewLabel_3_2_2_2);
		
		JLabel lblNewLabel_3_2_2_3 = new JLabel("Año título :");
		lblNewLabel_3_2_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2_2_3.setBounds(250, 230, 100, 20);
		frame.getContentPane().add(lblNewLabel_3_2_2_3);
		
		JLabel lblNewLabel_3_2_2_4 = new JLabel("DNI :");
		lblNewLabel_3_2_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2_2_4.setBounds(250, 260, 100, 20);
		frame.getContentPane().add(lblNewLabel_3_2_2_4);
		
		btnInscripcionPerito = new JButton("Generar inscripción en la lista de peritos");
		btnInscripcionPerito.setEnabled(false);
		btnInscripcionPerito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInscripcionPerito.setBounds(250, 288, 274, 25);
		frame.getContentPane().add(btnInscripcionPerito);
		
		TFnombre = new JTextField();
		TFnombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFnombre.setBounds(120, 140, 120, 20);
		frame.getContentPane().add(TFnombre);
		TFnombre.setColumns(10);
		
		TFapellidos = new JTextField();
		TFapellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFapellidos.setBounds(120, 170, 120, 20);
		frame.getContentPane().add(TFapellidos);
		TFapellidos.setColumns(10);
		
		TFdireccion = new JTextField();
		TFdireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFdireccion.setColumns(10);
		TFdireccion.setBounds(120, 200, 120, 20);
		frame.getContentPane().add(TFdireccion);
		
		TFpoblacion = new JTextField();
		TFpoblacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFpoblacion.setColumns(10);
		TFpoblacion.setBounds(120, 230, 120, 20);
		frame.getContentPane().add(TFpoblacion);
		
		TFtelefono = new JTextField();
		TFtelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFtelefono.setColumns(10);
		TFtelefono.setBounds(120, 260, 120, 20);
		frame.getContentPane().add(TFtelefono);
		
		TFdatos = new JTextField();
		TFdatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFdatos.setColumns(10);
		TFdatos.setBounds(120, 290, 120, 20);
		frame.getContentPane().add(TFdatos);
		
		TFfecha = new JTextField();
		TFfecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFfecha.setColumns(10);
		TFfecha.setBounds(408, 140, 116, 20);
		frame.getContentPane().add(TFfecha);
		
		TFtitulacion = new JTextField();
		TFtitulacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFtitulacion.setColumns(10);
		TFtitulacion.setBounds(374, 170, 150, 20);
		frame.getContentPane().add(TFtitulacion);
		
		TFcentro = new JTextField();
		TFcentro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFcentro.setColumns(10);
		TFcentro.setBounds(374, 200, 150, 20);
		frame.getContentPane().add(TFcentro);
		
		TFanio = new JTextField();
		TFanio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFanio.setColumns(10);
		TFanio.setBounds(374, 230, 150, 20);
		frame.getContentPane().add(TFanio);
		
		TFdni = new JTextField();
		TFdni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFdni.setColumns(10);
		TFdni.setBounds(374, 260, 150, 20);
		frame.getContentPane().add(TFdni);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(418, 97, 106, 20);
		frame.getContentPane().add(btnReset);
		
		Lid = new JLabel("");
		Lid.setFont(new Font("Tahoma", Font.BOLD, 14));
		Lid.setBounds(338, 109, 50, 20);
		frame.getContentPane().add(Lid);
	}

	public JFrame getFrame() { return this.frame;}
	public JTextField getTFidColegiado() {return TFidColegiado;}
	public JButton getBtnVerDatos() {return btnVerDatos;}
	public JButton getBtnInscripcionPerito() { return btnInscripcionPerito;}
	public JButton getBtnReset() {return btnReset;}
	public JLabel getLid() {return Lid;}
	
	public static String getNombre() { return TFnombre.getText();}
	public static String getApellidos() { return TFapellidos.getText();}
	public static String getDireccion() { return TFdireccion.getText();}
	public static String getPoblacion() { return TFpoblacion.getText();}
	public static String getDNI() { return TFdni.getText();}
	public static String getTelefono() { return TFtelefono.getText();}
	public static String getDatos() { return TFdatos.getText();}
	public static String getFecha() { return TFfecha.getText();}
	public static String getTitulacion() { return TFtitulacion.getText();}
	public static String getCentro() { return TFcentro.getText();}
	public static String getAnio() { return TFanio.getText();}

	
	public JTextField getTFnombre() {return TFnombre;}
	public JTextField getTFapellidos() {return TFapellidos;}
	public JTextField getTFdireccion() {return TFdireccion;}
	public JTextField getTFpoblacion() {return TFpoblacion;}
	public JTextField getTFtelefono() {return TFtelefono;}
	public JTextField getTFdatos() {return TFdatos;}
	public JTextField getTFfecha() {return TFfecha;}
	public JTextField getTFtitulacion() {return TFtitulacion;}
	public JTextField getTFcentro() {return TFcentro;}
	public JTextField getTFanio() {return TFanio;}
	public JTextField getTFdni() {return TFdni;}
}