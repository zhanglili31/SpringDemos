package com.jlu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jlu.entity.Person;
import com.jlu.service.PersonService;

@RequestMapping("controller")
@Controller//StudentController加入Ioc容器
public class PersonController {
	//控制器依赖于Service
		@Autowired
		@Qualifier("personService")
		private PersonService  personService;

		public void setStudentService(PersonService perosnService) {
			this.personService = personService;
		}

		@RequestMapping("queryPersonById/{id}")
		public ModelAndView queryStudentByNo(@PathVariable("id") Integer id,Map<String,Object> map) {
			ModelAndView mov=new ModelAndView("result");
			Person student = personService.queryPersonById(id) ;
			mov.addObject("student",student);
			return mov ;
		}
}
