package practica3.parcial4;

import practica3.ejercicio1.GeneralTree;
import java.util.LinkedList;

public class Parcial {
	private GeneralTree<Integer> ab;
	
	public LinkedList<LinkedList<Character>> caminosPares (GeneralTree<Character> ab){
		LinkedList<LinkedList<Character>> res = new LinkedList<LinkedList<Character>>();
		if (!ab.isEmpty())
			resuelve(res, ab);
		return res;
	}
	
	private void resuelve(LinkedList<LinkedList<Character>> L, GeneralTree<Character> ab) {
		
		
	}
	
	
	public static void main(String[] args) {

	}

}


