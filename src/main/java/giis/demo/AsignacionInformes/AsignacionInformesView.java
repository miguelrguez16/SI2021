package giis.demo.AsignacionInformes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
//<<<<<<< HEAD
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;




public class AsignacionInformesView extends JFrame {



	private static final long serialVersionUID = 59272130249980170L;

	private JFrame frmAsignacionDeInformes;
	private JTable tabInformes;
	private JTextField idInformeSeleccionado;
	private JTextField idPeritoSeleccionado;
	private JLabel lblListaInformesPendientes;
	private JLabel lblNewLabel;
	private JButton btnGuardarCambios;
	private JButton btnCancelarCambios;
	private JButton btnAsignacionAutomatica;
	private JTable tabPeritos;
	private JLabel lblMensaje;


	/**
	 * Create the application.
	 */
	public AsignacionInformesView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAsignacionDeInformes = new JFrame();
		frmAsignacionDeInformes.setTitle("Asignacion de Informes Peritales");
		frmAsignacionDeInformes.setName("Asignacion de Informes Peritales");
		
		frmAsignacionDeInformes.setBounds(0, 0, 562, 502);

		frmAsignacionDeInformes.getContentPane().setLayout(null);
		frmAsignacionDeInformes.setLocationRelativeTo(null);
		
		lblListaInformesPendientes = new JLabel("Informes Pendientes");
		lblListaInformesPendientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListaInformesPendientes.setHorizontalAlignment(SwingConstants.LEFT);

		lblListaInformesPendientes.setBounds(20, 21, 214, 14);

		frmAsignacionDeInformes.getContentPane().add(lblListaInformesPendientes);
		
		//Incluyo la tabla en un JScrollPane y anado este
		//en vez de la tabla para poder ver los headers de la tabla
		tabInformes = new JTable();
		tabInformes.setName("tabInformes");
		tabInformes.setDefaultEditor(Object.class, null); //readonly
		tabInformes.setBackground(SystemColor.control);
		JScrollPane tablePanel = new JScrollPane(tabInformes);

		tablePanel.setBounds(20, 54, 192, 291);

		frmAsignacionDeInformes.getContentPane().add(tablePanel);
		
		lblNewLabel = new JLabel("N.º informe:");

		lblNewLabel.setBounds(20, 359, 63, 14);

		frmAsignacionDeInformes.getContentPane().add(lblNewLabel);
		
		idInformeSeleccionado = new JTextField();
		idInformeSeleccionado.setEditable(false);

		idInformeSeleccionado.setBounds(124, 356, 85, 20);

		frmAsignacionDeInformes.getContentPane().add(idInformeSeleccionado);
		idInformeSeleccionado.setColumns(10);
		
		idPeritoSeleccionado = new JTextField();
		idPeritoSeleccionado.setEditable(false);

		idPeritoSeleccionado.setBounds(451, 353, 85, 20);

		frmAsignacionDeInformes.getContentPane().add(idPeritoSeleccionado);
		idPeritoSeleccionado.setColumns(10);
		
		//Guardar cambios
		btnGuardarCambios = new JButton("Asignacion Manual");
		btnGuardarCambios.setBounds(379, 429, 157, 23);
		frmAsignacionDeInformes.getContentPane().add(btnGuardarCambios);
		
		//Cancelar cambios
		btnCancelarCambios = new JButton("Cancelar");
		btnCancelarCambios.setBounds(20, 429, 157, 23);
		frmAsignacionDeInformes.getContentPane().add(btnCancelarCambios);
		
		JScrollPane tablePanelInformes = new JScrollPane((Component) null);
		tablePanelInformes.setBounds(328, 54, 208, 291);
		frmAsignacionDeInformes.getContentPane().add(tablePanelInformes);
		
		tabPeritos = new JTable();
		tabPeritos.setDefaultEditor(Object.class, null); //readonly
		tabPeritos.setBackground(SystemColor.control);
		tablePanelInformes.setViewportView(tabPeritos);
		
		JLabel lblListaPeritos = new JLabel("Peritos");
		lblListaPeritos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListaPeritos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaPeritos.setBounds(328, 21, 208, 14);
		frmAsignacionDeInformes.getContentPane().add(lblListaPeritos);
		
		JLabel lblNewLabel_4 = new JLabel("N.ª Perito:");
		lblNewLabel_4.setBounds(328, 359, 63, 14);
		frmAsignacionDeInformes.getContentPane().add(lblNewLabel_4);
		

		btnAsignacionAutomatica = new JButton("Asignacion Automática");
		btnAsignacionAutomatica.setBounds(200, 429, 157, 23);
		frmAsignacionDeInformes.getContentPane().add(btnAsignacionAutomatica);
		
		 lblMensaje = new JLabel("");
		lblMensaje.setBounds(124, 404, 267, 14);
		frmAsignacionDeInformes.getContentPane().add(lblMensaje);

	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frmAsignacionDeInformes; }
	public JTextField getIDInforme() {return this.idInformeSeleccionado;}
	public JTextField getIDPerito() {return this.idPeritoSeleccionado;}


	public JTable getTablaInformes() { return this.tabInformes; }
	public JTable getTablaPeritos() { return this.tabPeritos; }

	
	public JButton getBtnGuardarCambiosManual() {return this.btnGuardarCambios;}
	public JButton getBtnCancelarCambios(){return this.btnCancelarCambios;}
	public JButton getBtnAsignacionautomatica() {return this.btnAsignacionAutomatica;}
	
	
	public void setIdInforme(String idInforme) { this.idInformeSeleccionado.setText(idInforme);}
	public void setIdPerito(String idPerito) { this.idPeritoSeleccionado.setText(idPerito);}
	
	public JLabel getMensaje() {return this.lblMensaje;}
}

