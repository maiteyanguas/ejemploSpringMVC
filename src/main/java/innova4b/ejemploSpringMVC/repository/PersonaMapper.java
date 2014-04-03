package innova4b.ejemploSpringMVC.repository;

import innova4b.ejemploSpringMVC.model.Persona;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.LocalDate;
import org.springframework.jdbc.core.RowMapper;

public class PersonaMapper implements RowMapper<Persona> {

	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		Persona persona = new Persona();
    	persona.setNombre(rs.getString("nombre"));
    	persona.setApellido(rs.getString("apellido"));
    	persona.setFechaNacimiento(new LocalDate(rs.getDate("fechaNacimiento")));
		return persona;
	}

}
