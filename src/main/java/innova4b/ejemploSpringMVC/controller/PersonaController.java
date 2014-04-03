package innova4b.ejemploSpringMVC.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import innova4b.ejemploSpringMVC.model.Persona;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newPersona(ModelMap model) {
		model.addAttribute("persona",new Persona());
		return "persona/new";
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public void show(ModelMap model) {	
		if (!model.containsAttribute("persona"))
			model.addAttribute("persona",buildPersona("Maite","Yanguas",30));		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Persona persona, BindingResult result, RedirectAttributes redirect) {		
		if (result.hasErrors()) {
			return "persona/new";
		} else {
			redirect.addFlashAttribute("persona", persona);
			return "redirect:/ejemploSpringMVC/persona/show";
		}
	}

	
	private Persona buildPersona(String nombre, String apellido, int edad){
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEdad(edad);
		return persona;
	}
	
	


}
