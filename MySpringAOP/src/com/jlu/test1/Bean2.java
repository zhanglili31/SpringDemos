package com.jlu.test1;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class Bean2  implements AfterReturningAdvice{
	//returnValue �������ִ���귽���ķ���ֵ���������޸� <br>
    // method ������㷽�� <br>
    // args ������㷽���Ĳ������� <br>
    // target ��Ŀ�����
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		   System.out.println("===========����AfterReturning()============");
	       System.out.println("����:" + target);
	       System.out.println("����"+method);
	       System.out.print("����:");
	       for(Object obj:args)System.out.print(obj+" ");
	       System.out.println("����ֵ:"+returnValue);
	      
	}

}
