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


public class InscripcionesView {

	private static final long serialVersionUID = 1476210718996663912L;
	private JFrame frame;
	private JTable table;
	private JButton bJustificante;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	
	public InscripcionesView() {
		initialize();
	}

	private void initialize() {
		frame=new JFrame();
		frame.setBounds(0,0,352,450);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Inscripciones en cursos");
		frame.setName("Inscripciones en cursos");

		
		JLabel lblNewLabel = new JLabel("Lista de cursos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 320, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane tablePanel = new JScrollPane((Component) null);
		tablePanel.setBounds(10, 105, 320, 250);
		frame.getContentPane().add(tablePanel);
		
		table = new JTable();
		tablePanel.setViewportView(table);
		
		bJustificante = new JButton("Generar justificante");
		bJustificante.setBounds(160, 377, 159, 23);
		frame.getContentPane().add(bJustificante);
		
		lblNewLabel_1 = new JLabel("Nº de Colegiado  / Precolegiado: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 48, 218, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(244, 48, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

	public JFrame getFrame() { return this.frame;}
	public JTable getTablaCursos() {return this.table;}
	public JButton getbJustificante() { return this.bJustificante;}
	public JTextField getTextField() { return textField;}
	public void setTextField(JTextField textField) {this.textField = textField;}
}