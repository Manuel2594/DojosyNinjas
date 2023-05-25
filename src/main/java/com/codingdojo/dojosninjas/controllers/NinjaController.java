package com.codingdojo.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosninjas.models.Ninjas;
import com.codingdojo.dojosninjas.services.MainServices;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	private MainServices mainServices;
	
	@GetMapping("/ninja/new")
	public String formularioNinja(@ModelAttribute("ninja") Ninjas ninja,
			Model viewModel) {
		viewModel.addAttribute("dojos", mainServices.todosDojos());
		return"/ninjas/nuevoninja.jsp";
	}
	@PostMapping("/ninja/new")
	public String nuevoNinja(@Valid @ModelAttribute("ninja") Ninjas ninja, BindingResult resultado ) {
		if (resultado.hasErrors()) {
			return"/ninjas/nuevoninja.jsp";
		}
		mainServices.crearNinja(ninja);
		return "redirect:/dojos";
	}

}
