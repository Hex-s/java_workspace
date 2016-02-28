package com.niit;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.FieldPosition;

public class Exam6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//自定义键盘接受功能
		//缓冲字符流读取键盘输入
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//当输入exit的时候表示输入结束
			String str;
			while(!(str = reader.readLine()).equals("exit")){
				System.out.println(str);
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
