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

import com.accolite.spring.entity.Logging;
import com.accolite.spring.repository.LoggingRepository;
import com.accolite.spring.service.LoggingService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public  class LoggingTest {
	
	@Autowired
	private LoggingService employeeService;
	
	
	@MockBean
	private LoggingRepository loggingRepository;
	 
	
	ObjectMapper on = new ObjectMapper();
		
	
	@Test
	public void getAllOnboardings() throws Exception {
		
		when(loggingRepository.findAll()).thenReturn(Stream
				.of(new Logging(1, "New Demand created", "2020-06-06", 1),new Logging(2, "New Demand created", "2020-06-06", 1)).collect(Collectors.toList()));
		assertEquals(2,employeeService.list().size());
		
	}
	
	@Test
	public void addOnboardee() {
	Logging logging =	 new Logging(1, "New Demand created", "2020-06-06", 1);
		when(loggingRepository.save(logging)).thenReturn(logging);
		assertEquals(logging,employeeService.save(logging));
	}
	
	
	
	
}
	