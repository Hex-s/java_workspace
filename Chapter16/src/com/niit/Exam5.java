package com.niit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//使用字符流读取文本文件
		//字符流不能对图片，影像，音频等单字节构成的文件进行读取
//		try {
//			//创建字符输入流
//			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File("d:/a.jpg")));
//			//创建字符输出流
//			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("d:/b.jpg")));
//			int data;
//			while((data = reader.read()) != -1){
//				//System.out.println(data);
//				writer.write(data);
//			}
//			reader.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//缓冲字符流
		//InputerStreamReader是字节流通向字符流的桥梁
//		try {
//			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d:/循环练习.txt"))));
//			//readLine表示读取文件中的一行文本信息
//			//System.out.println(reader.readLine());
//			String str;
//			while((str = reader.readLine()) != null){
//				System.out.println(str);
//			}
//			reader.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//使用缓冲字符输出流写入文件信息
//		try {
//			//通过输出流向文件追加内容，需要在构建字节流的时候添加第二个参数用来表示是否在原文件中追加内容
//			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("d:/a.txt"),true)));
//			writer.write("hello");
//			//插入一个换行符
//			//writer.newLine();
//			//通过换行的转义符实现
//			writer.write("\r\n");
//			writer.write("niit\r\n");
//			writer.flush();
//			writer.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
