package com.jlu.test2;

public class PointCut {
	public void cutMethod(String str) {
		System.out.println("这是一个切入方法"+str);
	}
	public String produceEX(String str1,int intargs) {
		String str=null;
		//str.toString(); //关闭异常
		return  "return value of produceEX";
	}
	public void testAnnotation() {
		System.out.println("testAnnotation");
	}
	public void testSchema() throws ClassNotFoundException {
		System.out.println("执行 testScheam");
		throw new ClassNotFoundException();
	}
}
