package com.jlu.test1;
//���������������������ע��  bean1ע�뵽bean2
//xml�ļ��е��������£�
//<!-- ʹ�ù�����ע�� -->
//<bean id="bean3" class="com.jlu.test1.Bean3">
//	<constructor-arg value="3"></constructor-arg>
//	<constructor-arg value="str3"></constructor-arg>
//	<constructor-arg ref="bean2"></constructor-arg>
//</bean>


public class Bean2 {
	
	private int a2;
	private String str2;
	private Bean1 bean1;
	public int getA2() {
		return a2;
	}
	public void setA2(int a2) {
		this.a2 = a2;
	}
	public String getStr2() {
		return str2;
	}
	public void setStr2(String str2) {
		this.str2 = str2;
	}
	public Bean1 getBean1() {
		return bean1;
	}
	public void setBean1(Bean1 bean1) {
		this.bean1 = bean1;
	}
	
}
