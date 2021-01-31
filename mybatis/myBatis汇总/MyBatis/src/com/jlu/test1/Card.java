package com.jlu.test1;

public class Card {
	int cardid;
	String info;
	int personid;
	public Card() {}
	public Card(int cardid, String info, int personid) {
		super();
		this.cardid = cardid;
		this.info = info;
		this.personid = personid;
	}
	public int getCardid() {
		return cardid;
	}
	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	@Override
	public String toString() {
		return cardid+info+personid;
	}
}
