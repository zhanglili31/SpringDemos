package com.jlu.test1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//��������ڲ��Ի���֪ͨ��
public class Bean4 implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		Object result=null;
		try {
			System.out.println("===============����һ������֪ͨ============");
			System.out.println("����ʵ��ǰ��֪ͨ    ���result"+result);
			//ִ�����뷽��
			result=invocation.proceed();
			System.out.println("����ʵ�ֺ���֪ͨ     ���result"+result);
			//�������ò�����쳣���ͣ�����쳣��ƥ�䣬��ʵ���쳣֪ͨ��NullPointerException��ΪClassNotFoundException�Ͳ��ᱨ��
		}catch(Exception e) {
			System.out.println("����ʵ���쳣֪ͨ     ���e"+e);
			e.printStackTrace();
		}finally{
			System.out.println("������ô��Ҫִ��finally");
			
		}
		return result;
	}

}
