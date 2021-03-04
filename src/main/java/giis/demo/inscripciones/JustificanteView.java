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


public class JustificanteView {

	private static final long serialVersionUID = 1476210718996663912L;
	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTable table;
	private JLabel LNombre;
	private JLabel LApellidos;
	private JLabel LNColegiado;
	private JLabel LFecha;
	private JLabel LCantidad;
	private JLabel LNCuenta;
	
	public JustificanteView() {
		initialize();
	}

	private void initialize() {
		frame=new JFrame();
		frame.setBounds(0,0,500,450);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Justificante de inscripción");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 464, 26);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombre : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 73, 140, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Apellidos : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(20, 123, 140, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Número colegiado :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(20, 173, 140, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Fecha de solicitud : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(20, 224, 150, 27);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Cantidad a abonar : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(20, 280, 150, 27);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Número de cuenta : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(20, 336, 150, 27);
		frame.getContentPane().add(lblNewLabel_6);
		
		LNombre = new JLabel("");
		LNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LNombre.setBounds(170, 73, 247, 26);
		frame.getContentPane().add(LNombre);
		
		LApellidos = new JLabel("");
		LApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LApellidos.setBounds(170, 123, 247, 26);
		frame.getContentPane().add(LApellidos);
		
		LNColegiado = new JLabel("");
		LNColegiado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LNColegiado.setBounds(170, 173, 247, 26);
		frame.getContentPane().add(LNColegiado);
		
		LFecha = new JLabel("");
		LFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LFecha.setBounds(170, 225, 247, 26);
		frame.getContentPane().add(LFecha);
		
		LCantidad = new JLabel("");
		LCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LCantidad.setBounds(170, 281, 247, 26);
		frame.getContentPane().add(LCantidad);
		
		LNCuenta = new JLabel("");
		LNCuenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LNCuenta.setBounds(170, 336, 247, 26);
		frame.getContentPane().add(LNCuenta);
	}
	
	public JFrame getFrame() { return this.frame;}
	public JTable getTablaCursos() {return this.table;}

	public JLabel getLNombre() {
		return LNombre;
	}

	public void setLNombre(JLabel lNombre) {
		LNombre = lNombre;
	}

	public JLabel getLApellidos() {
		return LApellidos;
	}

	public void setLApellidos(JLabel lApellidos) {
		LApellidos = lApellidos;
	}

	public JLabel getLNColegiado() {
		return LNColegiado;
	}

	public void setLNColegiado(JLabel lNColegiado) {
		LNColegiado = lNColegiado;
	}

	public JLabel getLFecha() {
		return LFecha;
	}

	public void setLFecha(JLabel lFecha) {
		LFecha = lFecha;
	}

	public JLabel getLCantidad() {
		return LCantidad;
	}

	public void setLCantidad(JLabel lCantidad) {
		LCantidad = lCantidad;
	}

	public JLabel getLNCuenta() {
		return LNCuenta;
	}

	public void setLNCuenta(JLabel lNCuenta) {
		LNCuenta = lNCuenta;
	}
}
