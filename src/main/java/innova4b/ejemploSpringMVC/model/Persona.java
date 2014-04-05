package innova4b.ejemploSpringMVC.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="persona")
public class Persona {
	
	//Es necesario indicar la PK de la tabla
	@Id 
	@GeneratedValue 
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@NotEmpty
//	@Column(name="nombre")
//	no es necesario si el nombre de la columna es igual
	private String nombre;
	
	@NotEmpty
	private String apellido;
	

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@NotNull
	//Para poder usar la clase LocalDate con Hibernate
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
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
	
	public String getFechaNacimientoAsString() {
		return fechaNacimiento.toString(org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd"));
		
	}

}
