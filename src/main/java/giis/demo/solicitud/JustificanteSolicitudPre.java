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

public class JustificanteSolicitudPre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7758216415701614225L;
	private JFrame frmSolicitud;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel jlIDSolicitante;
	private JLabel jlIDSolicitud;
	private JLabel jlFechaSolicitud;
	private JLabel jlFechaFin;
	private JButton bGuardar;
	private JButton bCerrar;

	/**
	 * Create the application.
	 */
	public JustificanteSolicitudPre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSolicitud = new JFrame();
		frmSolicitud.setMinimumSize(new Dimension(471, 234));
		frmSolicitud.setTitle("Justificante de solicitud");
		frmSolicitud.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Solicitante");
		lblNewLabel.setBounds(10, 41, 140, 14);
		frmSolicitud.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Número Precolegiado");
		lblNewLabel_1.setBounds(10, 66, 140, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Fecha Solicitud");
		lblNewLabel_2.setBounds(10, 91, 140, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_2);
		
		jlIDSolicitante = new JLabel("");
		jlIDSolicitante.setBounds(209, 41, 167, 14);
		frmSolicitud.getContentPane().add(jlIDSolicitante);
		
		jlIDSolicitud = new JLabel("");
		jlIDSolicitud.setBounds(209, 66, 167, 14);
		frmSolicitud.getContentPane().add(jlIDSolicitud);
		
		jlFechaSolicitud = new JLabel("");
		jlFechaSolicitud.setBounds(209, 91, 167, 14);
		frmSolicitud.getContentPane().add(jlFechaSolicitud);
		
		bGuardar = new JButton("Guardar Copia");
		bGuardar.setBounds(157, 146, 140, 23);
		frmSolicitud.getContentPane().add(bGuardar);
		
		bCerrar = new JButton("Cerrar");
		bCerrar.setBounds(307, 146, 78, 23);
		frmSolicitud.getContentPane().add(bCerrar);
		
		JLabel lblNewLabel_3 = new JLabel("Justificante de Solicitud");
		lblNewLabel_3.setBounds(160, 11, 156, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha Expiración");
		lblNewLabel_4.setBounds(10, 116, 98, 14);
		frmSolicitud.getContentPane().add(lblNewLabel_4);
		
		jlFechaFin = new JLabel("");
		jlFechaFin.setBounds(209, 116, 140, 14);
		frmSolicitud.getContentPane().add(jlFechaFin);
	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frmSolicitud; }
	public JButton getBtnGuardar() { return this.bGuardar; }
	public JButton getBtnCerrar() { return this.bCerrar; }
	public JLabel getSolicitante() {
		return jlIDSolicitante;
	}
	public JLabel getSolicitud() {
		return jlIDSolicitud;
	}
	public JLabel getFechaSol() {
		return jlFechaSolicitud;
	}
	public JLabel getFechaFin() {
		return this.jlFechaFin;
	}
	public String getJlIDSolicitante() { return this.jlIDSolicitante.getText(); }
	public String getJlIDSolicitud() { return jlIDSolicitud.getText(); }
	public void setJlIDSolicitante(JLabel jlIDSolicitante) { this.jlIDSolicitante = jlIDSolicitante; }
	public void setJlIDSolicitud(JLabel jlIDSolicitud) { this.jlIDSolicitud = jlIDSolicitud; }
	public String getJlFechaSolicitud() { return jlFechaSolicitud.getText(); }
	public void setJlFechaSolicitud(JLabel jlFechaSolicitud) { this.jlFechaSolicitud = jlFechaSolicitud; }
	public String getJlFechaFin() { return jlFechaFin.getText(); }
	public void setJlFechaFin(JLabel jlFechaFin) { this.jlFechaFin = jlFechaFin; }
}

