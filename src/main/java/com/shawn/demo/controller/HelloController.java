package com.shawn.demo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shawn.demo.domain.Person;
import com.shawn.demo.service.PersonService;



@RestController()
public class HelloController {
	
	private final static Logger logger = Logger.getLogger(HelloController.class);
	private final static Logger jk = Logger.getLogger("jk");

	@Autowired
	private PersonService ps;

	@RequestMapping("/person/get")
	@ResponseBody
	public Person hello(Long id) {
		Person person = null;
		try {
			person = ps.get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;

	}

	@RequestMapping("/person/getAll")
	@ResponseBody
	public List<Person> getAll() {
		List<Person> list = null;
		try {
			list = ps.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}
}
