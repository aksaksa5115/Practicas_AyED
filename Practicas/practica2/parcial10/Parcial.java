package practica2.parcial10;

import practica2.ejercicio1y2.*;

public class Parcial {
	BinaryTree<Integer> ab;
	
	public BinaryTree<Integer> nuevoTree(){
	    if (ab == null || ab.isEmpty()) {
	        return null;
	    }
		BinaryTree<Integer> aux = new BinaryTree<Integer>(ab.getData());
		resuelve(aux, ab);
		return aux;
	}
	
	private void resuelve(BinaryTree<Integer> res, BinaryTree<Integer> ab) {
		
		if (ab.hasLeftChild()) {
			int dato = ab.getData() + ab.getLeftChild().getData();
			res.addLeftChild(new BinaryTree<Integer>(dato));
			resuelve(res.getLeftChild(), ab.getLeftChild());
		}
		if (ab.hasRightChild()) {
			res.addRightChild(ab.getRightChild());
			resuelve(res.getRightChild(), ab.getRightChild());
		}
		
	}
	
	public static void imprimirPreorden(BinaryTree<Integer> ab) {
	    if (ab == null) return;
	    System.out.print(ab.getData() + " ");
	    if (ab.hasLeftChild()) imprimirPreorden(ab.getLeftChild());
	    if (ab.hasRightChild()) imprimirPreorden(ab.getRightChild());
	}
	
	public static void main(String[] args) {
		
	    BinaryTree<Integer> root = new BinaryTree<>(10);

	    BinaryTree<Integer> left = new BinaryTree<>(5);
	    BinaryTree<Integer> right = new BinaryTree<>(20);

	    BinaryTree<Integer> leftLeft = new BinaryTree<>(3);
	    BinaryTree<Integer> leftRight = new BinaryTree<>(7);
	    BinaryTree<Integer> rightLeft = new BinaryTree<>(15);

	    left.addLeftChild(leftLeft);
	    left.addRightChild(leftRight);
	    right.addLeftChild(rightLeft);

	    root.addLeftChild(left);
	    root.addRightChild(right);

	    Parcial p = new Parcial(); // reemplazá esto con tu clase si tiene otro nombre
	    p.ab = root;               // asegurate de tener el árbol original en el atributo `ab`

	    BinaryTree<Integer> nuevo = p.nuevoTree();

	    // imprimimos en preorden para ver el resultado
	    imprimirPreorden(nuevo);
		

	}

}
