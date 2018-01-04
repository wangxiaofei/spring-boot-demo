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
import com.shawn.demo.domain.vo.PageVO;
import com.shawn.demo.service.PersonService;

@Component
@EnableCaching
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper personDao;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	@Cacheable(value = "person", key = "#id")
	public Person get(long id) throws Exception {
		Person person = personDao.getById(id);
		return person;
	}

	@Override
	@Cacheable(value = { "person" })
	@Transactional(readOnly = true)
	public PageVO<Person> page(long pageIndex, int pageSize) throws Exception {
		PageVO<Person> page = new PageVO<Person>(pageIndex,pageSize);
		List<Person> list = personDao.page(pageIndex, pageSize);
		long count = personDao.getTotalCount();
		page.setTotalResults(count);
		page.setList(list);
		return page;
	}

	@Override
	@CacheEvict(value = "person", allEntries = true)
	public Person update(Person person) throws Exception {
		personDao.update(person);
		person = personDao.getById(person.getId());
		return person;
	}

}
