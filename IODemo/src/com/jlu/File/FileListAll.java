package com.jlu.File;

import java.io.File;

public class FileListAll {
	public static void listAllFiles(File file,int rank) {
				if(!file.exists()) {
					System.out.println("�ļ���·��������");
					return ;
				}
				if(file.isDirectory()) {
					//�ȴ�ӡ��Ŀ¼
					for(int i=0;i<rank;i++)
						System.out.print("-");
					System.out.println(file.getName());
					//��ӡĿ¼�µ����ļ���Ŀ¼
					File[] tmp=file.listFiles();
					if(tmp!=null)
					for(int i=0;i<tmp.length;i++) {
						listAllFiles(tmp[i],rank+1);
					}
					return ;

				}
				//����һ���ļ�����ӡ�ļ���
				for(int i=0;i<rank;i++)
					System.out.print("-");
				System.out.println(file.getName());

	}
	public static void main(String[] args) {
		FileListAll.listAllFiles(new File("G:"+File.separator),0);
	}

}
