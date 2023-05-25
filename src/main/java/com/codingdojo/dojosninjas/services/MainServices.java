package com.codingdojo.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Dojos;
import com.codingdojo.dojosninjas.models.Ninjas;
import com.codingdojo.dojosninjas.repositories.DojosRepo;
import com.codingdojo.dojosninjas.repositories.NinjasRepo;

@Service
public class MainServices {
	@Autowired
	private DojosRepo dojosRepo;
	@Autowired
	private NinjasRepo ninjasRepo;
	
// CRUD Crear
	public Ninjas crearNinja(Ninjas ninja) {
		return ninjasRepo.save(ninja);
	}
	public Dojos crearDojo(Dojos dojo) {
		return dojosRepo.save(dojo);
	}
	
//CRUD LEER TODOS
	
	public List<Ninjas> todosNinjas(){
		return ninjasRepo.findAll();
	}
	public List<Dojos> todosDojos(){
		return dojosRepo.findAll();
	}
//CRUD LEER ID
	public Ninjas getNinja(Long id) {
		return ninjasRepo.findById(id).orElse(null);
	}
	public Dojos getDojos(Long id) {
		return dojosRepo.findById(id).orElse(null);
	}
	public Dojos encontrarDojo(Long id) {
		return dojosRepo.findById(id).orElse(null);
	}

}
