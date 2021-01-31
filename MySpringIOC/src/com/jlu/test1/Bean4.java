package com.jlu.test1;
//这个类用测试使用命名空间的使用。
//注意 注入的类中需要set方法
//引入p命名空间
//xmlns:p="http://www.springframework.org/schema/p"
//<bean id="course" class="org.lanqiao.entity.Course" p:courseHour="300" p:courseName="hadoop" p:teacher-ref="teacher">

public class Bean4 {
	private int a4;
	private String str4;
	Bean1 bean1;
	public int getA4() {
		return a4;
	}
	public String getStr4() {
		return str4;
	}
	public Bean1 getBean1() {
		return bean1;
	}
	public void setA4(int a4) {
		this.a4 = a4;
	}
	public void setStr4(String str4) {
		this.str4 = str4;
	}
	public void setBean1(Bean1 bean1) {
		this.bean1 = bean1;
	}
	

}
