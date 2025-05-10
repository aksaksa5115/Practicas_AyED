package practica2.parcial1;
import practica2.ejercicio1y2.*;
public class Parcial {
	private BinaryTree<Integer> ab;
	
	
	public Parcial(BinaryTree<Integer> ab2) {
		this.ab = ab2;
	}

	public boolean isTwoTree (int num) {
		boolean ok = false;
		BinaryTree<Integer> arb = buscar(ab, num);
		if (!arb.isEmpty()) {
			int izquierdo = -1;
			int derecho = -1;
			ok = resuelve(arb, num, izquierdo, derecho);
		}
		return ok;
	}
	
	private BinaryTree<Integer> buscar (BinaryTree<Integer> ab, int num){
		if (ab.getData() == num) 
			return ab;
		BinaryTree<Integer> aux = new BinaryTree<Integer>();
		if (ab.hasLeftChild())
			aux = buscar(ab.getLeftChild(), num);
		if ((ab.hasRightChild()) && (aux.isEmpty()))
			aux = buscar(ab.getRightChild(), num);
		return aux;
	}
	
	private boolean resuelve(BinaryTree<Integer> ab, int num, int izq, int der) {
		if (ab.hasLeftChild())
				izq = subarboles(ab.getLeftChild());
		if (ab.hasRightChild())
				der = subarboles(ab.getRightChild());
		
		return izq == der;
	}
	
	private int subarboles(BinaryTree<Integer> ab) {
		int x = 0;
		if (ab.hasLeftChild())
			x += subarboles(ab.getLeftChild());
		if (ab.hasRightChild())
			x += subarboles(ab.getRightChild());
		if ((ab.hasLeftChild()) && (ab.hasRightChild()))
			x++;
		return x;
	}

	public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.addRightChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
        ab.getLeftChild().getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(9));
        ab.getLeftChild().getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(16));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(18));
        ab.getRightChild().getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(8));
        ab.getRightChild().getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(24));
        
        Parcial parcialArb = new Parcial(ab);
        System.out.println("Resultado=" + parcialArb.isTwoTree(2));
        System.out.println("Resultado=" + parcialArb.isTwoTree(7));
        System.out.println("Resultado=" + parcialArb.isTwoTree(-3));
        System.out.println("Resultado=" + parcialArb.isTwoTree(4));
        System.out.println("Resultado=" + parcialArb.isTwoTree(55));

	}

}
