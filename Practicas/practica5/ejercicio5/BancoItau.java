package practica5.ejercicio5;

import practica5.ejercicio1.*;
import practica5.ejercicio1.adjList.AdjListGraph;
import practica1.ejercicio8.*;
import java.util.LinkedList;


public class BancoItau {
	
	
	public LinkedList<Persona> jubilados (Graph<Persona> personas, int valorMaximo, Persona empleado, int maxJubilados){
		LinkedList<Persona> jubilados = new LinkedList<>();
		boolean [] visitados = new boolean [personas.getSize()];
		Vertex<Persona> origen = personas.search(empleado);
		if (origen != null)
			BFSJubilados(personas, origen, jubilados, visitados, valorMaximo, maxJubilados);
		
		return jubilados;
	}
	
	private void BFSJubilados(Graph<Persona> personas, Vertex<Persona> actual, LinkedList<Persona> jubilados, boolean [] visitados, int valorMaximo, int maxJubilados) {
		Queue<Vertex<Persona>> BFS = new Queue<Vertex<Persona>>(); // esta poronga se recorre con una cola
		BFS.enqueue(actual); // la misma mierda que en el recorrido por niveles
		BFS.enqueue(null); // la misma puta logica
		visitados[actual.getPosition()] = true; // marcamos el primero osea el actual
		while (BFS != null && valorMaximo > 0 && jubilados.size() <= maxJubilados ) { // si no termina la cola, no nos alejamos lo suficiente y no nos quedamos sin espacio
			actual = BFS.dequeue(); // desencolamos el primero para procesarlo
			
			if (actual != null) { //si es null osea que o finalizo todo o finalizo el "nivel"
				for (Edge<Persona> e : personas.getEdges(actual)) { // recorremos todos sus adyacentes
					Vertex<Persona> vecino = e.getTarget(); // lo extraemos
					
					if (!visitados[vecino.getPosition()]) { // cheuqeamos que no lo hayamos visitado antes
						visitados[vecino.getPosition()] = true; // lo marcamos
						BFS.enqueue(vecino); // y lo encolamos para procesarlo despues
						
						Persona p = vecino.getData(); //extraemos la data  del jubilado (posiblemente jubilado sin aportes)
						
						if ( p.cumple() && jubilados.size() < maxJubilados) { // chequeamos que cumpla y que haya lugar (CFK se olvido esta parte y jubilo de mas)
							jubilados.add(p); // lo agregamos
						}
					}
					
				}
			} else if (!BFS.isEmpty()) { //si aun quedan cosas en la cola, significa que solo terminamos un nivel
				valorMaximo--; // decrementamos 1 nivel 
				BFS.enqueue(null); // volvemos a encolar el final del nuevo niveñ
			}
		}
		return; // al pedo pero me gusta ponerlo igual
	}
	

	public static void main(String[] args) {
		//todos los grafos, arboles y ejemplos de estructuras son robados de Matias Guaymas (te quiero mucho)
		Graph<Persona> grafo = new AdjListGraph<>();
		Persona p = new Persona("Empleado", "Matias", "AAA", true);
        Vertex v1 = grafo.createVertex(p);
        Vertex v2 = grafo.createVertex(new Persona("Jubilado", "Julian", "BBB", false));
        Vertex v3 = grafo.createVertex(new Persona("Jubilado", "Francisco", "CCC", false));
        Vertex v4 = grafo.createVertex(new Persona("Empleado", "Valentin", "DDD", true));
        Vertex v5 = grafo.createVertex(new Persona("Jubilado", "Omar", "EEE", true));
        Vertex v6 = grafo.createVertex(new Persona("Empleado", "Rosana", "FFF", true));
        Vertex v7 = grafo.createVertex(new Persona("Jubilado", "Maria", "GGG", false));
        Vertex v8 = grafo.createVertex(new Persona("Jubilado", "Sandra", "HHH", true));
        Vertex v9 = grafo.createVertex(new Persona("Jubilado", "Matheo", "III", false));
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        
        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);
        
        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);
        
        
        BancoItau banco = new BancoItau();
        
        System.out.println(banco.jubilados(grafo, 2, p, 40));

	}

}
