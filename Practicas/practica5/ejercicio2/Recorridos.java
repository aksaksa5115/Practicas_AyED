package practica5.ejercicio2;
import practica5.ejercicio1.adjList.*;
import practica5.ejercicio1.Edge;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import java.util.LinkedList;
import practica1.ejercicio8.Queue;

public class Recorridos<T> {
	
	public Recorridos() {};
	
	
	public LinkedList<T> DFS (Graph<T> grafo){
		boolean [] visitados = new boolean[grafo.getSize()];
		LinkedList<T> lista = new LinkedList<T>();
		for (Vertex<T> v : grafo.getVertices()) {
			if (!visitados[v.getPosition()]) {
				defese(grafo, v, visitados, lista);
			}
		}
		return lista;
	} 
	
	public void defese (Graph<T> grafo, Vertex<T> v, boolean[] visitados, LinkedList<T> lista) {
		visitados[v.getPosition()] = true; //marcamos al que estamos visitando
		lista.add(v.getData()); //lo agregamos a la lista 
		
		for (Edge e : grafo.getEdges(v)) { //loopeamos por cada conexion encontrada en el rango del grafo
			Vertex<T> vecino = e.getTarget(); //extraemos el vertice targeteado
			if (!visitados[vecino.getPosition()]) //verificamos que no haya sido visitado
				defese(grafo, vecino, visitados, lista); //recursivamos con el vertice targeteado
		}
		
	}
	
	public LinkedList<T> BFS (Graph<T> grafo){
		boolean [] visitados = new boolean[grafo.getSize()];
		LinkedList<T> lista = new LinkedList<T>();
		for (Vertex<T> v : grafo.getVertices()) {
			if (!visitados[v.getPosition()]) {
				defese(grafo, v, visitados, lista);
			}
		}
		return lista; 
	}
	
	public void befese (Graph<T> grafo, Vertex<T> v, boolean[] visitados, LinkedList<T> lista) {
		Queue<Vertex<T>> cola = new Queue<Vertex<T>>(); // usaremos para recorrer en orden
		cola.enqueue(v); // encolamos el primero
		visitados[v.getPosition()] = true; //lo marcamos en visitado
		
		while (!cola.isEmpty()) {
			Vertex<T> aux = cola.dequeue(); // extraemos uno
			lista.add(aux.getData()); //lo agregamos a la lista
			
			for (Edge<T> vecino : grafo.getEdges(aux)) { // por cada conexion
				Vertex<T> AuxV = vecino.getTarget(); // extraemos un vertice
				if (!visitados[AuxV.getPosition()]) { // verificamos que no haya sido visitado
					visitados[AuxV.getPosition()] = true; // lo marcamos como visitado
					cola.enqueue(AuxV); // y lo encolamos para recorrerlo
				}
			}
		}
	}
	
	

}
