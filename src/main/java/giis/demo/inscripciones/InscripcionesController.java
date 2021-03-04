package giis.demo.inscripciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.TableModel;
import giis.demo.cursos.CursoDisplayDTO;
import giis.demo.util.SwingUtil;


public class InscripcionesController {
	
	private InscripcionesModel modelo;
	private InscripcionesView vista;
	private JustificanteView justificante;
	private String lastSelectedKey="";
	private int idColegiado;
	private int idCurso;
	String colegiado;

	public InscripcionesController(InscripcionesModel m, InscripcionesView v, JustificanteView j) {
		this.modelo = m;
		this.vista = v;
		this.justificante=j;
		this.initView();
	}
	
	private void initView() {
		vista.getFrame().setVisible(true); 
		this.setListaCursosController();
		justificante.getFrame().setVisible(false);		
	}
	
	public void initController() {	
		vista.getbJustificante().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				vista.getFrame().setVisible(false);
				idColegiado=Integer.valueOf(vista.getTextField().getText());
				justificante.getFrame().setVisible(true);
				justificante.getLFecha().setText(modelo.getFecha());
				modelo.setNuevaInscripcion(idColegiado, idCurso);
				justificante.getLNombre().setText(modelo.getColegiadoNombre(idColegiado));
				justificante.getLApellidos().setText(modelo.getColegiadoApellidos(idColegiado));
				justificante.getLNColegiado().setText(String.valueOf(idColegiado));
				justificante.getLNCuenta().setText(modelo.getColegiadoDatos(idColegiado));
				justificante.getLCantidad().setText(modelo.getCursoPrecio(idCurso));				
			}
		});
		vista.getTablaCursos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				SwingUtil.exceptionWrapper(() -> updateDetail());
			}
		});
	}
	
	private void setListaCursosController() {
        List<CursoDisplayDTO> cursos = modelo.getListaCursosModelo();
        TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos,new String[] { "idCurso", "nombre", "fechaInicio" });
        vista.getTablaCursos().setModel(tmodel);
        SwingUtil.autoAdjustColumns(vista.getTablaCursos());
    }
	
	public void updateDetail() {
		this.lastSelectedKey=SwingUtil.getSelectedKey(vista.getTablaCursos());
		idCurso=Integer.parseInt(this.lastSelectedKey);
	}
}
