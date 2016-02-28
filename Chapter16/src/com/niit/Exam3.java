package com.niit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exam3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/************************字节流**********************/
		//字节流可以读写计算机里的任意文件
		//创建FileInputStream是最基本的输入流，用来读取文件的字节信息
//		try {
//			//输入流不能对文件夹进行读取
//			FileInputStream input = new FileInputStream(new File("d:/image"));
//			//使用字节流读取文件的信息
//			int data;
//			while((data = input.read()) != -1){
//				System.out.println(data);
//			}
//			//关闭数据流
//			input.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			//创建FileOutputStream,是最基本的输出流，用来向文件写入信息
//			//使用输出流时，如果文件存在，则会覆盖现有文件的数据
//			//如果文件不存在，输出流将重新新建文件并写入数据
//			FileOutputStream output = new FileOutputStream(new File("d:/b.txt"));
//			//往文件写入数据
//			output.write(98);
//			//清空缓冲
//			output.flush();
//			//关闭输出流
//			output.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
