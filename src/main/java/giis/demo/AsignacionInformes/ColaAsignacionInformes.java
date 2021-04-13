package giis.demo.AsignacionInformes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

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
		//System.out.println("perito asignado a insertar "+ perito);
		data.addFirst(perito);
		return perito;
	}
	
	public void asignadoManual(int idPerito) {
		int pos = 0;
		int tmp = 0;
		int i = 0;
		Iterator<Integer> itr = data.iterator();
		while(itr.hasNext() && pos==0) {
			tmp = itr.next();
			if(tmp==idPerito) 
				pos=i;
			else 
				i++;
			
		}
		data.remove(pos);
		data.addFirst(idPerito);
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
