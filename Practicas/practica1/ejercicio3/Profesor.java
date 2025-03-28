package practica1.ejercicio3;

public class Profesor {
	private String nombre_completo;
	private String Email;
	private String catedra;
	private String facultad;
	
	
	public Profesor(String nombre_completo, String email, String catedra, String facultad) {
		super();
		this.nombre_completo = nombre_completo;
		Email = email;
		this.catedra = catedra;
		this.facultad = facultad;
	}
	
	public Profesor(String nombre) {
		this.nombre_completo = nombre;
		this.Email = "profesor@gmail.com";
		this.catedra = "programacion";
		this.facultad = "informatica";
	}
	
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	
	public String tusDatos() {
		return "Profesor [nombre_completo=" + nombre_completo + ", Email=" + Email + ", catedra=" + catedra
				+ ", facultad=" + facultad + "]";
	}
	
	

}
