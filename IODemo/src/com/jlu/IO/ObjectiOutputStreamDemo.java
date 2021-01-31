package com.jlu.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectiOutputStreamDemo {
	public  static void saveObj(Object obj,OutputStream out) {
		ObjectOutputStream objOut=null;
		try {
			objOut=new ObjectOutputStream(out);
			objOut.writeObject(obj);
			System.out.println("写入成功");
			objOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public  static Object readObj(InputStream in) {
		ObjectInputStream objIn=null;
		Object res=null;
		try {
			objIn=new ObjectInputStream(in);
			res=objIn.readObject();
			System.out.println("读入成功");
			objIn.close();
			return res;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}


	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Person person=new Person(1,"2",3);
		ObjectiOutputStreamDemo.saveObj(person, new FileOutputStream("G:\\OutputSource\\test.txt"));
		Person person2=(Person)ObjectiOutputStreamDemo.readObj(new FileInputStream("G:\\OutputSource\\test.txt"));
		System.out.println(person2.age);
		System.out.println(person2.address);
		System.out.println(person2.height);
	}

}
