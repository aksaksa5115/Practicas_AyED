package practica3.parcial9;
import practica3.ejercicio1.GeneralTree;
import practica1.ejercicio8.Queue;
public class Parcial {
	
	
	public boolean esInferiorProfundo(GeneralTree<Integer> ab1, GeneralTree<Integer> ab2) {
		boolean ok = false;
		if ((!ab1.isEmpty()) && (!ab2.isEmpty())){
			
			ok = Profundo(ab1,ab2);
		}
		return ok;
	}
	
	private boolean Profundo(GeneralTree<Integer> ab1, GeneralTree<Integer> ab2) {
		
		Queue<GeneralTree<Integer>> cola1 = new Queue<GeneralTree<Integer>>();
		Queue<GeneralTree<Integer>> cola2 = new Queue<GeneralTree<Integer>>();
		cola1.enqueue(ab1);
		cola2.enqueue(ab2);
		while ((!cola1.isEmpty()) && (!cola2.isEmpty())) {
			GeneralTree<Integer> aux1 = cola1.dequeue();
			GeneralTree<Integer> aux2 = cola2.dequeue();
			int suma1 = aux1.getData();
			int suma2 = aux2.getData();
			
			if (aux1.getData() >= aux2.getData()) {
				return false;
			}
			
			for (int i=0; i<aux1.getChildren().size(); i++) {
				suma1 += aux1.getChildren().get(i).getData();
				cola1.enqueue(aux1.getChildren().get(i));
			}
			for (int i=0; i<aux2.getChildren().size(); i++) {
				suma2 += aux2.getChildren().get(i).getData();
				cola2.enqueue(aux2.getChildren().get(i));
			}
			
	        if (!aux1.isLeaf() && aux2.isLeaf()) {
	            return false;
	        }
	        
			if (suma1 >= suma2) {
				return false;
			}
		}
		if (!cola1.isEmpty()) {
		    return false; // ab1 tiene más nodos que ab2 → no puede ser inferior
		}
		return true;
	}

	public static void main(String[] args) {
		// ab1: raíz 3, hijos 1, 0, 1
        GeneralTree<Integer> ab1 = new GeneralTree<>(3);
        ab1.addChild(new GeneralTree<>(1));
        ab1.addChild(new GeneralTree<>(0));
        ab1.addChild(new GeneralTree<>(1));

        // ab2: raíz 6, hijos 3, 1, 2
        GeneralTree<Integer> ab2 = new GeneralTree<>(6);
        ab2.addChild(new GeneralTree<>(3));
        ab2.addChild(new GeneralTree<>(1));
        ab2.addChild(new GeneralTree<>(2));

        Parcial p = new Parcial();
        boolean resultado = p.esInferiorProfundo(ab1, ab2);
        System.out.println("¿ab1 es profundamente inferior a ab2?: " + resultado); // debería ser true

	}

}
