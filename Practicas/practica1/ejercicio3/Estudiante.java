package practica1.ejercicio3;


public class Estudiante {
	private String nombre_completo;
	private String comision;
	private String email;
	private String direccion;
	
	public Estudiante(String nombre, String com, String mail, String dire) {
		this.nombre_completo = nombre;
		this.comision = com;
		this.email = mail;
		this.direccion = dire;
	}
	
	public Estudiante(String nombre) {
		this.nombre_completo = nombre;
		this.comision = "1-A";
		this.email = "alumno@gmail.com";
		this.direccion = "su casa";
	}
	
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String tusDatos() {
		String cadena = "";
		cadena += this.nombre_completo + " esta en la comision " + this.comision + ", su correo es " + this.email
				+ " y su direccion es " + this.direccion;
		return cadena;
	}
	
	
	

}
