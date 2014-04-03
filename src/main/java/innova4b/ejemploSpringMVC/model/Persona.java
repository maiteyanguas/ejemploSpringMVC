package innova4b.ejemploSpringMVC.model;


import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Persona {	
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@Range(min = 1, max = 150)
	private int edad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad){
		this.edad = edad;
	}
}
