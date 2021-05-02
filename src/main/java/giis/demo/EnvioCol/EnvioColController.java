package giis.demo.EnvioCol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import giis.demo.cursos.CursoDisplayDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class EnvioColController {

	private static EnvioColModel modelo;
	private static EnvioColView vista;
	private String lastSelectedKey = "";

	public EnvioColController(EnvioColModel modelo, EnvioColView vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
	}

	public static void initview() {

		vista.getFrame().setVisible(true);

	}

	// Iniciar los controladore de la vista
	public void initController() {
		initview();
		setListaCursosController();

		vista.getBtnEnviar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// C:\\Users\\Alvaro\\Desktop
				if (modelo.compruebaPendientes() != null) {

					JFileChooser chooser = new JFileChooser();
					chooser.setCurrentDirectory(new File("/home/me/Documents"));
					int retrival = chooser.showSaveDialog(null);
					if (retrival == JFileChooser.APPROVE_OPTION) {
						try {
							FileWriter fw = new FileWriter(chooser.getSelectedFile() + ".txt");
							BufferedWriter bw = new BufferedWriter(fw);

							List<EnvioColDisplayDTO> envio = modelo.getListaCursosModelo();
							for (int i = 0; i < envio.size(); i++) {
								String aux = envio.get(i).getEstado();
								if (aux.contentEquals("pendiente")) {

									bw.write(envio.get(i).getDni() + ";" + envio.get(i).getTitulacion() + "\n");
								}

							}

							bw.close();
							modelo.updateEstado();
							setListaCursosController();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				} else
					JOptionPane.showMessageDialog(null, "No hay ninguna solicitud pendiente");
			}
		});

		vista.getBtnCerrar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				vista.getFrame().setVisible(false);
			}
		});

		vista.getBtnActualizar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setListaCursosController();
			}
		});

		vista.getBtnRecibir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modelo.compruebaEnTramite() != null) {
					JFileChooser chooser = new JFileChooser();
					// FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", ".csv");
					// chooser.setFileFilter(filter);
					int returnVal = chooser.showOpenDialog(vista);
					if (!(returnVal == JFileChooser.APPROVE_OPTION)) {
						throw new ApplicationException("Error en la selección del fichero de Recepcion");
					} else {
						// System.out.println("You chose to open this file: " +
						// chooser.getSelectedFile().getName());
						BufferedReader br = null;
						try {
							br = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsoluteFile()));
							String line = br.readLine();
							while (line != null) {
								String[] fields = line.split(";");
								// System.out.println(Arrays.toString(fields));
								String dni, titulo;
								dni = fields[0];
								// System.out.println(dni);
								titulo = fields[1];
								// System.out.println(titulo);
								if (titulo.contentEquals("Ing. Informática") || titulo.contentEquals("Master Ing. Informática")
										|| titulo.contentEquals("Lic. Informática")) {
									modelo.updateEstadoAprobado(modelo.getIDColegiado(dni), modelo.getFechaHoy());
									setListaCursosController();
								}

								else {
									modelo.updateEstadoCancelado(modelo.getIDColegiado(dni), modelo.getFechaHoy());
									setListaCursosController();
								}

								line = br.readLine();

							}
						} catch (IOException e1) {
							throw new ApplicationException("Error apertura fichero lectura");
						} finally {
							if (null != br) {
								try {
									br.close();
									justificanteAceptados();
									justificanteNoAceptados();
									// setlistaColegiadosPrecolegiados();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}

				} else
					JOptionPane.showMessageDialog(null, "No hay ninguna solicitud en trámite");
			}

		});
	}

	private static void setListaCursosController() {
		List<EnvioColDisplayDTO> cursos = modelo.getListaCursosModelo();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos,
				new String[] { "apellidos", "nombre", "dni", "titulacion", "fechaSolicitudColegiado", "estado" });
		vista.getTablaCursos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTablaCursos());
	}

	public void justificanteAceptados() {
		File file = new File (".","Aceptados "+modelo.getFechaHoy()+".txt");

		try {
			BufferedWriter bw;
			bw = new BufferedWriter (new FileWriter(file));
			List<EnvioColDisplayDTO> envio = modelo.getListaCursosModelo();
			bw.write("Lista Solicitudes de colegiación denegadas "+modelo.getFechaHoy()+"\n\n");
			for (int i = 0; i < envio.size(); i++) {
				String aux = envio.get(i).getEstado();

				if (aux.contentEquals("aprobado") && modelo.getFechaHoy().equals(envio.get(i).getFechaSolicitudColegiado())) {


					bw.write("DNI: " + envio.get(i).getDni() + "\nNombre: " + envio.get(i).getNombre() + "\nApellidos: " + envio.get(i).getApellidos() + 
							"\nFecha: " + envio.get(i).getFechaSolicitudColegiado()+"\n"+"Num. Colegiado: "+modelo.getIDColegiado(envio.get(i).getDni())+"\n");
					bw.write("---------------------------------------------------\n");
				}

			}

			bw.close();
			//modelo.updateEstado();
			//setListaCursosController();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void justificanteNoAceptados() {
		File file = new File (".","Denegados "+modelo.getFechaHoy()+".txt");

		try {
			BufferedWriter bw;
			bw = new BufferedWriter (new FileWriter(file));
			List<EnvioColDisplayDTO> envio = modelo.getListaCursosModelo();
			bw.write("Lista Solicitudes de colegiación admitidas "+modelo.getFechaHoy()+"\n\n");
			for (int i = 0; i < envio.size(); i++) {
				String aux = envio.get(i).getEstado();

				if (aux.contentEquals("Desestimada") && modelo.getFechaHoy().equals(envio.get(i).getFechaSolicitudColegiado())) {


					bw.write("DNI: " + envio.get(i).getDni() + "\nNombre: " + envio.get(i).getNombre() + "\nApellidos: " + envio.get(i).getApellidos() + 
							"\nFecha: " + envio.get(i).getFechaSolicitudColegiado()+"\n");
				
					bw.write("---------------------------------------------------\n");
				}

			}

			bw.close();
			//modelo.updateEstado();
			//setListaCursosController();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}


