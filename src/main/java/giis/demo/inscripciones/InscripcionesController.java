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
	private ComoPagarView pago;
	private JustificanteTarjetaView tarjeta;
	private boolean existeColectivo;
	
	private String lastCursoSelected="";
	private int idCurso;
	private String tipo;
	
	
	public InscripcionesController(InscripcionesModel m, InscripcionesView v, JustificanteView j, ComoPagarView p, JustificanteTarjetaView t) {
		this.modelo = m;
		this.vista = v;
		this.justificante=j;
		this.pago=p;
		this.tarjeta=t;
		this.initView();
		this.tipo="";
		this.existeColectivo=false;
		
	}
	
	private void initView() {
		vista.getFrame().setVisible(true); 
		this.setListaCursosController();
		pago.getFrame().setVisible(false);
		tarjeta.getFrame().setVisible(false);
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
		if(idCurso==0) 
			validateCondition(false, "Falta seleccionar un curso.");
		else {
			try {
				dni=Integer.parseInt(vista.getTFdniColectivo().getText());
			}catch(NumberFormatException e) {
				throw new ApplicationException("Error en el formato del número de dni del colectivo: "+vista.getTFdniColectivo().getText()+" no válido");
			}
			if(modelo.existeColectivo(dni)==true) { //EXISTE COLECTIVO
				existeColectivo=true;
				idColectivo=Integer.parseInt(modelo.getIdColectivo(dni));
				tipo=modelo.getColectivoTipo(idColectivo);
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
		pago.getFrame().setVisible(true);
		vista.getFrame().setVisible(false);
		
		modelo.setNuevaInscripcion(idColegiado, idCurso,"colegiado");
		System.out.println("Nueva inscripción: idColegiado="+idColegiado+", idCurso="+idCurso);
		
		
		pago.getBtnTransferencia().addActionListener(e -> SwingUtil.exceptionWrapper(() -> transferenciaColegiado()));
		pago.getBtnTarjeta().addActionListener(e -> SwingUtil.exceptionWrapper(() -> tarjetaColegiado()));
	}
	
	private void crearInscripcionPrecolegiado() {
		int idPrecolegiado=Integer.parseInt(vista.getTFidPre().getText());
		vista.getFrame().setVisible(false);
		pago.getFrame().setVisible(true);
		
		modelo.setNuevaInscripcion(idPrecolegiado, idCurso,"precolegiado");
		System.out.println("Nueva inscripción: idPrecolegiado="+idPrecolegiado+", idCurso="+idCurso);
		
		pago.getBtnTransferencia().addActionListener(e -> SwingUtil.exceptionWrapper(() -> transferenciaPrecolegiado()));
		pago.getBtnTarjeta().addActionListener(e -> SwingUtil.exceptionWrapper(() -> tarjetaPrecolegiado()));
	}
	
	private void crearInscripcionColectivo() {
		int dni=Integer.parseInt(vista.getTFdniColectivo().getText());
		int idColectivo= Integer.valueOf(modelo.getIdColectivo(dni));
		vista.getFrame().setVisible(false);
		pago.getFrame().setVisible(true);
		
		modelo.setNuevaInscripcion(idColectivo, idCurso,tipo);
		System.out.println("Nueva inscripción: idColectivo="+idColectivo+", idCurso="+idCurso+ ", tipo="+tipo);
		
		pago.getBtnTransferencia().addActionListener(e -> SwingUtil.exceptionWrapper(() -> transferenciaColectivo()));
		pago.getBtnTarjeta().addActionListener(e -> SwingUtil.exceptionWrapper(() -> tarjetaColectivo()));
	}

	private void transferenciaColegiado() {
		int idColegiado=Integer.parseInt(vista.getTFdniColegiado().getText());
		pago.getFrame().setVisible(false);
		justificante.getFrame().setVisible(true);
		 
		justificante.getLNombre().setText("Nombre: "+modelo.getColegiadoNombre(idColegiado));
		justificante.getLApellidos().setText("Apellidos: "+modelo.getColegiadoApellidos(idColegiado));
		justificante.getLNColegiado().setText("Id Colegiado: "+String.valueOf(idColegiado)+", inscrito en el Id Curso: "+idCurso);
		justificante.getLCantidad().setText("Cantidad a abonar:"+ modelo.getCursoPrecio(idCurso));
		justificante.getLFecha().setText("Fecha de la inscripción: "+modelo.getFecha());
		justificante.getLNCuenta().setText("Número de cuenta dónde abonar el pago: 1234567890");
	}
	
	private void transferenciaPrecolegiado() {
		int idPrecolegiado=Integer.parseInt(vista.getTFidPre().getText());
		pago.getFrame().setVisible(false);
		justificante.getFrame().setVisible(true);
		
		justificante.getLNombre().setText("Nombre: "+modelo.getPrecolegiadoNombre(idPrecolegiado));
		justificante.getLApellidos().setText("Apellidos: "+modelo.getPrecolegiadoApellidos(idPrecolegiado));
		justificante.getLNColegiado().setText("Id Precolegiado: "+String.valueOf(idPrecolegiado)+" inscrito en el Id Curso: "+idCurso);
		justificante.getLCantidad().setText("Cantidad a abonar: "+modelo.getCursoPrecioPrecolegiado(idCurso));
		justificante.getLFecha().setText("Fecha de la inscripción: "+modelo.getFecha());
		justificante.getLNCuenta().setText("Número de cuenta dónde abonar el pago: 1234567890");
		
		
	}
	
	private void transferenciaColectivo() {
		int dni=Integer.parseInt(vista.getTFdniColectivo().getText());
		int idColectivo= Integer.valueOf(modelo.getIdColectivo(dni));
		justificante.getFrame().setVisible(true);
		
		justificante.getLNombre().setText("Nombre: "+modelo.getColectivoNombre(idColectivo));
		justificante.getLApellidos().setText("Apellidos: "+modelo.getColectivoApellidos(idColectivo));
		justificante.getLNColegiado().setText("Id Colectivo: "+String.valueOf(idColectivo)+" inscrito en el Id Curso: "+idCurso);
		justificante.getLFecha().setText("Fecha de la inscripción: "+modelo.getFecha());
		justificante.getLNCuenta().setText("Número de cuenta dónde abonar el pago: 1234567890");
		
		if(existeColectivo==false) {
			if(tipo=="externo")
				justificante.getLCantidad().setText(modelo.getCursoPrecioExterno(idCurso));
			if(tipo=="estudiante")
				justificante.getLCantidad().setText(modelo.getCursoPrecioEstudiante(idCurso));
			if(tipo=="empresa")
				justificante.getLCantidad().setText(modelo.getCursoPrecioEmpresa(idCurso));
		}else {
			tipo=modelo.getColectivoTipo(idColectivo);
			if(tipo=="externo") justificante.getLCantidad().setText("Cantidad a abonar: "+modelo.getCursoPrecioExterno(idCurso));
			if(tipo=="estudiante") justificante.getLCantidad().setText("Cantidad a abonar: "+modelo.getCursoPrecioEstudiante(idCurso));
			if(tipo=="empresa") justificante.getLCantidad().setText("Cantidad a abonar: "+modelo.getCursoPrecioEmpresa(idCurso));	
		}
	}
	
	private void tarjetaColegiado() {
		comprobarCamposTarjeta();
		int idColegiado=Integer.parseInt(vista.getTFdniColegiado().getText());
		modelo.setInscripcionPagada(idColegiado, idCurso);
		pago.getFrame().setVisible(false);
		tarjeta.getFrame().setVisible(true);
		tarjeta.getLTarjeta().setText("Inscripción pagada: idColegiado="+idColegiado+", idCurso="+idCurso);
	}
	
	private void tarjetaPrecolegiado() {
		comprobarCamposTarjeta();
		int idPrecolegiado=Integer.parseInt(vista.getTFidPre().getText());
		modelo.setInscripcionPagada(idPrecolegiado, idCurso);
		pago.getFrame().setVisible(false);
		tarjeta.getFrame().setVisible(true);
		tarjeta.getLTarjeta().setText("Inscripción pagada: idPrecolegiado="+idPrecolegiado+", idCurso="+idCurso);
	}
	
	private void tarjetaColectivo() {
		comprobarCamposTarjeta();
		int dni=Integer.parseInt(vista.getTFdniColectivo().getText());
		int idColectivo= Integer.valueOf(modelo.getIdColectivo(dni));
		modelo.setInscripcionPagada(idColectivo, idCurso);
		pago.getFrame().setVisible(false);
		tarjeta.getFrame().setVisible(true);
		tarjeta.getLTarjeta().setText("Inscripción pagada: idColectivo="+idColectivo+", idCurso="+idCurso);
	}
	
	private boolean hayCamposVacios() {
		if(vista.getTFnombre().getText().isEmpty() || vista.getTFapellidos().getText().isEmpty() || vista.getTFpoblacion().getText().isEmpty() ||
				vista.getTFdireccion().getText().isEmpty() || vista.getTFtelefono().getText().isEmpty()) return true;
		else return false;
	}
	
	private void comprobarCamposTarjeta() {
		if(pago.getTFtarjeta().getText().isEmpty() || pago.getTFcvc().getText().isEmpty() || pago.getTFmes().getText().isEmpty() || pago.getTFano().getText().isEmpty() || pago.getTFtitular().getText().isEmpty()) 
			validateCondition(false, "Los datos para el pago con tarjeta deben estar rellenados.");
		else if(pago.getTFtarjeta().getText().length()!=16) 
			validateCondition(false, "El número de la tarjeta debe tener 16 dígitos.");
		else if(pago.getTFcvc().getText().length()!=3) 
			validateCondition(false, "El CVC debe tener 3 dígitos.");
		else if(hayMesErroneo()) 
			validateCondition(false, "El formato del mes debe ser: mm");
		else if(hayAnoErroneo()) 
			validateCondition(false, "El formato del año debe ser: aa. Además debe ser 21 o posterior.");
	}
	
	private boolean hayMesErroneo() {
		boolean aux;
		try {
			int mes=Integer.parseInt(pago.getTFmes().getText());
			if(mes<1||mes>12) aux=true;
			else aux=false;
		}catch(NumberFormatException e) {
			throw new ApplicationException("El mes debe tener sólo números.");
		}
		return aux;
	}
	
	private boolean hayAnoErroneo() {
		boolean aux;
		try {
			int ano=Integer.parseInt(pago.getTFano().getText());
			if(ano<21) aux=true;
			else aux=false;
		}catch(NumberFormatException e) {
			throw new ApplicationException("El año debe tener sólo números.");
		}
		return aux;
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