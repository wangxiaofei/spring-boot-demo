package com.shawn.demo.service;

import java.util.List;

import com.shawn.demo.domain.po.Person;

public interface PersonService {

	public Person get(Long id) throws Exception;

	public List<Person> getAll() throws Exception;
	
	public Person update(Person person) throws Exception;
}
