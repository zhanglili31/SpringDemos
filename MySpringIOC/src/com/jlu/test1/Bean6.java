package com.jlu.test1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//用于给各种数据类型赋值
// 数组 list hashmap   set
public class Bean6 {
	private int intArray[];
	private String strArray[];
//	Spring 默认为他们注入的子类是这种类型
//	class java.util.ArrayList
//	class java.util.LinkedHashMap
	private List<String> strList;
	private Map<String,String> hashMap;
	public int[] getIntArray() {
		return intArray;
	}
	public void setIntArray(int[] intArray) {
		this.intArray = intArray;
	}
	public String[] getStrArray() {
		return strArray;
	}
	public void setStrArray(String[] strArray) {
		this.strArray = strArray;
	}
	public List<String> getStrList() {
		return strList;
	}
	public void setStrList(List<String> strList) {
		this.strList = strList;
	}
	public Map<String, String> getHashMap() {
		return hashMap;
	}
	public void setHashMap(Map<String, String> hashMap) {
		this.hashMap = hashMap;
	}
	@Override
	public String toString() {
		System.out.println("intArray:"+intArray);
		for(int tmp:intArray) System.out.println(tmp);
		System.out.println("strArray:"+strArray);
		for(String str:strArray)System.out.println(str);
		System.out.println("strList"+strList);
		for(String tmp:strList)System.out.println(tmp);
		System.out.println("hashMap:"+hashMap);
		
		return "js";
		
	}

}
