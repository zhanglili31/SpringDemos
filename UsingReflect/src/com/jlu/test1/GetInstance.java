package com.jlu.test1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
//JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
//对于任意一个对象，都能够调用它的任意一个方法；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
public class GetInstance {
	public static void main(String[] args) {
		try {
//获取对象实例
			//方式0
			Class<String> clazz0=String.class;
			Class clazz01=String.class;
			//方式一
			Class<?> clazz1=Class.forName("com.jlu.test1.Sample");
			//方式二  种表达方式同时也告诉了我们任何一个类都有一个隐含的静态成员变量class
			Class clazz2=Sample.class;
			//方式3 这种表达方式在已知了该类的对象的情况下通过getClass方法获取
			Sample  sam=new Sample();
			Class clazz3=sam.getClass();
			// 获取class对象的实例
			System.out.println("获取对象的实例");
			System.out.println("clazz0:"+clazz0);
			System.out.println("clazz01:"+clazz01);
			System.out.println("clazz1:"+clazz1);
			System.out.println("clazz2:"+clazz2);
			System.out.println("clazz3:"+clazz3);
			System.out.println("clazz1==clazz2:"+(clazz1==clazz2));
			System.out.println("clazz2==clazz3:"+(clazz2==clazz3));
//获取对象的属性：反映此表示的类或接口的指定公共成员字段 类对象。 
			Field   f1=clazz1.getField("str0");
			//Field   f2=clazz1.getField("str1");str1 是私有地 不能获取到
			Field f2=clazz1.getDeclaredField("str1");
			Field f3=clazz1.getDeclaredField("b");
			Field []fs=clazz1.getFields();
			
			System.out.println("获取对象的属性");
			System.out.println("f1 str0:"+f1); 
			System.out.println("f2 str1:"+f2); 
			for(Field tmp:fs) {
				System.out.println("fs "+tmp);
			}
//使用对象的属性
			System.out.println("使用对象的属性");
			f2.setAccessible(true);
			f3.setAccessible(true);
			System.out.println(f2.toString()+" value:"+f2.get(sam));
			System.out.println(	f3.toString()+" vlaue:"+f3.getInt(null));
			
				
//获取对象的构造器
			//默认的构造器
			Constructor  c1=clazz1.getConstructor();
			Constructor	c2=clazz1.getConstructor(String.class,String.class);
			Constructor [] c3=clazz1.getConstructors();
			System.out.println("获取对象了的构造器");
			System.out.println("c1:"+c1);
			System.out.println("c2:"+c2);
			for(Constructor tmp:c3) {
				System.out.println("c3:" +tmp);
			} 
			// 使用构造器创建新的实例
			System.out.println("创建新的实例，并执行其方法。");
			Sample csam=(Sample) c2.newInstance("参数1","参数2");
			csam.testConNewInstance();
			//
			
			
			
//获取对象的方法
			//参数是数组类型呢？？？
			//参数是原始类型呢??
//			long.class <==> Long.TYPE
//			double.class <==> Double.TYPE
//		    float.class <==> Float.TYPE
//			bool.class <==> Boolean.TYPE
//			char.class <==> Character.TYPE
//			byte.class <==> Byte.TYPE
//			void.class <==> Void.TYPE
//			short.class <==> Short.TYPE	
//用反射的方法传入基本int数据类型的时候，int自动转换成了Integer.class,而实际上int对应的Class是int.class
//https://blog.csdn.net/csm_qz/article/details/46853567
//			如果使用该方法 会不能获取以多态方式传入的参数,因为重载是静态编译的，而多态是动态编译的 不能确定是哪一个类，
			
//getDeclaredMethod():获取当前类的所有方法，包括public/private/protected/default修饰的方法。
//getMethod():获取当前类及所有继承的父类的public修饰的方法。仅包括public
			Method m1=clazz1.getMethod("getStr1", null);//方法没有参数为null，否则依次  ClassNmae.class
			Method m2=clazz1.getMethod("setStr0", String.class);
			Method m3=clazz1.getMethod("tell", String.class);
			Method m4=clazz1.getMethod("setInt",int.class);//原始数据类型int
			Method m41=clazz1.getMethod("setInt", Integer.TYPE);//原始数据类型int
			Method m5=clazz1.getMethod("testArrayClass",String[].class);//类数组类型 String
			Method m6=clazz1.getMethod("testArray", int[].class);//原始数据数组类型 不能相互转换 int[] Integer[]
			Method m7=clazz1.getDeclaredMethod("testPrivate", String.class);//获取私有的方法
			System.out.println("获取对象的方法");
			System.out.println("m1:"+m1);
			System.out.println("m2:"+m2);
			System.out.println("m3:"+m3);
			System.out.println("m4:"+m4);
			System.out.println("m41:"+m41);
			System.out.println("m5:"+m5);
			System.out.println("m6:"+m6);
//执行所有的方法：
			m1.invoke(sam, null);
			m2.invoke(sam, "m2 参数 ");
			m3.invoke(sam, "m3 的参数");
			m4.invoke(sam, 4);
			m41.invoke(sam, 41);
//执行数组方法时做的处理，将数组类对象强制转换为Object的类对象。
			String str[]=new String[] {"m5 de String 数组参数1","m5 de String 数组参数2"};
			m5.invoke(sam,(Object)str);
			int   intArray[]=new int[]{1,2,3,4};
			m6.invoke(sam, (Object)intArray);
// 抑制Java的访问控制检查
// 否则会Error: TestPrivate can not access a member of class PrivateClass with modifiers "private"
			m7.setAccessible(true);
			m7.invoke(sam, "m7 的参数");
//访问静态方法
//访问静态的方法，第一个参数可以不是对象。
			clazz1.getMethod("testStatic",null).invoke(null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
class Sample{
	public String str0;
	private String  str1="私有String str1";
	private String  str2="hello";
	public static  final  int a=10;
	private static int b=5;
	public Sample() {
		
	}
	public String getStr1() {
		System.out.println("执行m1 getstr1");
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
		System.out.println("执行m2 setstr0");
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
		System.out.println("执行m3 tell");
		System.out.println("str");
	}
	public int setInt(int a) {
		System.out.println("执行m4 or m41  setInt1");
		System.out.println("a");
		return a;
	}
	public void testArray(int[] a) {
		System.out.println("执行m6      TestArray");
		for(int tmp:a) {
			System.out.print("  "+tmp);
		}
		System.out.println();
	}
	public void testArrayClass(String[] a) {
		System.out.println("执行m5         TestArrayClass");
		for(String tmp:a) {
			System.out.print("  "+tmp);
		}
		System.out.println();
	}
	private void testPrivate(String str) {
		System.out.println("执行m7         TestPrivate");
		System.out.println(str);
	}
	public static void  testStatic() {
		System.out.println("访问静态方法");
	}
	public void testConNewInstance() {
		System.out.println("             构造器执行新实例");
	}
	
}
