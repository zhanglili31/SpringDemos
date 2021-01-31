package com.jlu.test1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//这个类用于测试环绕通知：
public class Bean4 implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		Object result=null;
		try {
			System.out.println("===============这是一个环绕通知============");
			System.out.println("这里实现前置通知    输出result"+result);
			//执行切入方法
			result=invocation.proceed();
			System.out.println("这里实现后置通知     输出result"+result);
			//这里设置捕获的异常类型，如果异常不匹配，则不实现异常通知。NullPointerException改为ClassNotFoundException就不会报错。
		}catch(Exception e) {
			System.out.println("这里实现异常通知     输出e"+e);
			e.printStackTrace();
		}finally{
			System.out.println("不管怎么都要执行finally");
			
		}
		return result;
	}

}
