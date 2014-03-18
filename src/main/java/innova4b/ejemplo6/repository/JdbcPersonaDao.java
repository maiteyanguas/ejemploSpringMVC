package innova4b.ejemplo6.repository;

import innova4b.ejemplo6.model.Persona;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPersonaDao  implements PersonaDAO {
	  private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public List<Persona> list() {
		List<Persona> personas = this.jdbcTemplate.query("select nombre, apellido, fechaNacimiento from persona",new PersonaMapper());
		return personas;
	}

}
