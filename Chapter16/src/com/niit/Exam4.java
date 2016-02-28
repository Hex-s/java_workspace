package com.niit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exam4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//使用输入输出流复制图片
//		try {
//			//创建输入流读取图片
//			FileInputStream input = new FileInputStream(new File("d:/image/back.jpg"));
//			//创建输出流写入图片的信息
//			FileOutputStream output = new FileOutputStream(new File("d:/a.jpg"));
//			int data;
//			//循环读取图片中的每个字节
//			while((data = input.read()) != -1){
//				//将读取的每个字节通过输出流写入到另一个文件中
//				output.write(data);
//			}
//			input.close();
//			output.flush();
//			output.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//使用缓冲流复制图片
		//创建字节缓冲输入流,缓冲流依赖于字节流构建
//		try {
//			BufferedInputStream buffInput = new BufferedInputStream(new FileInputStream(new File("d:/image/back.jpg")));
//			//创建字节缓冲输出流
//			BufferedOutputStream buffOutput = new BufferedOutputStream(new FileOutputStream(new File("d:/a.jpg")));
//			//读取缓冲流的数据
//			int data;
//			while((data = buffInput.read()) != -1){
//				buffOutput.write(data);
//			}
//			buffInput.close();
//			buffOutput.flush();
//			buffOutput.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//使用字节流实现缓冲功能
		//以下代码实现整个文件的缓冲
//		try {
//			FileInputStream input = new FileInputStream(new File("d:/image/back.jpg"));
//			FileOutputStream output = new FileOutputStream(new File("d:/a.jpg"));
//			//缓冲数组
//			byte[] data = new byte[100000];
//			//通过输入流将读取的信息写入缓冲数组
//			input.read(data);
//			//将读取的信息通过输出流输出
//			output.write(data);
//			input.close();
//			output.flush();
//			output.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//缓冲文件应对文件读取的某一段数据进行缓冲，然后再从缓冲区输出信息，同时继续读取下一轮写至缓冲区内
		try {
			FileInputStream input = new FileInputStream(new File("d:/image/back.jpg"));
			FileOutputStream output = new FileOutputStream(new File("d:/a.jpg"));
			//创建缓冲数组
			byte[] data = new byte[1024];
			//读取的数据长度
			int len;
			while((len = input.read(data)) != -1){
				//对缓冲的数据进行输出
				output.write(data, 0, len);
			}
			input.close();
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
