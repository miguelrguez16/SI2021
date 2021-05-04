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


public class JustificanteTarjetaView {
	
	private JFrame frmJustificanteFormaDe;
	private JLabel LTarjeta;
	
	public JustificanteTarjetaView() {
		initialize();
	}

	private void initialize() {
		frmJustificanteFormaDe=new JFrame();
		frmJustificanteFormaDe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmJustificanteFormaDe.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmJustificanteFormaDe.setBounds(0,0,500,150);
		frmJustificanteFormaDe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Justificante pago con tarjeta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 464, 20);
		frmJustificanteFormaDe.getContentPane().add(lblNewLabel);
		
		LTarjeta = new JLabel("");
		LTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LTarjeta.setBounds(10, 42, 464, 45);
		frmJustificanteFormaDe.getContentPane().add(LTarjeta);
		frmJustificanteFormaDe.setLocationRelativeTo(null);
		frmJustificanteFormaDe.setTitle("Justificante: pago con tarjeta");
		frmJustificanteFormaDe.setName("Justificante: pago con tarjeta");
	}
	
	public JFrame getFrame() { return this.frmJustificanteFormaDe;}
	public JLabel getLTarjeta() {return LTarjeta;}
}

