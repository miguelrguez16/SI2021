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
	
	public ListaCursosAnioView() {
		initialize();
	}

	private void initialize() {
		frame=new JFrame();
		frame.setBounds(0,0,500,450);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de cursos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 464, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane tablePanel = new JScrollPane((Component) null);
		tablePanel.setBounds(10, 48, 464, 307);
		frame.getContentPane().add(tablePanel);
		
		table = new JTable();
		tablePanel.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		tablePanel.setColumnHeaderView(lblNewLabel_1);
	}

	public JFrame getFrame() { return this.frame;}
	public JTable getTablaCursos() {return this.table;}
}