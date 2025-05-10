package practica2.parcial8;
import practica2.ejercicio1y2.BinaryTree;
public class Parcial {
	
	public int sumaImparesPosOrdenMayorA (BinaryTree<Integer> ab, int limite) {
		int total = 0;
		if (!ab.isEmpty())
			total = resolver(ab, limite);
		
		
		return total;
	}
	
	private int resolver(BinaryTree<Integer> ab, int limite) {
		int suma = 0;
		if (ab.hasLeftChild())
			suma += resolver(ab.getLeftChild(), limite);
		if (ab.hasRightChild())
			suma += resolver(ab.getRightChild(), limite);
		if ((ab.getData() % 2 != 0) && (ab.getData() > limite))
			suma += ab.getData();
		return suma;
		
	}

	public static void main(String[] args) {
		
	    BinaryTree<Integer> ab = new BinaryTree<Integer>(15);
	    ab.addLeftChild(new BinaryTree<Integer>(7));
	    ab.addRightChild(new BinaryTree<Integer>(20));

	    ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(3));
	    ab.getLeftChild().addRightChild(new BinaryTree<Integer>(11));

	    ab.getRightChild().addLeftChild(new BinaryTree<Integer>(8));
	    ab.getRightChild().addRightChild(new BinaryTree<Integer>(17));

	    Parcial p = new Parcial();
	    int suma = p.sumaImparesPosOrdenMayorA(ab, 10);
	    System.out.println("Suma impares > 10: " + suma);  // Debería dar 43
		

	}

}
