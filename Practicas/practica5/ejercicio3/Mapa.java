/*Ejercicio 3
 3. caminoMasCorto(String ciudad1, String ciudad2): List<String>
 Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
 existe camino retorna la lista vacía. (Las rutas poseen la distancia).
 4. caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto): List<String>
 Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
 quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.
 5. caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto): List<String>
 Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
 que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
 medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
 retorna la lista vacía.*/

package practica5.ejercicio3;

import practica5.ejercicio1.adjList.*;
import practica5.ejercicio1.Edge;
import practica5.ejercicio1.Graph;
import practica5.ejercicio1.Vertex;
import java.util.LinkedList;
import practica1.ejercicio8.Queue;

public class Mapa {
	private Graph<String> mapita;
	
	
	public Mapa(Graph<String> mapaCiudades) {
		this.mapita = mapaCiudades;
	}

	/*1. devolverCamino (String ciudad1, String ciudad2): List<String>
 	Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
 	pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).*/
	
	public LinkedList<String> devolverCamino (String ciudad1, String ciudad2){
		boolean [] visitados = new boolean[this.mapita.getSize()];
		LinkedList<String> lista = new LinkedList<String>();
		Vertex<String> origen = this.mapita.search(ciudad1);
		Vertex<String> destino = this.mapita.search(ciudad2);
		if (origen != null && destino != null)
			DCResuelve(origen, destino, lista, visitados);
		return lista;
	}
	
	private boolean DCResuelve (Vertex<String> origen, Vertex<String> destino, LinkedList<String> camino, boolean[] visitados) {
		visitados[origen.getPosition()] = true;
		camino.add(origen.getData());
		if (origen.getData().equals(destino.getData()))
			return true;
		
		for (Edge<String> e : this.mapita.getEdges(origen)) {
			Vertex<String> vecino = e.getTarget();
			
			if (!visitados[vecino.getPosition()]) {
				
				if (DCResuelve(vecino, destino, camino, visitados))
					return true;
				
			}
		}
		camino.remove(camino.size() - 1);
		return false;
		
	}
	
	/*2. devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades): List<String>
 	Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
 	que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
 	vacía. (Sin tener en cuenta el combustible).*/
	
