package giis.demo.consultaInscritos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import giis.demo.solicitud.JustificanteSolicitud;
import giis.demo.solicitud.SolicitudController;
import giis.demo.solicitud.SolicitudModel;
import giis.demo.solicitud.SolicitudView;
import giis.demo.util.Database;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class mainPrueba extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPrueba frame = new mainPrueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainPrueba() {
		
		this.initialize();
	}


public void initialize() {
	setMinimumSize(new Dimension(264, 170));
	setTitle("Consulta Inscritos");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 264, 169);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	/*Database db = new Database();
	db.createDatabase(false);
	db.loadDatabase();*/
	JButton bConsulta = new JButton("Consultar Inscritos");
	bConsulta.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ConsultaInscritosController controllerInscritos = new ConsultaInscritosController(new ConsultaInscritosModel(),
					new ConsultaInscritosView());
			ConsultaInscritosController.initController();

		}
	});
	bConsulta.setBounds(45, 55, 146, 23);
	contentPane.add(bConsulta);
}


}