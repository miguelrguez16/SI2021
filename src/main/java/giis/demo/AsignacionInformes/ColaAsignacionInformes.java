package giis.demo.AsignacionInformes;

import java.util.LinkedList;

public class ColaAsignacionInformes {

	private LinkedList<Integer> data;
	private int size = 0;

	public ColaAsignacionInformes() {
		data = new LinkedList<>();
	}

	public void rellenarDatos(int idPerito) {
		data.addFirst(idPerito);
		size++;
	}

	public int getNuevoturno() {
		int perito = data.getLast();
		data.removeLast();
		System.out.println("perito asignado a insertar "+ perito);
		data.addFirst(perito);
		return perito;
	}

	public int turnoAsignado(int idPerito) {
		return data.indexOf(idPerito);
	}

	public int getSize() {
		return this.size;
	}

	public int getPeritoActualizar(int index) {
		return data.get(index);
	}

	@Override
	public String toString() {
		return "Cola " + data;
	}

}
