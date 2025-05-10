package practica2.parcial7;
import practica2.ejercicio1y2.BinaryTree;
import java.util.LinkedList;
public class Parcial {
	
	
	public LinkedList<Integer> resolver(BinaryTree<Integer> ab, int n) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		if (!ab.isEmpty()) {
			LinkedList<Integer> aux = new LinkedList<Integer>();
			resultado(ab, res, aux, n, 0);
		}
		return res;
	}
	
	private void resultado(BinaryTree<Integer> ab, LinkedList<Integer> res, LinkedList<Integer> aux, int n, int pares) {
		aux.add(ab.getData());
		
		if (ab.getData() % 2 == 0)
			pares++;
		
		if (ab.isLeaf()) {
			if (pares >= n) {
				res.clear();
				res.addAll(aux);
				return;
			} 
		} else {
			if (ab.hasLeftChild())
				resultado(ab.getLeftChild(), res, aux, n, pares);
			if (ab.hasRightChild())
				resultado(ab.getRightChild(), res, aux, n, pares);
		}
		aux.remove(aux.size() - 1);
		
	}
	

	public static void main(String[] args) {
		

		BinaryTree<Integer> ab = new BinaryTree<Integer>(6);

		BinaryTree<Integer> nodo3 = new BinaryTree<Integer>(3);
		nodo3.addLeftChild(new BinaryTree<Integer>(2));
		BinaryTree<Integer> nodo4 = new BinaryTree<Integer>(4);
		nodo4.addLeftChild(new BinaryTree<Integer>(5));
		nodo3.addRightChild(nodo4);

		BinaryTree<Integer> nodo8 = new BinaryTree<Integer>(8);
		nodo8.addLeftChild(new BinaryTree<Integer>(1));
		BinaryTree<Integer> nodo10 = new BinaryTree<Integer>(10);
		nodo10.addLeftChild(new BinaryTree<Integer>(12));
		nodo8.addRightChild(nodo10);

		ab.addLeftChild(nodo3);
		ab.addRightChild(nodo8);
		
		Parcial p = new Parcial();
		LinkedList<Integer> resultado = p.resolver(ab, 3);
		System.out.println(resultado);


	}

}
