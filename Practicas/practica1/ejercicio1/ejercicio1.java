package practica1.ejercicio1;

public class ejercicio1 {
	
	private static void NumerosEntreConFor(int x, int y) {

		
		for (int i = x; i<=y; i++) {
			System.out.println(i);
		}
	}
	
	private static void NumerosEntreConWhile(int x, int y) {

		while (x <= y) {
			System.out.println(x);
			x++;
		}
		
	}
	
	private static void NumerosEntreConRecursion(int x, int y) {
		if (x <= y) {
			System.out.println(x);
			NumerosEntreConRecursion(x + 1, y);
		}
		
	}
	
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		
		if (x > y) {
			int a = y;
			y = x;
			x = a;
		}
		System.out.println("-------recursividad-----------");
		NumerosEntreConRecursion(x,y);
		System.out.println("---------while---------");
		NumerosEntreConWhile(x,y);
		System.out.println("---------for---------");
		NumerosEntreConFor(x,y);
		
	}

}
