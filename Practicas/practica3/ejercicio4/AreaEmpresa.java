package practica3.ejercicio4;
import java.util.Random;
public class AreaEmpresa {
	private char nombre;
	private int retardo;
	
	public AreaEmpresa() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        char randomChar = chars.charAt(rand.nextInt(chars.length()));
		this.nombre = randomChar;
		this.retardo = (int)(Math.random() * 100) + 1;
	}
	
	public AreaEmpresa(String x, int retardo) {
		char z = x.charAt(0);
		this.nombre = z;
		this.retardo = retardo;
	}
	
	public int getRetardo() {
		return this.retardo;
	}

}
