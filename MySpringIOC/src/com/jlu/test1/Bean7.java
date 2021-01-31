package com.jlu.test1;
//这个类用来测试自动装配
public class Bean7 {
	private int a7;
	private Bean1 bean1;
	private Bean2 bean2;
	public int getA7() {
		return a7;
	}
	public void setA7(int a7) {
		this.a7 = a7;
	}
	public Bean1 getBean1() {
		return bean1;
	}
	public void setBean1(Bean1 bean1) {
		this.bean1 = bean1;
	}
	public Bean2 getBean2() {
		return bean2;
	}
	public void setBean2(Bean2 bean2) {
		this.bean2 = bean2;
	}
	
}
