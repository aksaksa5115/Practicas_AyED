package practica2.ejercicio7;
import practica2.ejercicio1y2.BinaryTree;
public class ParcialArboles {
	private BinaryTree<Integer> ab;
	
	public ParcialArboles(BinaryTree<Integer> a) {
		this.ab = a;
	}
	
	public boolean isLeftTree (int x) {
		BinaryTree<Integer> nodoX = nodoRaiz(this.ab, x);
		boolean ok = false;
		if (!nodoX.isEmpty()) {
			ok = isLeftTree(nodoX);
		}
		return ok;
	}
		
	public boolean isLeftTree(BinaryTree<Integer> nodoX) {
		int hijoIzquierdo = -1;
		int hijoDerecho = -1;
		if (nodoX.hasLeftChild())
			hijoIzquierdo = MayorEstricto(nodoX.getLeftChild());
		if (nodoX.hasRightChild())
			hijoDerecho = MayorEstricto(nodoX.getRightChild());
		return hijoIzquierdo > hijoDerecho;
	}
	
	public int MayorEstricto(BinaryTree<Integer> nodoX) {
		int x = 0;
		if (nodoX.hasLeftChild())
			x += MayorEstricto(nodoX.getLeftChild());
		if (nodoX.hasRightChild())
			x += MayorEstricto(nodoX.getRightChild());
		if ((nodoX.hasLeftChild() && !nodoX.hasRightChild()) || (!nodoX.hasLeftChild() && nodoX.hasRightChild()))
			x++;
		return x;
	}
	
	private BinaryTree<Integer> nodoRaiz(BinaryTree<Integer> ab, int num){
		if (ab.getData() == num)
			return ab;
		BinaryTree<Integer> a = new BinaryTree<Integer>();
		if (ab.hasLeftChild())
			a = nodoRaiz(ab.getLeftChild(), num);
		if (ab.hasRightChild() && (a.isEmpty()))
			a = nodoRaiz(ab.getRightChild(), num);
		return a;
	}
	
	

	public static void main(String[] args) {
		System.out.println("Test Ejercicio 7");
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.addRightChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(18));
        
        ParcialArboles parcial = new ParcialArboles(ab);
        
        System.out.println("Resultado=" + parcial.isLeftTree(10));
        System.out.println("-----------------------------------");
        System.out.println("Resultado=" + parcial.isLeftTree(2));
        System.out.println("Resultado=" + parcial.isLeftTree(-5));
        System.out.println("Resultado=" + parcial.isLeftTree(19));
        System.out.println("Resultado=" + parcial.isLeftTree(-3));
        
        

	}

}
