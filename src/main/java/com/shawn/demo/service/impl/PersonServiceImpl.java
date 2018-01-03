package com.shawn.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shawn.demo.dao.PersonMapper;
import com.shawn.demo.domain.Person;
import com.shawn.demo.service.PersonService;

import net.minidev.json.JSONObject;

@Component
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper pm;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public Person get(Long id) throws Exception {
		Person person = pm.getById(id);
		return person;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Person> getAll() throws Exception {
		List<Person> list = null;
		list = pm.getAll();
		return list;
	}

	@Override
	public Person createByRedis(Person person) throws Exception {
		 this.stringRedisTemplate.opsForValue().set("person", person.getName());
		 String rs = this.stringRedisTemplate.opsForValue().get("person");
		 Person person_rs = new Person();
		 person_rs.setName(rs);
		return person_rs;
	}

}
