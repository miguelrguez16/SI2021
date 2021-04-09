package giis.demo.inscripcionesListaPeritos;

import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;

public class inscripcionesListaPeritosController {
	
	private inscripcionesListaPeritosModel modelo;
	private inscripcionesListaPeritosView vista;
	private justificanteAltaView justificante;
	
	
	public inscripcionesListaPeritosController(inscripcionesListaPeritosModel m, inscripcionesListaPeritosView v, justificanteAltaView j) {
		this.modelo=m;
		this.vista=v;
		this.justificante=j;
		this.initView();
	}
	
	private void initView() {
		vista.getFrame().setVisible(true);
		justificante.getFrame().setVisible(false);
	}
	
	public void initController() {
		vista.getBtnVerDatos().addActionListener(e -> SwingUtil.exceptionWrapper(() -> visualizarDatos()));
		
		vista.getBtnInscripcionPerito().addActionListener(e -> SwingUtil.exceptionWrapper(() -> generarInscripcionPerito()));
	}

	private void visualizarDatos() {
		int idColegiado=-1;
		String aux="";
		try {
		idColegiado=Integer.parseInt(vista.getTFidColegiado().getText());
		}catch(NumberFormatException e) {
			throw new ApplicationException("Error en el formato del idColegiado: "+vista.getTFidColegiado().getText()+" no válido.");
		}
		aux=modelo.getColegiadoNombre(idColegiado)==null?"-1":modelo.getColegiadoNombre(idColegiado);
		if(aux!="-1") {
			vista.getTFnombre().setText(modelo.getColegiadoNombre(idColegiado));
			vista.getTFapellidos().setText(modelo.getColegiadoApellidos(idColegiado));
			vista.getTFdireccion().setText(modelo.getColegiadoDireccion(idColegiado));
			vista.getTFpoblacion().setText(modelo.getColegiadoPoblacion(idColegiado));
			vista.getTFtelefono().setText(modelo.getColegiadoTelefono(idColegiado));
			vista.getTFdatos().setText(modelo.getColegiadoDatos(idColegiado));
			vista.getTFfecha().setText(modelo.getColegiadoFechaS(idColegiado));
			vista.getTFtitulacion().setText(modelo.getColegiadoTitulacion(idColegiado));
			vista.getTFcentro().setText(modelo.getColegiadoCentro(idColegiado));
			vista.getTFanio().setText(modelo.getColegiadoAnioT(idColegiado));
			vista.getTFdni().setText(modelo.getColegiadoDNI(idColegiado));
		}
		else throw new ApplicationException("El idColegiado="+idColegiado+" no existe en nuestra Base de Datos.");
	}
	
	private void generarInscripcionPerito() {
		
		int idColegiado=Integer.parseInt(vista.getTFidColegiado().getText());
		if(modelo.existePerito(idColegiado)) {
			throw new ApplicationException("Ya hay un perito con ese idColegiado.");
		}
		else{
			justificante.getFrame().setVisible(true);
			modelo.actualizarColegiadoDatos(idColegiado);
			modelo.setNuevoPerito(idColegiado);
			justificante.getLidPerito().setText(modelo.getPeritoId(idColegiado));
			justificante.getLidColegiado().setText(""+idColegiado);
			justificante.getLNombre().setText(modelo.getColegiadoNombre(idColegiado));
			justificante.getLApellidos().setText(modelo.getColegiadoApellidos(idColegiado));
			justificante.getLFecha().setText(modelo.getFecha());
			justificante.getLturno().setText(modelo.getPeritoTurno(idColegiado));
			System.out.println("Inscripcion en Perito: idColegiado="+idColegiado);
		}
		
	}
}
