package innova4b.ejemplo6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import innova4b.ejemplo6.Persona;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(ModelMap model) {
		model.addAttribute("persona", buildPersona());
		return "persona/show";

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
