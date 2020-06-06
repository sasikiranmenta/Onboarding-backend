package com.accolite.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.spring.entity.Onboarding;
import com.accolite.spring.service.OnboardingService;
@CrossOrigin(origins = "*")
@RestController
public class OnboardingController {
	
	@Autowired
	private OnboardingService service;
	
	@PostMapping("/onboarding")
	public Onboarding add(@RequestBody Onboarding onboarding) {
		return service.save(onboarding);
	}
	
	@GetMapping("/onboarding")
	public List<Onboarding> list(){
	  return service.list();
		
	}
	@GetMapping("/onboarding/{id}")
	public Onboarding get(@PathVariable int id) {
		return service.get(id);
	}
	
	@PutMapping("/onboarding/{id}")
	public Onboarding update(@PathVariable int id ,@RequestBody Onboarding onboarding ) {
		return service.update(id,onboarding);
	}
	
	@DeleteMapping("/onboarding/{id}")
	public String deleteOnboarding(@PathVariable int id) {
		return service.delete(id);
	}
	
	

}
