package com.axsos.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.dojosandninjas.models.Dojo;
import com.axsos.dojosandninjas.models.Ninja;
import com.axsos.dojosandninjas.services.DojoService;
import com.axsos.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;

	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/ninjas/new")
	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List <Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "ninja.jsp";
	}
	
	@RequestMapping(value="/ninja", method= RequestMethod.POST)
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result){
        if (result.hasErrors()) {
            return "ninja.jsp";
        } else {
            Ninja newNinja = ninjaService.createNinja(ninja);
            return "redirect:/dojos/"+newNinja.getDojo().getId();
        }
	}
}
