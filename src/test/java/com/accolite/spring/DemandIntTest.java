//package com.accolite.spring;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.accolite.spring.entity.Demand;
//import com.accolite.spring.repository.DemandRepository;
//
//
//@SpringBootTest(
//		classes = Onboardings1Application.class,	webEnvironment = WebEnvironment.RANDOM_PORT
//		)
//@Transactional
//public class DemandIntTest {
//	
//	@LocalServerPort
//	private int port;
//	
//	@Autowired
//	private TestRestTemplate restTemplate;
//	
//	@Autowired
//	MockMvc mockmvc;
//	
//	
//	@Test
//	public void test() throws Exception {
//		
////		MvcResult mvcResult = mockmvc.perform(MockMvcRequestBuilders.get("/demand").accept(MediaType.APPLICATION_JSON)).andReturn();
////		System.out.println(mvcResult.getResponse());
//	   Demand demand = this.restTemplate.getForEntity("http://localhost:"+port+"/demand", demand);
//	this.restTemplate.getForObject("http://localhost:"+port+"/demand", demand)
//	}
//
//}
