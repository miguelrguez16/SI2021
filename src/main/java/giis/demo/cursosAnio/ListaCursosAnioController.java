package giis.demo.cursosAnio;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

import giis.demo.consultaInscritos.ConsultaInscritoDisplayDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;


public class ListaCursosAnioController {
	
	private ListaCursosAnioModel modelo;
	private ListaCursosAnioView vista;
	private int idCurso;
	private String lastCursoSelected="";

	public ListaCursosAnioController(ListaCursosAnioModel m, ListaCursosAnioView v) {
		this.modelo = m;
		this.vista = v;
		this.initView();
	}
	
	private void initView() {
		vista.getFrame().setVisible(true); 
		this.setListaCursosAnioController();
	}
	
	public void initController() {
		vista.getBtnCargar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> subirArchivo()));
		vista.getTablaCursos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				SwingUtil.exceptionWrapper(() -> updateDetail());
			}
		});
	}
	
	private void setListaCursosAnioController() {
        List<ListaCursosAnioDisplayDTO> cursos = modelo.getListaCursosAnioModelo();
        TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos,new String[] { "idCurso", "nombre", "fechaInicio", "estado", "plazasTotales", "plazasLibres" });
        vista.getTablaCursos().setModel(tmodel);
        SwingUtil.autoAdjustColumns(vista.getTablaCursos());
    }
	
	private void setListaInscritosCursoController() {
		List<ConsultaInscritoDisplayDTO> inscritos= modelo.getListaInscritos(idCurso);
		TableModel tmodel = SwingUtil.getTableModelFromPojos(inscritos,
				new String[] { "apellidos", "nombre", "tipo", "fecha", "precio", "estado", "cantidadDevolver" });
		vista.getTablaInscritos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTablaInscritos());
	}
	
	public void updateDetail() {
		this.lastCursoSelected=SwingUtil.getSelectedKey(vista.getTablaCursos());
		idCurso=Integer.parseInt(this.lastCursoSelected);
		vista.getLInscritos().setText("Lista provisional de inscritos al idCurso="+idCurso);
		this.setListaInscritosCursoController();
	}
	
	private void subirArchivo() {
		if (idCurso==0) {
			validateCondition(false, "Hay que seleccionar un curso.");
		}
		else {
			JFileChooser chooser=new JFileChooser();
			int returnVal=chooser.showOpenDialog(chooser);
			if(!(returnVal==JFileChooser.APPROVE_OPTION)) {
				throw new ApplicationException("Error en la selección del fichero de recepción");
			}else {
				BufferedReader br=null;
				try {
					br=new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsoluteFile()));
					String line=br.readLine();
					while(null!=line) {
						String[] fields=line.split(";");
						String dni, fecha, cantidad;
						dni=fields[0];
						fecha=fields[1];
						cantidad=fields[2];
						actualizarInscripcion(dni, fecha, cantidad);
						line=br.readLine();
					}
				}catch(IOException e) {
					throw new ApplicationException("Error apertura fichero lectura");
				}finally {
					if(null!=br) {
						try {
							br.close();
							this.setListaInscritosCursoController();
						}catch(IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	private void actualizarInscripcion(String dni, String fecha, String cantidad) {
		
		double x=Double.parseDouble(cantidad);
		if(x<=0)
			validateCondition(false, "Cantidad de pago negativa en DNI="+dni);
		
		if(modelo.esColegiado(dni)) { //SI ES COLEGIADO
			int idColegiado=modelo.getIdColegiado(dni);
			
			if(modelo.existeInscripcion(idColegiado, idCurso, "colegiado")) { //SI EXISTE INSCRIPCION
				String tipo="colegiado";
				String estado=modelo.getEstado(idColegiado, idCurso, tipo);
				if(!estado.equals("preinscrito")) 
					System.out.println("DNI="+dni+". Esta inscripción ya está pagada o ha sido anulada la inscripción.\n");
				else 
					esColegiado(dni, fecha, cantidad);
			}else 
				validateCondition(false, "No existe inscripción del idColegiado="+idColegiado+" en el idCurso="+idCurso);
		}
		
		else if(modelo.esPrecolegiado(dni)) {
			int idPrecolegiado=modelo.getIdPrecolegiado(dni);
			
			if(modelo.existeInscripcion(idPrecolegiado, idCurso, "precolegiado")) {
				String tipo="precolegiado";
				String estado=modelo.getEstado(idPrecolegiado, idCurso, tipo);
				if(!estado.equals("preinscrito"))
					System.out.println("DNI="+dni+". Esta inscripción ya está pagada o ha sido anulada la inscripción.\n");
				else
					esPrecolegiado(dni, fecha, cantidad);
			}else
					validateCondition(false, "No existe inscripcion del idPrecolegiado="+idPrecolegiado+" en el idCurso="+idCurso);
		}
		
		else if(modelo.esColectivo(dni)) {
			int idColectivo=modelo.getIdColectivo(dni);
			String tipo=modelo.getColectivoTipo(idColectivo);
			
			if(modelo.existeInscripcion(idColectivo, idCurso, tipo)) {
				String estado=modelo.getEstado(idColectivo, idCurso, tipo);
				if(!estado.equals("preinscrito"))
					System.out.println("DNI="+dni+". Esta inscripción ya está pagada o ha sido anulada la inscripción.\n");
				else
					esColectivo(dni, fecha, cantidad);
			}else
				validateCondition(false, "No existe inscripción del idColectivo="+idColectivo+" en el idCurso="+idCurso);
		}
		else throw new ApplicationException("No existe el dni="+dni+" en nuestra base de datos.");
	}
	
	private void esColegiado(String dni, String fecha, String cantidad) {
		System.out.println("Es colegiado. DNI="+dni);
		int idColegiado=modelo.getIdColegiado(dni);
		int idInscripcionCurso=modelo.getIdInscripcionCurso(idColegiado, idCurso, "colegiado");
		double precioYaPagado=modelo.getPrecioDevolver(idInscripcionCurso);
		String fechaInscripcion=modelo.getFechaInscripcion(idColegiado, idCurso);
		
		double cantidadPagada=Double.parseDouble(cantidad);
		double precioCurso=modelo.getPrecioColegiado(idCurso);
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaInicial;
			fechaInicial=dateFormat.parse(fechaInscripcion);
			Date fechaFinal= dateFormat.parse(fecha);
			int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
			
			if(dias<=3 && cantidadPagada == precioCurso) { //FECHA VALIDA y CANTIDAD VALIDA
				modelo.setInscripcionInscrita(idColegiado, idCurso,"colegiado");
				System.out.println("Pago aceptado. Cantidad correcta. Inscripción inscrita: idColegiado="+idColegiado+", idCurso="+idCurso+"\n");
			}
			
			else if(dias>3) { //FECHA INVALIDA
				double cantidadTotal=cantidadPagada+precioYaPagado;
				modelo.setInscripcionAnulada(idColegiado, idCurso,"colegiado", cantidadTotal);
				System.out.println("Fecha pago incorrecta. Inscripción anulada: idColegiado="+idColegiado+", idCurso="+idCurso+", cantidadDevolver="+cantidadTotal+"\n");
				this.setListaCursosAnioController();
			}
			
			else if(dias<=3 && cantidadPagada > precioCurso ) { //FECHA VALIDA y CANTIDAD MAYOR
				double cantidadDevolver=precioYaPagado+cantidadPagada-precioCurso;
				modelo.setInscripcionInscritaDevolver(idColegiado, idCurso,"colegiado", cantidadDevolver);
				System.out.println("Cantidad mayor. Inscripción inscrita: idColegiado="+idColegiado+", idCurso="+idCurso+", cantidadDevolver="+cantidadDevolver+"\n");
			}
			
			else if(dias<=3 && cantidadPagada < precioCurso){ //FECHA VALIDA y CANTIDAD MENOR
				double cantidadTotal=cantidadPagada+precioYaPagado;
				if(cantidadTotal==precioCurso) {
					modelo.setInscripcionInscrita(idColegiado, idCurso, "colegiado");
					System.out.println("Pago aceptado. Cantidad correcta. Inscripción inscrita: idColegiado="+idColegiado+", idCurso="+idCurso+"\n");
				}else if(cantidadTotal>precioCurso) {
					double aux=cantidadTotal-precioCurso;
					modelo.setInscripcionInscritaDevolver(idColegiado, idCurso, "colegiado", aux);
					System.out.println("Cantidad mayor. Inscripción inscrita: idColegiado="+idColegiado+", idCurso="+idCurso+", cantidadDevolver="+aux+"\n");
				}else {
					modelo.setInscripcionPreinscritaDevolver(idColegiado, idCurso, "colegiado", cantidadTotal);
					System.out.println("Cantidad menor. Inscripción queda preinscrita: idColegiado="+idColegiado+", idCurso="+idCurso+", cantidadDevolver="+cantidadTotal+"\n");
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	private void esPrecolegiado(String dni, String fecha, String cantidad) {
		System.out.println("Es precolegiado. DNI="+dni);
		int idPrecolegiado=modelo.getIdPrecolegiado(dni);
		String fechaInscripcion=modelo.getFechaInscripcion(idPrecolegiado, idCurso);
		
		double cantidadPagada=Double.parseDouble(cantidad);
		double precioCurso=modelo.getPrecioPrecolegiado(idCurso);
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaInicial;
			fechaInicial=dateFormat.parse(fechaInscripcion);
			Date fechaFinal= dateFormat.parse(fecha);
			int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
			
			if(dias<=3 && cantidadPagada == precioCurso) { //FECHA VALIDA y CANTIDAD VALIDA
				modelo.setInscripcionInscrita(idPrecolegiado, idCurso,"precolegiado");
				System.out.println("Pago aceptado. Cantidad correcta. Inscripción inscrita: idPrecolegiado="+idPrecolegiado+", idCurso="+idCurso+"\n");
			}
			
			else if(dias>3) { //FECHA INVALIDA
				modelo.setInscripcionAnulada(idPrecolegiado, idCurso,"precolegiado", cantidadPagada);
				System.out.println("Fecha pago incorrecta. Inscripción anulada: idPrecolegiado="+idPrecolegiado+", idCurso="+idCurso+", cantidadDevolver="+cantidadPagada+"\n");
				this.setListaCursosAnioController();
			}
			
			else if(dias<=3 && cantidadPagada > precioCurso ) { //FECHA VALIDA y CANTIDAD MAYOR
				double cantidadDevolver=cantidadPagada-precioCurso;
				modelo.setInscripcionInscritaDevolver(idPrecolegiado, idCurso,"precolegiado", cantidadDevolver);
				System.out.println("Cantidad mayor. Inscripción inscrita: idPrecolegiado="+idPrecolegiado+", idCurso="+idCurso+", cantidadDevolver="+cantidadDevolver+"\n");
			}
			
			else if(dias<=3 && cantidadPagada < precioCurso){ //FECHA VALIDA y CANTIDAD MENOR
				modelo.setInscripcionPreinscritaDevolver(idPrecolegiado, idCurso, "precolegiado", cantidadPagada);
				System.out.println("Cantidad menor. Inscripción queda preinscrita: idPrecolegiado="+idPrecolegiado+", idCurso="+idCurso+", cantidadDevolver="+cantidadPagada+"\n");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private void esColectivo(String dni, String fecha, String cantidad) {
		int idColectivo=modelo.getIdColectivo(dni);
		String tipo=modelo.getColectivoTipo(idColectivo);
		System.out.println("Es colectivo tipo="+tipo+". DNI="+dni);
		String fechaInscripcion=modelo.getFechaInscripcion(idColectivo, idCurso);
		
		double cantidadPagada=Double.parseDouble(cantidad);
		double precioCurso=0.0;
		if(tipo.equals("estudiante")) {
			precioCurso=modelo.getPrecioEstudiante(idCurso);
		}else if(tipo.equals("empresa")) {
			precioCurso=modelo.getPrecioEmpresa(idCurso);
		}else if(tipo.equals("externo")) {
			precioCurso=modelo.getPrecioExterno(idCurso);
		}

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaInicial;
			fechaInicial=dateFormat.parse(fechaInscripcion);
			Date fechaFinal= dateFormat.parse(fecha);
			int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
			
			if(dias<=3 && cantidadPagada == precioCurso) { //FECHA VALIDA y CANTIDAD VALIDA
				modelo.setInscripcionInscrita(idColectivo, idCurso, tipo);
				System.out.println("Pago aceptado. Cantidad correcta. Inscripción inscrita: idColectivo="+idColectivo+", idCurso="+idCurso+"\n");
			}
			
			else if(dias>3) { //FECHA INVALIDA
				modelo.setInscripcionAnulada(idColectivo, idCurso, tipo, cantidadPagada);
				System.out.println("Fecha pago incorrecta. Inscripción anulada: idColectivo="+idColectivo+", idCurso="+idCurso+", cantidadDevolver="+cantidadPagada+"\n");
				this.setListaCursosAnioController();
			}
			
			else if(dias<=3 && cantidadPagada > precioCurso ) { //FECHA VALIDA y CANTIDAD MAYOR
				double cantidadDevolver=cantidadPagada-precioCurso;
				modelo.setInscripcionInscritaDevolver(idColectivo, idCurso, tipo, cantidadDevolver);
				System.out.println("Cantidad mayor. Inscripción inscrita: idColectivo="+idColectivo+", idCurso="+idCurso+", cantidadDevolver="+cantidadDevolver+"\n");
			}
			
			else if(dias<=3 && cantidadPagada < precioCurso){ //FECHA VALIDA y CANTIDAD MENOR
				modelo.setInscripcionPreinscritaDevolver(idColectivo, idCurso, tipo, cantidadPagada);
				System.out.println("Cantidad menor. Inscripción queda preinscrita: idColectivo="+idColectivo+", idCurso="+idCurso+", cantidadDevolver="+cantidadPagada+"\n");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}
}
