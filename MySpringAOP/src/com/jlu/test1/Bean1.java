package com.jlu.test1;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

//这个类用于前置通知
//
public class Bean1 implements MethodBeforeAdvice{
	// method : 切入的方法 
    //args ：切入方法的参数 
    // target ：目标对象
  
   @Override
   public void before(Method method, Object[] args, Object target) throws Throwable {
       System.out.println("===========进入beforeAdvice()============ ");
       System.out.println("对象:" + target);
       System.out.println("方法"+method);
       System.out.print("参数:");
       for(Object obj:args)System.out.print(obj+" ");
       System.out.println(" \n要进入切入点方法了");
   }

}
