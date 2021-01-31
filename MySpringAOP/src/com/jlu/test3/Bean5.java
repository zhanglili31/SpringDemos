package com.jlu.test3;
//��������ڲ���ʹ��ע��ķ�ʽ
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
//@AfterThrowing    �쳣֪ͨ
//@AfterReturning	����
//@After	������㷽�����ػ����׳��쳣
//@Around	����
//@Before	ǰ��
@Component("bean5")//ָ������һ��beanҪ���뵽ioc������
@Aspect//ָ������һ��������
//����
//<context:component-scan base-package="com.jlu.test3"></context:component-scan>
//<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
public class Bean5 {
	@AfterReturning( pointcut= "execution(public void com.jlu.test2.PointCut.testAnnotation())" ,returning="returningValue" ) 
	public Object myAfter(JoinPoint jp,Object returningValue) {//returningValue�Ƿ���ֵ������Ҫ����spring
		System.out.println("AfterReturning  myAfter ");
		return returningValue;
	}
	//3.�˴��л���֪ͨ������֪ͨ����һ��Ҫ��ProceedingJoinPoint���͵Ĳ������룬Ȼ��ִ�ж�Ӧ��proceed()���������Ʋ���ʵ�֡�
	@Around( value= "execution(public void com.jlu.test2.PointCut.testAnnotation())" ) 
	public void myAround(ProceedingJoinPoint pj) {//returningValue�Ƿ���ֵ������Ҫ����spring
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
//     * ����һ���������е�
//     */
//    @Pointcut("execution(** com.spring.aop.service.Perfomance.perform(..))")
//    public void performance() {
//    }
//
//    /**
//     * Ŀ�귽��ִ��֮ǰ����
//     */
//    @Before("performance()")
//    public void silenceCellPhone() {
//        System.out.println("Silencing cell phones");
//    }
//
//    /**
//     * Ŀ�귽��ִ��֮ǰ����
//     */
//    @Before("performance()")
//    public void takeSeats() {
//        System.out.println("Taking seats");
//    }
//
//    /**
//     * Ŀ�귽��ִ��������
//     */
//    @AfterReturning("performance()")
//    public void applause() {
//        System.out.println("CLAP CLAP CLAP");
//    }
//
//    /**
//     * Ŀ�귽�������쳣ʱ����
//     */
//    @AfterThrowing("performance()")
//    public void demandRefund() {
//        System.out.println("Demanding a refund");
//    }
//
//}
