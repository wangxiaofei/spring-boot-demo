package com.shawn.demo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shawn.demo.common.EnumResultCode;
import com.shawn.demo.domain.po.Person;
import com.shawn.demo.domain.vo.PageVO;
import com.shawn.demo.domain.vo.ResultVO;
import com.shawn.demo.service.PersonService;

@RestController()
@RequestMapping("/person")
public class PersonController {

	private final static Logger logger = Logger.getLogger(PersonController.class);
	private final static Logger jk = Logger.getLogger("jk");

	@Autowired
	private PersonService ps;

	@GetMapping("/get/{id}")
	public ResultVO<Person> get(@PathVariable Long id) {
		ResultVO<Person> rs = new ResultVO<Person>(EnumResultCode.SUCCESS.getCode());
		Person person = null;
		try {
			person = ps.get(id);
			rs.setData(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;

	}

	@RequestMapping("/page")
	public ResultVO<PageVO<Person>> page(long pageIndex, int pageSize) {
		ResultVO<PageVO<Person>> rs = new ResultVO<PageVO<Person>>(EnumResultCode.SUCCESS.getCode());
		try {
			PageVO<Person> page = ps.page(pageIndex, pageSize);
			rs.setData(page);
		} catch (Exception e) {
			rs.setCode(EnumResultCode.FAIL.getCode());
			e.printStackTrace();
		}
		return rs;
	}

	@RequestMapping("/update")
	public Person update(Person person) {
		Person rs = null;
		try {
			rs = ps.update(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
