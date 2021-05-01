package giis.demo.EmisionRecepcionCobro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;

public class EmisionRecepcionController {

	private EmisionRecepcionModel model;
	private EmisionRecepcionView vista;

	Calendar c1 = Calendar.getInstance();

	public EmisionRecepcionController(EmisionRecepcionModel modelo, EmisionRecepcionView vista) {
		super();
		this.model = modelo;
		this.vista = vista;
		this.initview();
	}

	public void initview() {
		vista.getFrame().setVisible(true);
		setlistaColegiadosPrecolegiados();
	}

	public void initController() {
		vista.getBtnEmisionCobro().addActionListener(e -> SwingUtil.exceptionWrapper(() -> emitirCobro()));
		vista.getBtnRecepcionCobro().addActionListener(e -> SwingUtil.exceptionWrapper(() -> RecibirCobro()));
	}

	private void emitirCobro() {
		List<EmisionRecepcionDTO> lista = model.getListaEmisionCobro1(this.getFechaPrimerDiaAnio());
		if (lista.isEmpty()) {
			throw new ApplicationException("Los recibos para este año ya han sido emitidos");
		} else {
			File fichero = new File(".", "Emision1Recibos.txt");

			try {
				fichero.createNewFile();
				FileWriter fw = new FileWriter(fichero);
				BufferedWriter bw = new BufferedWriter(fw);

				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getTipo().equals("Colegiado")) {
						bw.write("Nombre completo: " + lista.get(i).getNombre() + " " + lista.get(i).getApellidos()
								+ "\tDNI: " + lista.get(i).getDni() + "\tCantidad: 130€ " + "\tCuenta Cargo: "
								+ lista.get(i).getNumeroCuenta() + "\tNúmero Recibo: " + i + "\tFecha: " + getFecha()
								+ "\n");
						model.actualizarPrimeraEmisionColegiado(lista.get(i).getDni(), getFecha());

					} else if (lista.get(i).getTipo().equals("Precolegiado")) {
						bw.write("Nombre completo: " + lista.get(i).getNombre() + " " + lista.get(i).getApellidos()
								+ "\tDNI: " + lista.get(i).getDni() + "\tCantidad: 100€ " + "\tCuenta Cargo: "
								+ lista.get(i).getNumeroCuenta() + "\tNúmero Recibo: " + i + "\tFecha: " + getFecha()
								+ "\n");
						model.actualizarPrimeraEmisionPrecolegiado(lista.get(i).getDni(), getFecha());
					}

				}
				bw.close();

				setlistaColegiadosPrecolegiados();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void RecibirCobro() {
		List<EmisionRecepcionDTO> lista = model.getListaEmisionCobro1(this.getFechaPrimerDiaAnio());
		List<EmisionRecepcionDTO> variosSinRecibir = model.getQuedanSinCobrar();

		if (!lista.isEmpty()) {
			throw new ApplicationException("Aún quedan recibos por emitir");

		} else if (!variosSinRecibir.isEmpty()) {
			JFileChooser chooser = new JFileChooser();

			int returnVal = chooser.showOpenDialog(vista);
			if (!(returnVal == JFileChooser.APPROVE_OPTION)) {
				throw new ApplicationException("Error en la seleccion del fichero de Recepcion");
			} else {
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsoluteFile()));
					String line = br.readLine();
					while (null != line) {
						String[] fields = line.split(" ");
						String dni, estado;
						dni = fields[0];
						estado = comprobarEstado(fields[1]);
						if (!estado.equals("error")) {
							actualizarRecibo(dni, estado);
						}
						line = br.readLine();
					}
				} catch (IOException e) {
					throw new ApplicationException("Error apertura fichero lectura");
				} finally {
					if (null != br) {
						try {
							br.close();
							setlistaColegiadosPrecolegiados();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} else {
			throw new ApplicationException(
					"Ya se han obtenido los recibos de cobro para este año\n");
		}

	}

	private String comprobarEstado(String estado) {
		if (estado.equals("No")) {
			return "No cobrado";
		} else if (estado.equals("cobrado")) {
			return "cobrado";
		} else {
			return "error";
		}

	}

	private void actualizarRecibo(String dni, String estado) {
		if (model.esColegiado(dni)) {
			if (model.getEstadoColegiado(estado, dni)) {
				model.actualizarReciboColegiado1(dni, estado, getFecha());
			} // else {System.out.println("Existe " + dni + " estado: " + estado);}
		} else if (model.esPrecolegiado(dni)) {
			if (model.getEstadoPrecolegiado(estado, dni)) {
				model.actualizarReciboPrecolegiado1(dni, estado, getFecha());
			} // else {System.out.println("Existe " + dni + " estado: " + estado);}
		} else {
			System.out.println("El dni: "+ dni + "nun existe");
			//JOptionPane.showMessageDialog(null, "El dni: " + dni + " no existe en la base de datos");
		}
	}

	private void setlistaColegiadosPrecolegiados() {// model.getListaColegiadosPrecolegiados();
		List<EmisionRecepcionDTO> colegiadosPrecolegiados = model.getListaCompleta();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(colegiadosPrecolegiados, new String[] { "numero", "tipo",
				"nombre", "apellidos", "estadoRecibos", "fechaEmision", "fechaCobro", "fechaReclamacion" }); // ,"dni","numeroCuenta"
																												// });
		vista.gettabColegiadosPrecolegiados().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.gettabColegiadosPrecolegiados());

	}

	/*
	 * Devuelve la fecha actual del sistema YEAR-MONTH-DAY
	 */
	public String getFecha() {
		StringBuilder fecha = new StringBuilder();
		String tmp;
		tmp = Integer.toString(c1.get(Calendar.YEAR));
		fecha.append(tmp + "-");
		tmp = "";
		tmp = (c1.get(Calendar.MONTH) + 1 < 10) ? (String) ("0" + Integer.toString(c1.get(Calendar.MONTH) + 1))
				: (String) (Integer.toString(c1.get(Calendar.MONTH) + 1));
		fecha.append(tmp + "-");

		tmp = (c1.get(Calendar.DATE) < 10) ? (String) ("0" + Integer.toString(c1.get(Calendar.DATE)))
				: (String) (Integer.toString(c1.get(Calendar.DATE)));
		fecha.append(tmp);

		// System.out.println(fecha.toString());
		return fecha.toString();
	}

	public String getFechaPrimerDiaAnio() {
		StringBuilder fecha = new StringBuilder();
		String tmp;
		tmp = Integer.toString(c1.get(Calendar.YEAR));
		fecha.append(tmp + "-01-01");
		return fecha.toString();
	}

	public String getFechaPrimerFinAnio() {
		StringBuilder fecha = new StringBuilder();
		String tmp;
		tmp = Integer.toString(c1.get(Calendar.YEAR + 1));
		fecha.append(tmp + "-01-01");
		return fecha.toString();
	}

}
