package com.axsos.relationships.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.DateFormatter;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.relationships.models.License;
import com.axsos.relationships.models.Person;
import com.axsos.relationships.services.LicenseServices;
import com.axsos.relationships.services.PersonServices;


@Controller
public class LicenseController {
	 private final LicenseServices licenseService;
	 private final PersonServices personService;

    public LicenseController(LicenseServices licenseService, PersonServices personService) {
        this.licenseService = licenseService;
        this.personService = personService;
       
    }
	
    @RequestMapping("licenses/new")
    public String newLicense(@ModelAttribute("licenses") License license, Model model) {
    	List<Person>persons =personService.allPersons();
        model.addAttribute("persons",persons);
    	return "new.jsp";
    }
    @RequestMapping(value="/licenses", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("licenses") License license, BindingResult result){
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            License newLicense = licenseService.createLicense(license);
            Person person = newLicense.getPerson();
            return "redirect:/persons/"+person.getId();
        }
}
}