	public LinkedList<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, LinkedList<String> ciudades){
		boolean [] visitados = new boolean[this.mapita.getSize()];
		LinkedList<String> lista = new LinkedList<String>();
		Vertex<String> origen = this.mapita.search(ciudad1);
		Vertex<String> destino = this.mapita.search(ciudad2);
		if (origen != null && destino != null)
			DCEResuelve(origen, destino, lista, ciudades, visitados);
		return lista;
	}
	
	private boolean DCEResuelve (Vertex<String> actual, Vertex<String> destino, LinkedList<String> camino, LinkedList<String> prohibidos, boolean[] visitados ) {
		
		if (prohibidos.contains(actual.getData())) {
			return false;
		}
		visitados[actual.getPosition()] = true;
		camino.add(actual.getData());
		
		if(actual.getData().equals(destino.getData())) {
			return true;
		}
		
		for (Edge<String> e : this.mapita.getEdges(actual)) {
			Vertex<String> vecino = e.getTarget();
			if (!visitados[vecino.getPosition()] && !prohibidos.contains(vecino.getData())) {
				if (DCEResuelve (vecino, destino, camino, prohibidos, visitados)){
					return true;
				}
			}
			
		}
		camino.remove(camino.size() - 1);
		return false;
	}
	
	
	public LinkedList<String> caminoMasCorto(String ciudad1, String ciudad2) {
		boolean [] visitados = new boolean[this.mapita.getSize()];
		LinkedList<String> lista = new LinkedList<String>();
		Vertex<String> origen = this.mapita.search(ciudad1);
		Vertex<String> destino = this.mapita.search(ciudad2);
		if (origen != null && destino != null)
			CMCresuelve(origen, destino, lista, new LinkedList<String>(), visitados, 0, Integer.MAX_VALUE);
		return lista;
	}
	
	private int CMCresuelve (Vertex<String> actual, Vertex<String> destino, LinkedList<String> camino, LinkedList<String> camActual, 
    boolean[] visitados, int DistActual, int DistMinima) {
		
		visitados[actual.getPosition()] = true;
		camActual.add(actual.getData());
		if (actual.equals(destino) && DistActual < DistMinima) {
			camino.removeAll(camino);
			camino.addAll(camActual);
			DistMinima = DistActual; 
		} else {
			for (Edge<String> e : this.mapita.getEdges(actual)) {
				Vertex<String> vecino = e.getTarget();
				int peso = e.getWeight();
				if (!visitados[vecino.getPosition()] && DistActual + peso < DistMinima) {
					DistMinima = CMCresuelve(vecino, destino, camino, camActual, visitados, DistActual + peso, DistMinima);
				}
			}
		}
		
		visitados[actual.getPosition()] = false;
		camActual.remove(camActual.size() - 1);
		
		return DistMinima;
		
	
	}
	
	public LinkedList<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int combustible){
		boolean [] visitados = new boolean[this.mapita.getSize()];
		LinkedList<String> lista = new LinkedList<String>();
		Vertex<String> origen = this.mapita.search(ciudad1);
		Vertex<String> destino = this.mapita.search(ciudad2);
		if (origen != null && destino != null)
			CSCC(origen, destino, lista, visitados, combustible);
		return lista;
	}
	
	private boolean CSCC(Vertex<String> actual, Vertex<String> destino, LinkedList<String> camino, boolean[] visitados, int combustible) {
		visitados[actual.getPosition()] = true;
		camino.add(actual.getData());
		if (actual.equals(destino))
			return true;
		for (Edge<String> e : this.mapita.getEdges(actual)) {
			Vertex<String> vecino = e.getTarget();
			if (!visitados[vecino.getPosition()] && e.getWeight() <= combustible) {
				if (CSCC(vecino, destino, camino, visitados, combustible - e.getWeight()))
					return true;
			}
		}
		visitados[actual.getPosition()] = false;
		camino.remove(camino.size() - 1);
		return false;
		
	}
	
	public LinkedList<String> caminoCargandoMenosCombustible(String ciudad1, String ciudad2, int combustible){
		boolean [] visitados = new boolean[this.mapita.getSize()];
		LinkedList<String> lista = new LinkedList<String>();
		Vertex<String> origen = this.mapita.search(ciudad1);
		Vertex<String> destino = this.mapita.search(ciudad2);
		if (origen != null && destino != null)
			CCCC(origen, destino, lista, new LinkedList<String>(), visitados, combustible, 0, Integer.MAX_VALUE, combustible);
		return lista;
	}
	
	private int CCCC (Vertex<String> actual, Vertex<String> destino, LinkedList<String> camino, LinkedList<String> camActual, boolean [] visitados, int combustible, int cantRecargas, int minRecargas, int tanque) {
		visitados[actual.getPosition()] = true;
		camActual.add(actual.getData());
		if (actual.equals(destino) && cantRecargas < minRecargas) {
			camino.removeAll(camino);
			camino.addAll(camActual);
			minRecargas = cantRecargas;
		} else {
			for (Edge<String> e: this.mapita.getEdges(actual)) {
				Vertex<String> vecino = e.getTarget();
				int peso = e.getWeight();
				if (!visitados[vecino.getPosition()]) {
					if (combustible >= peso) {
						minRecargas = CCCC(vecino, destino, camino, camActual, visitados, combustible - peso, cantRecargas, minRecargas, tanque);
					} else if (tanque >= peso) {
						minRecargas = CCCC(vecino, destino, camino, camActual, visitados, tanque - peso, cantRecargas + 1, minRecargas, tanque);
					}
				}
			}
		}
		visitados[actual.getPosition()] = false;
		camActual.remove(camActual.size() - 1);
		
		return minRecargas;
		
	}
	
	public static void main(String[] args) {
		
		Graph<String> mapaCiudades = new AdjListGraph<String>();
        Vertex<String> v1 = mapaCiudades.createVertex("La Plata"); //Casa Caperucita
        Vertex<String> v2 = mapaCiudades.createVertex("Ensenada"); //Claro 3
        Vertex<String> v3 = mapaCiudades.createVertex("Berisso"); //Claro 1
        Vertex<String> v4 = mapaCiudades.createVertex("Berazategui"); //Claro 2
        Vertex<String> v5 = mapaCiudades.createVertex("Florencio Varela"); //Claro 5
        Vertex<String> v6 = mapaCiudades.createVertex("Presidente Peron"); //Claro 4
        Vertex<String> v7 = mapaCiudades.createVertex("San Vicente"); //Casa Abuelita
        mapaCiudades.connect(v1, v2, 4);
        mapaCiudades.connect(v2, v1, 4);
        mapaCiudades.connect(v1, v3, 3);
        mapaCiudades.connect(v3, v1, 3);
        mapaCiudades.connect(v1, v4, 4);
        mapaCiudades.connect(v4, v1, 4);
        mapaCiudades.connect(v2, v5, 15);
        mapaCiudades.connect(v5, v2, 15);
        mapaCiudades.connect(v3, v5, 3);
        mapaCiudades.connect(v5, v3, 3);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v4, v5, 11);
        mapaCiudades.connect(v5, v4, 11);
        mapaCiudades.connect(v4, v6, 10);
        mapaCiudades.connect(v6, v4, 10);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v5, v7, 4);
        mapaCiudades.connect(v7, v5, 4);
        mapaCiudades.connect(v6, v7, 9);
        mapaCiudades.connect(v7, v6, 9);
        
        Mapa mapa = new Mapa(mapaCiudades);
        
        System.out.print("LISTA DEVOLVER CAMINO: ");
        System.out.println(mapa.devolverCamino("La Plata", "San Vicente"));
        
        LinkedList<String> prohibidos = new LinkedList<String>();
        prohibidos.add("Berisso");
        System.out.println("-------------------------------------------");
        System.out.print("LISTA DEVOLVER CAMINO EXCEPTO LOS PROHIBIDOS: ");
        //System.out.print(mapa.devolverCaminoExceptuando("La Plata", "San Vicente", prohibidos));
        System.out.println("-------------------------------------------");
        System.out.println("LISTA DEVOLVER CAMINO MAS CORTO");
        //System.out.println(mapa.caminoMasCorto("La Plata", "San Vicente"));
        System.out.println("-------------------------------------------");
        System.out.println("LISTA DEVOLVER CAMINO SIN CARGAR NAFTA");
        //System.out.println(mapa.caminoSinCargarCombustible("La Plata", "San Vicente", 10));
        System.out.println("-------------------------------------------");
        System.out.println("LISTA DEVOLVER CAMINO CARGANDO LA MENOR CANTIDAD DE VECES");
        System.out.println(mapa.caminoCargandoMenosCombustible("La Plata", "San Vicente", 4));

        
	}

}
