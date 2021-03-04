package AsignacionInformes;

import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.TableModel;

import giis.demo.util.SwingUtil;

public class AsignacionInformesController {

	private AsignacionInformesModel modelo;
	private AsignacionInformesView vista;

	public AsignacionInformesController(AsignacionInformesModel modelo, AsignacionInformesView vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.initview();
	}

	public void initview() {
		vista.getFrame().setVisible(true);
		

	}

	// Iniciar los controladore de la vista
	public void initController() {
		
		vista.getBtnGuardarCambios().addActionListener(e -> SwingUtil.exceptionWrapper(()-> guardarAsignacionInformes()));
		vista.getBtnCancelarCambios().addActionListener(e -> SwingUtil.exceptionWrapper(()-> cancelarCambios()));
		
		vista.getTabInformes().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				SwingUtil.exceptionWrapper(() -> updateInformes());
			}

		});
		
		vista.getTabPeritos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				SwingUtil.exceptionWrapper(() -> updatePeritos());
			}

		});

	}
	
	private void updateInformes() {
		List<InformeDisplayDTO> info = modelo.getInfomes("pendiente");
		TableModel tmodelInformes = SwingUtil.getTableModelFromPojos(info,
				new String[] { "idInforme", "estado"});
		vista.getTabInformes().setModel(tmodelInformes);
		SwingUtil.autoAdjustColumns(vista.getTabInformes());

	}
	
	private void updatePeritos() {
		List<PeritoDisplayDTO> peritos = modelo.getPeritos();
		TableModel tmodelInformes = SwingUtil.getTableModelFromPojos(peritos,
				new String[] { "idPerito", "nombre"});
		vista.getTabInformes().setModel(tmodelInformes);
		SwingUtil.autoAdjustColumns(vista.getTabInformes());
	}	
	

	private void guardarAsignacionInformes() {
		// TODO Auto-generated method stub
	}
	
	private void cancelarCambios() {
		// TODO Auto-generated method stub
	}

}
