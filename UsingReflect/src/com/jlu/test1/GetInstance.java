package com.jlu.test1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
//JAVA���������������״̬�У���������һ���࣬���ܹ�֪���������������Ժͷ�����
//��������һ�����󣬶��ܹ�������������һ�����������ֶ�̬��ȡ����Ϣ�Լ���̬���ö���ķ����Ĺ��ܳ�Ϊjava���Եķ�����ơ�
public class GetInstance {
	public static void main(String[] args) {
		try {
//��ȡ����ʵ��
			//��ʽ0
			Class<String> clazz0=String.class;
			Class clazz01=String.class;
			//��ʽһ
			Class<?> clazz1=Class.forName("com.jlu.test1.Sample");
			//��ʽ��  �ֱ�﷽ʽͬʱҲ�����������κ�һ���඼��һ�������ľ�̬��Ա����class
			Class clazz2=Sample.class;
			//��ʽ3 ���ֱ�﷽ʽ����֪�˸���Ķ���������ͨ��getClass������ȡ
			Sample  sam=new Sample();
			Class clazz3=sam.getClass();
			// ��ȡclass�����ʵ��
			System.out.println("��ȡ�����ʵ��");
			System.out.println("clazz0:"+clazz0);
			System.out.println("clazz01:"+clazz01);
			System.out.println("clazz1:"+clazz1);
			System.out.println("clazz2:"+clazz2);
			System.out.println("clazz3:"+clazz3);
			System.out.println("clazz1==clazz2:"+(clazz1==clazz2));
			System.out.println("clazz2==clazz3:"+(clazz2==clazz3));
//��ȡ��������ԣ���ӳ�˱�ʾ�����ӿڵ�ָ��������Ա�ֶ� ����� 
			Field   f1=clazz1.getField("str0");
			//Field   f2=clazz1.getField("str1");str1 ��˽�е� ���ܻ�ȡ��
			Field f2=clazz1.getDeclaredField("str1");
			Field f3=clazz1.getDeclaredField("b");
			Field []fs=clazz1.getFields();
			
			System.out.println("��ȡ���������");
			System.out.println("f1 str0:"+f1); 
			System.out.println("f2 str1:"+f2); 
			for(Field tmp:fs) {
				System.out.println("fs "+tmp);
			}
//ʹ�ö��������
			System.out.println("ʹ�ö��������");
			f2.setAccessible(true);
			f3.setAccessible(true);
			System.out.println(f2.toString()+" value:"+f2.get(sam));
			System.out.println(	f3.toString()+" vlaue:"+f3.getInt(null));
			
				
//��ȡ����Ĺ�����
			//Ĭ�ϵĹ�����
			Constructor  c1=clazz1.getConstructor();
			Constructor	c2=clazz1.getConstructor(String.class,String.class);
			Constructor [] c3=clazz1.getConstructors();
			System.out.println("��ȡ�����˵Ĺ�����");
			System.out.println("c1:"+c1);
			System.out.println("c2:"+c2);
			for(Constructor tmp:c3) {
				System.out.println("c3:" +tmp);
			} 
			// ʹ�ù����������µ�ʵ��
			System.out.println("�����µ�ʵ������ִ���䷽����");
			Sample csam=(Sample) c2.newInstance("����1","����2");
			csam.testConNewInstance();
			//
			
			
			
//��ȡ����ķ���
			//���������������أ�����
			//������ԭʼ������??
//			long.class <==> Long.TYPE
//			double.class <==> Double.TYPE
//		    float.class <==> Float.TYPE
//			bool.class <==> Boolean.TYPE
//			char.class <==> Character.TYPE
//			byte.class <==> Byte.TYPE
//			void.class <==> Void.TYPE
//			short.class <==> Short.TYPE	
//�÷���ķ����������int�������͵�ʱ��int�Զ�ת������Integer.class,��ʵ����int��Ӧ��Class��int.class
//https://blog.csdn.net/csm_qz/article/details/46853567
//			���ʹ�ø÷��� �᲻�ܻ�ȡ�Զ�̬��ʽ����Ĳ���,��Ϊ�����Ǿ�̬����ģ�����̬�Ƕ�̬����� ����ȷ������һ���࣬
			
//getDeclaredMethod():��ȡ��ǰ������з���������public/private/protected/default���εķ�����
//getMethod():��ȡ��ǰ�༰���м̳еĸ����public���εķ�����������public
			Method m1=clazz1.getMethod("getStr1", null);//����û�в���Ϊnull����������  ClassNmae.class
			Method m2=clazz1.getMethod("setStr0", String.class);
			Method m3=clazz1.getMethod("tell", String.class);
			Method m4=clazz1.getMethod("setInt",int.class);//ԭʼ��������int
			Method m41=clazz1.getMethod("setInt", Integer.TYPE);//ԭʼ��������int
			Method m5=clazz1.getMethod("testArrayClass",String[].class);//���������� String
			Method m6=clazz1.getMethod("testArray", int[].class);//ԭʼ������������ �����໥ת�� int[] Integer[]
			Method m7=clazz1.getDeclaredMethod("testPrivate", String.class);//��ȡ˽�еķ���
			System.out.println("��ȡ����ķ���");
			System.out.println("m1:"+m1);
			System.out.println("m2:"+m2);
			System.out.println("m3:"+m3);
			System.out.println("m4:"+m4);
			System.out.println("m41:"+m41);
			System.out.println("m5:"+m5);
			System.out.println("m6:"+m6);
//ִ�����еķ�����
			m1.invoke(sam, null);
			m2.invoke(sam, "m2 ���� ");
			m3.invoke(sam, "m3 �Ĳ���");
			m4.invoke(sam, 4);
			m41.invoke(sam, 41);
//ִ�����鷽��ʱ���Ĵ��������������ǿ��ת��ΪObject�������
			String str[]=new String[] {"m5 de String �������1","m5 de String �������2"};
			m5.invoke(sam,(Object)str);
			int   intArray[]=new int[]{1,2,3,4};
			m6.invoke(sam, (Object)intArray);
// ����Java�ķ��ʿ��Ƽ��
// �����Error: TestPrivate can not access a member of class PrivateClass with modifiers "private"
			m7.setAccessible(true);
			m7.invoke(sam, "m7 �Ĳ���");
//���ʾ�̬����
//���ʾ�̬�ķ�������һ���������Բ��Ƕ���
			clazz1.getMethod("testStatic",null).invoke(null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
class Sample{
	public String str0;
	private String  str1="˽��String str1";
	private String  str2="hello";
	public static  final  int a=10;
	private static int b=5;
	public Sample() {
		
	}
	public String getStr1() {
		System.out.println("ִ��m1 getstr1");
		return str1;
	}
	public void setStr1(String str1) {
		this.str1 = str1;
	}
	public Sample(String str1, String str2) {
		super();
		this.str1 = str1;
		this.str2 = str2;
	}
	public Sample(String str0, String str1, String str2) {
		super();
		this.str0 = str0;
		this.str1 = str1;
		this.str2 = str2;
	}
	public String getStr0() {
		return str0;
	}
	public void setStr0(String str0) {
		System.out.println("ִ��m2 setstr0");
		this.str0 = str0;
	}
	public String getStr2() {
		return str2;
	}
	public void setStr2(String str2) {
		this.str2 = str2;
	}
	public static int getB() {
		return b;
	}
	public static void setB(int b) {
		Sample.b = b;
	}
	public static int getA() {
		return a;
	}
	
	//////////////////////////////////
	public void tell(String str) {
		System.out.println("ִ��m3 tell");
		System.out.println("str");
	}
	public int setInt(int a) {
		System.out.println("ִ��m4 or m41  setInt1");
		System.out.println("a");
		return a;
	}
	public void testArray(int[] a) {
		System.out.println("ִ��m6      TestArray");
		for(int tmp:a) {
			System.out.print("  "+tmp);
		}
		System.out.println();
	}
	public void testArrayClass(String[] a) {
		System.out.println("ִ��m5         TestArrayClass");
		for(String tmp:a) {
			System.out.print("  "+tmp);
		}
		System.out.println();
	}
	private void testPrivate(String str) {
		System.out.println("ִ��m7         TestPrivate");
		System.out.println(str);
	}
	public static void  testStatic() {
		System.out.println("���ʾ�̬����");
	}
	public void testConNewInstance() {
		System.out.println("             ������ִ����ʵ��");
	}
	
}
