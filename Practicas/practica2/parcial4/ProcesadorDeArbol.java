package practica2.parcial4;

import java.util.LinkedList;

import practica2.ejercicio1y2.BinaryTree;
import practica2.parcial3.Parcial;

public class ProcesadorDeArbol {
	
    private BinaryTree<Integer> ab;
    
    public ProcesadorDeArbol(BinaryTree<Integer> ab) {
        this.ab = ab;
    }
    
    public Parcial procesar() {
        int cant = 0;
        LinkedList<BinaryTree<Integer>> lis = new LinkedList<BinaryTree<Integer>>();
        if(!ab.isEmpty())
        	cant = procesar(ab, lis);
        return new Parcial(lis, cant);
    }
    
    private int procesar(BinaryTree<Integer> ab, LinkedList<BinaryTree<Integer>> lista) {
        int nodosInPares = 0;

        if (ab.getData() % 2 != 0)
            nodosInPares++;

        if ((ab.hasLeftChild() && !ab.hasRightChild()) || (ab.hasRightChild() && !ab.hasLeftChild()))
            lista.add(ab);

        if (ab.hasLeftChild())
            nodosInPares += procesar(ab.getLeftChild(), lista);

        if (ab.hasRightChild())
            nodosInPares += procesar(ab.getRightChild(), lista);

        return nodosInPares;
    	
    	
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
        
        ProcesadorDeArbol p = new ProcesadorDeArbol(ab);
        Parcial parc = p.procesar();
        
        System.out.println("");
        
        System.out.println(parc.getLis());
        System.out.println(parc.getCant());

	}

}
