package com.jlu.IO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedInputStreamDemo {

	public static void readFile(String path) {
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			try {
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
				byte[] res = new byte[1024 ];
				int len = 0;
				byte tmp;
				OutputStream out=new FileOutputStream("G:\\OutputSource\\test.txt");
				while ((len= in.read(res,0,res.length)) != -1) {
					out.write(res,0,len);
					System.out.print(new String(res,0,len));

				}

				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	public static void main(String[] args) {
		BufferedInputStreamDemo.readFile("G:\\InputSource\\test.txt");
	}


}
