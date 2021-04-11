package giis.demo.inscripcionesListaPeritos;

import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;

public class inscripcionesListaPeritosController {

	private inscripcionesListaPeritosModel modelo;
	private inscripcionesListaPeritosView vista;
	private justificanteAltaView justificante;

	public inscripcionesListaPeritosController(inscripcionesListaPeritosModel m, inscripcionesListaPeritosView v,
			justificanteAltaView j) {
		this.modelo = m;
		this.vista = v;
		this.justificante = j;
		this.initView();
	}

	private void initView() {
		vista.getFrame().setVisible(true);
		justificante.getFrame().setVisible(false);
	}

	public void initController() {
		vista.getBtnVerDatos().addActionListener(e -> SwingUtil.exceptionWrapper(() -> visualizarDatos()));

		vista.getBtnInscripcionPerito().addActionListener(e -> SwingUtil.exceptionWrapper(() -> generarInscripcionPerito()));
		
		vista.getBtnReset().addActionListener(e -> SwingUtil.exceptionWrapper(() -> reset()));
	}

	private void visualizarDatos() {
		int idColegiado = -1;
		String aux = "";
		try {
			idColegiado = Integer.parseInt(vista.getTFidColegiado().getText());
		} catch (NumberFormatException e) {
			throw new ApplicationException(
					"Error en el formato del idColegiado: " + vista.getTFidColegiado().getText() + " no válido.");
		} finally {
			aux = modelo.getColegiadoNombre(idColegiado) == null ? "" : modelo.getColegiadoNombre(idColegiado);
			if (!aux.equals("")) {
				System.out.println("Id colegiado elegido: " +idColegiado);
				vista.getLid().setText(vista.getTFidColegiado().getText());
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
				vista.getTFidColegiado().setEnabled(false);
				vista.getBtnVerDatos().setEnabled(false);
				vista.getBtnInscripcionPerito().setEnabled(true);
			} else {
				vista.getTFnombre().setText("");
				vista.getTFapellidos().setText("");
				vista.getTFdireccion().setText("");
				vista.getTFpoblacion().setText("");
				vista.getTFtelefono().setText("");
				vista.getTFdatos().setText("");
				vista.getTFfecha().setText("");
				vista.getTFtitulacion().setText("");
				vista.getTFcentro().setText("");
				vista.getTFanio().setText("");
				vista.getTFdni().setText("");
				vista.getBtnVerDatos().setEnabled(true);
				vista.getBtnInscripcionPerito().setEnabled(false);
				throw new ApplicationException(	"El idColegiado=" + idColegiado + " no existe en nuestra Base de Datos.");
			}
		}
	}

	private void generarInscripcionPerito() {

		int idColegiado = Integer.parseInt(vista.getTFidColegiado().getText());
		if (modelo.existePerito(idColegiado)) {
			throw new ApplicationException("Ya hay un perito con ese idColegiado.");
		} else {
			if(vista.getTFnombre().getText().isEmpty()) {
				throw new ApplicationException("Los datos del colegiado deben estar rellenados.");
			}
			justificante.getFrame().setVisible(true);
			modelo.actualizarColegiadoDatos(idColegiado);
			modelo.setNuevoPerito(idColegiado);
			justificante.getLidPerito().setText(modelo.getPeritoId(idColegiado));
			justificante.getLidColegiado().setText("" + idColegiado);
			justificante.getLNombre().setText(modelo.getColegiadoNombre(idColegiado));
			justificante.getLApellidos().setText(modelo.getColegiadoApellidos(idColegiado));
			justificante.getLFecha().setText(modelo.getFecha());
			justificante.getLturno().setText(modelo.getPeritoTurno(idColegiado));
			System.out.println("Inscripcion en Perito: idColegiado=" + idColegiado);
		}
	}
	
	private void reset() {
		vista.getLid().setText("");
		vista.getTFidColegiado().setEnabled(true);
		vista.getTFidColegiado().setText("");
		vista.getTFnombre().setText("");
		vista.getTFapellidos().setText("");
		vista.getTFdireccion().setText("");
		vista.getTFpoblacion().setText("");
		vista.getTFtelefono().setText("");
		vista.getTFdatos().setText("");
		vista.getTFfecha().setText("");
		vista.getTFtitulacion().setText("");
		vista.getTFcentro().setText("");
		vista.getTFanio().setText("");
		vista.getTFdni().setText("");
		vista.getBtnVerDatos().setEnabled(true);
		vista.getBtnInscripcionPerito().setEnabled(false);
	}
}
