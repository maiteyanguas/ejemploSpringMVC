package innova4b.ejemplo6;

import java.util.Calendar;
import java.util.Date;

public class Persona {	
	private String nombre;
	private String apellido;
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
	
	public int getAnoNacimiento(){
		int anoNacimiento=0;
		if (this.edad!=0)
		anoNacimiento = Calendar.getInstance().get(Calendar.YEAR)-this.edad;
		return anoNacimiento;
		
	}

}
