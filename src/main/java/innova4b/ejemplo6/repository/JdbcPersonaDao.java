package innova4b.ejemplo6.repository;

import innova4b.ejemplo6.model.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPersonaDao  implements PersonaDAO {
	  private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public List<Persona> list() {
		List<Persona> personas = jdbcTemplate.query("select nombre, apellido, fechaNacimiento from persona",new PersonaMapper());
		return personas;
	}
	
	public void insert(final Persona persona) {
		String sql="insert into persona (nombre, apellido, fechaNacimiento) values (?,?,?);";
		try {			
			jdbcTemplate.update(sql, new Object[]{persona.getNombre(),persona.getApellido(),persona.getFechaNacimientoAsString()});
		}catch (DataAccessException dae){
			dae.printStackTrace();
		}		
	}

}
