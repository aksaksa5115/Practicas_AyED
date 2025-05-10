package practica2.parcial6;
import practica2.ejercicio1y2.BinaryTree;
import practica1.ejercicio8.Queue;
public class NivelArbol {
	
	private BinaryTree<Integer> ab;
	
	public NivelArbol(BinaryTree<Integer> ab2) {
		this.ab = ab2;
	}
	
	public BinaryTree<Integer> minEnNivelAB(int n) {
		BinaryTree<Integer> res = new BinaryTree<Integer>();
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		cola.enqueue(ab);
		int min = Integer.MAX_VALUE;
		int nivelActual = 0;
		while(!cola.isEmpty() && (nivelActual <= n)) {
			int nodos = cola.size();
			
			for (int i=0; i<nodos; i++) {
				BinaryTree<Integer> aux = cola.dequeue();
				if ((aux.isLeaf()) && (aux.getData() < min) && (nivelActual == n)) {
					min = aux.getData();
					res.setData(min);
				}
				if (aux.hasLeftChild())
					cola.enqueue(aux.getLeftChild());
				if (aux.hasRightChild())
					cola.enqueue(aux.getRightChild());
			}
			nivelActual++;
		}	
		return res;
	}
	
	

	public static void main(String[] args) {
		
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(2));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
        ab.addRightChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(9));
        ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(4));
        
        NivelArbol a = new NivelArbol(ab);
        
        //Es necesario .getData(), porque si retorna null, se hace un .toString() a un objeto nulo, tirando nullPointerException
        
        System.out.println(a.minEnNivelAB(1).getData());
        System.out.println(a.minEnNivelAB(2).getData());
        System.out.println(a.minEnNivelAB(3).getData());

		
	}

}
