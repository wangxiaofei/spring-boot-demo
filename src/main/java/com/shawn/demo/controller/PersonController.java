package com.shawn.demo.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shawn.demo.domain.po.Person;
import com.shawn.demo.service.PersonService;

@RestController()
@RequestMapping("/person")
public class PersonController {

	private final static Logger logger = Logger.getLogger(PersonController.class);
	private final static Logger jk = Logger.getLogger("jk");

	@Autowired
	private PersonService ps;

	@GetMapping("/get/{id}")
	public Person hello(@PathVariable Long id) {
		Person person = null;
		try {
			person = ps.get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;

	}

	@RequestMapping("/getAll")
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

	@RequestMapping("/update")
	@ResponseBody
	public Person update(Person person) {
		Person rs = null ;
		try {
			 rs = ps.update(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
