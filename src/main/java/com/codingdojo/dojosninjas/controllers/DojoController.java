package com.codingdojo.dojosninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosninjas.models.Dojos;
import com.codingdojo.dojosninjas.services.MainServices;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	@Autowired
	private MainServices mainServices;
	
	@GetMapping("/dojos")
	public String index(Model viewModel) {
		viewModel.addAttribute("dojos",mainServices.todosDojos());
		return"dojos/index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String formularioDojo(@ModelAttribute("dojo") Dojos dojo) {
		return"/dojos/nuevodojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String nuevoDojo(@Valid @ModelAttribute("dojo") Dojos dojo, BindingResult resultado ) {
		if (resultado.hasErrors()) {
			return"/dojos/nuevodojo.jsp";
		}
		mainServices.crearDojo(dojo);
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos/{idDojo}")
	public String dojosYninjas(@PathVariable("idDojo")Long idd, Model viewModel) {
		viewModel.addAttribute("dojosyninjas", mainServices.encontrarDojo(idd) );
		return"/dojos/mostardojo.jsp";
		
		
	}

}
