package com.axsos.relationships.controllers;




import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.relationships.models.License;
import com.axsos.relationships.models.Person;
import com.axsos.relationships.services.LicenseServices;
import com.axsos.relationships.services.PersonServices;


@Controller
public class PersonController {
    private final PersonServices personService;
    private final LicenseServices licenseService;

    public PersonController(PersonServices personService, LicenseServices licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }
    @RequestMapping("")
    public String Home(){
        return "redirect:/persons/new";
    }
    @RequestMapping("/persons/{id}")
    public String show(@PathVariable("id")Long id,Model model){
        Person person =personService.findPerson(id);

        model.addAttribute("person",person);

        return "show.jsp";
    }

    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "home.jsp";
    }
    @RequestMapping(value="/persons", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "home.jsp";
        } else {
            personService.createPerson(person);
            return "redirect:/licenses/new";
        }
    }


}
