package giis.demo.inscripcionesListaPeritos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JScrollPane;
import java.awt.Component;



public class justificanteAltaView {

	
	private JFrame frame;
	private JLabel LidPerito;
	private JLabel LidColegiado;
	private JLabel LNombre;
	private JLabel LApellidos;
	private JLabel LFecha;
	private JLabel Lturno;
	
	public justificanteAltaView() {
		initialize();
	}

	private void initialize() {
		frame=new JFrame();
		frame.setBounds(0,0,450,230);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Lista de inscritos a cursos");
		
		JLabel lblNewLabel = new JLabel("Justificación de solicitud de alta en peritos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 414, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 110, 80, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellidos :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(225, 110, 80, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 140, 80, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Turno :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(225, 140, 80, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Id Perito :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 80, 80, 20);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("Id Colegiado :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(225, 80, 100, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		LidPerito = new JLabel("");
		LidPerito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LidPerito.setBounds(100, 80, 100, 20);
		frame.getContentPane().add(LidPerito);
		
		LNombre = new JLabel("");
		LNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LNombre.setBounds(100, 110, 100, 20);
		frame.getContentPane().add(LNombre);
		
		LFecha = new JLabel("");
		LFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LFecha.setBounds(100, 140, 100, 20);
		frame.getContentPane().add(LFecha);
		
		LidColegiado = new JLabel("");
		LidColegiado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LidColegiado.setBounds(324, 80, 100, 20);
		frame.getContentPane().add(LidColegiado);
		
		LApellidos = new JLabel("");
		LApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LApellidos.setBounds(324, 110, 100, 20);
		frame.getContentPane().add(LApellidos);
		
		Lturno = new JLabel("");
		Lturno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Lturno.setBounds(324, 140, 100, 20);
		frame.getContentPane().add(Lturno);
	}

	public JFrame getFrame() { return this.frame;}
	public JLabel getLidPerito() {return LidPerito;}
	public JLabel getLidColegiado() {return LidColegiado;}
	public JLabel getLNombre() {return LNombre;}
	public JLabel getLApellidos() {return LApellidos;}
	public JLabel getLFecha() {return LFecha;}
	public JLabel getLturno() {return Lturno;}
}