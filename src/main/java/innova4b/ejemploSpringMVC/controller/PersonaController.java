package innova4b.ejemploSpringMVC.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import innova4b.ejemploSpringMVC.model.Persona;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newPersona() {
		return "persona/new";
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public void show(ModelMap model,HttpServletRequest request) {
		if (null==request.getSession().getAttribute("persona"))
			model.addAttribute("persona",buildPersona("Maite","Yanguas",30));
		else
			model.addAttribute("persona",(Persona)request.getSession().getAttribute("persona"));
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpSession session, @RequestParam String nombre, @RequestParam String apellido, @RequestParam int edad) {
		//tengo que hacer un redirect, porque si no puedo volver a enviar el formulario. Pero pierdo el modelo		
		session.setAttribute("persona", buildPersona(nombre,apellido,edad));
		return "redirect:/ejemploSpringMVC/persona/show";
	}
	
	private Persona buildPersona(String nombre, String apellido, int edad){
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEdad(edad);
		return persona;
	}
	
	


}
