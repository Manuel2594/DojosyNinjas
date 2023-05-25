package com.codingdojo.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.dojosninjas.services.MainServices;

@Controller
public class MainController {
	@Autowired
	private MainServices mainServices;
	
	@GetMapping("/")
	public String raiz() {
		return "redirect:/dojos";
	}

}
