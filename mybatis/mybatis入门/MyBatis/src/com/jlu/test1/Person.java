package com.jlu.test1;



public class Person {
	 int id;
	 String c1;
	 String c2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getC1() {
		return c1;
	}
	public void setC1(String c1) {
		this.c1 = c1;
	}
	public String getC2() {
		return c2;
	}
	public void setC2(String c2) {
		this.c2 = c2;
	}
	@Override
	public String toString() {
		return id+c1+c2;
	}
	 
}
