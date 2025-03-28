package practica1.ejercicio5;

public class ejercicio5 {
	private static datos da;
	
	public static int[] puntoA(int[] numeros) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int prom = 0;
		for (int i=0; i<(numeros.length); i++){
			if (i<min)
				min = i;
			if (i>max)
				max = i;
			prom+= i;
		}
		return new int[] {max, min, prom};
	}
	
	public static datos puntoB(int[] numeros) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int prom = 0;
		for (int i=0; i<(numeros.length); i++){
			if (i<min)
				min = i;
			if (i>max)
				max = i;
			prom+= i;
		}
		return new datos(max, min, prom);
	}
	
	public static void puntoC(int[] numeros) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int prom = 0;
		for (int i=0; i<(numeros.length); i++){
			if (i<min)
				min = i;
			if (i>max)
				max = i;
			prom+= i;
		}
		da = new datos(max, min, prom);
	}

	
	public static void main(String[] args) {
		
		int [] numeros = new int[] {4, 56, 13, 756, 84, 354, 11, 55, 66, 91};
		
		datos d = new datos();
		
		puntoA(numeros);
		
		puntoB(numeros);
		
		puntoC(numeros);
		
		
		

	}

}
