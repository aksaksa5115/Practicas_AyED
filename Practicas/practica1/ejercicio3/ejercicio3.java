package practica1.ejercicio3;

public class ejercicio3 {

	public static void main(String[] args) {
		
		String [] nombresP = new String[]{"martin", "tombi", "naji"}; 
		String [] nombresA = new String[]{"juani", "SOS"};
		
		
		Estudiante [] alumnos = new Estudiante [2];
		Profesor [] profesores = new Profesor [3];
		
		

		
		for(int i=0; i<(profesores.length); i++) {
			profesores[i] = new Profesor(nombresP[i]);
		}
		for(int i=0; i<(alumnos.length); i++) {
			alumnos[i] = new Estudiante(nombresA[i]);
		}
		System.out.println("----------profesores---------");
	
		for(int i=0; i<(profesores.length); i++) {
			System.out.println(profesores[i].tusDatos());
			System.out.println("---------");
		}
		System.out.println("----------alumnos---------");

		for(int i=0; i<(alumnos.length); i++) {
			System.out.println(alumnos[i].tusDatos());
			System.out.println("---------");
		}
		
		
	}

}
