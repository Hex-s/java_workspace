package com.niit.homework;

import java.util.Scanner;

public class HomeWork3 {
	/**
	 * 输入一个文件名,判断该文件是记事本文件还是幻灯片文件还是JAVA源文件，或者是可执行文件，其他文件或非法文件
	 * @param fileName 需要判断的文件名
	 * @return 返回该文件名是否正确
	 */
	public String file(String fileName){
		//文件类型的结果
		String result = "";
		//文件类型前的.
		int index = fileName.lastIndexOf(".");
		//文件类型
		String str = fileName.substring(index+1);
		//记事本文件
		if(str.equalsIgnoreCase("txt")){
			result = "记事本文件";
		}
		//幻灯片文件
		else if(str.equalsIgnoreCase("ppt")){
			result = "幻灯片文件";
		}
		//java源文件
		else if(str.equalsIgnoreCase("java")){
			result = "JAVA源文件";
		}
		//可执行文件
		else if(str.equalsIgnoreCase("exe")){
			result = "可执行文件";
		}
		//其他文件或非法文件
		else{
			result = "其他文件或非法文件";
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入文件名：");
		String fileName = sc.next();
		HomeWork3 hw = new HomeWork3();
		String result = hw.file(fileName);
		System.out.println(fileName+"是一个"+result);
	}

}
