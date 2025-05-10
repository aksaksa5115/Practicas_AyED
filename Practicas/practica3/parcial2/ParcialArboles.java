package practica3.parcial2;

import practica3.ejercicio1.GeneralTree;
import java.util.LinkedList;
import practica1.ejercicio8.Queue;

public class ParcialArboles {
	private GeneralTree<Integer> ab;
	
	public ParcialArboles(GeneralTree<Integer> a) {
		this.ab = a;
	}
	
	public LinkedList<Integer> camino (int num){
		LinkedList<Integer> aux = new LinkedList<Integer>();
		LinkedList<Integer> lista = new LinkedList<Integer>();
		if (!ab.isEmpty()) {
			
			resuelve(lista, aux, ab, num);
		}
		return lista;
	}
	
	private void resuelve(LinkedList<Integer> l, LinkedList<Integer> aux, GeneralTree<Integer> ab, int num) {
		
		aux.add(ab.getData());
		
		if (ab.isLeaf()) {
			l.addAll(aux);
			return;
		}
		
		if (ab.getChildren().size() != num) {
			aux.remove(aux.size() - 1);
			return;
		}
		
		for (GeneralTree<Integer> hijos : ab.getChildren()) {
			
			resuelve(l, aux, hijos, num);
			if (!l.isEmpty())
				break;
		}
		
		aux.remove(aux.size() - 1);
	}
	public static void main(String[] args) {

	}

}
