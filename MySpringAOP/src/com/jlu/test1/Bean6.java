package com.jlu.test1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
// �����ͨ��   schema ��ʽʵ��aop
//���ã�
//xmlns:aop="http://www.springframework.org/schema/aop"
//<!--  ʹ��schema��ʽʵ��aop -->
//<bean id="bean6" class="com.jlu.test1.Bean6"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(public void com.jlu.test2.PointCut.testSchema())" id="pointcut6"/>
//	<aop:aspect ref="bean6">
//			<!-- �����ߣ����� ҵ�� addStudent  ��  ֪ͨbefore -->
//	 	<aop:before method="before" pointcut-ref="pointcut6"/>
//	 	<!-- �����ߣ����� ҵ�� addStudent  ��  ֪ͨafterReturning -->
//	 	<aop:after-returning method="afterReturning" returning="returnValue" pointcut-ref="pointcut6"/>
//	 	
//	 	<aop:after-throwing method="whenException" pointcut-ref="pointcut6" throwing="e"/>
//	 	<!-- ���� -->
//	 	<aop:around method="around" pointcut-ref="pointcut6" />
//		
//	</aop:aspect>
//</aop:config>
public class Bean6{

	//����֪ͨ����  :JoinPoint������ע��
	public void afterReturning(JoinPoint jp,Object returnValue) throws Throwable {
		System.out.println("��������������������������֪ͨ��Ŀ�����"+jp.getThis()+",���õķ�������"+jp.getSignature().getName()+",�����Ĳ���������"+jp.getArgs().length+"�������ķ���ֵ��"+returnValue);
	}
	
	public void before() {
		System.out.println("����������������������ǰ��֪ͨ...");
	}
	
	public void whenException(JoinPoint jp,NullPointerException e) {
		System.out.println(">>>>>>>>>>>>>>>>�쳣��" +e.getMessage());
	}
	//ע�⣺����֪ͨ �᷵��Ŀ�귽���ķ���ֵ����˷���ֵΪObject
	public Object around(ProceedingJoinPoint jp)    {
		System.out.println("''''''''''''''''''����֪ͨ��ǰ��֪ͨ");
		Object result = null ; 
		try {
			 result = jp.proceed() ;//ִ�з���
			 System.out.println("'''''''''"+jp.getSignature().getName()+","+result);
			System.out.println("''''''''''''''''''����֪ͨ������֪ͨ");
		}catch(Throwable e) {
			System.out.println("''''''''''''''''''����֪ͨ���쳣֪ͨ");
			e.printStackTrace();
		}
		return result ;
	}


}
