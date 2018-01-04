package com.shawn.demo.service;

import com.shawn.demo.domain.po.Person;
import com.shawn.demo.domain.vo.PageVO;

public interface PersonService {

	public Person get(long id) throws Exception;

	public PageVO<Person> page(long pageIndex, int pageSize) throws Exception;

	public Person update(Person person) throws Exception;
}
