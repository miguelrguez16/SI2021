package giis.demo.cursos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class CursoController {

	private CursoModel modelo;
	private CursoView vista;
	private String lastSelectedKey = "";
	private Calendar c1 = Calendar.getInstance();


	public CursoController(CursoModel modelo, CursoView vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.initview();

	}

	public void initview() {
		vista.getFrame().setVisible(true);
		setListaCursosController();

	}

	// Iniciar los controladore de la vista
	public void initController() {

		vista.getBtnActualizarCurso().addActionListener(e -> SwingUtil.exceptionWrapper(() -> guardarCambios()));

		vista.getTablaCursos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				SwingUtil.exceptionWrapper(() -> updateCursosPendientes());
			}
		});

		vista.getRellenarDatos().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.getInicioInscripcion().setText("2020-02-02");
				vista.getFinInscripcion().setText("2021-02-02");
				vista.getPlazasCurso().setText("43");
			}
		});
	}

	/*
	 * Guardar datos de la insctipcion y plazas en la base de datos
	 */
	private void guardarCambios() {
		// obtener datos
		int id = -10;
		int plazas = -10;
		Date fechaInicio, fechaFin, fechaId;

		fechaInicio = Util.isoStringToDate(vista.getInicioInscripcion().getText());
		fechaFin = Util.isoStringToDate(vista.getFinInscripcion().getText());

		// comprobamos que las fechas son correctas

		validateFechasInscripcion(fechaInicio, fechaFin);

		// Comprobamos que los numero son correctpd
		try {
			id = Integer.parseInt(vista.getIDNombre().getText());
			plazas = Integer.parseInt(vista.getPlazasCurso().getText(), 10);

		} catch (NumberFormatException e) {
			throw new ApplicationException(
					"Error en el formato del numero: '" + vista.getPlazasCurso().getText() + "' no válido");
		} finally {

			if (plazas >= 1 && id >= 1) {
				// llamar al modelo guardar datos
				modelo.setCursoCambios(fechaInicio, fechaFin, plazas, id);
				// restablezco la vista
				
				fechaId = Util.isoStringToDate(getFechaCursoSeleccionado(id));
				String tmp = fechaFin.toString();	
				String [] parts = tmp.split(" ");
				
				int year = Integer.parseInt(parts[5]); //Anio de la fecha actual
				
				setListaCursosController();//ACTUALIZACION DE LA VISTA
				vista.getIDNombre().setText("");
				vista.getCursoNombre().setText("");
				vista.getInicioInscripcion().setText("");
				vista.getFinInscripcion().setText("");
				vista.getPlazasCurso().setText("");
				
				if (validateFechaCorrecta(fechaId, fechaFin) || year < c1.get(Calendar.YEAR)) {
					throw new ApplicationException("AVISO: lainscripcion no es correcta respecto a la de Inicio"
							+ "\n Se procederá al registro de la fecha igualmente");
				}
				
			} else {
				// si pasa algo con los números EXCEPCION
				throw new ApplicationException("falta seleccionar Id o rellenar el nº de plazas");
			}
		}
	}

	private void setListaCursosController() {
		List<CursoDisplayDTO> cursos = modelo.getListaCursosModelo();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos,
				new String[] { "idCurso", "nombre", "fechaInicio" });
		vista.getTablaCursos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTablaCursos());
	}

	private boolean validateFechaCorrecta(Date inicio, Date fin) {
		return inicio.compareTo(fin) <= 0;
	}

	/*
	 * Comprobante de que las fechas son correctas
	 */
	private void validateFechasInscripcion(Date inicio, Date fin) {

		validateNotNull(inicio, "La fecha de inicio de inscripcion no puede ser nula");
		validateNotNull(fin, "La fecha de fin de inscripcion no puede ser nula");
		validateCondition(inicio.compareTo(fin) < 0, "La fecha de inicio no puede ser posterior a la de fin");
		validateCondition(fin.compareTo(inicio) > 0, "La fecha de fin no puede ser posterior a la de la carrera");
	}

	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj == null)
			throw new ApplicationException(message);

	}

	public void updateCursosPendientes() {

		this.lastSelectedKey = SwingUtil.getSelectedKey(vista.getTablaCursos());
		int idCurso = Integer.parseInt(this.lastSelectedKey);

		CursoEntity cursoSelec = modelo.getCursoSelec(idCurso);
		vista.getIDNombre().setText(cursoSelec.getIdCurso());
		vista.getCursoNombre().setText(cursoSelec.getNombre());

	}

	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}

	/*
	 * Devuelve la fecha de inicio de
	 */
	private String getFechaCursoSeleccionado(int id) {
		CursoEntity cursoSelec = modelo.getCursoSelec(id);
		return cursoSelec.getFechaInicio();

	}

}
