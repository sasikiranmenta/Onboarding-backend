package com.accolite.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.accolite.spring.entity.Onboarding;
import com.accolite.spring.repository.OnboardingRepository;
import com.accolite.spring.service.OnboardingService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public  class OnboardingTest {
	
	@Autowired
	private OnboardingService onboardingService;
	
	
	@MockBean
	private OnboardingRepository onboardingRepository;
	 
	
	ObjectMapper on = new ObjectMapper();
		
	
	@Test
	public void getAllOnboardings() throws Exception {
		
		when(onboardingRepository.findAll()).thenReturn(Stream
				.of(new Onboarding(1,2,"sasi","sasikiran","ssn",4,45678,"nellore","nellore","mumbai","2020-06-06","2020-06-06","mjbb","kjbkj","klhkjh" ),new Onboarding(1,2,"sasi","sasikiran","ssn",4,45678,"nellore","nellore","mumbai","2020-06-06","2020-06-06","mjbb","kjbkj","klhkjh" )).collect(Collectors.toList()));
		assertEquals(2,onboardingService.list().size());
		
	}
	
	@Test
	public void addOnboardee() {
	Onboarding onboarding =	 new Onboarding(1,2,"sasi","sasikiran","ssn",4,45678,"nellore","nellore","mumbai","2020-06-06","2020-06-06","mjbb","kjbkj","klhkjh" );
		when(onboardingRepository.save(onboarding)).thenReturn(onboarding);
		assertEquals(onboarding,onboardingService.save(onboarding));
	}
	
	
	@Test
	public void getOnboardee() {
		
	 Onboarding onboarding = new Onboarding(1,2,"sasi","sasikiran","ssn",4,45678,"nellore","nellore","mumbai","2020-06-06","2020-06-06","mjbb","kjbkj","klhkjh" );
		when(onboardingRepository.findById(1)).thenReturn(Optional.of(onboarding));
		assertEquals(onboarding, onboardingService.get(1));		
	}
	
	@Test
	public void deleteOnboarding() {
	     onboardingService.delete(1);
	    verify(onboardingRepository,times(1)).deleteById(1);
	}
	
	
	
	
}
	