package com.accolite.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.spring.entity.Onboarding;
import com.accolite.spring.repository.OnboardingRepository;

@Service
public class OnboardingService {
	
	@Autowired
	private OnboardingRepository repository;
	
	public Onboarding save(Onboarding onboarding) {
		return repository.save(onboarding);
	}
	

	
//	public List<Onboarding> saveOnboarding(List<Onboarding> onboardings){
//		return repository.saveAll(onboardings);
//	}
//	
	public List<Onboarding> list(){
		return repository.findAll();
	}

	public Onboarding get(int id) {
		return repository.findById(id).orElse(null);
	}
	
//	public Onboarding getOnboardingByName(String name) {
//		return repository.findByName(name);
//	}
	
	public String delete(int id) {
		repository.deleteById(id);
		return "Onboarding removed"+id;
	}
	
	public Onboarding update(int id, Onboarding onboarding) {
	Onboarding oldonboarding = repository.findById(id).orElse(null);
	oldonboarding.setDemandId(onboarding.getDemandId());
	oldonboarding.setName(onboarding.getName());
	oldonboarding.setEmail(onboarding.getEmail());
	oldonboarding.setCollege(onboarding.getCollege());
	oldonboarding.setCgpa(onboarding.getCgpa());
	oldonboarding.setPersonalNumber(onboarding.getPersonalNumber());
	oldonboarding.setPermanentAddress(onboarding.getPermanentAddress());
	oldonboarding.setPresentAddress(onboarding.getPresentAddress());
	oldonboarding.setLocation(onboarding.getLocation());
	oldonboarding.setOnboardingStart(onboarding.getOnboardingStart());
	oldonboarding.setEta(onboarding.getEta());
	oldonboarding.setBgvCheck(onboarding.getBgvCheck());
	oldonboarding.setOnboardingStatus(onboarding.getOnboardingStatus());
	oldonboarding.setSkills(onboarding.getSkills());
	return repository.save(oldonboarding);
	}

	
}
