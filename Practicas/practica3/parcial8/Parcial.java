package practica3.parcial8;
import practica3.ejercicio1.GeneralTree;

public class Parcial {
	
	public int resolver (GeneralTree<Integer> ab) {
		
		int[] resultado = resuelve(ab);
	    int total = resultado[0];
	    int pares = resultado[1];
	    int impares = resultado[2];

	    if (total % 2 == 0)
	    	return pares;
	    else
	    	return impares;
	}
	
	private int[] resuelve (GeneralTree<Integer> ab) {
        int total = 0;
        int pares = 0;
        int impares = 0;
        if (ab.hasChildren()) {
        	int[] res = resuelve(ab.getChildren().get(0));
        	total += res[0];
        	pares += res[1];
        	impares += res[2];
        }
        total += ab.getData();
        if (ab.getData() % 2 == 0)
        	pares += ab.getData();
        else
        	impares += ab.getData();
        for (int i = 1; i<ab.getChildren().size(); i++) {
            int[] sub = resuelve(ab.getChildren().get(i));
            total += sub[0];
            pares += sub[1];
            impares += sub[2];
        }
        return new int[] {total, pares, impares};
        
        
        
	}

	public static void main(String[] args) {
	    GeneralTree<Integer> root = new GeneralTree<>(10);

	    GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
	    GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
	    GeneralTree<Integer> nodo4 = new GeneralTree<>(4);

	    GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
	    GeneralTree<Integer> nodo2 = new GeneralTree<>(2);

	    nodo3.addChild(nodo7);
	    nodo3.addChild(nodo2);

	    root.addChild(nodo5); // primer hijo
	    root.addChild(nodo3);
	    root.addChild(nodo4);

	    Parcial p = new Parcial();
	    int resultado = p.resolver(root);

	    System.out.println("Resultado: " + resultado);

	}

}
