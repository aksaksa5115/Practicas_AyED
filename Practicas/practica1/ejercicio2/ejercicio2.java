package practica1.ejercicio2;

public class ejercicio2 {
	

	public static int[] Multiplos(int n) {
		int[] multiplos = new int[n];
		
		for (int i=1; i<=n; i++ ) {
			multiplos[i - 1] = n * i;
		}
		
		return multiplos;
	}
	
	public static void main(String[] args) {
	
		int[] multiplos = Multiplos(10);
		
		for (int num : multiplos) {
			System.out.println(num + " ");
		}
	}
}
