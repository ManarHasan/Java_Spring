package com.axsos.dojosurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SurveyController {
	@RequestMapping("")
	public String home() {
		return "survey.jsp";
	}
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(@RequestParam("name") String name, @RequestParam("location") String location, @RequestParam("language") String language, @RequestParam("comment") String comment, HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		if (language.equals("Java")) {
			return "redirect:/result-java";
		}
		return "redirect:/result";
	}
	@RequestMapping("/result")
	public String result() {
		return "result.jsp";
	}
	@RequestMapping("/result-java")
	public String resultJava() {
		return "java.jsp";
	}
}
