package com.shawn.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.shawn.demo.domain.Person;
import com.shawn.demo.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest
@TestPropertySource(properties = { "server.port=8080", "server.address=localhost" })
public class PersonTest {

	@Autowired
	private PersonService ps;

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${server.address}")
	private String address;

	@Value("${server.port}")
	private int port;

	// @Test
	// public void personGetByIDRest() {
	// Person person = restTemplate.getForObject("http://" + address + ":" + port +
	// "/person/get/1", Person.class);
	// assertNotNull(person);
	// assertEquals("王五", person.getName());
	// }
	//
	// @Test
	// public void personGetByIDService() throws Exception {
	// Person person = ps.get(Long.valueOf(1));
	// assertNotNull(person);
	// assertEquals(Integer.valueOf(1), person.getAge());
	// }

	@Test
	public void personGetByIDRedis() throws Exception {
		Person person = new Person();
		person.setName("aaa");
		Person rs = ps.createByRedis(person);
		assertEquals("aaa", rs.getName());
	}

}
