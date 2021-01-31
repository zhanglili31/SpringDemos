package com.jlu.service.impl;

import com.jlu.entity.Person;
import com.jlu.mapper.PersonMapper;
import com.jlu.service.PersonService;

public class PersonServiceImpl implements PersonService {
	private PersonMapper personMapper;
	@Override

	public Person queryPersonById(int id) {
		// TODO Auto-generated method stub

		return personMapper.queryPersonById(id);
	}
	public void setPersonMapper(PersonMapper personMapper) {
		this.personMapper = personMapper;
	}

}
