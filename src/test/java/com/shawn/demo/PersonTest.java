package com.shawn.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.shawn.demo.domain.Person;
import com.shawn.demo.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest
public class PersonTest {

	@Autowired
	private PersonService ps;

	private RestTemplate restTemplate = new RestTemplate();
	
	private int port = 8080;

	@Test
	public void personGetByIDRest() {
		Person person = restTemplate.getForObject("http://localhost:" + port + "/person/get/1", Person.class);
		assertNotNull(person);
		assertEquals("王五", person.getName());
	}
	
	@Test
	public void personGetByIDService() throws Exception {
		Person person = ps.get(Long.valueOf(1));
		assertNotNull(person);
		assertEquals(Integer.valueOf(1), person.getAge());
	}

}
