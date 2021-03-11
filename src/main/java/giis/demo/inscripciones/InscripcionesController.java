package giis.demo.inscripciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.TableModel;
import giis.demo.cursos.CursoDisplayDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;


public class InscripcionesController {
	
	private InscripcionesModel modelo;
	private InscripcionesView vista;
	private JustificanteView justificante;
	
	private String lastCursoSelected="";
	
	private int idColegiado;
	private int idCurso;
	String colegiado;
	

	public InscripcionesController(InscripcionesModel m, InscripcionesView v, JustificanteView j) {
		this.modelo = m;
		this.vista = v;
		this.justificante=j;
		idCurso=0;
		idColegiado=0;
		this.initView();
	}
	
	private void initView() {
		vista.getFrame().setVisible(true); 
		this.setListaCursosController();
		justificante.getFrame().setVisible(false);		
	}
	
	public void initController() {	
		vista.getbJustificante().addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprobarInscripcion()));

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
		this.lastCursoSelected=SwingUtil.getSelectedKey(vista.getTablaCursos());
		idCurso=Integer.parseInt(this.lastCursoSelected);
	}
	
	private void comprobarInscripcion() {
		int idColegiado=-1;
		
		try {
			idColegiado=Integer.parseInt(vista.getTextField().getText());			
		}catch(NumberFormatException e) {
			throw new ApplicationException("Error en el formato del número: "+vista.getTextField().getText()+" no válido");
		}
		if(idColegiado<=0 || modelo.getColegiadoNombre(idColegiado)==null)
			throw new ApplicationException("Error en la introduccion del número del idColegiado.");
		
		if(idCurso==0)
			validateCondition(false, "Falta seleccionar un curso.");
		
		if(modelo.existeInscripcion(idColegiado, idCurso)==true){
			throw new ApplicationException("Error en la inscripción, el idColegiado ya está inscrito en este curso");
		}
		else {
			vista.getFrame().setVisible(false);
			idColegiado=Integer.valueOf(vista.getTextField().getText());
			justificante.getFrame().setVisible(true);
			justificante.getLFecha().setText(modelo.getFecha());
			modelo.setNuevaInscripcion(idColegiado, idCurso);
			System.out.println("Nueva inscripción: idColegiado="+idColegiado+", idCurso="+idCurso);
			justificante.getLNombre().setText(modelo.getColegiadoNombre(idColegiado));
			justificante.getLApellidos().setText(modelo.getColegiadoApellidos(idColegiado));
			justificante.getLNColegiado().setText(String.valueOf(idColegiado));
			justificante.getLNCuenta().setText(modelo.getColegiadoDatos(idColegiado));
			justificante.getLCantidad().setText(modelo.getCursoPrecio(idCurso));
		}
		
	}
	
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}
	
}
