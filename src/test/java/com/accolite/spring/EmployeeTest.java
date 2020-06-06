package com.accolite.spring;

import static org.assertj.core.api.Assertions.assertThat;
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

import com.accolite.spring.entity.Demand;
import com.accolite.spring.entity.Employee;
import com.accolite.spring.repository.EmployeeRepository;
import com.accolite.spring.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public  class EmployeeTest {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@MockBean
	private EmployeeRepository employeeRepository;
	 
	
	ObjectMapper on = new ObjectMapper();
		
	
	@Test
	public void getAllEmployee() throws Exception {
		
		when(employeeRepository.findAll()).thenReturn(Stream
				.of(new Employee(1, "Sasi", "sasi", "sasi", "admin", "http://home"),new Employee(1, "Sasi", "sasi", "sasi", "admin", "http://home")).collect(Collectors.toList()));
		assertEquals(2,employeeService.list().size());
		
	}
	
	@Test
	public void addEmployee() {
	Employee employee =	 new Employee(1, "Sasi", "sasi", "sasi", "admin", "http://home");
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee,employeeService.save(employee));
	}
	
	
	@Test
	public void getEmployee() {
		
	 Employee employee = new Employee(1, "Sasi", "sasi", "sasi", "admin", "http://home");
		when(employeeRepository.findById((long) 1)).thenReturn(Optional.of(employee));
		assertEquals(employee, employeeService.get(1));		
	}
	
	@Test
	public void deleteEmployee() {
	     employeeService.delete(1);
	    verify(employeeRepository,times(1)).deleteById((long) 1);
	}
	
	
	@Test
	public void update() {
		
		 Employee employee = new Employee(1, "Sasi", "sasi", "sasi", "admin", "http://home");
			
		when(employeeRepository.findById((long) 1)).thenReturn(Optional.of(employee));
		employee.setName("kiran");

		when(employeeRepository.save(employee)).thenReturn(employee);
		assertThat(employeeService.update(1, employee)).isEqualTo(employee);
	}	
	
	
	
	
	
	
}
	