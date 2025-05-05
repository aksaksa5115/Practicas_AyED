package practica3.ejercicio6;
import practica3.ejercicio1.GeneralTree;
import java.util.LinkedList;

public class RedAguaPotable {
	private GeneralTree<Character> ab;
	
	
	public RedAguaPotable(GeneralTree<Character> ab2) {
		this.ab = ab2;
	}

	public double minimoCaudal(double caudal) {
		double res = 0;
		if (!ab.isEmpty())
			res = Caudales(ab, caudal);
		return res;
	}
	
	private double Caudales(GeneralTree<Character> ab, double caudal) {
		if (ab.isLeaf())
			return caudal;
		double caudalDiv = caudal / ab.getChildren().size();
		double minimo = Double.MAX_VALUE;
		
		for (GeneralTree<Character> hijos: ab.getChildren()) {
			double caudalHijo = Caudales(hijos, caudalDiv);
			minimo = Math.min(caudalHijo, minimo);
		}
		return minimo;
			
		
		
		
	}
	public static void main(String[] args) {
		
		
GeneralTree<Character> ab1 = new GeneralTree<Character>('B');
        
        LinkedList<GeneralTree<Character>> subChildren1 = new LinkedList<GeneralTree<Character>>();
        subChildren1.add(new GeneralTree<Character>('L'));
        GeneralTree<Character> subAb1 = new GeneralTree<Character>('G', subChildren1);
        LinkedList<GeneralTree<Character>> subChildren2 = new LinkedList<GeneralTree<Character>>();
        subChildren2.add(new GeneralTree<Character>('F'));
        subChildren2.add(subAb1);
        GeneralTree<Character> ab2 = new GeneralTree<Character>('C', subChildren2);
        
       LinkedList<GeneralTree<Character>> subChildren3 = new LinkedList<GeneralTree<Character>>();
        subChildren3.add(new GeneralTree<Character>('M'));
        subChildren3.add(new GeneralTree<Character>('N'));
        GeneralTree<Character> subAb2 = new GeneralTree<Character>('J', subChildren3);
        LinkedList<GeneralTree<Character>> subChildren4 = new LinkedList<GeneralTree<Character>>();
        subChildren4.add(new GeneralTree<Character>('H'));
        subChildren4.add(new GeneralTree<Character>('I'));
        subChildren4.add(subAb2);
        subChildren4.add(new GeneralTree<Character>('K'));
        subChildren4.add(new GeneralTree<Character>('P'));
        GeneralTree<Character> ab3 = new GeneralTree<Character>('D', subChildren4);
        
        GeneralTree<Character> ab4 = new GeneralTree<Character>('E');
        
        LinkedList<GeneralTree<Character>> arbol = new LinkedList<GeneralTree<Character>>();
        arbol.add(ab1);
        arbol.add(ab2);
        arbol.add(ab3);
        arbol.add(ab4);
        GeneralTree<Character> ab = new GeneralTree<Character>('A', arbol);
        
        RedAguaPotable red = new RedAguaPotable(ab);
        System.out.println("Caudal minimo que recibe una casa: " + red.minimoCaudal(1000.0));

	}

}
