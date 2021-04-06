package giis.demo.nuevosCursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class NuevosCursoController {

	private NuevosCursoModel modelo;
	private NuevosCursoView vista;
	private Calendar c1 = Calendar.getInstance();

	public NuevosCursoController(NuevosCursoModel modelo, NuevosCursoView vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.initview();
	}

	public void initview() {
		vista.getFrame().setVisible(true);
		actualizarNuevosCursos();
	}

	// Iniciar los controladore de la vista
	public void initController() {

		vista.getBtnActualizarCurso().addActionListener(e -> SwingUtil.exceptionWrapper(() -> guardarCambios()));

		vista.getActualizarLista().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actualizarNuevosCursos()));

		vista.getRellenarDatos().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.getNombreCurso().setText("java POO");
				vista.getPrecioColegiado().setText("20");
				vista.getFechaInicio().setText("2021-05-04");
				vista.getFechaFin().setText("2021-05-10");

			}
		});
		
		vista.getVaciar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.getNombreCurso().setText("");
				vista.getPrecioColegiado().setText("");
				vista.getFechaInicio().setText("");
				vista.getFechaFin().setText("");
				
			}
		});
	}

	private void actualizarNuevosCursos() {
		List<NuevosCursoDisplayDTO> cursosNuevos = modelo.getListaCursosModelo();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursosNuevos,
				new String[] { "idCurso", "nombre", "precio", "fechaInicio", "fechaFin"});
		vista.getTablaCursos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTablaCursos());

	}

	private void guardarCambios() {
		String nombre;

		double precio = -1.2;
		nombre = vista.getNombreCurso().getText();
		comprobarDatosTexto(nombre);

		Date fechaInicio = Util.isoStringToDate(vista.getFechaInicio().getText());
		Date fechaFin = Util.isoStringToDate(vista.getFechaFin().getText());
		validateFechas(fechaInicio, fechaFin);

		try {
			precio = Double.parseDouble(vista.getPrecioColegiado().getText());
		} catch (NumberFormatException e) {
			throw new ApplicationException("Error en el numero de sesiones o en los precios.");
		} finally {
			validateCondition(precio > 0, "Error en el precio de colegiados.\nDebe ser un N.ª decimal positivo Ej: '20.13'");
			modelo.setCursoNuevos(nombre, precio, fechaInicio, fechaFin);
			actualizarNuevosCursos();
		}

	}

	private void comprobarDatosTexto(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			throw new ApplicationException("Error al introducir el nombre,\n No puede estar vacío");
		} else  if (modelo.existeCurso(nombre)) {
			JOptionPane.showMessageDialog(null, "El Nombre del curso ya existe, se procederá a la planificacion");
		} else {
		}

	}

	private void validateFechas(Date inicio, Date fin) {

		String[] fechaInicioTmp = inicio.toString().split(" ");
		String[] fechaFinTmp = fin.toString().split(" ");

		if (Integer.parseInt(fechaInicioTmp[5]) != c1.get(Calendar.YEAR)
				|| Integer.parseInt(fechaFinTmp[5]) != c1.get(Calendar.YEAR)) {
			throw new ApplicationException("El año debe ser el actual");
		}

		validateNotNull(inicio, "La fecha de inicio de inscripcion no puede ser nula");
		validateNotNull(fin, "La fecha de fin de inscripcion no puede ser nula");
		validateCondition(inicio.compareTo(fin) < 0, "La fecha de inicio no puede ser posterior a la de fin");
		validateCondition(fin.compareTo(inicio) > 0, "La fecha de fin no puede ser anterior a la de inicio");

	}

	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj == null)
			throw new ApplicationException(message);

	}

	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}

	// idCurso, nombre, fechaInicio, fechaFin, precioColegiado, precioPrecolegiado,
	// precioColectivo, profesor, instalcion, sesiones;

}
