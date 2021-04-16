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
	private boolean existeColectivo;
	
	
	public InscripcionesController(InscripcionesModel m, InscripcionesView v, JustificanteView j) {
		this.modelo = m;
		this.vista = v;
		this.justificante=j;
		this.initView();
		this.tipo="";
		this.existeColectivo=false;
		
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
	
	private void inscripcionColegiado() {
		int idColegiado=-1;
		if(idCurso==0) { //NO SELECCIONO CURSO
			validateCondition(false, "Hay que seleccionar un curso.");
		}else { //SELECCIONO CURSO
			try {
				idColegiado=Integer.parseInt(vista.getTFdniColegiado().getText()); 
			}catch(NumberFormatException e) {
				throw new ApplicationException("Error en el formato del número del idColegiado.");
			}
			if(modelo.existeColegiado(idColegiado)==true) { //EXISTE COLEGIADO
				if(modelo.existeInscripcion(idColegiado, idCurso, "colegiado")==true) { //EXISTE INSCRIPCION
					vista.getTFdniColegiado().setText("");
					throw new ApplicationException("Error en la inscripción, el idColegiado="+idColegiado+" ya está inscrito en el idCurso="+idCurso);
				}else { //NO EXISTE INSCRIPCION
					if(hayPlazasLibres()) { //SI HAY PLAZAS
						crearInscripcionColegiado();
					}else //SI NO HAY PLAZAS
						throw new ApplicationException("No hay plazas libres en este idCurso="+idCurso);
				}
			}else //NO EXISTE COLEGIADO
				throw new ApplicationException("No existe en nuestra base de datos de Colegiados ese idColegiado.");
		}
	}
	
	private void inscripcionPrecolegiado() {
		int idPrecolegiado=-1;
		if(idCurso==0) //NO SELECCION CURSO
			validateCondition(false, "Hay que seleccionar un curso.");
		else { //SELECCION DE CURSO
			try{
				idPrecolegiado=Integer.parseInt(vista.getTFidPre().getText());
			}catch(NumberFormatException e) {
				throw new ApplicationException("Error en el formato del número del idPrecolegiado.");
			}
			if(modelo.existePrecolegiado(idPrecolegiado)==true) { //EXISTE PRECOLEGIADO
				if(modelo.existeInscripcion(idPrecolegiado, idCurso, "precolegiado")==true) { //EXISTE INSCRIPCION
					vista.getTFidPre().setText("");
					throw new ApplicationException("Error en la inscripción, el idPrecolegiado="+idPrecolegiado+" ya está inscrito en el idCurso="+idCurso);
				}else //NO EXISTE INSCRIPCION
					 if(hayPlazasLibres()) //SI HAY PLAZAS
						 crearInscripcionPrecolegiado();
					 else //SI NO HAY PLAZAS
						 throw new ApplicationException("No hay plazas libres en este idCurso="+idCurso);
			}else //NO EXISTE PRECOLEGIADO
				throw new ApplicationException("No existe en nuestra base de datos de Precolegiados ese idPrecolegiado.");
		}
	}
	
	private void inscripcionColectivo() {
		int idColectivo=-1;
		int dni=-1;
		existeColectivo=false;
		if(idCurso==0) 
			validateCondition(false, "Falta seleccionar un curso.");
		else {
			try {
				dni=Integer.parseInt(vista.getTFdniColectivo().getText());
			}catch(NumberFormatException e) {
				throw new ApplicationException("Error en el formato del número de dni del colectivo: "+vista.getTFdniColectivo().getText()+" no válido");
			}
			if(modelo.existeColectivo(dni)==true) { //EXISTE COLECTIVO
				idColectivo=Integer.parseInt(modelo.getIdColectivo(dni));
				tipo=modelo.getColectivoTipo(idColectivo);
				existeColectivo=true;
				if(modelo.existeInscripcion(idColectivo, idCurso, tipo)==true) { //EXISTE INSCRIPCION
					vista.getTFdniColectivo().setText("");
					throw new ApplicationException("Error, hay un colectivo de tipo="+tipo+" con dni="+dni+" inscrito en el idCurso="+idCurso);
				}else { //NO EXISTE INSCRIPCION
					if(hayPlazasLibres()) //SI HAY PLAZAS
						crearInscripcionColectivo();
					else //SI NO HAY PLAZAS
						throw new ApplicationException("No hay plazas libres en este idCurso="+idCurso);
				}
			}else { //NO EXISTE COLECTIVO
				if(hayCamposVacios()) 
					validateCondition(false, "Rellena los datos del nuevo colectivo.");
				else {
					tipo=getTipo();
					if(tipo=="") //no se selecciona un tipo de colectivo
						throw new ApplicationException("Error, hay que seleccionar un tipo de colectivo");
					else { //se selecciona un tipo de colectivo
						modelo.setNuevoColectivo(tipo);
						System.out.println("Añadido colectivo con idColectivo="+idColectivo+" ,tipo="+tipo);
						if(hayPlazasLibres()) //SI HAY PLAZAS
							crearInscripcionColectivo();
						else //SI NO HAY PLAZAS
							throw new ApplicationException("No hay plazas libres en este idCurso="+idCurso);
					}
				}
			}
		}
	}
	
	private void crearInscripcionColegiado() {
		int idColegiado=Integer.parseInt(vista.getTFdniColegiado().getText());
		vista.getFrame().setVisible(false);
		justificante.getFrame().setVisible(true);
		
		modelo.setNuevaInscripcion(idColegiado, idCurso,"colegiado");
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
		
		modelo.setNuevaInscripcion(idPrecolegiado, idCurso,"precolegiado");
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
		
		modelo.setNuevaInscripcion(idColectivo, idCurso,tipo);
		System.out.println("Nueva inscripción: idColectivo="+idColectivo+", idCurso="+idCurso+ ", tipo="+tipo);
		
		justificante.getLblNewLabel_3().setText("IdColectivo : ");
		justificante.getLNombre().setText(modelo.getColectivoNombre(idColectivo));
		justificante.getLApellidos().setText(modelo.getColectivoApellidos(idColectivo));
		justificante.getLNColegiado().setText(String.valueOf(idColectivo));
		justificante.getLNCuenta().setText("1234567890");
		justificante.getLFecha().setText(modelo.getFecha());
		
		if(existeColectivo==false) {
			if(tipo=="externo")
				justificante.getLCantidad().setText(modelo.getCursoPrecioExterno(idCurso));
			if(tipo=="estudiante")
				justificante.getLCantidad().setText(modelo.getCursoPrecioEstudiante(idCurso));
			if(tipo=="empresa")
				justificante.getLCantidad().setText(modelo.getCursoPrecioEmpresa(idCurso));
		}else {
			tipo=modelo.getColectivoTipo(idColectivo);
			if(tipo=="externo") justificante.getLCantidad().setText(modelo.getCursoPrecioExterno(idCurso));
			if(tipo=="estudiante") justificante.getLCantidad().setText(modelo.getCursoPrecioEstudiante(idCurso));
			if(tipo=="empresa") justificante.getLCantidad().setText(modelo.getCursoPrecioEmpresa(idCurso));
		}
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
	
	private boolean hayPlazasLibres() {
		String plazasTotales=modelo.getCursoPlazasTotales(idCurso);
		String plazasOcupadas=modelo.getCursoPlazasOcupadas(idCurso);
		int tot=Integer.valueOf(plazasTotales);
		int ocu=Integer.valueOf(plazasOcupadas);
		if(ocu<tot)
			return true;
		else return false;
	}
	
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}
}