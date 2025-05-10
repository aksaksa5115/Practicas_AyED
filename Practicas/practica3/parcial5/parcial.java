package practica3.parcial5;
import java.util.LinkedList;
import java.util.List;

import practica3.ejercicio1.GeneralTree;
public class parcial {
	private GeneralTree<Integer> ab;
	
	
	
	public parcial(GeneralTree<Integer> ab2) {
		// TODO Auto-generated constructor stub
		this.ab = ab2;
	}

	public LinkedList<Integer> hojaLejana (){
		LinkedList<Integer> res = new LinkedList<Integer>();
		if (!ab.isEmpty())
			resuelve(res, ab, new LinkedList<Integer>());
		return res;
	}
	
	private void resuelve(LinkedList<Integer> l, GeneralTree<Integer> ab, LinkedList<Integer> aux) {
		aux.add(ab.getData());
		if (ab.isLeaf()) {
			if (aux.size() > l.size()) {
				l.clear();
				l.addAll(aux);
			}
		} else {
			for (GeneralTree<Integer> hijos : ab.getChildren())
				resuelve(l, hijos, aux);
		}
		aux.remove(aux.size() - 1);
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
        
        parcial cam = new parcial(a);
        System.out.println(cam.hojaLejana());
	}

}
