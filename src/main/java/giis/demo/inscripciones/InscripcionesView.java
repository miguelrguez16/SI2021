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


public class InscripcionesView {

	private static final long serialVersionUID = 1476210718996663912L;
	private JFrame frame;
	private JTable table;
	private JButton bJustificante;
	private JButton btnComprobar;
	private static JTextField TFdni;
	private static JTextField TFnombre;
	private static JTextField TFdatos;
	private static JTextField TFapellidos;
	private JLabel lblNewLabel_7;
	private static JTextField TFdireccion;
	private static JTextField TFpoblacion;
	private static JTextField TFtelefono;
	
	public InscripcionesView() {
		initialize();
	}

	private void initialize() {
		frame=new JFrame();
		frame.setBounds(0,0,602,370);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Inscripciones en cursos");
		frame.setName("Inscripciones en cursos");

		
		JLabel lblNewLabel = new JLabel("Lista de cursos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(336, 100, 240, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane tablePanel = new JScrollPane((Component) null);
		tablePanel.setBounds(336, 145, 240, 140);
		frame.getContentPane().add(tablePanel);
		
		table = new JTable();
		tablePanel.setViewportView(table);
		
		bJustificante = new JButton("Justificante de inscripción al curso");
		bJustificante.setBounds(336, 295, 240, 20);
		frame.getContentPane().add(bJustificante);
		
		TFdni = new JTextField();
		TFdni.setBounds(366, 40, 80, 20);
		frame.getContentPane().add(TFdni);
		TFdni.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Introduzca su DNI para comprobar si ya está registrado :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 40, 350, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(456, 40, 120, 20);
		frame.getContentPane().add(btnComprobar);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 145, 150, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Datos del solicitante");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 100, 300, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Datos bancarios :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 295, 150, 20);
		frame.getContentPane().add(lblNewLabel_5);
		
		TFnombre = new JTextField();
		TFnombre.setBounds(160, 145, 149, 20);
		frame.getContentPane().add(TFnombre);
		TFnombre.setColumns(10);
		
		TFdatos = new JTextField();
		TFdatos.setBounds(160, 295, 149, 20);
		frame.getContentPane().add(TFdatos);
		TFdatos.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Apellidos :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 175, 150, 20);
		frame.getContentPane().add(lblNewLabel_6);
		
		TFapellidos = new JTextField();
		TFapellidos.setBounds(160, 175, 149, 20);
		frame.getContentPane().add(TFapellidos);
		TFapellidos.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Direccion :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 205, 150, 20);
		frame.getContentPane().add(lblNewLabel_7);
		
		TFdireccion = new JTextField();
		TFdireccion.setBounds(160, 205, 149, 20);
		frame.getContentPane().add(TFdireccion);
		TFdireccion.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Población :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 235, 150, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_8 = new JLabel("Teléfono :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(10, 265, 150, 20);
		frame.getContentPane().add(lblNewLabel_8);
		
		TFpoblacion = new JTextField();
		TFpoblacion.setBounds(160, 235, 149, 20);
		frame.getContentPane().add(TFpoblacion);
		TFpoblacion.setColumns(10);
		
		TFtelefono = new JTextField();
		TFtelefono.setBounds(160, 265, 149, 20);
		frame.getContentPane().add(TFtelefono);
		TFtelefono.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Inscripciones en cursos");
		lblNewLabel_9.setForeground(Color.BLACK);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9.setBounds(10, 10, 566, 25);
		frame.getContentPane().add(lblNewLabel_9);
	}

	public JFrame getFrame() { return this.frame;}
	public JTable getTablaCursos() {return this.table;}
	public JButton getbJustificante() { return this.bJustificante;}
	public JButton getbtnComprobar() { return this.btnComprobar;}
	public JTextField getTFdni() { return this.TFdni;}
	public JTextField getTFnombre() {return TFnombre;}
	public JTextField getTFdatos() {return TFdatos;}
	public JTextField getTFapellidos() {return TFapellidos;}
	public JTextField getTFdireccion() {return TFdireccion;}
	public JTextField getTFpoblacion() {return TFpoblacion;}
	public JTextField getTFtelefono() {return TFtelefono;}
	
	public static String getNombre() {return TFnombre.getText();}
	public static String getApellidos() { return TFapellidos.getText();}
	public static String getDireccion() { return TFdireccion.getText();}
	public static String getPoblacion() { return TFpoblacion.getText();}
	public static String getTelefono() { return TFtelefono.getText();}
	public static String getDni() { return TFdni.getText();}
	public static String getDatos() { return TFdatos.getText();}
}