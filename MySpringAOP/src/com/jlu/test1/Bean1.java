package com.jlu.test1;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

//���������ǰ��֪ͨ
//
public class Bean1 implements MethodBeforeAdvice{
	// method : ����ķ��� 
    //args �����뷽���Ĳ��� 
    // target ��Ŀ�����
  
   @Override
   public void before(Method method, Object[] args, Object target) throws Throwable {
       System.out.println("===========����beforeAdvice()============ ");
       System.out.println("����:" + target);
       System.out.println("����"+method);
       System.out.print("����:");
       for(Object obj:args)System.out.print(obj+" ");
       System.out.println(" \nҪ��������㷽����");
   }

}
