package practica2.ejercicio8;
import practica2.ejercicio1y2.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> ab;

	
	
	public boolean esPrefijo(BinaryTree<Integer> arb1, BinaryTree<Integer> arb2) {
		boolean ok = false;
		if (!arb1.isEmpty() && !arb2.isEmpty())
			ok = Prefijos(arb1, arb2);
		return ok;
	}
	
	private boolean Prefijos(BinaryTree<Integer> arb1, BinaryTree<Integer> arb2) {
		if (arb1.getData() != arb2.getData())
			return false;
		boolean res = true;
		if (arb1.hasLeftChild()) {
			if (arb2.hasLeftChild()) {
				if (res)
					res = Prefijos(arb1.getLeftChild(), arb2.getLeftChild());
			} else res = false;
				
		}
		if (arb1.hasRightChild()) {
			if(arb1.hasRightChild()) {
				if (res)
					res = Prefijos(arb1.getRightChild(), arb2.getRightChild());
			} else res = false;
		}
		return res;
	}
	public static void main(String[] args) {
		
        System.out.println("Test Ejercicio8");
        ParcialArboles parcialArboles = new ParcialArboles();
        
        BinaryTree<Integer> ab1 = new BinaryTree<Integer>(4);
        ab1.addLeftChild(new BinaryTree<Integer>(2));
        ab1.addRightChild(new BinaryTree<Integer>(6));
        ab1.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab1.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        
        BinaryTree<Integer> ab2 = new BinaryTree<Integer>(4);
        ab2.addLeftChild(new BinaryTree<Integer>(2));
        ab2.addRightChild(new BinaryTree<Integer>(6));
        ab2.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab2.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab2.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab2.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        BinaryTree<Integer> ab3 = new BinaryTree<Integer>(4);
        ab3.addLeftChild(new BinaryTree<Integer>(2));
        ab3.addRightChild(new BinaryTree<Integer>(6));
        ab3.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab3.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        
        BinaryTree<Integer> ab4 = new BinaryTree<Integer>(4);
        ab4.addLeftChild(new BinaryTree<Integer>(2));
        ab4.addRightChild(new BinaryTree<Integer>(6));
        ab4.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab4.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        
        BinaryTree<Integer> ab5 = new BinaryTree<Integer>();
        BinaryTree<Integer> ab6 = new BinaryTree<Integer>();
        
        BinaryTree<Integer> ab7 = new BinaryTree<Integer>(3);
        BinaryTree<Integer> ab8 = new BinaryTree<Integer>();
        
        BinaryTree<Integer> ab9 = new BinaryTree<Integer>();
        BinaryTree<Integer> ab10 = new BinaryTree<Integer>(3);
        
        System.out.println("Ab1 es prefijo de ab2? " + parcialArboles.esPrefijo(ab1, ab2));
        System.out.println("Ab3 es prefijo de ab4? " + parcialArboles.esPrefijo(ab3, ab4));
        System.out.println("Ab5 es prefijo de ab6? " + parcialArboles.esPrefijo(ab5, ab6));
        System.out.println("Ab7 es prefijo de ab8? " + parcialArboles.esPrefijo(ab7, ab8));
        System.out.println("Ab9 es prefijo de ab10? " + parcialArboles.esPrefijo(ab9, ab10));
		
		

	}

}
