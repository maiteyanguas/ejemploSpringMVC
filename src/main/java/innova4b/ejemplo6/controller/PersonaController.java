package innova4b.ejemplo6.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import innova4b.ejemplo6.model.Persona;

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
	public String add(HttpServletRequest request, ModelMap model) {
		String nombre = request.getParameter("nombre")!=null?request.getParameter("nombre"):"";
		String apellido = request.getParameter("apellido")!=null?request.getParameter("apellido"):"";
		int edad = request.getParameter("edad")!=null?Integer.parseInt(request.getParameter("edad")):0;
		//model.addAttribute("persona", buildPersona(nombre,apellido,edad));
		//return "persona/show";
		//tengo que hacer un redirect, porque si no, puedo volver a enviar el formulario. 
		//Pero pierdo el modelo. Lo guardo en sesión
		HttpSession session = request.getSession(true);			
		session.setAttribute("persona", buildPersona(nombre,apellido,edad));	
		return "redirect:/ejemplo6/persona/show";

	}
	
	private Persona buildPersona(String nombre, String apellido, int edad){
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEdad(edad);
		return persona;
	}
	
	


}
