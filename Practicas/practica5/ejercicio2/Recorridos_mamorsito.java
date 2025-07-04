package practica5.ejercicio2;

import practica5.ejercicio1.Edge;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import java.util.ArrayList;

public class Recorridos_mamorsito {
	
	public ArrayList<Integer> dfs(Graph<Integer> grafo){
		boolean [] visitados = new boolean[grafo.getSize()]; 
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(!grafo.isEmpty()) {
			for(Vertex<Integer> v: grafo.getVertices()) {
				if(!visitados[v.getPosition()]) {
					defese(grafo, v, list, visitados);
				}
			}
		}
		return list;
	}
	
	private void defese(Graph<Integer> grafo, Vertex<Integer> v, ArrayList<Integer> list, boolean[] visitados) {
		visitados[v.getPosition()] = true;
		list.add(v.getData());
		for(Edge<Integer> e: grafo.getEdges(v)) {
			Vertex<Integer> vecino = e.getTarget();
			if(!visitados[vecino.getPosition()])
				defese(grafo, vecino, list, visitados);
		}
	}
	

	public static void main(String[] args) {

	}

}
