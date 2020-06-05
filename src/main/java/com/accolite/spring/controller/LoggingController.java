package com.accolite.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.spring.entity.Logging;

import com.accolite.spring.service.LoggingService;


@RestController
public class LoggingController {
	
	@Autowired
	private LoggingService service;
	
	@PostMapping("/logging")
	public Logging add(@RequestBody Logging logging) {
		return service.save(logging);
	}
	
	@GetMapping("/logging")
	public List<Logging> list(){
	  return service.list();
		
	}
	
	
}
