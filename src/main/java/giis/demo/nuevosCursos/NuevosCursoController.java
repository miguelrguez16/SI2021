package giis.demo.nuevosCursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

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
		iniciarComboBoxProfesores();
		actualizarNuevosCursos();
	}
	
	@SuppressWarnings("unchecked")
	public void iniciarComboBoxProfesores() {
		List<nombreProfesoresDTO> nombreProfesores = modelo.getListaProfesores();
		Iterator<nombreProfesoresDTO> itr = nombreProfesores.iterator();
		vista.getProfesoresCombo().addItem(" ---- seleccionar  ---- ");
		while(itr.hasNext()) {
			nombreProfesoresDTO tmp = itr.next();
			String aux = tmp.getNombre()+ " " + tmp.getApellidos();
			vista.getProfesoresCombo().addItem(aux);
		}
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
				vista.getprecioEmpresa().setText("20");
				vista.getprecioPrecolegiado().setText("10");
				vista.getprecioEstudiante().setText("12");
				vista.getprecioExterno().setText("22");
				vista.getProfesoresCombo().setSelectedItem("Nela Lois");
				vista.getInstalacion().setText("Aulario Norte");
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
				new String[] {"idCurso","nombre","precio","fechaInicio","fechaFin","precioPrecolegiado","precioEstudiante","precioEmpresa","precioExterno","profesor","instalacion"});
		vista.getTablaCursos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTablaCursos());

	}

	private void guardarCambios() {
		String nombre,instalacion;
		nombre = vista.getNombreCurso().getText();
		instalacion = vista.getInstalacion().getText();
		comprobarDatosTexto(nombre,instalacion);		
		double precio = -1.2,precioPrecolegiado = -1.2, precioEstudiante= -1.2,precioExterno= -1.2,precioEmpresa= -1.2;

		int profesor = vista.getProfesoresCombo().getSelectedIndex();

		Date fechaInicio = Util.isoStringToDate(vista.getFechaInicio().getText());
		Date fechaFin = Util.isoStringToDate(vista.getFechaFin().getText());
		validateFechas(fechaInicio, fechaFin);

		try {
			precio = Double.parseDouble(vista.getPrecioColegiado().getText());
			precioPrecolegiado= Double.parseDouble(vista.getprecioPrecolegiado().getText());
			precioEstudiante= Double.parseDouble(vista.getprecioEstudiante().getText());
			precioExterno= Double.parseDouble(vista.getprecioExterno().getText());
			precioEmpresa= Double.parseDouble(vista.getprecioEmpresa().getText());
		} catch (NumberFormatException e) {
			throw new ApplicationException("Error en el valor de los precios los precios.");
		} finally {
			validateCondition(precio > 0, "Error en el precio de colegiados.\nDebe ser un N.ª decimal positivo Ej: '20.13'");
			validateCondition(precioPrecolegiado > 0, "Error en el precio de precolegiados.\nDebe ser un N.ª decimal positivo Ej: '20.13'");
			validateCondition(precioEstudiante > 0, "Error en el precio de estudiantes.\nDebe ser un N.ª decimal positivo Ej: '20.13'");
			validateCondition(precioExterno > 0, "Error en el precio de externos.\nDebe ser un N.ª decimal positivo Ej: '20.13'");
			validateCondition(precioEmpresa > 0, "Error en el precio de empresa.\nDebe ser un N.ª decimal positivo Ej: '20.13'");
			validateCondition(profesor !=-1, "Error al seleccionar profesor.\nDebe seleccionar uno en el Combo Box");

			modelo.setCursoNuevos(nombre, precio, fechaInicio, fechaFin, precioPrecolegiado,precioEstudiante, precioExterno, precioEmpresa,profesor,instalacion);
			actualizarNuevosCursos();
		}

	}

	private void comprobarDatosTexto(String nombre, String instalacion) {
		if (nombre == null || nombre.isEmpty()) {
			throw new ApplicationException("Error al introducir el nombre,\n No puede estar vacío");
		} else  if (modelo.existeCurso(nombre)) {
			JOptionPane.showMessageDialog(null, "El Nombre del curso ya existe, se procederá a la planificacion");
		} else if (instalacion == null || instalacion.isEmpty()){
			throw new ApplicationException("Error al introducir la instalacion,\n No puede estar vacío");
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
