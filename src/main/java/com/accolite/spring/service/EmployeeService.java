package com.accolite.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.spring.entity.Employee;
import com.accolite.spring.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepository repository;
	
		public Employee save(Employee employee) {
		     return repository.save(employee);	
	    }

	 
		public Employee get(long id) {
		    return repository.findById(id).orElse(null);	
	    }

	   
		public List<Employee> list() {
		       	return repository.findAll();
	    }

	   
		public Employee update(long id, Employee employee) {
			Employee oldemployee = repository.findById(id).orElse(null);
			oldemployee.setPhotourl(employee.getPhotourl());
			oldemployee.setName(employee.getName());
			oldemployee.setEmail(employee.getEmail());
			oldemployee.setRole(employee.getEmail());
			oldemployee.setPass(employee.getPass());
			return repository.save(oldemployee);
		
		}

	   
		public String delete(long id) {
		repository.deleteById(id);
		return "Onboarding removed"+id;
		
			
		}
	

}
