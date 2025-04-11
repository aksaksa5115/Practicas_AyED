package practica2.ejercicio5;
import practica2.ejercicio1y2.BinaryTree;

public class ProfundidadDeArbolBinario {

	
	public static int SumaElementosProfundidad(int x, BinaryTree<Integer> ab) {
		int total = 0;
		if (!ab.isEmpty())
			total = SumadorElementosPorProfundidad(x, ab, 0);
		return total;
	}
	
	private static int SumadorElementosPorProfundidad(int x, BinaryTree<Integer> ab, int nivelActual) {
		if (x == nivelActual) {
			return ab.getData();
		}
		int suma = 0;
		if (ab.hasLeftChild())
			suma += SumadorElementosPorProfundidad(x, ab.getLeftChild(), nivelActual + 1);
		if (ab.hasRightChild())
			suma += SumadorElementosPorProfundidad(x, ab.getRightChild(), nivelActual + 1);

		return suma;
	}
	
	
	public static void main(String[] args) {
		
        System.out.println("Test Profundidad");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4); //profundidad 0
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6)); // profundidad 1
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8)); //profundidad 2
		
        System.out.println(SumaElementosProfundidad(2, ab));

	}

}
