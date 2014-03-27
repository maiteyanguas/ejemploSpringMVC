package innova4b.ejemplo6.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import innova4b.ejemplo6.model.Persona;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show() {
		HashMap<String, Persona> model = new HashMap<String, Persona>();
		model.put("persona", buildPersona());
		ModelAndView mv = new ModelAndView("persona/show",model);
		return mv;
	}
	
	private Persona buildPersona(){
		Persona persona = new Persona();
		String nombre = "Maite";
		String apellido = "Yanguas";
		int edad = 30;
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEdad(edad);
		return persona;
	}
	
	


}
