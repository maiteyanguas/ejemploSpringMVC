package innova4b.ejemplo6.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import innova4b.ejemplo6.model.Persona;
import innova4b.ejemplo6.repository.JdbcPersonaDao;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired 
	JdbcPersonaDao jdbcPersonaDao;
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newPersona(ModelMap model) {
		model.addAttribute("persona",new Persona());
		return "persona/new";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("personas",jdbcPersonaDao.list());
		return "persona/list";
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public void show(ModelMap model) {	
		if (!model.containsAttribute("persona"))
			model.addAttribute("persona",buildPersona("Maite","Yanguas","25/11/1983"));		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Persona persona, BindingResult result, RedirectAttributes redirect) {		
		if (result.hasErrors()) {
			return "persona/new";
		} else {
			jdbcPersonaDao.insert(persona);
			return "redirect:/ejemplo6/persona/list";
		}
	}

	
	private Persona buildPersona(String nombre, String apellido, String fechaNacimiento){
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setFechaNacimiento(fechaNacimiento);
		return persona;
	}
	
	


}
