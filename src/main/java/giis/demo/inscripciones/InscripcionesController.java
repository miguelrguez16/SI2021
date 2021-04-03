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
	private int idColectivo;
	private int dni;
	

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
		vista.getbtnComprobar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprobarExistenciaDNI()));
		
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
		if(idCurso==0) //curso seleccionado sino ERROR
			validateCondition(false, "Falta seleccionar un curso.");
		
		if(!comprobarCamposRellenos()) //campos rellenos sino ERROR
			validateCondition(false, "Todos los campos deben estar rellenos.");
		
		if(idColegiado!=-1) { //si está registrado en nuestra BD
			if(modelo.existeInscripcion(idColegiado, idCurso)==true){ //ya hay esa inscripcion en ese curso
				throw new ApplicationException("Error en la inscripción, el idColegiado ya está inscrito en el idCurso="+idCurso);
			}
			else  nuevaInscripcionColegiado();//no existe inscripcion en ese curso
				
		}else { //sino está registrado en nuestra BD
			dni=Integer.parseInt(vista.getTFdni().getText()); //cogemos el dni del colectivo
			idColectivo= modelo.getIdColectivo(dni)==null?-1:Integer.valueOf(modelo.getIdColectivo(dni));
			
			if(idColectivo==-1) { //no esta registrado en bd colectivo
				modelo.setNuevoColectivo();
				idColectivo=Integer.valueOf(modelo.getIdColectivo(dni));
				System.out.println("Añadido nuevo colectivo con idColectivo="+idColectivo);
			}
			
			if(modelo.existeInscripcionColectivo(idColectivo, idCurso)==true) //existe inscripcion de ese dni ERROR
				throw new ApplicationException("Error, hay un colectivo con dni="+dni+" inscrito en el idCurso="+idCurso);
			
			else inscripcionColectivo(); //no existe inscripcion
		}
	}
	
	private void comprobarExistenciaDNI() {
		try {
			dni=Integer.parseInt(vista.getTFdni().getText());
		}catch(NumberFormatException e) {
			throw new ApplicationException("Error en el formato del número: "+vista.getTFdni().getText()+" no válido");
		}
		idColegiado=modelo.getIdColegiado(dni)==null?-1: Integer.valueOf(modelo.getIdColegiado(dni));
		
		if(idColegiado!=-1) {
			System.out.println("¡Lo tenemos en nuestra base de datos de colegiados!");
			vista.getTFnombre().setText(modelo.getColegiadoNombre(idColegiado));
			vista.getTFapellidos().setText(modelo.getColegiadoApellidos(idColegiado));
			vista.getTFdireccion().setText(modelo.getColegiadoDireccion(idColegiado));
			vista.getTFdatos().setText(modelo.getColegiadoDatos(idColegiado));	
			vista.getTFtelefono().setText(modelo.getColegiadoTelefono(idColegiado));
			vista.getTFpoblacion().setText(modelo.getColegiadoPoblacion(idColegiado));
			
		}else throw new ApplicationException("No existe en nuestra base de datos un colegiado con ese DNI.\nPor favor, introduzca sus datos para poder inscribirte a un curso.");
	}
	
	private void nuevaInscripcionColegiado() {
		vista.getFrame().setVisible(false);
		justificante.getFrame().setVisible(true);
		
		modelo.setNuevaInscripcion(idColegiado, idCurso);
		System.out.println("Nueva inscripción: idColegiado="+idColegiado+", idCurso="+idCurso);
		
		justificante.getLNombre().setText(modelo.getColegiadoNombre(idColegiado));
		justificante.getLApellidos().setText(modelo.getColegiadoApellidos(idColegiado));
		justificante.getLNColegiado().setText(String.valueOf(idColegiado));
		justificante.getLNCuenta().setText(modelo.getColegiadoDatos(idColegiado));
		justificante.getLCantidad().setText(modelo.getCursoPrecio(idCurso));
		justificante.getLFecha().setText(modelo.getFecha());
	}
	
	private void inscripcionColectivo() {
		vista.getFrame().setVisible(false);
		justificante.getFrame().setVisible(true);
		
		modelo.setNuevaInscripcionColectivo(idColectivo, idCurso);
		System.out.println("Nueva inscripción: idColectivo="+idColectivo+", idCurso="+idCurso);
		
		justificante.getLNombre().setText(vista.getTFnombre().getText());
		justificante.getLApellidos().setText(vista.getTFapellidos().getText());
		justificante.getLNColegiado().setText("No colegiado, idColectivo="+modelo.getIdColectivo(dni));
		justificante.getLNCuenta().setText(vista.getTFdatos().getText());
		justificante.getLCantidad().setText(modelo.getCursoPrecio(idCurso));
		justificante.getLFecha().setText(modelo.getFecha());
	}
	
	private boolean comprobarCamposRellenos() {
		if(vista.getTFnombre().getText().isEmpty()||vista.getTFapellidos().getText().isEmpty()||vista.getTFdni().getText().isEmpty()||vista.getTFdireccion().getText().isEmpty()||vista.getTFpoblacion().getText().isEmpty()||vista.getTFtelefono().getText().isEmpty()||vista.getTFdatos().getText().isEmpty())
			return false;
		else return true;
	}
	
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}	
}