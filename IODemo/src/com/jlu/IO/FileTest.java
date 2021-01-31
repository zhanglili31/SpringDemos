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
	 * @param source 源文件的路径
	 * @param goal  生成目标文件的路径
	 * 主要是用于拷贝一个文件
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
	 * @param sourceDir 源目录路径
	 * @param goalDir	目标目录路径
	 * 主要的作用将源目录拷贝到目标目录下
	 * 使用递归的方式
	 * 是文件就拷贝
	 * 是目录就递归拷贝目录
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
				if (fileList[i].isFile()) {// 对文件copy
					sourceFile = fileList[i];
					// 这里是设置目标文件的FILE 可能会出错 如果出错可以打印出来看下
					goalFile = new File(tmpGoal.getPath() + File.separator + fileList[i].getName());
					FileTest.copyFile(sourceFile, goalFile);
				} else if (fileList[i].isDirectory()) {// 拷贝目录
					copyDirectory(fileList[i], tmpGoal);

				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// 这里要加转义字符
		FileTest.copyFile(new File("G:\\InputSource\\test.txt"), new File("G:\\OutputSource\\test.txt"));
		System.out.println("拷贝文件成功");

	}

}
