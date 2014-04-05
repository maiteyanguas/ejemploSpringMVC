package innova4b.ejemploSpringMVC.controller;

import innova4b.ejemploSpringMVC.model.Persona;
import innova4b.ejemploSpringMVC.repository.PersonaDao;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired  
	PersonaDao PersonaDao;
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newPersona(ModelMap model) {
		model.addAttribute("persona",new Persona());
		return "persona/new";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("personas",PersonaDao.list());
		return "persona/list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Persona persona, BindingResult result, RedirectAttributes redirect) {		
		if (result.hasErrors()) {
			return "persona/new";
		} else {
			PersonaDao.insert(persona);
			return "redirect:/ejemploSpringMVC/persona/list";
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {		
			PersonaDao.delete(id);
			return "redirect:/ejemploSpringMVC/persona/list";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(ModelMap model, @PathVariable("id") Long id) {		
			model.addAttribute("persona", PersonaDao.get(id));
			return "persona/edit";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid Persona persona, BindingResult result, RedirectAttributes redirect) {		
		if (result.hasErrors()) {
			return "persona/edit/"+persona.getId();
		} else {
			PersonaDao.update(persona);
			return "redirect:/ejemploSpringMVC/persona/list";
		}
	}

}
