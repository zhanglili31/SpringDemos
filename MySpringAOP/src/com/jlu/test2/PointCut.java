package com.jlu.test2;

public class PointCut {
	public void cutMethod(String str) {
		System.out.println("����һ�����뷽��"+str);
	}
	public String produceEX(String str1,int intargs) {
		String str=null;
		//str.toString(); //�ر��쳣
		return  "return value of produceEX";
	}
	public void testAnnotation() {
		System.out.println("testAnnotation");
	}
	public void testSchema() throws ClassNotFoundException {
		System.out.println("ִ�� testScheam");
		throw new ClassNotFoundException();
	}
}
