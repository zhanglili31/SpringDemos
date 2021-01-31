package com.jlu.test1;
//这个类用于测试给对象赋予null值
//<!--  测试给字符串赋予空字符和类对象null -->
//<bean id="bean5" class="com.jlu.test1.Bean5">
//	<property name="a5" value="5"></property>
//	<property name="str5" value="str5"></property>
//	<property name="strnull"><null/></property>
//	<property name="bean4"><null/></property>
//</bean>
public class Bean5 {
	private int a5;
	private String str5;
	private String strnull;
	private Bean4 bean4;
	public int getA5() {
		return a5;
	}
	public void setA5(int a5) {
		this.a5 = a5;
	}
	public String getStr5() {
		return str5;
	}
	public void setStr5(String str5) {
		this.str5 = str5;
	}
	public String getStrnull() {
		return strnull;
	}
	public void setStrnull(String strnull) {
		this.strnull = strnull;
	}
	public Bean4 getBean4() {
		return bean4;
	}
	public void setBean4(Bean4 bean4) {
		this.bean4 = bean4;
	}
	
	
}
