package com.niit.exam2;

import java.io.ObjectInputStream.GetField;

public class UserTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		User[] users = new User[10];
		for(int i = 0; i < users.length; i++){
			//�������ÿ��Ԫ�ؽ���ʵ����
			users[i] = User.getInstance();
			//ͨ����ϣֵ��ʶ�Ƿ���ͬһ������
			System.out.println(users[i].hashCode());
		}
	}

}
