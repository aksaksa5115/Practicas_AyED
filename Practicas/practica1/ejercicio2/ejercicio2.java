package practica1.ejercicio2;

import java.util.Scanner;

public class ejercicio2 {
	

	public static int[] Multiplos(int n) {
		int[] multiplos = new int[n];
		
		for (int i=1; i<=n; i++ ) {
			multiplos[i - 1] = n * i;
		}
		
		return multiplos;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("ingrese numero:");
		int N = scanner.nextInt();
		
	
		int[] multiplos = Multiplos(N);
		
		for (int num : multiplos) {
			System.out.println(num + " ");
		}
	}
}
