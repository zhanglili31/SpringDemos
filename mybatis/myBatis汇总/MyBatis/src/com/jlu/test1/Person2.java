package com.jlu.test1;
//这个类用于测试一对一查询的业务类  包含person 和card
//
public class Person2 {
	int id;
	 String c1;
	 String c2;
	 boolean sex;
	 int classid;
	 Card card;
	 public Person2() {}
	public Person2(int id, String c1, String c2, boolean sex, int classid, Card card) {
		super();
		this.id = id;
		this.c1 = c1;
		this.c2 = c2;
		this.sex = sex;
		this.classid = classid;
		this.card = card;
	}
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
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	@Override 
	public String toString() {
		return id+c1+c2+classid+sex+card;
	}
	 
}
