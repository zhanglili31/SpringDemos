package com.jlu.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAll {
	public static void main(String[] args) throws ClassNotFoundException {
		//����ǰ��֪ͨ�ͺ���֪ͨ��
		new PointCut().cutMethod("��������spring����");
		ApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext.xml");
		PointCut pc=(PointCut)context.getBean("pointCut");
		pc.cutMethod("  ������Spring ����");
		//�����쳣֪ͨ��
		pc.produceEX("str1", 1);
		//ע�����
		pc.testAnnotation();
		//schemma
		pc.testSchema();
	}
	
}
