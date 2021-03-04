package giis.demo.cursos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
		vista.getFrame().setVisible(true);
		setListaCursosController();

	}

	// Iniciar los controladore de la vista
	public void initController() {

		vista.getBtnActualizarCurso().addActionListener(e -> SwingUtil.exceptionWrapper(() -> guardarCambios()));
		vista.getTablaCursos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// no usa mouseClicked porque al establecer seleccion simple en la tabla de
				// carreras
				// el usuario podria arrastrar el raton por varias filas e interesa solo la
				// ultima
				SwingUtil.exceptionWrapper(() -> updateCursosPendientes());
			}
		});

	}

	private void setListaCursosController() {
		List<CursoDisplayDTO> cursos = modelo.getListaCursosModelo();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos,new String[] { "idCurso", "nombre", "fechaInicio" });
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

	private void guardarCambios() {
	}

}
