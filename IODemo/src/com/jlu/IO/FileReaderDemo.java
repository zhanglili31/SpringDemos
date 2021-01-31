package com.jlu.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileReaderDemo {
	public static  void copyFile(File source ,File goal) {
		Reader read=null;
		Writer writer=null;
		try {
			read=new FileReader(source);
			writer=new FileWriter(goal);
			char [] buffer=new char[1024];
			int len=0;
			while((len=read.read(buffer))!=-1) {
				System.out.println(new String(buffer,0,len));
				writer.write(buffer, 0, len);
			}
			read.close();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		FileReaderDemo.copyFile(new File("G:\\InputSource\\test.txt"), new File("G:\\OutputSource\\test.txt"));
	}

}
