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
		//ʹ��������ʵ�����л�
		
//		User user = new User(1001, "tom");
//		try {
//			//����������
//			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("d:/user.data"));
//			//�����ݽ������л�����
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
		
		//�����л���ȡ�־ñ������л�����
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
		//����
		User user = (User)obj;
		System.out.println(user.getUserId()+"\t"+user.getUserName());
		
	}

}
