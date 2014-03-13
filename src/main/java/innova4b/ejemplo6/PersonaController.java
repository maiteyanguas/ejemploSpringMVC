package innova4b.ejemplo6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import innova4b.ejemplo6.Persona;

@Controller
@RequestMapping("/persona")
public class PersonaController {

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String ver(ModelMap model) {
		Persona persona = new Persona();
		String nombre = "Maite";
		String apellido = "Yanguas";
		int edad = 30;
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEdad(edad);

		model.addAttribute("persona", persona);
		return "persona";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView nueva() {
		return new ModelAndView("personaNueva", "command", new Persona());
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String nueva(@ModelAttribute("SpringWeb")Persona persona, ModelMap model) {
		Persona nuevaPersona = new Persona();
		nuevaPersona.setNombre(persona.getNombre());
		nuevaPersona.setApellido(persona.getApellido());
		nuevaPersona.setEdad(persona.getEdad());

		model.addAttribute("persona", nuevaPersona);
		return "persona";
	}

}
