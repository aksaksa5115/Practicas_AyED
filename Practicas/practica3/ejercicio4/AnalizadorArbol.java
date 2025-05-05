package practica3.ejercicio4;

import practica3.ejercicio1.GeneralTree;
import java.util.LinkedList;
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
				sumaNivel += aux.getData().getRetardo();
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
		
		 LinkedList<GeneralTree<AreaEmpresa>> children1 = new LinkedList<GeneralTree<AreaEmpresa>>();
	        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("A",4)));
	        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("B",7)));
	        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("C",5)));
	        GeneralTree<AreaEmpresa> a1 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("J",13), children1);
	        
	        LinkedList<GeneralTree<AreaEmpresa>> children2 = new LinkedList<GeneralTree<AreaEmpresa>>();
	        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("D",6)));
	        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("E",10)));
	        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("F",18)));
	        GeneralTree<AreaEmpresa> a2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("K",25), children2);
	        
	        LinkedList<GeneralTree<AreaEmpresa>> children3 = new LinkedList<GeneralTree<AreaEmpresa>>();
	        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("G",9)));
	        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("H",12)));
	        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("I",19)));
	        GeneralTree<AreaEmpresa> a3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("L",10), children3);
	        
	        LinkedList<GeneralTree<AreaEmpresa>> children4 = new LinkedList<GeneralTree<AreaEmpresa>>();
	        children4.add(a1);
	        children4.add(a2);
	        children4.add(a3);
	        GeneralTree<AreaEmpresa> a = new GeneralTree<AreaEmpresa>(new AreaEmpresa("M",14), children4);
	        
	        AnalizadorArbol arb = new AnalizadorArbol();
	        System.out.println("El mayor promedio entre todos los valores promedios de los niveles es: " + arb.devolverMaximoPromedio(a));

	}

}
