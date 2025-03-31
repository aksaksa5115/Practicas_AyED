package practica1.ejercicio5;

public class datos {
	private int min;
	private int max;
	private double prom;

	
	public datos () {
		
	}
	
	public datos (int min, int max, double prom) {
		this.min = min;
		this.max = max;
		this.prom = prom;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public void setMax(int max) {
		this.max = max;
	}


	public void setProm(double prom) {
		this.prom = prom;
	}

	@Override
	public String toString() {
		return "datos [min=" + min + ", max=" + max + ", prom=" + prom + "]";
	}
	
	
	
	
}
