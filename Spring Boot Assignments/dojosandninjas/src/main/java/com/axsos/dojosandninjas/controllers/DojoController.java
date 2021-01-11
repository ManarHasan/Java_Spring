package com.axsos.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.dojosandninjas.models.Dojo;
import com.axsos.dojosandninjas.models.Ninja;
import com.axsos.dojosandninjas.services.DojoService;


@Controller
public class DojoController {
	private final DojoService dojoService;

	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	@RequestMapping("")
	public String root() {
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("/dojos/new")
	public String dojoForm(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
	@RequestMapping(value="/dojo", method= RequestMethod.POST)
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
        if (result.hasErrors()) {
            return "dojo.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/ninjas/new";
        }
	}
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id")Long id,Model model){
        Dojo dojo =dojoService.findDojo(id);
        List <Ninja> ninjas = dojo.getNinjas();

        model.addAttribute("dojo",dojo);
        model.addAttribute("ninjas",ninjas);
        return "show.jsp";
    }
	
}
