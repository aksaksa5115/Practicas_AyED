package practica3.parcial3;
import java.util.LinkedList;
import java.util.List;
import practica1.ejercicio8.Queue;
import practica3.ejercicio1.GeneralTree;

public class Parcial {
	private GeneralTree<Integer> ab;
	
	
	/*
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		boolean ok = false;
		
		if (!arbol.isEmpty()) {
			int nodoRaiz = arbol.getData();
			ok = resuelve(arbol, nodoRaiz);
		}
		return ok;
	}
	
	private static boolean resuelve(GeneralTree<Integer> ab, int Raiz) {
		boolean ok = true;
		
		if (!ab.getChildren().isEmpty()) {
			int menor = hijoMenor(ab.getChildren());
			if (menor != Raiz)
				return false;
		}
		for (GeneralTree<Integer> hijos : ab.getChildren()) {
		    if (!resuelve(hijos, ab.getData())) {
		        return false;
		    }
		}
		return ok;
	}
	
	private static int hijoMenor (List<GeneralTree<Integer>> ListaHijos) {
		int x = Integer.MAX_VALUE;
		for (GeneralTree<Integer> hijos : ListaHijos)
			x = Math.min(hijos.getData(), x);
		
		return x;
	}
	*/
	
	public static boolean esDeSeleccion(GeneralTree<Integer> ab) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(ab);
		GeneralTree<Integer> aux = new GeneralTree<Integer>();
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			int Menor = Integer.MAX_VALUE;
			for (GeneralTree<Integer> hijos : aux.getChildren()) {
				Menor = Math.min(hijos.getData(), Menor);
				cola.enqueue(hijos);
			}
			if ((!aux.isLeaf()) && (Menor != aux.getData()))
				return false;
		}
		return true;
		
	}

	public static void main(String[] args) {
		
        List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(35));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(35, subChildren1);
        
        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(35, subChildren2);
        
        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(35));
        subChildren3.add(new GeneralTree<Integer>(83));
        subChildren3.add(new GeneralTree<Integer>(90));
        subChildren3.add(new GeneralTree<Integer>(33));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(33, subChildren3);
        
        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(14));
        subChildren4.add(new GeneralTree<Integer>(12));
        //subChildren4.add(new GeneralTree<Integer>(18));
        subChildren4.add(subAb3);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(12, subChildren4);
        //GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(18, subChildren4);
        
        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(12, subArbIzq);
        
        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(25));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
        
        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol); 
        
        System.out.println("Es de seleccion el primer arbol: " + esDeSeleccion(a));
		

	}

}
