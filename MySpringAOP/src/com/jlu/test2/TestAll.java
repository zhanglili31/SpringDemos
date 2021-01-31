package com.jlu.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAll {
	public static void main(String[] args) throws ClassNotFoundException {
		//测试前置通知和后置通知：
		new PointCut().cutMethod("不是来自spring容器");
		ApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext.xml");
		PointCut pc=(PointCut)context.getBean("pointCut");
		pc.cutMethod("  来自于Spring 容器");
		//测试异常通知：
		pc.produceEX("str1", 1);
		//注解测试
		pc.testAnnotation();
		//schemma
		pc.testSchema();
	}
	
}
