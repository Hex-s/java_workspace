package com.niit.exam2;

import java.io.ObjectInputStream.GetField;

public class UserTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		User[] users = new User[10];
		for(int i = 0; i < users.length; i++){
			//对数组的每个元素进行实例化
			users[i] = User.getInstance();
			//通过哈希值辨识是否是同一个对象
			System.out.println(users[i].hashCode());
		}
	}

}
