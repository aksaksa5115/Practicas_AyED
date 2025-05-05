package practica3.ejercicio1;

import java.util.Arrays;
import java.util.List;

public class pruebaGeneralTree {

	public static void main(String[] args) {
        GeneralTree<Integer> nodo1 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(2);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
        GeneralTree<Integer> nodo8 = new GeneralTree<>(8);

        // Armamos el árbol:
        //            1
        //         /  |  \
        //        2   3   4
        //       / \
        //      5   6
        //         / \
        //        7   8

        nodo6.setChildren(Arrays.asList(nodo7, nodo8));
        nodo2.setChildren(Arrays.asList(nodo5, nodo6));
        nodo1.setChildren(Arrays.asList(nodo2, nodo3, nodo4));
        
        int ancho = nodo1.ancho();
        //System.out.println("El ancho del árbol es: " + ancho);  // Debería ser 3 (nivel de nodos 2, 3, 4)
        
        GeneralTree<String> c = new GeneralTree<>("C");
        GeneralTree<String> b = new GeneralTree<>("B", List.of(c));
        GeneralTree<String> a = new GeneralTree<>("A", List.of(b));

        System.out.println(a.esAncestro("A", "C")); // true
        System.out.println(a.esAncestro("B", "C")); // true
        System.out.println(a.esAncestro("C", "A")); // false

	}

}
