package com.jlu.test1;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

//��������ڲ����쳣֪ͨ��
// ���������ʱ����Ҫ��Bean3 ���෽����ȥ������� �쳣   str.toString(); //�ر��쳣
//�쳣֪ͨ���ӿ�û�а����κη�����֪ͨ�����Զ���
public class Bean3  implements ThrowsAdvice{
	  // ֪ͨ��������Ҫ�������ָ�ʽ��д
    // @param method
    //           ��ѡ������ķ���
    //@param args
    //           ��ѡ������ķ����Ĳ���
   // @param target
    //          ��ѡ��Ŀ�����
    // @param throwable
    //  ���� : �쳣���࣬��������쳣������࣬���������֪ͨ��
	// Ҫô��û�п�ѡ������Ҫô���С�
  //Method method, Object[] args, Object target,
   public void afterThrowing(Throwable throwable) {
	   System.out.println("===========����afterThrowing()============");
      // System.out.println("����:" + target);
       //System.out.println("����"+method);
       System.out.print("����:");
       //for(Object obj:args)System.out.print(obj+" ");
       throwable.printStackTrace();
   }

}
