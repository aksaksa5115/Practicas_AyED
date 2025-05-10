package practica3.parcial1;

import practica3.ejercicio1.GeneralTree;
import java.util.LinkedList;
import practica1.ejercicio8.Queue;
public class ParcialArboles {
	private GeneralTree<Integer> ab;
	
	public ParcialArboles(GeneralTree<Integer> a) {
		this.ab = a;
	}
	
	public LinkedList<Integer> nivel (int num){
		LinkedList<Integer> lista = new LinkedList<Integer>();
		if (!ab.isEmpty()) {
			int x = num;
			resuelve(lista, ab, x );
		}
		return lista;
	}
	
	private void resuelve(LinkedList<Integer> l, GeneralTree<Integer> ab, int x){
		
		GeneralTree<Integer> aux = new GeneralTree<Integer>();
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(ab);
		while (!cola.isEmpty()) {
			
			LinkedList<Integer> auxL = new LinkedList<Integer>();
			boolean cumplenTodos = true;
			
			int cantNodos = cola.size();
			for (int i=0; i<cantNodos; i++) {
				aux = cola.dequeue();
				auxL.add(aux.getData());
				
				if (aux.getChildren().size() != x)
					cumplenTodos = false;
			}
			if (cumplenTodos)
				l.addAll(auxL);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		

	}

}
