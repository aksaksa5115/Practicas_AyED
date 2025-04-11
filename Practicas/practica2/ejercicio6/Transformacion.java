package practica2.ejercicio6;
import practica2.ejercicio1y2.BinaryTree;



public class Transformacion {

	public static BinaryTree<Integer> suma (BinaryTree<Integer> ab){
		if (!ab.isEmpty())
			sumas(ab);
		return ab;
	}
	
	private static int sumas(BinaryTree<Integer> ab2) {
		int sum = 0;
		if (ab2.isLeaf()) {
			sum = ab2.getData();
			ab2.setData(0);
			return sum;
		}
		if (ab2.hasLeftChild())
			sum += sumas(ab2.getLeftChild());
		if (ab2.hasRightChild())
			sum += sumas(ab2.getRightChild());
		int actual = ab2.getData();
		ab2.setData(sum);
		return actual + sum;
	}
	
	
	
	
	public static void main(String[] args) {
		
        System.out.println("Test Transformacion");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        ab.imprimirArbol();
        System.out.println("Arbol transformado");
        ab = suma(ab);
        ab.imprimirArbol();

	}

}
