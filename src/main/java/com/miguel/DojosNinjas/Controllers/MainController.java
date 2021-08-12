package com.miguel.DojosNinjas.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miguel.DojosNinjas.Models.Dojo;
import com.miguel.DojosNinjas.Models.Ninja;
import com.miguel.DojosNinjas.Services.DojoService;
import com.miguel.DojosNinjas.Services.NinjaService;



@Controller
public class MainController{

//	Agrega depoendencias

	private final NinjaService ninjaService;
	private final DojoService dojoService;

//	Constructor
	public MainController(NinjaService ninjaService, DojoService dojoService ) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;

	}

//	redirecciona 

	@RequestMapping("/")
	public String index() {
		return "redirect:/dojos/new";
	}	
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/newDojo.jsp";
	}

	
	// crear un nuevo dojo (post)

		@RequestMapping(value = "/dojos/new", method = RequestMethod.POST)
		public String createNinja(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
			if (result.hasErrors()) {
				return "/newDojo.jsp";
			} else {
				dojoService.createDojo(dojo);
				return "redirect:/dojos/new";
			}
		}
		
		
		@RequestMapping("/ninjas/new")
		public String main(@ModelAttribute ("ninja") Ninja ninja, Model model) {
			List<Dojo> dojos = dojoService.findAll();
			model.addAttribute("dojos", dojos);
			return "/newNinja.jsp";
		}

	// crear una nueva ninja (post)

	@RequestMapping(value = "/ninjas/new", method = RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "/newNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
	// Muestra Ninjas en Dojos
	
	@RequestMapping("/dojos/{id}")
	public String viewDojo(Model model, @PathVariable("id") Long id) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", dojo.getNinjas());
		return "showDojo.jsp";
	}
	
	
	
}
