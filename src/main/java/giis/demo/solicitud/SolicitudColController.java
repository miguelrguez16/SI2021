package giis.demo.solicitud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;

public class SolicitudColController {

	String DNI;
	String DNIpre;
	private SolicitudColView vistacol;
	private SolicitudPreView vistapre;
	private SolicitudColModel modelo;
	private JustificanteSolicitudCol justificante;
	private JustificanteSolicitudPre justificantepre;
	private Solicitudes sol;

	public SolicitudColController(SolicitudColModel model, SolicitudColView vistacol, JustificanteSolicitudCol justificante, SolicitudPreView vistapre, JustificanteSolicitudPre justificantepre, Solicitudes sol) {

		super();
		this.modelo = model;
		this.vistacol = vistacol;
		this.vistapre = vistapre;
		this.justificante = justificante;
		this.justificantepre = justificantepre;
		this.sol = sol;

	}

	public void initView() {
		sol.getFrame().setVisible(true);
		vistapre.getFrame().setVisible(false);
		vistacol.getFrame().setVisible(false);
		justificantepre.getFrame().setVisible(false);
		justificante.getFrame().setVisible(false);
		
		sol.getBtnCol().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sol.getFrame().setVisible(false);
				vistacol.getFrame().setVisible(true);
			}
		});
		sol.getBtnPre().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sol.getFrame().setVisible(false);
				vistapre.getFrame().setVisible(true);
			}
		});
	}

	public void intiController() {
		this.initView();
		DNI=null;
		DNIpre = null;
		vistacol.getBtnEnviar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				DNI = SolicitudColView.getDNI();
				String aux=modelo.ComprobarDNI(DNI);
				if (aux==null) {
					modelo.writeSolicitud();
					vistacol.getFrame().setVisible(false);
					justificante.getFechaSol().setText(modelo.getFecha());
					justificante.getSolicitante()
							.setText(String.valueOf(vistacol.getNombre() + " " + vistacol.getApellidos()));
					justificante.getSolicitud().setText(String.valueOf(modelo.getIDSolicitud()));
					justificante.getFrame().setVisible(true);
					vistacol.getTfDNI().setText("");
					
					
				} else {
					vistacol.getTfDNI().setText("");
					JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese DNI. Introduce uno válido");
					DNI = SolicitudColView.getDNI();
					
					
					
				} 
			}

		});
		
		vistapre.getBtnEnviarpre().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				DNIpre = SolicitudPreView.getDNIpre();
				String aux=modelo.ComprobarDNIpre(DNIpre);
				if (aux==null) {
					modelo.writeSolicitudpre();
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
					vistapre.getFrame().setVisible(false);
					justificantepre.getFechaSol().setText(modelo.getFecha());
					//justificantepre.getFechaFin().setText("2020"/*modelo.getFechaExp()*/);
					justificantepre.getFechaFin().setText(modelo.getFechaExp());
					justificantepre.getSolicitante()
							.setText(String.valueOf(vistapre.getNombrepre() + " " + vistapre.getApellidospre()));
					justificantepre.getSolicitud().setText(String.valueOf(modelo.getIDSolicitudpre()));
					justificantepre.getFrame().setVisible(true);
					vistapre.getTfDNI().setText("");
					
					
				} else {
					vistapre.getTfDNI().setText("");
					JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese DNI. Introduce uno válido");
					DNI = SolicitudPreView.getDNIpre();
					
					
					
				} 
			}

		});

		vistacol.getBtnPrueba().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				vistacol.getTfNombre().setText("Lionel Andres");
				vistacol.getTfApellidos().setText("Messi Cuccitini");
				vistacol.getTfDireccion().setText("Calle Ave del Paraiso");
				vistacol.getTfPoblacion().setText("Gijon");
				vistacol.getTfTelefono().setText("643211664");
				vistacol.getTfTitulacion().setText("Ingenieria Informatica");
				vistacol.getTfCentro().setText("Escuela Politecnica de Ingenieria");
				vistacol.getTfYear().setText("2020");
				vistacol.getTfCuenta().setText("ES21123456781234");
			}

		});
		
		vistapre.getBtnPruebapre().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				vistapre.getTfNombre().setText("Frodo");
				vistapre.getTfApellidos().setText("Bolson");
				vistapre.getTfDireccion().setText("Hobbiton");
				vistapre.getTfPoblacion().setText("La Comarca");
				vistapre.getTfTelefono().setText("323568794");
				vistapre.getTfTitulacion().setText("Ingenieria Informatica");
				vistapre.getTfCentro().setText("Escuela Politecnica de Ingenieria");
				vistapre.getTfCuenta().setText("ES21123456784567");
			}

		});

		justificante.getBtnCerrar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				justificante.getFrame().setVisible(false);
			}
		});
		
		justificantepre.getBtnCerrar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				justificantepre.getFrame().setVisible(false);
			}
		});
		
	}

}