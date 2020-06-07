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

import com.accolite.spring.controller.OnboardingController;
import com.accolite.spring.controller.OnboardingController;
import com.accolite.spring.entity.Onboarding;
import com.accolite.spring.service.OnboardingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=OnboardingController.class)
public class OnboardingContTest {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private OnboardingService onboardingService;
	
	@Test
	public void testSave() throws Exception{
		
		 Onboarding onboarding = new Onboarding(1,2,"sasi","sasikiran","ssn",4,45678,"nellore","nellore","mumbai","2020-06-06","2020-06-06","mjbb","kjbkj","klhkjh" );
		
		String inputInJson = this.mapToJson(onboarding);
		 String URI = "/onboarding";
		 when(onboardingService.save(Mockito.any(Onboarding.class))).thenReturn(onboarding);
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
	public void testById() throws Exception {
		
		 Onboarding onboarding = new Onboarding(1,2,"sasi","sasikiran","ssn",4,45678,"nellore","nellore","mumbai","2020-06-06","2020-06-06","mjbb","kjbkj","klhkjh" );
		
		Mockito.when(onboardingService.get(Mockito.anyInt())).thenReturn(onboarding);
		
		String URI = "/onboarding/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(onboarding); 
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(outputInJson);
	}

	@Test
	public void testGetAll() throws Exception {
		
		 Onboarding onboarding = new Onboarding(1,2,"sasi","sasikiran","ssn",4,45678,"nellore","nellore","mumbai","2020-06-06","2020-06-06","mjbb","kjbkj","klhkjh" );
			
		 Onboarding onboarding1 = new Onboarding(1,2,"sasi","sasikiran","ssn",4,45678,"nellore","nellore","mumbai","2020-06-06","2020-06-06","mjbb","kjbkj","klhkjh" );
				
		List<Onboarding> onboardingList = new ArrayList<>();
		onboardingList.add(onboarding);
		onboardingList.add(onboarding1);
		
		Mockito.when(onboardingService.list()).thenReturn(onboardingList);
		
		String URI = "/onboarding";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockmvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(onboardingList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	
	

	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	


}
