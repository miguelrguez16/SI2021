package giis.demo.cursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.table.TableModel;

import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class CursoController {

	private CursoModel modelo;
	private CursoView vista;
	private String lastSelectedKey = "";

	public CursoController(CursoModel modelo, CursoView vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.initview();
	}

	public void initview() {
		System.out.println("Hola");
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

	private void setListaCursosController() {
		List<CursoDisplayDTO> cursos = modelo.getListaCursosModelo();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos,
				new String[] { "idCurso", "nombre", "fechaInicio" });
		vista.getTablaCursos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTablaCursos());
	}

	public void updateCursosPendientes() {

		this.lastSelectedKey = SwingUtil.getSelectedKey(vista.getTablaCursos());
		int idCurso = Integer.parseInt(this.lastSelectedKey);

		CursoEntity cursoSelec = modelo.getCursoSelec(idCurso);
		vista.getIDNombre().setText(cursoSelec.getIdCurso());
		vista.getCursoNombre().setText(cursoSelec.getNombre());

	}

	/*
	 * Guardar datos de la insctipcion y plazas en la base de datos
	 */
	private void guardarCambios() {
		// obtener datos
		int id = -10;
		int plazas = -10;
		Date fechaInicio, fechaFin;
		
		fechaInicio = Util.isoStringToDate(vista.getInicioInscripcion().getText());
		fechaFin = Util.isoStringToDate(vista.getFinInscripcion().getText());
		
		//comprobamos que las fechas son correctas
		validateFechasInscripcion(fechaInicio, fechaFin);
		
		
		//Comprobamos que los numero son correctpd
		try {
			id = Integer.parseInt(vista.getIDNombre().getText());
			plazas = Integer.parseInt(vista.getPlazasCurso().getText(), 10);
		} catch (NumberFormatException e) {
			throw new ApplicationException("Error en el formato del numero: '" + vista.getPlazasCurso().getText() + "' no válido");
		} finally {
			if (plazas != -10 && id != -10) {
				// llamar al modelo guardar datos
				modelo.setCursoCambios(fechaInicio, fechaFin, plazas, id);
				//restablezco la vista
				setListaCursosController();
				vista.getIDNombre().setText("");
				vista.getCursoNombre().setText("");

			} else {
				//si pasa algo con los números EXCEPCION
				throw new ApplicationException("Error en la introducion de los datos");
			}
		}
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
	
	/* De uso general para validacion de condiciones */
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}

}
