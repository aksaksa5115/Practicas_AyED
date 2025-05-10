package practica2.parcial9;
import java.util.LinkedList;

import practica2.ejercicio1y2.BinaryTree;

public class parcial {
	
	
	public LinkedList<Integer> resolver(BinaryTree<Integer> ab){
		LinkedList<Integer> res = new LinkedList<Integer>();
		if (!ab.isEmpty())
			resuelve(ab, res);
		return res;
		
	}
	
	private void resuelve(BinaryTree<Integer> ab, LinkedList<Integer> l) {
		int izquierdos = 0;
		int derecho = 0;
		if (ab.hasLeftChild())
			izquierdos = contar(ab.getLeftChild());
		if (ab.hasRightChild())
			derecho = contar(ab.getRightChild());
		if (izquierdos == derecho)
			l.add(ab.getData());
		
		if (ab.hasLeftChild())
			resuelve(ab.getLeftChild(), l);
		if (ab.hasRightChild())
			resuelve(ab.getRightChild(), l);
	}
	
	private int contar(BinaryTree<Integer> ab) {
		int cant = 1;
		if (ab.hasLeftChild()) {
			cant++;
			cant += contar(ab.getLeftChild());
		}
		if (ab.hasRightChild()) {
			cant++;
			cant += contar(ab.getRightChild());
		}
		return cant;
	}
	
	public static void main(String[] args) {
		
	    BinaryTree<Integer> ab = new BinaryTree<>(10);

	    BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
	    nodo5.addLeftChild(new BinaryTree<>(3));
	    nodo5.addRightChild(new BinaryTree<>(7));

	    BinaryTree<Integer> nodo15 = new BinaryTree<>(15);
	    nodo15.addRightChild(new BinaryTree<>(20));

	    ab.addLeftChild(nodo5);
	    ab.addRightChild(nodo15);

	    parcial p = new parcial();
	    LinkedList<Integer> resultado = p.resolver(ab);

	    System.out.println(resultado);  // Debería imprimir: [5, 3, 7, 20]
		

	}

}
