package practica3.ejercicio11;

import practica3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

import practica1.ejercicio8.Queue;

public class ParcialArboles {
	private GeneralTree<Integer> ab;
	
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		boolean ok = false;
		
		if (!arbol.isEmpty())
			ok = resuelve(arbol);
		
		return ok;
	}
	
	private static boolean resuelve(GeneralTree<Integer> ab) {
		
		GeneralTree<Integer> aux = new GeneralTree<Integer>(); // variable auxiliar para recorrer los hijos
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>(); // tu cola
		
		cola.enqueue(ab); // encolamos el primer nodo (raiz de todo)
		int nodosAntiguos = 0; // arrancamos por lo mas facil, en la primera iteracion la cantidad de nodos antiguos es 0 (aun no arrancamos)
		while (!cola.isEmpty()) { // ya saben esto
			int nodosActuales = cola.size(); // nos quedamos con la cantidad de nodos  
			
			if (nodosActuales != (nodosAntiguos + 1)) // chequeamos que cumpla la condicion de que tiene que haber uno mas que en el nivel anterior
				return false;
			
			for (int i=0; i < nodosActuales; i++) { // recorremos todos los nodos que fueron cargados
				aux = cola.dequeue(); // descolamos el primero
				for (GeneralTree<Integer> hijos : aux.getChildren()) // lo usaremos para recorrer sus hijos
					cola.enqueue(hijos); // y guardarlos
			}
			nodosAntiguos = nodosActuales; // actualizamos nodosAntiguos cada vez que termina un nivel
		}
		return true; // si llega hasta aca significa que malio sien
	}
	 
	 
	 
	public static void main(String[] args) {
		
		List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(83));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(18, subChildren1);
        
        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(5, subChildren2);
        
        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(33));
        subChildren3.add(new GeneralTree<Integer>(12));
        subChildren3.add(new GeneralTree<Integer>(17));
        subChildren3.add(new GeneralTree<Integer>(9));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(3, subChildren3);
        
        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(7));
        subChildren4.add(new GeneralTree<Integer>(11));
        subChildren4.add(subAb3);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(4, subChildren4);
        
        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(1, subArbIzq);
        
        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(13));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
        
        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(2, arbol);
        
        System.out.println("Es creciente el arbol 1: " + resolver(a));
        
        List<GeneralTree<Integer>> subChildren5 = new LinkedList <GeneralTree<Integer>>();
        subChildren5.add(new GeneralTree<Integer>(7));
        subChildren5.add(subAb3);
        GeneralTree<Integer> subAb5 = new GeneralTree<Integer>(4, subChildren5);
        
        List<GeneralTree<Integer>> subArbIzq2 = new LinkedList<GeneralTree<Integer>>();
        subArbIzq2.add(subAb2);
        subArbIzq2.add(subAb5);
        GeneralTree<Integer> arbIzq2 = new GeneralTree<Integer>(1, subArbIzq2);
        
        List <GeneralTree<Integer>> arbol2 = new LinkedList <GeneralTree<Integer>>();
        arbol2.add(arbIzq2);
        arbol2.add(arbDer);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, arbol2);
        
        System.out.println("Es creciente el arbol 2: " + resolver(a2));
        
        
        //Mas casos para evaluar
        
        List <GeneralTree<Integer>> arbol3 = new LinkedList <GeneralTree<Integer>>();
        arbol3.add(new GeneralTree<Integer>(1));
        arbol3.add(new GeneralTree<Integer>(2));
        arbol3.add(new GeneralTree<Integer>(3));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(4, arbol3);
        
        System.out.println("Es creciente el arbol 3: " + resolver(a3));
        
        List <GeneralTree<Integer>> arbol4 = new LinkedList <GeneralTree<Integer>>();
        arbol4.add(new GeneralTree<Integer>(19));
        GeneralTree<Integer> a4 = new GeneralTree<Integer>(2, arbol4);
        
        System.out.println("Es creciente el arbol 4: " + resolver(a4)); //Me devolvia true porque la cola se vacio justo en el null y no llega a evaluar el else if y sale del while, retornando true (en mi primera resolucion)
        
        List <GeneralTree<Integer>> subArb1 = new LinkedList <GeneralTree<Integer>>();
        subArb1.add(new GeneralTree<Integer>(1));
        subArb1.add(new GeneralTree<Integer>(2));
        GeneralTree<Integer> subA3 = new GeneralTree<Integer>(4, subArb1);
        List <GeneralTree<Integer>> subArb2 = new LinkedList <GeneralTree<Integer>>();
        subArb2.add(new GeneralTree<Integer>(3));
        subArb2.add(subA3);
        GeneralTree<Integer> a5 = new GeneralTree<Integer>(6, subArb2); 
        
        System.out.println("Es creciente el arbol 5: " + resolver(a5));

	}

}
