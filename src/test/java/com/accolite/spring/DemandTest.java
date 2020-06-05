package com.accolite.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.accolite.spring.entity.Demand;
import com.accolite.spring.repository.DemandRepository;
import com.accolite.spring.service.DemandService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public  class DemandTest {
	
	@Autowired
	private DemandService demandService;
	
	
	@MockBean
	private DemandRepository demandRepository;
	 
	
	ObjectMapper on = new ObjectMapper();
		
	
	@Test
	public void getAllOnboardings() throws Exception {
		
		when(demandRepository.findAll()).thenReturn(Stream
				.of(new Demand(1, "JAVA","2020-0606", "Not Satisfied", "MUMBAI", "6",1),new Demand(2, "JAVA","2020-0606", "Not Satisfied", "MUMBAI", "6",1)).collect(Collectors.toList()));
		assertEquals(2,demandService.list().size());
		
	}
	
	@Test
	public void addOnboardee() {
	Demand demand =	 new Demand(1, "JAVA","2020-0606", "Not Satisfied", "MUMBAI", "6",1);
		when(demandRepository.save(demand)).thenReturn(demand);
		assertEquals(demand,demandService.save(demand));
	}
	
	
	@Test
	public void getOnboardee() {
		
	 Demand demand = new Demand(1, "JAVA","2020-0606", "Not Satisfied", "MUMBAI", "6",1);;
		when(demandRepository.findById((long) 1)).thenReturn(Optional.of(demand));
		assertEquals(demand, demandService.get(1));		
	}
	
	@Test
	public void deleteOnboarding() {
	     demandService.delete(1);
	    verify(demandRepository,times(1)).deleteById((long) 1);
	}
	
	
	
	
}
	