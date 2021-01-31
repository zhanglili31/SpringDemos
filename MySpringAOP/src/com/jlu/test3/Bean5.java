package com.jlu.test3;
//这个类用于测试使用注解的方式
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
//@AfterThrowing    异常通知
//@AfterReturning	后置
//@After	在切入点方法返回或者抛出异常
//@Around	环绕
//@Before	前置
@Component("bean5")//指明这是一个bean要加入到ioc容器。
@Aspect//指明这是一个切面类
//配置
//<context:component-scan base-package="com.jlu.test3"></context:component-scan>
//<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
public class Bean5 {
	@AfterReturning( pointcut= "execution(public void com.jlu.test2.PointCut.testAnnotation())" ,returning="returningValue" ) 
	public Object myAfter(JoinPoint jp,Object returningValue) {//returningValue是返回值，但需要告诉spring
		System.out.println("AfterReturning  myAfter ");
		return returningValue;
	}
	//3.此处有环绕通知，环绕通知方法一定要有ProceedingJoinPoint类型的参数传入，然后执行对应的proceed()方法，环绕才能实现。
	@Around( value= "execution(public void com.jlu.test2.PointCut.testAnnotation())" ) 
	public void myAround(ProceedingJoinPoint pj) {//returningValue是返回值，但需要告诉spring
		System.out.println("Around myAround ");
		try {
			pj.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
//@Aspect
//public class Audience {
//
//    /**
//     * 定义一个公共的切点
//     */
//    @Pointcut("execution(** com.spring.aop.service.Perfomance.perform(..))")
//    public void performance() {
//    }
//
//    /**
//     * 目标方法执行之前调用
//     */
//    @Before("performance()")
//    public void silenceCellPhone() {
//        System.out.println("Silencing cell phones");
//    }
//
//    /**
//     * 目标方法执行之前调用
//     */
//    @Before("performance()")
//    public void takeSeats() {
//        System.out.println("Taking seats");
//    }
//
//    /**
//     * 目标方法执行完后调用
//     */
//    @AfterReturning("performance()")
//    public void applause() {
//        System.out.println("CLAP CLAP CLAP");
//    }
//
//    /**
//     * 目标方法发生异常时调用
//     */
//    @AfterThrowing("performance()")
//    public void demandRefund() {
//        System.out.println("Demanding a refund");
//    }
//
//}
