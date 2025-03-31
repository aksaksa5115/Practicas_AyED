package practica1.ejercicio7;

import java.util.Scanner;
import java.util.ArrayList;

public class sucesion {

	
	private static void sucesion(ArrayList<Integer> numeros, int n) {
		if (n == 1) {
			numeros.add(n);
			return;
		}
		if ((n % 2) == 0) {
			numeros.add(n);
			sucesion(numeros, n/2);
		}
		else {
			numeros.add(n);
			sucesion(numeros, 3*n+1);
		}
		
	}
	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("ingrese numero para la sucesion: ");
		sucesion(numeros, scanner.nextInt());
		System.out.println(numeros.toString());
		
		
		

	}

}
