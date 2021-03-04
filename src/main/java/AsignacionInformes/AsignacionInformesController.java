package AsignacionInformes;



public class AsignacionInformesController {

	private AsignacionInformesModel modelo;
	private AsignacionInformesView vista;

	public AsignacionInformesController(AsignacionInformesModel modelo, AsignacionInformesView vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.initview();
	}

	public void initview() {
		vista.getFrame().setVisible(true);
		

	}

	// Iniciar los controladore de la vista
	public void initController() {
	}

}
