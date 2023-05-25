package com.codingdojo.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojosninjas.models.Dojos;

public interface DojosRepo extends CrudRepository<Dojos ,Long>  {
	List<Dojos> findAll();
	
}