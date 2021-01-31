package com.jlu.test1;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

//这个类用于测试异常通知：
// 测试这个的时候需要到Bean3 的类方法中去开启这个 异常   str.toString(); //关闭异常
//异常通知，接口没有包含任何方法。通知方法自定义
public class Bean3  implements ThrowsAdvice{
	  // 通知方法，需要按照这种格式书写
    // @param method
    //           可选：切入的方法
    //@param args
    //           可选：切入的方法的参数
   // @param target
    //          可选：目标对象
    // @param throwable
    //  必填 : 异常子类，出现这个异常类的子类，则会进入这个通知。
	// 要么都没有可选参数，要么都有。
  //Method method, Object[] args, Object target,
   public void afterThrowing(Throwable throwable) {
	   System.out.println("===========进入afterThrowing()============");
      // System.out.println("对象:" + target);
       //System.out.println("方法"+method);
       System.out.print("参数:");
       //for(Object obj:args)System.out.print(obj+" ");
       throwable.printStackTrace();
   }

}
