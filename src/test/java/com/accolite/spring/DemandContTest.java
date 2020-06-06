package com.accolite.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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

import com.accolite.spring.controller.DemandController;
import com.accolite.spring.entity.Demand;
import com.accolite.spring.service.DemandService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=DemandController.class)
class DemandContTest {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private DemandService demandService;
	
	@Test
	public void testSave() throws Exception{
		
		 Demand demand = new Demand(1, "JAVA","2020-0606", "Not Satisfied", "MUMBAI", "6",1);
		 String inputInJson = this.mapToJson(demand);
		 String URI = "/demand";
		 when(demandService.save(Mockito.any(Demand.class))).thenReturn(demand);
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
		
		 Demand demand = new Demand(1, "JAVA","2020-0606", "Not Satisfied", "MUMBAI", "6",1);
		
		Mockito.when(demandService.get(Mockito.anyInt())).thenReturn(demand);
		
		String URI = "/demand/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(demand); 
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(outputInJson);
	}

	@Test
	public void testGetAllBookedTickets() throws Exception {

		 Demand demand = new Demand(1, "JAVA","2020-0606", "Not Satisfied", "MUMBAI", "6",1);
		 Demand demand1 = new Demand(2, "JAVA","2020-0606", "Not Satisfied", "MUMBAI", "6",1);
		
		List<Demand> demandList = new ArrayList<>();
		demandList.add(demand);
		demandList.add(demand1);
		
		Mockito.when(demandService.list()).thenReturn(demandList);
		
		String URI = "/demand";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockmvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(demandList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	
	

	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	


}
