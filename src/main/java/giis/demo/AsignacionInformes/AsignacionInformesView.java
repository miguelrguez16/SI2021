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
	private JTable tabPeritos;


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
		
		frmAsignacionDeInformes.setBounds(0, 0, 518, 502);

		frmAsignacionDeInformes.getContentPane().setLayout(null);
		frmAsignacionDeInformes.setLocationRelativeTo(null);
		
		lblListaInformesPendientes = new JLabel("Informes Pendientes");
		lblListaInformesPendientes.setHorizontalAlignment(SwingConstants.CENTER);

		lblListaInformesPendientes.setBounds(33, 21, 175, 14);

		frmAsignacionDeInformes.getContentPane().add(lblListaInformesPendientes);
		
		//Incluyo la tabla en un JScrollPane y anado este
		//en vez de la tabla para poder ver los headers de la tabla
		tabInformes = new JTable();
		tabInformes.setName("tabInformes");
		tabInformes.setDefaultEditor(Object.class, null); //readonly
		tabInformes.setBackground(SystemColor.control);
		JScrollPane tablePanel = new JScrollPane(tabInformes);

		tablePanel.setBounds(33, 54, 192, 291);

		frmAsignacionDeInformes.getContentPane().add(tablePanel);
		
		lblNewLabel = new JLabel("Nº informe:");

		lblNewLabel.setBounds(33, 356, 63, 14);

		frmAsignacionDeInformes.getContentPane().add(lblNewLabel);
		
		idInformeSeleccionado = new JTextField();
		idInformeSeleccionado.setEditable(false);

		idInformeSeleccionado.setBounds(124, 356, 85, 20);

		frmAsignacionDeInformes.getContentPane().add(idInformeSeleccionado);
		idInformeSeleccionado.setColumns(10);
		
		idPeritoSeleccionado = new JTextField();
		idPeritoSeleccionado.setEditable(false);

		idPeritoSeleccionado.setBounds(392, 353, 85, 20);

		frmAsignacionDeInformes.getContentPane().add(idPeritoSeleccionado);
		idPeritoSeleccionado.setColumns(10);
		
		//Guardar cambios
		btnGuardarCambios = new JButton("Asignacion Manual");
		btnGuardarCambios.setBounds(316, 407, 141, 31);
		frmAsignacionDeInformes.getContentPane().add(btnGuardarCambios);
		
		//Cancelar cambios
		btnCancelarCambios = new JButton("cancelar");
		btnCancelarCambios.setBounds(30, 407, 109, 31);
		frmAsignacionDeInformes.getContentPane().add(btnCancelarCambios);
		
		JScrollPane tablePanelInformes = new JScrollPane((Component) null);
		tablePanelInformes.setBounds(269, 54, 208, 291);
		frmAsignacionDeInformes.getContentPane().add(tablePanelInformes);
		
		tabPeritos = new JTable();
		tabPeritos.setDefaultEditor(Object.class, null); //readonly
		tabPeritos.setBackground(SystemColor.control);
		tablePanelInformes.setViewportView(tabPeritos);
		
		JLabel lblListaPeritos = new JLabel("Peritos");
		lblListaPeritos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaPeritos.setBounds(259, 21, 198, 14);
		frmAsignacionDeInformes.getContentPane().add(lblListaPeritos);
		
		JLabel lblNewLabel_4 = new JLabel("Nº Perito");
		lblNewLabel_4.setBounds(269, 356, 63, 14);
		frmAsignacionDeInformes.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Asignacion Automática");
		btnNewButton.setBounds(149, 411, 157, 23);
		frmAsignacionDeInformes.getContentPane().add(btnNewButton);

	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frmAsignacionDeInformes; }
	public JTextField getIDInforme() {return this.idInformeSeleccionado;}
	public JTextField getIDPerito() {return this.idPeritoSeleccionado;}


	public JTable getTablaInformes() { return this.tabInformes; }
	public JTable getTablaPeritos() { return this.tabPeritos; }

	
	public JButton getBtnGuardarCambios() {return this.btnGuardarCambios;}
	public JButton getBtnCancelarCambios(){return this.btnCancelarCambios; }
	
	
	public void setIdInforme(String idInforme) { this.idInformeSeleccionado.setText(idInforme);}
	public void setIdPerito(String idPerito) { this.idPeritoSeleccionado.setText(idPerito);}
}

