package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Test {
	@RequestMapping("/test")
	public String root(Model model) {
		model.addAttribute("dojoName", "Burbank");
		return "index.jsp";
	}
}
