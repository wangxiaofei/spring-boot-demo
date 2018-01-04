package com.shawn.demo.dao;

import java.util.List;

import com.shawn.demo.domain.po.Person;

public interface PersonMapper {

	public Person getById(Long id);

	public List<Person> getAll();

	public int update(Person person);
}
