package com.jlu.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTest {
	/**
	 * @param source Դ�ļ���·��
	 * @param goal  ����Ŀ���ļ���·��
	 * ��Ҫ�����ڿ���һ���ļ�
	 *
	 */
	public static void copyFile(File source, File goal) {
		InputStream in = null;
		try {
			in = new FileInputStream(source);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OutputStream out = null;
		try {
			out = new FileOutputStream(goal);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] buffer = new byte[1024];
		int len = 0;
		try {
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param sourceDir ԴĿ¼·��
	 * @param goalDir	Ŀ��Ŀ¼·��
	 * ��Ҫ�����ý�ԴĿ¼������Ŀ��Ŀ¼��
	 * ʹ�õݹ�ķ�ʽ
	 * ���ļ��Ϳ���
	 * ��Ŀ¼�͵ݹ鿽��Ŀ¼
	 */
	public static void copyDirectory(File sourceDir, File goalDir) {
		if (!sourceDir.isDirectory()) {
			System.out.println("sourceDir is not dir");
			return;
		}
		if (!goalDir.isDirectory()) {
			System.out.println("goalDir is not dir");
			return;
		}
		File tmpGoal = new File(goalDir.getPath() + File.separator + sourceDir.getName());
		tmpGoal.mkdir();
		File fileList[] = sourceDir.listFiles();
		File sourceFile = null;
		File goalFile = null;
		if (fileList != null) {
			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].isFile()) {// ���ļ�copy
					sourceFile = fileList[i];
					// ����������Ŀ���ļ���FILE ���ܻ���� ���������Դ�ӡ��������
					goalFile = new File(tmpGoal.getPath() + File.separator + fileList[i].getName());
					FileTest.copyFile(sourceFile, goalFile);
				} else if (fileList[i].isDirectory()) {// ����Ŀ¼
					copyDirectory(fileList[i], tmpGoal);

				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// ����Ҫ��ת���ַ�
		FileTest.copyFile(new File("G:\\InputSource\\test.txt"), new File("G:\\OutputSource\\test.txt"));
		System.out.println("�����ļ��ɹ�");

	}

}
