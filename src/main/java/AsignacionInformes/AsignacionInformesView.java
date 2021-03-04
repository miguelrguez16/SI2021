package AsignacionInformes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
//<<<<<<< HEAD
import java.awt.FlowLayout;
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

		frmAsignacionDeInformes.setBounds(0, 0, 405, 502);

		frmAsignacionDeInformes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmAsignacionDeInformes.getContentPane().setLayout(null);

		
		lblListaInformesPendientes = new JLabel("Informes Pendientes");
		lblListaInformesPendientes.setHorizontalAlignment(SwingConstants.CENTER);

		lblListaInformesPendientes.setBounds(10, 11, 183, 14);

		frmAsignacionDeInformes.getContentPane().add(lblListaInformesPendientes);
		
		//Incluyo la tabla en un JScrollPane y anado este en vez de la tabla para poder ver los headers de la tabla
		tabInformes = new JTable();
		tabInformes.setName("tabCarreras");
		tabInformes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabInformes.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablePanel = new JScrollPane(tabInformes);

		tablePanel.setBounds(7, 41, 175, 291);

		frmAsignacionDeInformes.getContentPane().add(tablePanel);
		
		lblNewLabel = new JLabel("Nº informe:");

		lblNewLabel.setBounds(17, 339, 63, 14);

		frmAsignacionDeInformes.getContentPane().add(lblNewLabel);
		
		idInformeSeleccionado = new JTextField();
		idInformeSeleccionado.setEditable(false);

		idInformeSeleccionado.setBounds(100, 336, 75, 20);

		frmAsignacionDeInformes.getContentPane().add(idInformeSeleccionado);
		idInformeSeleccionado.setColumns(10);
		
		idPeritoSeleccionado = new JTextField();
		idPeritoSeleccionado.setEditable(false);

		idPeritoSeleccionado.setBounds(292, 336, 89, 20);

		frmAsignacionDeInformes.getContentPane().add(idPeritoSeleccionado);
		idPeritoSeleccionado.setColumns(10);
		
		//Guardar cambios
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setBounds(213, 407, 141, 31);
		frmAsignacionDeInformes.getContentPane().add(btnGuardarCambios);
		
		//Cancelar cambios
		btnCancelarCambios = new JButton("cancelar");
		btnCancelarCambios.setBounds(36, 407, 109, 31);
		frmAsignacionDeInformes.getContentPane().add(btnCancelarCambios);
		
		JScrollPane tablePanelInformes = new JScrollPane((Component) null);
		tablePanelInformes.setBounds(195, 41, 186, 291);
		frmAsignacionDeInformes.getContentPane().add(tablePanelInformes);
		
		tabPeritos = new JTable();
		tabPeritos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabPeritos.setDefaultEditor(Object.class, null); //readonly
		tablePanelInformes.setViewportView(tabPeritos);
		
		JLabel lblListaPeritos = new JLabel("Peritos");
		lblListaPeritos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaPeritos.setBounds(203, 11, 183, 14);
		frmAsignacionDeInformes.getContentPane().add(lblListaPeritos);
		
		JLabel lblNewLabel_4 = new JLabel("Nº Perito");
		lblNewLabel_4.setBounds(219, 339, 63, 14);
		frmAsignacionDeInformes.getContentPane().add(lblNewLabel_4);

	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frmAsignacionDeInformes; }
	public JTextField getCursoNombre() {return this.idInformeSeleccionado;}
	public JTextField getIDNombre() {return this.idPeritoSeleccionado;}


	public JTable getTabInformes() { return this.tabInformes; }
	public JTable getTabPeritos() { return this.tabPeritos; }

	
	public JButton getBtnGuardarCambios() {return this.btnGuardarCambios;}
	public JButton getBtnCancelarCambios(){return this.btnCancelarCambios; }
	
	
	public void setIdInforme(String idInforme) { this.idInformeSeleccionado.setText(idInforme);}
	public void setIdPerito(String idPerito) { this.idPeritoSeleccionado.setText(idPerito);}

	
}

