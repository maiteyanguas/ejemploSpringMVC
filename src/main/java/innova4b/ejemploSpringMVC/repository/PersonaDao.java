package innova4b.ejemploSpringMVC.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import innova4b.ejemploSpringMVC.model.Persona;

@Repository
@Transactional
public class PersonaDao {
	
	@Autowired
   SessionFactory sessionFactory;
	
	public List<Persona> list() {
		//Cuidado la tabla se llama persona, pero la clase se llama Persona
		return sessionFactory.getCurrentSession().createQuery("from Persona").list();
	}

	public void insert(Persona persona) {
		sessionFactory.getCurrentSession().save(persona);	
	}

	public void delete(Long id) {
		Session session= sessionFactory.getCurrentSession();
		sessionFactory.getCurrentSession().delete(session.get(Persona.class, id));	
	}

	public Persona get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Persona persona = (Persona)session.createQuery("select distinct p from Persona as p left join fetch p.direcciones where p.id="+id).list().get(0);
		return persona;
	}

	public void update(Persona persona) {
		sessionFactory.getCurrentSession().update(persona);
	}

}
