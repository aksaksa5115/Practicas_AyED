package practica2.parcial5;

import practica2.ejercicio1y2.BinaryTree;

public class Parcial {
	private BinaryTree<Personaje> ab;
	
	
    public Parcial(BinaryTree<Personaje> arb) {
        this.ab = arb;
    }
    
    public Personaje princesaAccesible() {
    	Personaje p = new Personaje();
    	if (!ab.isEmpty()) {
    		p = persona(ab);
    	}
    	
    	return p;
    	
    }
    
    private Personaje persona (BinaryTree<Personaje> ab) {
    	Personaje P = ab.getData();
    	if (P.esPrincesa()) {
    		return P;
    	} else {
    		Personaje aux = null;
    		if (!P.esDragon()) {
    			if (ab.hasLeftChild())
    				aux = persona(ab.getLeftChild());
    			if ((ab.hasRightChild()) && (aux == null))
    				aux = persona(ab.getRightChild());
    		}
    		return aux;
    	}

    	
    }
    
	
	
	public static void main(String[] args) {
			
        BinaryTree<Personaje> ab = new BinaryTree<Personaje>(new Personaje("X", "Prueba"));
        ab.addLeftChild(new BinaryTree<Personaje>(new Personaje("Dragon", "Roberto")));
        ab.getLeftChild().addLeftChild(new BinaryTree<Personaje>(new Personaje("Princesa", "Roxanne")));
        ab.getLeftChild().addRightChild(new BinaryTree<Personaje>(new Personaje("Y", "Prueba")));
        ab.addRightChild(new BinaryTree<Personaje>(new Personaje("Z", "Prueba")));
        ab.getRightChild().addRightChild(new BinaryTree<Personaje>(new Personaje("W", "Prueba")));
        ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<Personaje>(new Personaje("Princesa", "Diana")));
        
        Parcial p = new Parcial(ab);
        System.out.println(p.princesaAccesible());

	}

}
