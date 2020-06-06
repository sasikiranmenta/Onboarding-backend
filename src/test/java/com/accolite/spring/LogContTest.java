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

import com.accolite.spring.controller.LoggingController;
import com.accolite.spring.entity.Logging;
import com.accolite.spring.service.LoggingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=LoggingController.class)
public class LogContTest {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private LoggingService loggingService;
	
	@Test
	public void testSave() throws Exception{

		Logging logging =	 new Logging(1, "New Demand created", "2020-06-06", 1);
		String inputInJson = this.mapToJson(logging);
		 String URI = "/logging";
		 when(loggingService.save(Mockito.any(Logging.class))).thenReturn(logging);
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
	public void testGetAll() throws Exception {

		Logging logging =	 new Logging(1, "New Demand created", "2020-06-06", 1);
		Logging logging1 =	 new Logging(2, "New Demand created", "2020-06-06", 1);
		
		List<Logging> loggingList = new ArrayList<>();
		loggingList.add(logging);
		loggingList.add(logging1);
		
		Mockito.when(loggingService.list()).thenReturn(loggingList);
		
		String URI = "/logging";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockmvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(loggingList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	
	

	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	


}
