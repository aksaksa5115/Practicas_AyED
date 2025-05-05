package practica3.ejercicio7;

import java.util.LinkedList;
import java.util.List;

import practica3.ejercicio1.GeneralTree;

public class Caminos {
	private GeneralTree<Integer> ab;
	
	
	public Caminos(GeneralTree<Integer> a) {
		this.ab = a;
	}

	public LinkedList<Integer> caminoAHojaMasLejana(){
		LinkedList<Integer> lejano = new LinkedList<Integer>();
		LinkedList<Integer> actual = new LinkedList<Integer>();
		if (!ab.isEmpty()) {
			HojaLejana(ab, lejano, actual);
		}
		return lejano;
	}
	
	private void HojaLejana(GeneralTree<Integer> ab, LinkedList<Integer> lejano, LinkedList<Integer> actual){

		actual.add(ab.getData());
		
		if (ab.isLeaf()) {
			if (actual.size() > lejano.size()) {
				lejano.clear();
				lejano.addAll(actual);
			}
		} else {
			for (GeneralTree<Integer> hijos : ab.getChildren()) {
				HojaLejana(hijos, lejano, actual);
			}
		}
		actual.remove(actual.size() - 1); 
	}
	
	public static void main (String args[]) {
		
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(6, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(new GeneralTree<Integer>(10));
        subChildren2.add(subA);
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(17, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(9, subChildren3);
        
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(16));
        subChildren4.add(new GeneralTree<Integer>(7));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(14, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(subB);
        subChildren5.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(15, subChildren5);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol);
        
        Caminos cam = new Caminos(a);
        
        System.out.println("Camino a hoja mas lejana: " + cam.caminoAHojaMasLejana());
	}
	
}
