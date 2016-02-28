package com.niit.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExam3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<User> list = new ArrayList<User>();
		User user1 = new User(1001,"tom");
		User user2 = new User(1002,"jack");
		User user3 = new User(1003,"lucy");
		//将用户对象存入集合
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		//判断集合中是否包含lucy用户
//		User newUser = new User("lucy");
		//通过get方法获取的集合中元素对象自身
//		User newUser = list.get(0);
//		newUser.setName("tony");
		
		//如果集合中的泛型是自定义类型，在使用contains和indexOf方法判断的时候一定要重写对象的equals方法
//		if(list.contains(newUser)){
//			System.out.println("包含了用户");
//		}
//		else{
//			System.out.println("该用户不存在");
//		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("输入要搜索的用户编号：");
		int userId = sc.nextInt();
		//根据用户编号创建用户对象
		User newUser = new User(userId);
		
		//判断用户是否存在
//		boolean hasUser = false;
//		for(User user : list){
//			if(user.getUserId() == userId){
//				hasUser = true;
//				break;
//			}
//		}
//		if(hasUser){
//			System.out.println("用户存在！");
//		}
		
		if(list.contains(newUser)){
//			System.out.println("包含了用户");
			//如果存在打印用户的姓名
			//System.out.println(list.get(list.indexOf(newUser)).getName());
			//根据对象查找索引
			int index = list.indexOf(newUser);
			//根据索引获取对象
			User user = list.get(index);
			System.out.println(user.getName());
			
		}
		else{
			System.out.println("该用户不存在");
		}
		
//		for(User user : list){
//			System.out.println(user.getName());
//		}
	}

}
