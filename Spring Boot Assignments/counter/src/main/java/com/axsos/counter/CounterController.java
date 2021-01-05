package com.axsos.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {

	@RequestMapping("/")
	public String display(HttpSession session) {
		if (session.isNew()) {
			session.setAttribute("count", 0);
		}
		else {
			Integer count = (Integer) session.getAttribute("count");
			count ++;
			session.setAttribute("count", count);
		}
		return "home.jsp";
	}
	
	@RequestMapping("/times-two")
	public String two(HttpSession session) {
		if (session.isNew()) {
			session.setAttribute("count", 0);
		}
		else {
			Integer count = (Integer) session.getAttribute("count");
			count += 2;
			session.setAttribute("count", count);
		}
		return "home.jsp";
	}
	@RequestMapping("/delete")
	public String del(HttpSession session) {
		if (session.isNew()) {
			session.setAttribute("count", 0);
		}
		session.setAttribute("count", 0);
		return "home.jsp";
	}
}
