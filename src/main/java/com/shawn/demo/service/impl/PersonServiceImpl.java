package com.shawn.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shawn.demo.dao.PersonMapper;
import com.shawn.demo.domain.Person;
import com.shawn.demo.service.PersonService;

@Component
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper pm;

	@Override
	public Person get(Long id) throws Exception {
		Person person = pm.getById(id);
		return person;
	}

	@Override
	public List<Person> getAll() throws Exception {
		List<Person> list = null;
		list = pm.getAll();
		return list;
	}

}
