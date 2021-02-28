package giis.demo.cursos;

import giis.demo.util.SwingUtil;

public class CursoController {
	
	private CursoModel modelo;
	private CursoView vista;
	
	private String lastSelectedKey="";

	public CursoController(CursoModel modelo, CursoView vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		//pruebas controlador
		
	
		
		this.initview();
	}

	public void initview() {
		// TODO Auto-generated method stub
		vista.getFrame().setVisible(true); 
		
	}
	
	//Iniciar los controladore de la vista
	public void initController() {
		
		//view.getBtnTablaCarreras().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaCarreras()));
		vista.getBtnTablaCurso().addActionListener(e-> SwingUtil.exceptionWrapper(() -> getListaCurso()));
		
	}

	public void getListaCurso() {
		
	}
	
	
	

}
