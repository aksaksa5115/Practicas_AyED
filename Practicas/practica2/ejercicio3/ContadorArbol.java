package practica2.ejercicio3;
import java.util.ArrayList;
import practica2.ejercicio1y2.BinaryTree;
public class ContadorArbol {
	
	public static ArrayList<Integer> numerosParesInOrden(BinaryTree<Integer> arbolito){
		ArrayList<Integer> pares = new ArrayList<Integer>();
		if (!arbolito.isEmpty())
			ContadorParesInOrden(pares, arbolito);
		return pares;
	}
	
	public static ArrayList<Integer> numerosParesPostOrden(BinaryTree<Integer> arbolito){
		ArrayList<Integer> pares = new ArrayList<Integer>();
		if (!arbolito.isEmpty())
			ContadorParesInOrden(pares, arbolito);
		return pares;
	}
	
	public static void ContadorParesInOrden(ArrayList<Integer> p, BinaryTree<Integer> a) {
		if (a.hasLeftChild())
			ContadorParesInOrden(p, a.getLeftChild());
		if (a.getData() % 2 == 0 )
			p.add(a.getData());
		if (a.hasRightChild())
			ContadorParesInOrden(p, a.getRightChild());
	}
	
	public static void ContadorParesPostOrden(ArrayList<Integer> p, BinaryTree<Integer> a) {
		if (a.hasLeftChild())
			ContadorParesPostOrden(p, a.getLeftChild());
		if (a.hasRightChild())
			ContadorParesPostOrden(p, a.getRightChild());
		if (a.getData() % 2 == 0 )
			p.add(a.getData());
	}
	
	
	
	

	public static void main(String[] args) {
		
		BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        System.out.println("---------recorrido InOrden---------");
        ArrayList<Integer> paresInOrden = numerosParesInOrden(ab);
        System.out.println(paresInOrden.toString());
        System.out.println("---------recorrido PostOrden---------");
        paresInOrden = numerosParesPostOrden(ab);
        System.out.println(paresInOrden.toString());
		

	}

}
