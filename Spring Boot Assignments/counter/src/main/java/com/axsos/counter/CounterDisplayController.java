package com.axsos.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterDisplayController {
	@RequestMapping("/counter")
	 public String index(HttpSession session){
		if (session.isNew()) {
			session.setAttribute("count", 0);
		}
       return "counter.jsp";
   }
	
}
