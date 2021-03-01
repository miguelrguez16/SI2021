package giis.demo.inscripciones;

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

public class InscripcionesView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7758216415701614225L;
	private JFrame frame;
	private JTextField txtFechaHoy;
	private JButton btnTabCurso;
	private JTable tabCurso;
	private JComboBox<Object> lstCurso;
	private JTable tabDetalle;

	/**
	 * Create the application.
	 */
	public InscripcionesView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Curso");
		frame.setName("Curso");
		frame.setBounds(0, 0, 492, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		
		final JLabel lblSimulacion;
		final JLabel lblFechaHoy;

		lblSimulacion = new JLabel("Selección curso para las fechas");
		frame.getContentPane().add(lblSimulacion, "cell 0 1");
		
		lblFechaHoy = new JLabel("Nombre curso");
		frame.getContentPane().add(lblFechaHoy, "flowx,cell 0 3");
		
		txtFechaHoy = new JTextField();
		txtFechaHoy.setName("txtFechaHoy");
		frame.getContentPane().add(txtFechaHoy, "cell 0 3,growx");
		txtFechaHoy.setColumns(10);
		
		btnTabCurso = new JButton("Ver cursos en esta tabla");
		btnTabCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		lblFechaHoy.setLabelFor(btnTabCurso);
		frame.getContentPane().add(btnTabCurso, "cell 0 3");
		
		JLabel lblLbltable = new JLabel("Proximas cursos (pendientes):");
		frame.getContentPane().add(lblLbltable, "cell 0 4");
		
		//Incluyo la tabla en un JScrollPane y anado este en vez de la tabla para poder ver los headers de la tabla
		tabCurso = new JTable();
		tabCurso.setName("tabCarreras");
		tabCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabCurso.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablePanel = new JScrollPane(tabCurso);
		frame.getContentPane().add(tablePanel, "cell 0 5,grow");
		
				
		lstCurso = new JComboBox<>();
		frame.getContentPane().add(lstCurso, "cell 0 7,growx");
		
		JLabel lblAlSeleccionarLa = new JLabel("Al seleccionar la tabla (no el combo) muestra detalles");
		frame.getContentPane().add(lblAlSeleccionarLa, "cell 0 8");
		
		JLabel lblPorcentajeDescuento = new JLabel("Cursos: ");
		frame.getContentPane().add(lblPorcentajeDescuento, "flowx,cell 0 9");
		
		
		tabDetalle = new JTable();
		tabDetalle.setName("tabDetalle");
		tabDetalle.setRowSelectionAllowed(false);
		tabDetalle.setDefaultEditor(Object.class, null); //readonly
		tabDetalle.setBackground(SystemColor.control);
		JScrollPane tableDetallePanel = new JScrollPane(tabDetalle);
		tableDetallePanel.setMinimumSize(new Dimension(200,95));
		tableDetallePanel.setPreferredSize(new Dimension(300,95));
		frame.getContentPane().add(tableDetallePanel, "cell 0 10"); 
	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frame; }
	public String getFechaHoy()  { return this.txtFechaHoy.getText(); }
	public void setFechaHoy(String fechaIso)  { this.txtFechaHoy.setText(fechaIso); }
	public JButton getBtnTablaCurso() { return this.btnTabCurso; }
	public JTable getTablaCurso() { return this.tabCurso; }
	public JComboBox<Object> getListaCarreras() { return this.lstCurso; }
	public JTable getDetalleCarrera() { return this.tabDetalle; }
	
}

