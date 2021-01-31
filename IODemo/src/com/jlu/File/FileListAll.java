package com.jlu.File;

import java.io.File;

public class FileListAll {
	public static void listAllFiles(File file,int rank) {
				if(!file.exists()) {
					System.out.println("文件或路径不存在");
					return ;
				}
				if(file.isDirectory()) {
					//先打印该目录
					for(int i=0;i<rank;i++)
						System.out.print("-");
					System.out.println(file.getName());
					//打印目录下的子文件或目录
					File[] tmp=file.listFiles();
					if(tmp!=null)
					for(int i=0;i<tmp.length;i++) {
						listAllFiles(tmp[i],rank+1);
					}
					return ;

				}
				//这是一个文件，打印文件名
				for(int i=0;i<rank;i++)
					System.out.print("-");
				System.out.println(file.getName());

	}
	public static void main(String[] args) {
		FileListAll.listAllFiles(new File("G:"+File.separator),0);
	}

}
