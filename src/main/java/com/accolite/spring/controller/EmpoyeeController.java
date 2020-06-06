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

import com.accolite.spring.entity.Employee;
import com.accolite.spring.service.EmployeeService;

@CrossOrigin(origins = "*")
@RestController
public class EmpoyeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employee")
	public Employee add(@RequestBody Employee employee) {
		return service.save(employee);
	}
	
	@GetMapping("/employee")
	public List<Employee> list(){
	  return service.list();
		
	}
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable long id) {
		return service.get(id);
	}
	
	@PutMapping("/employee/{id}")
	public Employee update(@PathVariable long id ,@RequestBody Employee employee ) {
		return service.update(id,employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteOnboarding(@PathVariable long id) {
		return service.delete(id);
	}

}
