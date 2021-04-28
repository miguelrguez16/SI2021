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
import java.awt.Canvas;
import javax.swing.JSeparator;


public class ComoPagarView {
	
	private JFrame frame;
	private JButton btnTarjeta;
	private JButton btnTransferencia;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField TFtarjeta;
	private JTextField TFtitular;
	private JTextField TFmes;
	private JTextField TFcvc;
	private JLabel lblNewLabel_4_2_2;
	private JLabel lblNewLabel_4_2_3;
	private JTextField TFano;
	
	
	public ComoPagarView() {
		initialize();
	}

	private void initialize() {
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.setBounds(0,0,500,400);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscripción: Forma de pago");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 15, 464, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Dos formas de realizar el pago de la inscripción :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 50, 464, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		btnTransferencia = new JButton("Pago por transferencia");
		btnTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTransferencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTransferencia.setBounds(140, 107, 200, 20);
		frame.getContentPane().add(btnTransferencia);
		
		btnTarjeta = new JButton("Pago con tarjeta");
		btnTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTarjeta.setBounds(140, 180, 200, 20);
		frame.getContentPane().add(btnTarjeta);
		
		lblNewLabel_1 = new JLabel("Pago por transferencia");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 77, 464, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("Pago con tarjeta");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 150, 464, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Número de tarjeta (16 números) :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 250, 225, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		TFtarjeta = new JTextField();
		TFtarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFtarjeta.setBounds(250, 250, 225, 20);
		frame.getContentPane().add(TFtarjeta);
		TFtarjeta.setColumns(10);
		
		TFtitular = new JTextField();
		TFtitular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFtitular.setColumns(10);
		TFtitular.setBounds(250, 220, 225, 20);
		frame.getContentPane().add(TFtitular);
		
		TFmes = new JTextField();
		TFmes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFmes.setColumns(10);
		TFmes.setBounds(290, 280, 40, 20);
		frame.getContentPane().add(TFmes);
		
		TFcvc = new JTextField();
		TFcvc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFcvc.setColumns(10);
		TFcvc.setBounds(250, 310, 60, 20);
		frame.getContentPane().add(TFcvc);
		
		JLabel lblNewLabel_4_1 = new JLabel("Nombre del titular :");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(10, 220, 225, 20);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Fecha de caducidad (mm-aa) :");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(10, 280, 225, 20);
		frame.getContentPane().add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("CVC (3 dígitos) :");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2_1.setBounds(10, 310, 225, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1);
		
		lblNewLabel_4_2_2 = new JLabel("Mes :");
		lblNewLabel_4_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2_2.setBounds(250, 280, 40, 20);
		frame.getContentPane().add(lblNewLabel_4_2_2);
		
		lblNewLabel_4_2_3 = new JLabel("Año :");
		lblNewLabel_4_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2_3.setBounds(335, 280, 40, 20);
		frame.getContentPane().add(lblNewLabel_4_2_3);
		
		TFano = new JTextField();
		TFano.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFano.setColumns(10);
		TFano.setBounds(380, 280, 40, 20);
		frame.getContentPane().add(TFano);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Inscripción: Forma de pago");
		frame.setName("Inscripción: Forma de pago");
	}
	
	public JFrame getFrame() { return this.frame;}

	public JButton getBtnTarjeta() {
		return btnTarjeta;
	}

	public JButton getBtnTransferencia() {
		return btnTransferencia;
	}

	public void setBtnTarjeta(JButton btnTarjeta) {
		this.btnTarjeta = btnTarjeta;
	}

	public void setBtnTransferencia(JButton btnTransferencia) {
		this.btnTransferencia = btnTransferencia;
	}

	public JTextField getTFtarjeta() {
		return TFtarjeta;
	}

	public JTextField getTFtitular() {
		return TFtitular;
	}

	public JTextField getTFmes() {
		return TFmes;
	}

	public JTextField getTFano() {
		return TFano;
	}
	
	public JTextField getTFcvc() {
		return TFcvc;
	}
}

