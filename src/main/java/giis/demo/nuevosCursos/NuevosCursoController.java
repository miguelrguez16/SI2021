package giis.demo.nuevosCursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
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
				vista.getNombreProfesor().setText("Paquito");
				vista.getInstalacion().setText("Colegio Oficial");
				vista.getNumeroSesiones().setText("4");
				vista.getPrecioColegiado().setText("20");
				vista.getPrecioPrecolegiado().setText("22");
				vista.getPrecioColectivo().setText("23");
				vista.getFechaInicio().setText("2021-05-04");
				vista.getFechaFin().setText("2021-05-10");

			}
		});
		
		vista.getVaciar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.getNombreCurso().setText("");
				vista.getNombreProfesor().setText("");
				vista.getInstalacion().setText("");
				vista.getNumeroSesiones().setText("");
				vista.getPrecioColegiado().setText("");
				vista.getPrecioPrecolegiado().setText("");
				vista.getPrecioColectivo().setText("");
				vista.getFechaInicio().setText("");
				vista.getFechaFin().setText("");
				
			}
		});
	}

	private void actualizarNuevosCursos() {
		List<NuevosCursoDisplayDTO> cursosNuevos = modelo.getListaCursosModelo();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursosNuevos,
				new String[] { "idCurso", "nombre", "precio", "fechaInicio", "fechaFin", "precioPrecolegiado",
						"precioColectivo", "profesor", "instalacion", "sesiones" });
		vista.getTablaCursos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTablaCursos());

	}

	private void guardarCambios() {
		String nombre, profesor, instalacion;

		int sesiones = -1;
		double precio = -1.2, precioPrecolegiado = -1.3, precioColectivo = -1.4;

		nombre = vista.getNombreCurso().getText();
		profesor = vista.getNombreProfesor().getText();
		instalacion = vista.getInstalacion().getText();
		comprobarDatosTexto(nombre, profesor, instalacion);

		Date fechaInicio = Util.isoStringToDate(vista.getFechaInicio().getText());
		Date fechaFin = Util.isoStringToDate(vista.getFechaFin().getText());
		validateFechas(fechaInicio, fechaFin);

		try {
			sesiones = Integer.parseInt(vista.getNumeroSesiones().getText());
			precio = Double.parseDouble(vista.getPrecioColegiado().getText());
			precioPrecolegiado = Double.parseDouble(vista.getPrecioPrecolegiado().getText());
			precioColectivo = Double.parseDouble(vista.getPrecioColectivo().getText());
		} catch (NumberFormatException e) {
			throw new ApplicationException("Error en el numero de sesiones o en los precios.");
		} finally {
			validateCondition(sesiones > 1, "Error en el numero de sesiones.\nDebe ser un N.ª natural");
			validateCondition(precio > 0, "Error en el precio de colegiados.\nDebe ser un N.ª positivo");
			validateCondition(precioPrecolegiado > 0, "Error en el precio de colegiados.\nDebe ser un N.ª positivo");
			validateCondition(precioColectivo > 0, "Error en el precio de colegiados.\nDebe ser un N.ª positivo");

			//System.out.println("Sesiones: " + sesiones);
			//System.out.println("Precios-> Colegiado: " + precio + "precolegiado: " + precioPrecolegiado + "Colectivo: " + precioColectivo);
			modelo.setCursoNuevos(nombre, precio, fechaInicio, fechaFin, precioPrecolegiado, precioColectivo, profesor, instalacion, sesiones);
			actualizarNuevosCursos();
		}

	}

	private void comprobarDatosTexto(String nombre, String profesor, String instalacion) {
		if (nombre == null || nombre.isEmpty()) {
			throw new ApplicationException("Error al introducir el nombre,\n No puede estar vacío");
		}else if(modelo.existeCurso(nombre)){
			throw new ApplicationException("Error al introducir el nombre,\n Ya existe para este año");
		}else if (profesor == null) {
			throw new ApplicationException("Error al introducir el profesor,\n No puede estar vacío");
		} else if (instalacion == null) {
			throw new ApplicationException("Error al introducir la instalacion,\n No puede estar vacío");
		} else {
			System.out.println("Datos introducidos: " + nombre + " ->" + profesor + " -> " + instalacion);
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

		//System.out.println("Fechas: inicio -> " + Util.dateToIsoString(inicio.));
		//System.out.println("Fechas: fin -> " + Util.dateToIsoString(fin));

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
