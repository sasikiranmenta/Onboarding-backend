package com.accolite.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.spring.entity.Demand;
import com.accolite.spring.repository.DemandRepository;

@Service
public class DemandService {

	@Autowired
	private DemandRepository repository;
	
		public Demand save(Demand demand) {
		     return repository.save(demand);	
	    }

	 
		public Demand get(long id) {
		    return repository.findById(id).orElse(null);	
	    }

	   
		public List<Demand> list() {
		       	return repository.findAll();
	    }

	   
		public Demand update(long id, Demand demand) {
			Demand olddemand = repository.findById(id).orElse(null);
			olddemand.setLocation(demand.getLocation());
//			olddemand.setEmployee(demand.getEmployee());
			olddemand.setEmpid(demand.getEmpid());
			olddemand.setStart(demand.getStart());
			olddemand.setSkills(demand.getSkills());
			olddemand.setCount(demand.getCount());
			olddemand.setStatus(demand.getStatus());	
			return repository.save(olddemand);
		
		}

	   
		public String delete(long id) {
		repository.deleteById(id);
		return "Onboarding removed"+id;
		
			
		}
	
	
	
	
	
}
