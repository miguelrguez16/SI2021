package giis.demo.EmisionRecepcionCobro;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.SwingConstants;





public class EmisionRecepcionView extends JFrame {



	private static final long serialVersionUID = 59272130249980170L;

	private JFrame frame;
	private JTable tabColegiadosPrecolegiados;
	private JLabel lblLbltable;
	private JButton btnEmitirRecibos;
	private JButton btnRecibirRecibos;


	/**
	 * Create the application.
	 */
	public EmisionRecepcionView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Emision y Recibo de cobros");
		frame.setName("Emision y Recibo de cobros");

		frame.setBounds(0, 0, 667, 429);

		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		
		lblLbltable = new JLabel("Lista de Colegiados y Precolegiados");
		lblLbltable.setHorizontalAlignment(SwingConstants.CENTER);
		lblLbltable.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLbltable.setToolTipText("Center");

		lblLbltable.setBounds(10, 11, 633, 20);

		frame.getContentPane().add(lblLbltable);
		
		//Incluyo la tabla en un JScrollPane y anado este en vez de la tabla para poder ver los headers de la tabla
		tabColegiadosPrecolegiados = new JTable();
		tabColegiadosPrecolegiados.setName("tab");
		tabColegiadosPrecolegiados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabColegiadosPrecolegiados.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablePanel = new JScrollPane(tabColegiadosPrecolegiados);

		tablePanel.setBounds(7, 41, 643, 291);

		frame.getContentPane().add(tablePanel);
	
		btnEmitirRecibos = new JButton("Emitir Recibos");
		btnEmitirRecibos.setBounds(509, 352, 141, 31);
		frame.getContentPane().add(btnEmitirRecibos);
		
		btnRecibirRecibos = new JButton("Recepción Recibos");
		btnRecibirRecibos.setBounds(328, 352, 150, 31);
		frame.getContentPane().add(btnRecibirRecibos);

	}

	//Getters y Setters anadidos para acceso desde el controlador (representacion compacta)
	public JFrame getFrame() { return this.frame; }

	public JTable gettabColegiadosPrecolegiados() { return this.tabColegiadosPrecolegiados; }
	public JButton getBtnEmisionCobro() {return this.btnEmitirRecibos;}
	public JButton getBtnRecepcionCobro() {return this.btnRecibirRecibos;}

}


