package com.niit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Exam8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//使用数据流实现序列化
		
//		User user = new User(1001, "tom");
//		try {
//			//创建对象流
//			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("d:/user.data"));
//			//将数据进行序列化保存
//			output.writeObject(user);
//			output.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		user.setUserName("jack");
		
		//反序列化读取持久保存序列化数据
		Object obj = null;
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File("d:/user.data")));
			obj = input.readObject();
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//拆箱
		User user = (User)obj;
		System.out.println(user.getUserId()+"\t"+user.getUserName());
		
	}

}
