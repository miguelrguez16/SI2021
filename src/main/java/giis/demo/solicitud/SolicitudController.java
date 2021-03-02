package giis.demo.solicitud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import giis.demo.util.SwingUtil;

public class SolicitudController {
		
	private SolicitudView vista;
	private SolicitudModel modelo;
	private JustificanteSolicitud justificante;
	public SolicitudController (SolicitudModel model, SolicitudView vista, JustificanteSolicitud justificante) {
		
		super();
		this.modelo = model;
		this.vista = vista;
		this.justificante = justificante;
		
	}
	
	
	public void intiController () {
		
		vista.getBtnEnviar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				modelo.writeSolicitud();
				System.out.print("Se han introducido los siguientes datos:\nDNI: "+SolicitudView.getDNI()+"\nNombre: "+SolicitudView.getNombre()+"\nApellidos: "+SolicitudView.getApellidos()+
						"\nDireccion: "+SolicitudView.getDireccion()+"\nPoblacion: "+SolicitudView.getTelefono()+"\nTitulacion: "+SolicitudView.getTitulacion()+"\nCentro: "+SolicitudView.getCentro()+
						"\nAño Titulo: "+SolicitudView.getYear()+"\nIBAN: "+SolicitudView.getCuenta()+"\nFecha Solicitud: "+modelo.getFecha());
				vista.getFrame().setVisible(false);
				justificante.getFechaSol().setText(modelo.getFecha());
				justificante.getFrame().setVisible(true);
				
			}
			
			
		
		});
		
		vista.getBtnPrueba().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				vista.getTfDNI().setText("53458992S");
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
	
	public void initView() {
		vista.getFrame().setVisible(true);
		justificante.getFrame().setVisible(false);
	}

	
}
