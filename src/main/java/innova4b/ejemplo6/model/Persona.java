package innova4b.ejemplo6.model;


import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.format.annotation.DateTimeFormat;


public class Persona {	
	private String nombre;
	private String apellido;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaNacimiento;

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
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getEdad(){
		LocalDate hoy = new LocalDate();
		int edad = Years.yearsBetween(fechaNacimiento, hoy).getYears();
		return edad;
		
	}

	public void setFechaNacimiento(String fechaNacimiento2) {
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento2,org.joda.time.format.DateTimeFormat.forPattern("dd/MM/yyyy"));
		
	}

}
