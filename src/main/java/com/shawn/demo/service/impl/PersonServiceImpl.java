package com.shawn.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shawn.demo.dao.PersonMapper;
import com.shawn.demo.domain.po.Person;
import com.shawn.demo.service.PersonService;

@Component
@EnableCaching
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper pm;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	@Cacheable(value = "person", key = "#id")
	public Person get(Long id) throws Exception {
		Person person = pm.getById(id);
		return person;
	}

	@Override
	@Cacheable(value = { "person" })
	@Transactional(readOnly = true)
	public List<Person> getAll() throws Exception {
		List<Person> list = null;
		list = pm.getAll();
		return list;
	}

	@Override
	@CacheEvict(value = "person", allEntries = true)
	public Person update(Person person) throws Exception {
		pm.update(person);
		person = pm.getById(person.getId());
		return person;
	}

}
