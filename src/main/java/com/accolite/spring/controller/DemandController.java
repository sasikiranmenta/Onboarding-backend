package com.accolite.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.spring.entity.Demand;
import com.accolite.spring.service.DemandService;

@RestController
public class DemandController {

	@Autowired
	private DemandService service;
	
	@PostMapping("/demand")
	public Demand add(@RequestBody Demand demand) {
		return service.save(demand);
	}
	
	@GetMapping("/demand")
	public List<Demand> list(){
	  return service.list();
		
	}
	@GetMapping("/demand/{id}")
	public Demand get(@PathVariable long id) {
		return service.get(id);
	}
	
	@PutMapping("/demand/{id}")
	public Demand update(@PathVariable long id ,@RequestBody Demand demand ) {
		return service.update(id,demand);
	}
	
	@DeleteMapping("/demand/{id}")
	public String deleteOnboarding(@PathVariable long id) {
		return service.delete(id);
	}
	
	
	
	
	
}
