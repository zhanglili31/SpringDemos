package com.jlu.test2;

import java.util.List;
import java.util.Map;

import com.jlu.test1.Person;

public interface PersonMapper {
	Person queryPersonById(int id);
	void insertPerson(Person person);
	void deletePersonById(int id);
	void updatePersonById(Person person);
	//use converter
	Person selectPersonByIdWithConverter(int id);
	void updatePersonByIdWithConveter(Person person);
	//return hashMap
	Map queryPersonByIdReturnHashMap(int id);
	List queryPersonByIdReturnTable();
	//¶¯Ì¬sql
	Person queryPersonDynamic(Person person);
	
}
