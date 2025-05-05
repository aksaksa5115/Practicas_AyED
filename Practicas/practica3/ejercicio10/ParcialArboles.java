package practica3.ejercicio10;

import java.util.LinkedList;
import java.util.List;

import practica3.ejercicio1.GeneralTree;

public class ParcialArboles {
	private GeneralTree<Integer> ab;
	
	
	
	public static LinkedList<Integer> resolver(GeneralTree<Integer> ab) {
		
		LinkedList<Integer> resuelve = new LinkedList<Integer>();
		LinkedList<Integer> maximo = new LinkedList<Integer>();
		Maximo max = new Maximo(-1);
		if (!ab.isEmpty()) {
			resuelve(ab, resuelve, maximo, 1, 0, max);
		}
		return maximo;
	}
	
	private static void resuelve(GeneralTree<Integer> ab, LinkedList<Integer> lista, LinkedList<Integer> maximo, int nivel, int suma, Maximo max) {
		
		if (ab.getData() == 1) {
			lista.add(ab.getData());
			suma += ab.getData() * nivel;
		}
		
		if (ab.isLeaf()) {
			if (suma > max.getMax()) {
				max.setMax(suma);
				maximo.clear();
				maximo.addAll(lista);
			}
		} else {
			for (GeneralTree<Integer> hijos : ab.getChildren()) {
				resuelve(hijos, lista, maximo, nivel + 1, suma, max);
			}
		}
		
		if (ab.getData() == 1) {
			lista.remove(lista.size() - 1);
		}
		
	}
	

	public static void main(String[] args) {
		List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(1, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(subA);
        subChildren2.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(0, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(0, subChildren3);
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(subB);
        GeneralTree<Integer> subC = new GeneralTree<Integer>(0, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(new GeneralTree<Integer>(1));
        subChildren5.add(subC);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, subChildren5);
        
        List<GeneralTree<Integer>> subChildren6 = new LinkedList<GeneralTree<Integer>>();
        subChildren6.add(new GeneralTree<Integer>(0));
        subChildren6.add(new GeneralTree<Integer>(0));
        GeneralTree<Integer> subD = new GeneralTree<Integer>(0, subChildren6);
        List<GeneralTree<Integer>> subChildren7 = new LinkedList<GeneralTree<Integer>>();
        subChildren7.add(subD);
        GeneralTree<Integer> subE = new GeneralTree<Integer>(0, subChildren7);
        List<GeneralTree<Integer>> subChildren8 = new LinkedList<GeneralTree<Integer>>();
        subChildren8.add(subE);
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(1, subChildren8);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(1, arbol);
        
        System.out.println(resolver(a));
		
		

	}

}
