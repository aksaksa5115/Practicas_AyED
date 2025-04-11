package practica2.ejercicio4;
import practica2.ejercicio1y2.BinaryTree;

public class RedBinariaLlena {
	

	public static int RetardoReenvio(BinaryTree<Integer> ab) {
		int x = 0;
		if (!ab.isEmpty()) {
			x = MayorRetardoReenvio(ab);
		}
		return x;
	}
	
	public static int MayorRetardoReenvio(BinaryTree<Integer> ab) {
		int retardoIzquierdo = 0;
		int retardoDerecho = 0;
		
		if (ab.hasLeftChild())
			retardoIzquierdo = MayorRetardoReenvio(ab.getLeftChild());
		if (ab.hasRightChild())
			retardoDerecho = MayorRetardoReenvio(ab.getRightChild());
		
		return Math.max(retardoIzquierdo, retardoDerecho) + ab.getData();
	}
	
	
	public static void main(String args []) {
		
        System.out.println("Test mayor retardo");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        System.out.println("El mayor retardo posible es de: " + RetardoReenvio(ab) + " segundos");
		
	}

}
