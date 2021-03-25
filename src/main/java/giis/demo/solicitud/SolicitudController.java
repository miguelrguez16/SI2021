package giis.demo.solicitud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;

public class SolicitudController {

	String DNI;
	private SolicitudView vista;
	private SolicitudModel modelo;
	private JustificanteSolicitud justificante;

	public SolicitudController(SolicitudModel model, SolicitudView vista, JustificanteSolicitud justificante) {

		super();
		this.modelo = model;
		this.vista = vista;
		this.justificante = justificante;

	}

	public void initView() {
		vista.getFrame().setVisible(true);
		justificante.getFrame().setVisible(false);
	}

	public void intiController() {
		this.initView();
		DNI=null;
		vista.getBtnEnviar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				DNI = SolicitudView.getDNI();
				String aux=modelo.ComprobarDNI(DNI);
				if (aux==null) {
					modelo.writeSolicitud();
					/*
					 * System.out.print("Se han introducido los siguientes datos:\nDNI: "
					 * +SolicitudView.getDNI()+"\nNombre: "+SolicitudView.getNombre()
					 * +"\nApellidos: "+SolicitudView.getApellidos()+
					 * "\nDireccion: "+SolicitudView.getDireccion()+"\nPoblacion: "+SolicitudView.
					 * getTelefono()+"\nTitulacion: "+SolicitudView.getTitulacion()+"\nCentro: "
					 * +SolicitudView.getCentro()+
					 * "\nAño Titulo: "+SolicitudView.getYear()+"\nIBAN: "+SolicitudView.getCuenta()
					 * +"\nFecha Solicitud: "+modelo.getFecha());
					 */
					vista.getFrame().setVisible(false);
					justificante.getFechaSol().setText(modelo.getFecha());
					justificante.getSolicitante()
							.setText(String.valueOf(vista.getNombre() + " " + vista.getApellidos()));
					justificante.getSolicitud().setText(String.valueOf(modelo.getIDSolicitud()));
					justificante.getFrame().setVisible(true);
					vista.getTfDNI().setText("");
					
					
				} else {
					vista.getTfDNI().setText("");
					JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese DNI. Introduce uno válido");
					DNI = SolicitudView.getDNI();
					
					
					//vista.setVisible(true);
				} /* throw new ApplicationException(mensaje); */
			}

		});

		vista.getBtnPrueba().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				vista.getTfNombre().setText("Lionel Andres");
				vista.getTfApellidos().setText("Messi Cuccitini");
				vista.getTfDireccion().setText("Calle Ave del Paraiso");
				vista.getTfPoblacion().setText("Gijon");
				vista.getTfTelefono().setText("643211664");
				vista.getTfTitulacion().setText("Ingenieria Informatica");
				vista.getTfCentro().setText("Escuela Politecnica de Ingenieria");
				vista.getTfYear().setText("2020");
				vista.getTfCuenta().setText("ES21123456781234");
			}

		});

		justificante.getBtnCerrar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				justificante.getFrame().setVisible(false);
			}
		});
	}

}
