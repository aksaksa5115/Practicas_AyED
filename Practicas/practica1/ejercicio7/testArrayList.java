package practica1.ejercicio7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class testArrayList {
	
	
	private static boolean capicua(ArrayList<Integer> numeros) {
		int x = numeros.size() - 1;
		System.out.println("cantida de elementos en la lista: "+ x);
		for (int i=0; i<numeros.size()/2; i++) {
			if (!numeros.get(i).equals(numeros.get(x))) {
				return false;
			}
			x--;
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.print("ingrese numero: ");
		int x = scan.nextInt();
		while (x != -1) {
			System.out.print("ingrese numero: ");
			numeros.add(x);
			x = scan.nextInt();
		}
		
		//aca iran varias formas de imprimirlas
		System.out.println("-----------formas de impresion------------");
		
		System.out.println("usando forEach con lambda");
		//si te queres sentir re capo usalo si no no importa porque el for-each le gana
		numeros.forEach(elem -> System.out.println(elem));
		
		System.out.println("usando tostring");
		//si sos un vago de mierda (yo)
		System.out.println(numeros.toString());
		
		System.out.println("usando for de toda la vida ");
		//si sos mogolico esta bueno (yo lo uso)
		for (int i=0; i<numeros.size(); i++) {
		    System.out.println(numeros.get(i) + " ");
		}
		
		System.out.println("usando for each");
		//GOAT
		for (int num : numeros) {
		    System.out.println(num + " ");
		}
		
		System.out.println("usando iterator");
		//una poronga inentendible este metodo
		Iterator<Integer> it = numeros.iterator();
		while (it.hasNext()) {
		    System.out.println(it.next() + " ");
		}

		//lista capicua o no
		System.out.println("------------revision si es capicua o no-------------");
		System.out.println(capicua(numeros));
		
		//lo de la linked list es lo mismo que esto, la linked list es una doble lista enlazada nada mas
	}

}
