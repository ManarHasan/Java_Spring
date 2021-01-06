package com.axsos.ninjagold;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RenderController {
	
	@RequestMapping("")
	public String homeRedirect(HttpSession session) {
		if(session.isNew()) {
			session.setAttribute("gold", 0);
			session.setAttribute("activity", "");
		}
		return "redirect:/Gold";
	}
	@RequestMapping("/Gold")
	public String home(HttpSession session) {
		if(session.isNew()) {
			session.setAttribute("gold", 0);
			session.setAttribute("activity", "");
		}
		return "home.jsp";
	}
	@RequestMapping("/reset")
	public String playAgain(HttpSession session) {
		if(session.isNew()) {
			return "redirect:/";
		}
		session.setAttribute("gold", 0);
		session.setAttribute("activity", "");
		return "redirect:/";
	}
	@RequestMapping("/prison")
	public String prison(HttpSession session) {
		if(session.isNew()) {
			return "redirect:/";
		}
		return "prison.jsp";
	}
	
}
