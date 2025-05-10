package practica2.parcial2;

import practica2.ejercicio1y2.BinaryTree;

public class Parcial {
	private BinaryTree<Integer> ab;
	
	
	public Parcial(BinaryTree<Integer> ab2) {
		this.ab = ab2;
	}

	public boolean resolver(int k) {
		boolean ok = false;
		int suma = 0;
		if (!ab.isEmpty())
			ok = resuelve(ab, k, suma);
		return ok;
	}
	
	private boolean resuelve(BinaryTree<Integer> ab, int k, int suma) {
		suma += ab.getData();
		
		if (ab.isLeaf()) {
			return suma == k;
		}
		
		if ((ab.hasLeftChild()) && (!resuelve(ab.getLeftChild(), k , suma)))
			return false;
		if ((ab.hasRightChild()) && (!resuelve(ab.getRightChild(), k, suma)))
			return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		
        BinaryTree<Integer> ab = new BinaryTree<Integer>(1);
        ab.addLeftChild(new BinaryTree<Integer>(3));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(3));
        //ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(2));
        
        Parcial a = new Parcial(ab);
        System.out.println(a.resolver(7));
		

	}

}
