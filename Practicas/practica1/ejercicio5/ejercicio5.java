package practica1.ejercicio5;

public class ejercicio5 {
	private static datos da;
	
	public static int[] puntoA(int[] numeros) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int prom = 0;
		for (int i=0; i<(numeros.length); i++){
			if (numeros[i]>min)
				min = numeros[i];
			if (numeros[i]<max)
				max = numeros[i];
			prom+= numeros[i];
		}
		return new int[] {min, max, prom/numeros.length};
	}
	
	public static datos puntoB(int[] numeros) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int prom = 0;
		for (int i=0; i<(numeros.length); i++){
			if (numeros[i]<min)
				min = numeros[i];
			if (numeros[i]>max)
				max = numeros[i];
			prom+= numeros[i];
		}
		return new datos(min, max, prom/numeros.length);
	}
	
	public static void puntoC(int[] numeros) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int prom = 0;
		for (int i=0; i<(numeros.length); i++){
			if (numeros[i]>min)
				min = numeros[i];
			if (numeros[i]<max)
				max = numeros[i];
			prom+= numeros[i];
		}
		da = new datos(min, max, prom/numeros.length);
	}

	
	public static void main(String[] args) {
		
		int [] numeros = new int[] {4, 56, 13, 756, 84, 354, 11, 55, 66, 91};
		
		puntoA(numeros);
		
		System.out.print(puntoB(numeros).toString());
		
		puntoC(numeros);

	}

}
