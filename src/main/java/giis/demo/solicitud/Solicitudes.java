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

public class Solicitudes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7758216415701614225L;
	private JFrame frmSolicitudes;
	private JButton bPre;
	private JButton bCol;

	/**
	 * Create the application.
	 */
	public Solicitudes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSolicitudes = new JFrame();
		frmSolicitudes.setMinimumSize(new Dimension(471, 234));
		frmSolicitudes.setTitle("Realizar Solicitud");
		frmSolicitudes.getContentPane().setLayout(null);
		
		bPre = new JButton("Solicitud Precolegiado");
		bPre.setBounds(42, 79, 163, 23);
		frmSolicitudes.getContentPane().add(bPre);
		
		bCol = new JButton("Solicitud Colegiado");
		bCol.setBounds(228, 79, 163, 23);
		frmSolicitudes.getContentPane().add(bCol);
	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frmSolicitudes; }
	public JButton getBtnPre() { return this.bPre; }
	public JButton getBtnCol() { return this.bCol; }

}

