package com.axsos.ninjagold;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/submit")
public class GoldController {

		@RequestMapping("")
		public String processGold(@RequestParam("type") String type, HttpSession session) {
			Random rand = new Random();
			if(session.isNew()) {
				session.setAttribute("activity", "");
			}
			String message = "";
			int gold = (int) session.getAttribute("gold");
			if(type.equals("farm")) {
				int num = rand.nextInt(21-10)+10;
				message += "You earned "+num+" gold!"+new java.util.Date()+" </br>";
				gold += num;
				session.setAttribute("gold", gold);
			}
			else if(type.equals("cave")) {
				int num = rand.nextInt(11-5)+5;
				message += "You earned "+num+" gold!"+new java.util.Date()+"  </br>";
				gold += num;
				session.setAttribute("gold", gold);
			}
			else if(type.equals("house")) {
				int num = rand.nextInt(6-2)+2;
				message += "You earned "+num+" gold!"+new java.util.Date()+" </br>";
				gold += num;
				session.setAttribute("gold", gold);
			}
			else if(type.equals("spa")) {
				int num = rand.nextInt(21-5)+5;
				message += "<span>You lost "+num+" gold!"+new java.util.Date()+"</span> </br>";
				gold -= num;
				session.setAttribute("gold", gold);
			}
			else{
				int num = rand.nextInt(51);
				if(rand.nextBoolean()) {
					gold += num;
					session.setAttribute("gold", gold);
					message += "You earned "+num+" gold!"+new java.util.Date()+" </br>";
				}
				else{
					gold -= num;
					session.setAttribute("gold", gold);
					message += "<span> You lost "+num+" gold!"+new java.util.Date()+" </span></br>";
				}
			}
			if(gold < -100) {
				return "redirect:/prison";
			}
			else {
				message = (String) session.getAttribute("activity") + message;
				session.setAttribute("activity", message);
				return "redirect:/";
			}
		}
		
}
