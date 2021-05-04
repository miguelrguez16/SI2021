package giis.demo.cursosAnio;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JScrollPane;
import java.awt.Component;



public class ListaCursosAnioView {

	
	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JLabel LInscritos;
	private JButton btnCargar;
	
	public ListaCursosAnioView() {
		initialize();
	}

	private void initialize() {
		frame=new JFrame();
		frame.setBounds(0,0,530,499);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Lista de inscritos a cursos");
		
		JLabel lblNewLabel = new JLabel("Lista de cursos este año con inscripción abierta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 494, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane tablePanel = new JScrollPane((Component) null);
		tablePanel.setBounds(10, 48, 464, 105);
		frame.getContentPane().add(tablePanel);
		
		table = new JTable();
		tablePanel.setViewportView(table);
		
		LInscritos = new JLabel("Lista de inscritos al curso ");
		LInscritos.setHorizontalAlignment(SwingConstants.CENTER);
		LInscritos.setFont(new Font("Tahoma", Font.BOLD, 16));
		LInscritos.setBounds(10, 197, 494, 20);
		frame.getContentPane().add(LInscritos);
		
		JScrollPane tablePanel_1 = new JScrollPane((Component) null);
		tablePanel_1.setBounds(10, 228, 494, 221);
		frame.getContentPane().add(tablePanel_1);
		
		table_1=new JTable();
		tablePanel_1.setViewportView(table_1);
		
		btnCargar = new JButton("Subir archivo de pago por transferencia");
		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCargar.setBounds(10, 164, 300, 22);
		frame.getContentPane().add(btnCargar);
	}

	public JFrame getFrame() { return this.frame;}
	public JTable getTablaCursos() {return this.table;}
	public JButton getBtnCargar() {return this.btnCargar;}
	public JTable getTablaInscritos() {return this.table_1;}
	public JLabel getLInscritos() {return this.LInscritos;}
}