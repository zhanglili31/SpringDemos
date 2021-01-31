package com.jlu.test1;

import java.util.List;
import java.util.Map;

public class MyClass {
	int classId;
	String classInfo;
	List<Person> personList;
	public MyClass(){}

	public List<Person> getPersonList() {
		return personList;
	}






	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public MyClass(int classId, String classInfo, List<Person> personList) {
		super();
		this.classId = classId;
		this.classInfo = classInfo;
		this.personList = personList;
	}


	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassInfo() {
		return classInfo;
	}
	public void setClassInfo(String classInfo) {
		this.classInfo = classInfo;
	}
	@Override
	public String toString() {
		return "MyClass [classId=" + classId + ", classInfo=" + classInfo + ", personList=" + personList
				+ ", getPersonList()=" + getPersonList() + ", getClassId()=" + getClassId() + ", getClassInfo()="
				+ getClassInfo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
