package giis.demo.AsignacionInformes;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
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
	private ColaAsignacionInformes cola;

	public AsignacionInformesController(AsignacionInformesModel modelo, AsignacionInformesView vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.initview();
		keyInforme = 0;
		keyInforme = 0;
		cola = new ColaAsignacionInformes();
	}

	public void initview() {
		vista.getFrame().setVisible(true);
		showPeritosInformes();

	}

	// Iniciar los controladore de la vista
	public void initController() {
		rellenarColaPeritos();

		vista.getBtnGuardarCambiosManual()
				.addActionListener(e -> SwingUtil.exceptionWrapper(() -> guardarAsignacionInformesManual()));
		vista.getBtnCancelarCambios().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cancelarCambios()));
		vista.getBtnAsignacionautomatica()
				.addActionListener(e -> SwingUtil.exceptionWrapper(() -> guardarAsignacionInformesAutomatica()));

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

	private void rellenarColaPeritos() {
		int totalPeritos = modelo.getNumeroPerito();
		if (totalPeritos == 0)
			throw new NullPointerException("eL TOTAL DE PERITOS YE 0");
		int tmp = 0, turno = 1;
		for (int i = 0; i < totalPeritos; i++) {
			tmp = modelo.getPerito(turno);
			
			if (tmp == 0)
				throw new NullPointerException("el id de perito YE 0");
			
			cola.rellenarDatos(tmp);
			turno++;
		}
		System.out.println(cola.toString());

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

	private void guardarAsignacionInformesManual() {
		if (keyPerito == 0 || keyInforme == 0) {
			validateCondition(false, "Falta seleccionar datos");
		} else {
			modelo.asignarInformeManual(keyInforme, keyPerito);
			keyPerito = 0;
			keyInforme = 0;
			vista.getIDInforme().setText("");
			vista.getIDPerito().setText("");
			showPeritosInformes();
		}
	}

	private void guardarAsignacionInformesAutomatica() {
		if (keyInforme == 0) {
			validateCondition(false, "Falta seleccionar informe");
		} else {
			keyPerito = cola.getNuevoturno();
			modelo.asignarInformeManual(keyInforme, keyPerito);
			System.out.println("Informe "+keyInforme +" -> Perito: " +keyPerito);
			keyPerito = 0;
			keyInforme = 0;
			vista.getIDInforme().setText("");
			vista.getIDPerito().setText("");
			modificarTurnosBaseDatos();
			
			showPeritosInformes();
		}

	}

	private void modificarTurnosBaseDatos() {
		int perito = 0;
		int turnoNuevo = 0;
		int total = modelo.getNumeroPerito();
		for (int i = 0; i < cola.getSize(); i++) {
			perito = cola.getPeritoActualizar(i);
			turnoNuevo = total - cola.turnoAsignado(perito);
			modelo.cambiarTAP(perito, turnoNuevo);
		}
		System.out.println(cola.toString());

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
		TableModel tmodelPeritos = SwingUtil.getTableModelFromPojos(peritos,
				new String[] { "idPerito", "nombre", "turno" });
		vista.getTablaPeritos().setModel(tmodelPeritos);
		SwingUtil.autoAdjustColumns(vista.getTablaPeritos());

	}

	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}

}
