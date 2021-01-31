package com.jlu.test1;
//对应在xml中的配置
//<bean id="bean1" class="com.jlu.test1.Bean1">
//	<property name="a" value=" 1"></property>
//</bean>
public class Bean1 {
	private int a1;
	private String str1;

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public int getA1() {
		return a1;
	}

	public void setA1(int a) {
		this.a1 = a;
	}
	
}
