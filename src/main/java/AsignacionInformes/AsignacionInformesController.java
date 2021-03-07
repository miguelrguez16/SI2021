package AsignacionInformes;

import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.TableModel;

import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;

public class AsignacionInformesController {

	private AsignacionInformesModel modelo;
	private AsignacionInformesView vista;

	private String lastInformeSelected = "";
	private String lastPeritoSelected = "";
	private int keyPerito, keyInforme;

	public AsignacionInformesController(AsignacionInformesModel modelo, AsignacionInformesView vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.initview();
		keyInforme = 0;
		keyInforme = 0;
	}

	public void initview() {
		vista.getFrame().setVisible(true);
		showPeritosInformes();

	}

	// Iniciar los controladore de la vista
	public void initController() {

		vista.getBtnGuardarCambios()
				.addActionListener(e -> SwingUtil.exceptionWrapper(() -> guardarAsignacionInformes()));
		vista.getBtnCancelarCambios().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cancelarCambios()));

		vista.getTablaInformes().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				SwingUtil.exceptionWrapper(() -> updateInformes());
			}

		});

		vista.getTablaPeritos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				SwingUtil.exceptionWrapper(() -> updatePeritos());
			}
		});

	}

	private void updateInformes() {
		this.lastInformeSelected = SwingUtil.getSelectedKey(vista.getTablaInformes());
		System.out.println("Selecciono el informe: " + lastInformeSelected);

		vista.getIDInforme().setText(lastInformeSelected);
		keyInforme = Integer.parseInt(lastInformeSelected);

	}

	private void updatePeritos() {
		this.lastPeritoSelected = SwingUtil.getSelectedKey(vista.getTablaPeritos());
		// int idPerito = Integer.parseInt(this.lastPeritoSelected);
		System.out.println("Selecciono el perito: " + lastPeritoSelected);

		vista.getIDPerito().setText(lastPeritoSelected);
		keyPerito = Integer.parseInt(lastPeritoSelected);
	}

	private void guardarAsignacionInformes() {
		if (keyPerito == 0 || keyInforme == 0) {
			validateCondition(false, "Falta seleccionar datos");
		} else {
			modelo.asignarInforme(keyInforme, keyPerito);
			keyPerito = 0;
			keyInforme = 0;
			vista.getIDInforme().setText("");
			vista.getIDPerito().setText("");
			showPeritosInformes();
		}

	}

	private void cancelarCambios() {
		keyPerito = 0;
		keyInforme = 0;
		vista.getIDInforme().setText("");
		vista.getIDPerito().setText("");
		showPeritosInformes();
	}

	private void showPeritosInformes() {
		List<InformeDisplayDTO> info = modelo.getInfomes("pendiente");
		TableModel tmodelInformes = SwingUtil.getTableModelFromPojos(info,
				new String[] { "idInformePerito", "estado" });
		vista.getTablaInformes().setModel(tmodelInformes);
		SwingUtil.autoAdjustColumns(vista.getTablaInformes());

		List<PeritoDisplayDTO> peritos = modelo.getPeritos();
		TableModel tmodelPeritos = SwingUtil.getTableModelFromPojos(peritos, new String[] { "idPerito", "nombre" });
		vista.getTablaPeritos().setModel(tmodelPeritos);
		SwingUtil.autoAdjustColumns(vista.getTablaPeritos());

	}

	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}

}
