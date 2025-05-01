package practica3.ejercicio4;

import practica3.ejercicio1.GeneralTree;
import practica1.ejercicio8.Queue;
public class AnalizadorArbol {

	
	
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		double maximo = 0;
		if (!arbol.isEmpty())
			maximo = resuelve(arbol);
		return maximo;
	}
	
	private double resuelve(GeneralTree<AreaEmpresa> arbol) {
		
		GeneralTree<AreaEmpresa> aux;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue();
		cola.enqueue(arbol);
		cola.enqueue(null); //lo usamos para saber cuando finalizamos el nivel
		double maxProm = 0;
		double sumaNivel = 0;
		int cantNodosNivel = 0;
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			
			if (aux != null) {
				sumaNivel = aux.getData().getRetardo();
				cantNodosNivel++;
				
				for (GeneralTree<AreaEmpresa> hijos : aux.getChildren())
					cola.enqueue(hijos);
			} else { 
				double prom = sumaNivel / cantNodosNivel;
				maxProm = Math.max(maxProm, prom);
				
				sumaNivel = 0;
				cantNodosNivel = 0;
				
				if (!cola.isEmpty())
					cola.enqueue(null);
				
			}
			
		}
		
		return maxProm;
	}
	
	
	
	public static void main(String[] args) {
		

	}

}
