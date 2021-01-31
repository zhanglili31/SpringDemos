package com.jlu.test2;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import com.jlu.test1.Bean1;
import com.jlu.test1.Bean2;

//这个类用来测试注解注入\
@Component("bean8")
public class Bean8 {
	@Value("8")
	private int a8;
	@Qualifier("bean1")
	@Autowired
	private Bean1 bean11;
	@Autowired
	private Bean2 bean2;
	public int getA8() {
		return a8;
	}
	public Bean1 getBean11() {
		return bean11;
	}
	public Bean2 getBean2() {
		return bean2;
	}
	
	
}
