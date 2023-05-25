package com.codingdojo.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojosninjas.models.Ninjas;

public interface NinjasRepo extends CrudRepository<Ninjas ,Long>  {
	
	List<Ninjas> findAll();
	
}
