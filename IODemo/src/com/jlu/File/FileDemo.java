package com.jlu.File;

import java.io.File;

public class FileDemo {
public static void main(String[] args) {
	String path="G:"+File.separator;
	File myfile=new File(path);
	boolean exists=myfile.exists();
	boolean mkdir=myfile.mkdir();
	boolean mkdirs=myfile.mkdirs();
	boolean isFile=myfile.isFile();
	boolean isDirectory=myfile.isDirectory();
	File[] fileList=myfile.listFiles();
	String[] fileName=myfile.list();
	System.out.println("path :"+path);
	System.out.println("exists:"+exists);
	System.out.println("mkdir:"+mkdir);
	System.out.println("mkdirs:"+mkdirs);
	System.out.println("isFile:"+isFile);
	System.out.println("isDirectory:"+isDirectory);
	System.out.println("fileList");
	if(fileList!=null) {
		for(int i=0;i<fileList.length;i++) {
			System.out.println(fileList[i].toString());
		}
	}
	System.out.println("String list");
	if(fileName!=null) {
		for(int i=0;i<fileName.length;i++) {
			System.out.println(fileName[i].toString());
		}
	}


}
}
