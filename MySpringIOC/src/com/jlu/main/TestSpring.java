package com.jlu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jlu.test1.Bean1;
import com.jlu.test1.Bean2;
import com.jlu.test1.Bean3;
import com.jlu.test1.Bean4;
import com.jlu.test1.Bean5;
import com.jlu.test1.Bean6;
import com.jlu.test1.Bean7;
import com.jlu.test2.Bean8;

public class TestSpring {
	public static void  main(String args[]) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//测试bean1
		Bean1 b1=(Bean1)context.getBean("bean1");
		System.out.println("test bean 1");
		System.out.println(b1.getA1());
		System.out.println(b1.getStr1());
		
		///测试bean2 
		Bean2 b2=(Bean2)context.getBean("bean2");
		System.out.println("test bean2");
		System.out.println(b2.getA2());
		System.out.println(b2.getStr2());
		System.out.println(b2.getBean1().getStr1());
		///测试bean3
		Bean3 b3=(Bean3)context.getBean("bean3");
		System.out.println("test bean3");
		System.out.println(b3.getA3());
		System.out.println(b3.getStr3());
		System.out.println(b3.getBean2().getStr2())	;
		//测试bean4
		Bean4 b4=(Bean4)context.getBean("bean4");
		System.out.println("test bean4");
		System.out.println(b4.getA4());
		System.out.println(b4.getStr4());
		System.out.println(b4.getBean1().getStr1());
		
		//测试bean5
		Bean5 b5=(Bean5) context.getBean("bean5");
		System.out.println("test bean5");
		System.out.println(b5.getA5());
		System.out.println(b5.getStr5());
		System.out.println(b5.getStrnull());
		System.out.println(b5.getBean4());
		
		//TestBean6
		Bean6 bean6=(Bean6) context.getBean("bean6");
		System.out.println("testBean6");
		bean6.toString();
		//Spring 注入的list默认是 class java.util.ArrayList
		System.out.println(bean6.getStrList().getClass());
		//spring 注入的map默认是 class java.util.LinkedHashMap
		System.out.println(bean6.getHashMap().getClass());
		//test Bean7  自动装配
		Bean7 bean7=(Bean7)context.getBean("bean7");
		System.out.println("test bean7");
		System.out.println(bean7.getA7());
		System.out.println(bean7.getBean1().getStr1());
		System.out.println(bean7.getBean2().getStr2());
		//test Bean8  注解注入
		System.out.println("\ntest bean8");
		Bean8 bean8=(Bean8) context.getBean("bean8");
		System.out.println(bean8.getA8());
		System.out.println(bean8.getBean11().getA1());
		System.out.println(bean8.getBean2().getA2());
	}

}
