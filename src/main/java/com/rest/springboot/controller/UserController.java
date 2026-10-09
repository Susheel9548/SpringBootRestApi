package com.rest.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	

	@GetMapping
	public String greet() {
		System.out.println("Usercontroller.greet() :");

		return "home";
	}


		
 
}
