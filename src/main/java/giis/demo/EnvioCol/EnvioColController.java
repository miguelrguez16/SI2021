package giis.demo.EnvioCol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
						//C:\\Users\\Alvaro\\Desktop
						File fichero = new File (".","EnvioCol.txt");
						
						try {
							fichero.createNewFile();
							FileWriter fw = new FileWriter(fichero);
							BufferedWriter bw = new BufferedWriter(fw);
							
							List<EnvioColDisplayDTO> envio = modelo.getListaCursosModelo();
							for(int i=0;i<envio.size();i++) {
								bw.write("DNI: "+envio.get(i).getDni()+" Titulacion :"+envio.get(i).getTitulacion()+"\n\n");
								//bw.write("Titulacion: "+envio.get(i).getTitulacion()+"\n");
							}
							
							bw.close();
							modelo.updateEstado();
							setListaCursosController();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			
			 
		vista.getBtnCerrar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				vista.getFrame().setVisible(false);
				}
			});
		
		vista.getBtnActualizar().addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				setListaCursosController();
			}
		});
		}
	
	private static void setListaCursosController() {
		List<EnvioColDisplayDTO> cursos = modelo.getListaCursosModelo();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos,
				new String[] { "apellidos", "nombre", "dni", "titulacion", "estado" });
		vista.getTablaCursos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTablaCursos());
	}
	
}