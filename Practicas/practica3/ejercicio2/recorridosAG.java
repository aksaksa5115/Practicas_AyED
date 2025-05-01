package practica3.ejercicio2;

import practica3.ejercicio1.GeneralTree;
import java.util.ArrayList;

public class recorridosAG {
	
	public ArrayList<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> a, Integer n){
		ArrayList<Integer> impares = new ArrayList<Integer>();
		if (!a.isEmpty())
			ImparesMayoresQuePreOrden(a, n, impares);
		return impares;
	}
	
	private void ImparesMayoresQuePreOrden (GeneralTree<Integer> a, Integer n, ArrayList<Integer> impares){
		if ( (a.getData() > n) && (a.getData() % 2 != 0) )
			impares.add(a.getData());
		
		for (GeneralTree<Integer> child : a.getChildren()) {
			ImparesMayoresQuePreOrden(child, n, impares );
		}
		
	}
	
	public ArrayList<Integer> numerosImparesMayoresQueInOrden (GeneralTree<Integer> a, Integer n){
		ArrayList<Integer> impares = new ArrayList<Integer>();
		if (!a.isEmpty())
			ImparesMayoresQueInOrden(a, n, impares);
		return impares;
	}
	
	private void ImparesMayoresQueInOrden (GeneralTree<Integer> a, Integer n, ArrayList<Integer> impares){
		if (a.hasChildren())
			ImparesMayoresQueInOrden(a.getChildren().get(0), n, impares);
		if ( (a.getData() > n) && (a.getData() % 2 != 0) )
			impares.add(a.getData());
		for (int i=1; i<a.getChildren().size(); i++)
			ImparesMayoresQueInOrden(a.getChildren().get(i), n, impares);
	}
	
	public ArrayList<Integer> numerosImparesMayoresQuePostOrden (GeneralTree<Integer> a, Integer n){
		ArrayList<Integer> impares = new ArrayList<Integer>();
		if (!a.isEmpty())
			ImparesMayoresQuePostOrden(a, n, impares);
		return impares;
	}
	
	private void ImparesMayoresQuePostOrden (GeneralTree<Integer> a, Integer n, ArrayList<Integer> impares) {
		for (GeneralTree<Integer> child : a.getChildren())
			ImparesMayoresQuePostOrden(child, n, impares);
		if ( (a.getData() > n) && (a.getData() % 2 != 0) )
			impares.add(a.getData());
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// Crear nodos
        GeneralTree<Integer> root = new GeneralTree<>(4);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
        GeneralTree<Integer> nodo1 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(5);

        // Armar relaciones (4 es la raíz)
        root.addChild(nodo3);
        root.addChild(nodo6);
        root.addChild(nodo7);

        // 6 tiene dos hijos: 1 y 5
        nodo6.addChild(nodo1);
        nodo6.addChild(nodo5);

        // Ahora podemos recorrer e imprimir
	}
	

}
