package com.jlu.entity;
public class Person {
	 int id;
	 String c1;
	 String c2;
	 boolean sex;
	 int classid;
	 int cardid;
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public int getCardid() {
		return cardid;
	}
	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	public int getId() {
		return id;
	}
	public Person() {}
	public Person(int id, String c1, String c2) {
		super();
		this.id = id;
		this.c1 = c1;
		this.c2 = c2;
	}

	public Person(int id, String c1, String c2, boolean sex) {
		this.id = id;
		this.c1 = c1;
		this.c2 = c2;
		this.sex = sex;
	}

	public Person(int id, String c1, String c2, boolean sex, int classid, int cardid) {
		super();
		this.id = id;
		this.c1 = c1;
		this.c2 = c2;
		this.sex = sex;
		this.classid = classid;
		this.cardid = cardid;
	}
	public boolean getSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
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
		return id+c1+c2+sex+classid+cardid;
	}

}
