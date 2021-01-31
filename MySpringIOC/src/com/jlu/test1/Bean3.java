package com.jlu.test1;
//这个类用于  1测试使用构造器注入类    ref的使用

public class Bean3 {
	private  int a3;
	private String str3;
	private Bean2 bean2;
	public Bean3(int a3, String str3,Bean2 bean2) {
	
		this.a3 = a3;
		this.str3 = str3;
		this.bean2=bean2;
	}
	public int getA3() {
		return a3;
	}
	public String getStr3() {
		return str3;
	}
	public Bean2 getBean2() {
		return bean2;
	}
	
	

}
