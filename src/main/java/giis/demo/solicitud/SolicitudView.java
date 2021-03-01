package giis.demo.solicitud;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;

public class SolicitudView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7758216415701614225L;
	private JFrame frmSolicitud;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_7;
	private JLabel lblNewLabel_8;
	private JTextField textField_8;
	private JLabel lblNewLabel_9;
	private JTextField textField_9;

	/**
	 * Create the application.
	 */
	public SolicitudView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSolicitud = new JFrame();
		frmSolicitud.setTitle("Solicitud");
		frmSolicitud.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 75, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(66, 72, 86, 20);
		frmSolicitud.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setBounds(179, 75, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 72, 178, 20);
		frmSolicitud.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dirección");
		lblNewLabel_2.setBounds(10, 100, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 97, 345, 20);
		frmSolicitud.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Población");
		lblNewLabel_3.setBounds(10, 125, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 122, 132, 20);
		frmSolicitud.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Teléfono");
		lblNewLabel_4.setBounds(233, 125, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(289, 122, 122, 20);
		frmSolicitud.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Titulación");
		lblNewLabel_5.setBounds(10, 167, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(66, 164, 345, 20);
		frmSolicitud.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Centro");
		lblNewLabel_6.setBounds(10, 192, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(66, 189, 132, 20);
		frmSolicitud.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Año Titulación");
		lblNewLabel_7.setBounds(233, 195, 75, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setBounds(318, 189, 93, 20);
		frmSolicitud.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		lblNewLabel_8 = new JLabel("IBAN");
		lblNewLabel_8.setBounds(10, 242, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_8);
		
		textField_8 = new JTextField();
		textField_8.setBounds(66, 239, 345, 20);
		frmSolicitud.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		lblNewLabel_9 = new JLabel("DNI");
		lblNewLabel_9.setBounds(10, 46, 46, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_9);
		
		textField_9 = new JTextField();
		textField_9.setBounds(66, 43, 122, 20);
		frmSolicitud.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar solicitud");
		btnNewButton.setBounds(412, 299, 103, 23);
		frmSolicitud.getContentPane().add(btnNewButton);
	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frmSolicitud; }
	public String getFechaHoy()  { return this.txtFechaHoy.getText(); }
	public void setFechaHoy(String fechaIso)  { this.txtFechaHoy.setText(fechaIso); }
	public JButton getBtnTablaCurso() { return this.btnTabCurso; }
	public JTable getTablaCurso() { return this.tabCurso; }
	public JComboBox<Object> getListaCarreras() { return this.lstCurso; }
	public JTable getDetalleCarrera() { return this.tabDetalle; }
}

