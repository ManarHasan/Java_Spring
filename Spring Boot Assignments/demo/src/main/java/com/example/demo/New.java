package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class New {
	//method to show how path variables work.
	@RequestMapping("/users/{num}")
	public String users(@PathVariable("num") String num) {
		return "hello " + num;
	}
	//method to show how path variables work.
	@RequestMapping("/products/{num}/edit")
	public String products(@PathVariable("num") String num) {
		return "hello " + num;
	}
}
