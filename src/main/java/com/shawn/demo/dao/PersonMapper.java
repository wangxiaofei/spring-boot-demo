package com.shawn.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shawn.demo.domain.po.Person;

public interface PersonMapper {

	public Person getById(long id);

	public List<Person> page(@Param("pageIndex") long pageIndex, @Param("pageSize") long pageSize);

	public int update(Person person);
	
	public long getTotalCount();
}
