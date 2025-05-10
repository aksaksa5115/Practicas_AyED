package practica3.parcial6;
import java.util.LinkedList;
import java.util.List;

import practica3.ejercicio1.GeneralTree;

public class Parcial {
	
	
	public int recorridoPostOrden(GeneralTree<Integer> ab, int min) {
		
		for (GeneralTree<Integer> hijos : ab.getChildren()) {
			min = recorridoPostOrden(hijos, min);
		}
		if (ab.getData() > min)
			min = ab.getData();
		
		return min;
		
		
	}

	
	public static void main(String[] args) {
		
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(2));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(7, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(new GeneralTree<Integer>(4));
        subChildren2.add(subAb1);
        subChildren2.add(new GeneralTree<Integer>(6));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(3, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        subChildren3.add(new GeneralTree<Integer>(9));
        subChildren3.add(new GeneralTree<Integer>(10));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(5, subChildren3);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        GeneralTree<Integer> a = new GeneralTree<Integer>(8, arbol);
        
        Parcial r = new Parcial();
        System.out.println(r.recorridoPostOrden(a, Integer.MIN_VALUE));

	}

}
