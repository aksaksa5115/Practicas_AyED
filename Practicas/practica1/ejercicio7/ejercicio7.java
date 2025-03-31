package practica1.ejercicio7;

import java.util.ArrayList;
import java.util.Scanner;
import practica1.ejercicio3.Estudiante;

public class ejercicio7 {
	private static Scanner scanner = new Scanner(System.in);
	
	private static ArrayList<Estudiante> estudiantes() {
		ArrayList<Estudiante> e = new ArrayList<Estudiante>();
		for (int i=0; i<3; i++) {
			System.out.println("ingrese nombre estudiante: ");
			Estudiante es = new Estudiante(scanner.nextLine());
			e.add(es);
		}
		return e;
	}

	public static void main(String[] args) {
		ArrayList<Estudiante> estudiantes1 = estudiantes();
		ArrayList<Estudiante> estudiantes2 = new ArrayList<>(estudiantes1);

		System.out.println("printeo de ambas listas con las mismas cosas ");
		for (int i=0; i<estudiantes1.size(); i++) {
			System.out.println("--------");
			System.out.println(estudiantes1.get(i).tusDatos());
			System.out.println("--------");
			System.out.println(estudiantes2.get(i).tusDatos());
		}
		System.out.println("ingrese direccion del estudiante "+estudiantes1.getFirst().getNombre_completo());
		estudiantes1.getFirst().setDireccion(scanner.nextLine());
		
		for (int i=0; i<estudiantes1.size(); i++) {
			System.out.println("--------");
			System.out.println(estudiantes1.get(i).tusDatos());
			System.out.println("--------");
			System.out.println(estudiantes2.get(i).tusDatos());
		}
		//no entiendo el enunciado, como que a que conclusion llegue? es obvio que una lista cambio y la otra sigue igual lpm 2do año de programacion
		// y mira lo que vienen a preguntar
		//hay 200 formas de copiar una lista; no me voy a poner a hacer algunas porque tengo sueño

	}

}
