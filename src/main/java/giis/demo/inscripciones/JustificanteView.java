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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,600,342);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Justificante curso");
		frame.setName("Justificante curso");

		
		JLabel lblNewLabel = new JLabel("Justificante de inscripción para la transferencia");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(20, 15, 540, 26);
		frame.getContentPane().add(lblNewLabel);
		
		LNombre = new JLabel("Nombre :");
		LNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LNombre.setBounds(20, 60, 260, 25);
		frame.getContentPane().add(LNombre);
		
		LApellidos = new JLabel("Apellidos :");
		LApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LApellidos.setBounds(300, 60, 260, 25);
		frame.getContentPane().add(LApellidos);
		
		LNColegiado = new JLabel("Nº colegiado :");
		LNColegiado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LNColegiado.setBounds(20, 101, 540, 25);
		frame.getContentPane().add(LNColegiado);
		
		LFecha = new JLabel("Fecha de la inscripción :");
		LFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LFecha.setBounds(20, 140, 540, 25);
		frame.getContentPane().add(LFecha);
		
		LCantidad = new JLabel("Cantidad a abonar :");
		LCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LCantidad.setBounds(20, 180, 540, 25);
		frame.getContentPane().add(LCantidad);
		
		LNCuenta = new JLabel("Número de la cuenta :");
		LNCuenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LNCuenta.setBounds(20, 220, 540, 25);
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

