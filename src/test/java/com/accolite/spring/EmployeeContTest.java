package com.accolite.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.accolite.spring.controller.EmpoyeeController;
import com.accolite.spring.entity.Employee;
import com.accolite.spring.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=EmpoyeeController.class)
public class EmployeeContTest {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private EmployeeService employeeService;
	
	@Test
	public void testSave() throws Exception{
		
		 Employee employee = new Employee(1, "Sasi", "sasi", "sasi", "admin", "http://home");
		 String inputInJson = this.mapToJson(employee);
		 String URI = "/employee";
		 when(employeeService.save(Mockito.any(Employee.class))).thenReturn(employee);
		 RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post(URI)
					.accept(MediaType.APPLICATION_JSON).content(inputInJson)
					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mockmvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			
			String outputInJson = response.getContentAsString();
			
			assertThat(outputInJson).isEqualTo(inputInJson);
			assertEquals(HttpStatus.OK.value(), response.getStatus());
		 
	}
	
	@Test
	public void testGetTicketById() throws Exception {
		
		 Employee employee = new Employee(1, "Sasi", "sasi", "sasi", "admin", "http://home");
		
		Mockito.when(employeeService.get(Mockito.anyInt())).thenReturn(employee);
		
		String URI = "/employee/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(employee); 
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(outputInJson);
	}

	@Test
	public void testGetAllBookedTickets() throws Exception {
 	
				 Employee employee = new Employee(1, "Sasi", "sasi", "sasi", "admin", "http://home");
					
				 Employee employee1 = new Employee(1, "Sasi", "sasi", "sasi", "admin", "http://home");
						
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee);
		employeeList.add(employee1);
		
		Mockito.when(employeeService.list()).thenReturn(employeeList);
		
		String URI = "/employee";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockmvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(employeeList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	
	

	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	


}
