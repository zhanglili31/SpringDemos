package com.jlu.test1;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class Bean2  implements AfterReturningAdvice{
	//returnValue ：切入点执行完方法的返回值，但不能修改 <br>
    // method ：切入点方法 <br>
    // args ：切入点方法的参数数组 <br>
    // target ：目标对象
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		   System.out.println("===========进入AfterReturning()============");
	       System.out.println("对象:" + target);
	       System.out.println("方法"+method);
	       System.out.print("参数:");
	       for(Object obj:args)System.out.print(obj+" ");
	       System.out.println("返回值:"+returnValue);
	      
	}

}
