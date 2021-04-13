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
	private int idCurso;
	private String tipo;
	
	public InscripcionesController(InscripcionesModel m, InscripcionesView v, JustificanteView j) {
		this.modelo = m;
		this.vista = v;
		this.justificante=j;
		this.initView();
		this.tipo="";
	}
	
	private void initView() {
		vista.getFrame().setVisible(true); 
		this.setListaCursosController();
		justificante.getFrame().setVisible(false);	
	}
	
	public void initController() {	
		
		vista.getbInscripcionColegiado().addActionListener(e -> SwingUtil.exceptionWrapper(() -> inscripcionColegiado()));
		
		vista.getbInscripcionColectivo().addActionListener(e -> SwingUtil.exceptionWrapper(() -> inscripcionColectivo()));
		
		vista.getbInscripcionPrecolegiado().addActionListener(e -> SwingUtil.exceptionWrapper(() -> inscripcionPrecolegiado()));
		
		vista.getTablaCursos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				SwingUtil.exceptionWrapper(() -> updateDetail());
			}
		});
	}
	
	private void setListaCursosController() {
        List<CursoDisplayDTO> cursos = modelo.getListaCursosModelo();
        TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos,new String[] { "idCurso", "nombre", "fechaInicio", "precio", "precioPrecolegiado", "precioEstudiante", "precioEmpresa", "precioExterno" });
        vista.getTablaCursos().setModel(tmodel);
        SwingUtil.autoAdjustColumns(vista.getTablaCursos());
    }
	
	public void updateDetail() {
		this.lastCursoSelected=SwingUtil.getSelectedKey(vista.getTablaCursos());
		idCurso=Integer.parseInt(this.lastCursoSelected);
	}
	
	private void inscripcionColectivo() {
		int dni=-1;
		int idColectivo=-1;
		String tipo="";
		try {
			dni=Integer.parseInt(vista.getTFdniColectivo().getText());
		}catch(NumberFormatException e) {
			throw new ApplicationException("Error en el formato del número de dni del colectivo: "+vista.getTFdniColectivo().getText()+" no válido");
		}catch(NullPointerException e1) {
			throw new ApplicationException("Hay que introducir un idColectivo");
		}
		idColectivo= modelo.getIdColectivo(dni)==null?-1:Integer.valueOf(modelo.getIdColectivo(dni));
		if(idCurso==0) 
			validateCondition(false, "Falta seleccionar un curso.");
		if(idColectivo!=-1) { 
			if(modelo.existeInscripcionColectivo(idColectivo, idCurso)==true) {
				vista.getTFdniColectivo().setText("");
				throw new ApplicationException("Error, hay un colectivo con dni="+dni+" inscrito en el idCurso="+idCurso);
			}else crearInscripcionColectivo();
		}else { //no existe en nuestra BD colectivo
			if(hayCamposVacios()) 
				validateCondition(false, "Rellena los datos del nuevo colectivo.");
			
			tipo=getTipo();
			if(tipo=="") 
				throw new ApplicationException("Error, hay que seleccionar un tipo de colectivo");
			modelo.setNuevoColectivo(tipo);
			System.out.println("Añadido nuevo colectivo con idColectivo="+idColectivo);
			idColectivo=Integer.valueOf(modelo.getIdColectivo(dni));
			crearInscripcionColectivo();
		}
	}
	
	private void inscripcionColegiado() {
		int idColegiado=-1;
		try {
			idColegiado=Integer.parseInt(vista.getTFdniColegiado().getText()); 
		}catch(NumberFormatException e) {
			throw new ApplicationException("Error en el formato del número del idColegiado: "+vista.getTFdniColectivo().getText()+" no válido");
		}
		if(idCurso==0) 
			validateCondition(false, "Falta seleccionar un curso.");
		int x=modelo.getColegiadoNombre(idColegiado)==null?-1:idColegiado;
		
		if(x!=-1) {
			if(modelo.existeInscripcion(idColegiado, idCurso)==true) {
				vista.getTFdniColegiado().setText("");
				throw new ApplicationException("Error en la inscripción, el idColegiado="+idColegiado+" ya está inscrito en el idCurso="+idCurso);
			}else crearInscripcionColegiado();
		}else throw new ApplicationException("No existe en nuestra base de datos ese idColegiado.");
	}
	
	private void inscripcionPrecolegiado() {
		int idPrecolegiado=-1;
		try{
			idPrecolegiado=Integer.parseInt(vista.getTFidPre().getText());
		}catch(NumberFormatException e) {
			throw new ApplicationException("Error en el formato del número del idPrecolegiado: "+vista.getTFdniColectivo().getText()+" no válido");
		}
		if(idCurso==0)
			validateCondition(false, "Falta seleccionar un curso.");
		int x=modelo.getPrecolegiadoNombre(idPrecolegiado)==null?-1:idPrecolegiado;
		
		if(x!=-1) {
			if(modelo.existeInscripcionPrecolegiado(idPrecolegiado, idCurso)==true) {
				vista.getTFidPre().setText("");
				throw new ApplicationException("Error en la inscripción, el idPrecolegiado="+idPrecolegiado+" ya está inscrito en el idCurso="+idCurso);
			}else crearInscripcionPrecolegiado();
		}else throw new ApplicationException("No existe en nuestra Base de Datos de Precolegiados ese idPrecolegiado");
	}
	
	private void crearInscripcionColegiado() {
		int idColegiado=Integer.parseInt(vista.getTFdniColegiado().getText());
		vista.getFrame().setVisible(false);
		justificante.getFrame().setVisible(true);
		modelo.setNuevaInscripcion(idColegiado, idCurso);
		System.out.println("Nueva inscripción: idColegiado="+idColegiado+", idCurso="+idCurso);
		
		justificante.getLblNewLabel_3().setText("IdColegiado : ");
		justificante.getLNombre().setText(modelo.getColegiadoNombre(idColegiado));
		justificante.getLApellidos().setText(modelo.getColegiadoApellidos(idColegiado));
		justificante.getLNColegiado().setText(String.valueOf(idColegiado));
		justificante.getLNCuenta().setText("1234567890");
		justificante.getLCantidad().setText(modelo.getCursoPrecio(idCurso));
		justificante.getLFecha().setText(modelo.getFecha());
	}
	
	private void crearInscripcionPrecolegiado() {
		int idPrecolegiado=Integer.parseInt(vista.getTFidPre().getText());
		vista.getFrame().setVisible(false);
		justificante.getFrame().setVisible(true);
		modelo.setNuevaInscripcionPrecolegiado(idPrecolegiado, idCurso);
		System.out.println("Nueva inscripción: idPrecolegiado="+idPrecolegiado+", idCurso="+idCurso);
		
		justificante.getLblNewLabel_3().setText("IdPrecolegiado : ");
		justificante.getLNombre().setText(modelo.getPrecolegiadoNombre(idPrecolegiado));
		justificante.getLApellidos().setText(modelo.getPrecolegiadoApellidos(idPrecolegiado));
		justificante.getLNColegiado().setText(String.valueOf(idPrecolegiado));
		justificante.getLNCuenta().setText("1234567890");
		justificante.getLCantidad().setText(modelo.getCursoPrecioPrecolegiado(idCurso));
		justificante.getLFecha().setText(modelo.getFecha());
	}
	
	private void crearInscripcionColectivo() {
		int dni=Integer.parseInt(vista.getTFdniColectivo().getText());
		int idColectivo= Integer.valueOf(modelo.getIdColectivo(dni));
		vista.getFrame().setVisible(false);
		justificante.getFrame().setVisible(true);
		modelo.setNuevaInscripcionColectivo(idColectivo, idCurso);
		System.out.println("Nueva inscripción: idColectivo="+idColectivo+", idCurso="+idCurso);
		tipo=getTipo();
		if(tipo=="externo")
			justificante.getLCantidad().setText(modelo.getCursoPrecioExterno(idCurso));
		if(tipo=="estudiante")
			justificante.getLCantidad().setText(modelo.getCursoPrecioEstudiante(idCurso));
		if(tipo=="empresa")
			justificante.getLCantidad().setText(modelo.getCursoPrecioEmpresa(idCurso));
		if(tipo=="")
            justificante.getLCantidad().setText(modelo.getCursoPrecioEstudiante(idCurso));
		
		justificante.getLblNewLabel_3().setText("IdColectivo : ");
		justificante.getLNombre().setText(modelo.getColectivoNombre(idColectivo));
		justificante.getLApellidos().setText(modelo.getColectivoApellidos(idColectivo));
		justificante.getLNColegiado().setText(String.valueOf(idColectivo));
		justificante.getLNCuenta().setText("1234567890");
		justificante.getLFecha().setText(modelo.getFecha());
	}
	
	private boolean hayCamposVacios() {
		if(vista.getTFnombre().getText().isEmpty()||vista.getTFapellidos().getText().isEmpty()||vista.getTFpoblacion().getText().isEmpty()||vista.getTFdireccion().getText().isEmpty()||vista.getTFtelefono().getText().isEmpty())
			return true;
		else return false;
	}
	
	private String getTipo() {
		if(vista.getRBempresa().isSelected())
			return "empresa";
		if(vista.getRBestudiante().isSelected())
			return "estudiante";
		if(vista.getRBexterno().isSelected())
			return "externo";
		else return "";
	}
	
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}
}