package com.niit.collection.list;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListExam2 {

	public static void main(String[] args) {
		//ArrayList list = new ArrayList();
		
		//通过泛型强化集合的安全性，统一集合存储的数据类型,避免数据的拆箱操作
//		ArrayList<User> list = new ArrayList<User>();
//		User user1 = new User("tom");
//		User user2 = new User("jack");
//		User user3 = new User("lucy");
//		//将用户对象存入集合
//		list.add(user1);
//		list.add(user2);
//		list.add(user3);
//		//list.add("tony");
//		
//		//遍历集合
//		for(User user : list){
//			//拆箱成User类型
//			//User user = (User)obj;
//			System.out.println(user.getName());
//		}
		
		//泛型指定的类型必须是引用数据类型
		//ArrayList<Integer> list = new ArrayList<Integer>();
		
		//泛型中也可以指定其他集合类型，形成嵌套的集合
		//ArrayList<Collection<Integer>> list = new ArrayList<Collection<Integer>>();
		
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		//构建子集合
		ArrayList<String> childList1 = new ArrayList<String>();
		childList1.add("a");
		childList1.add("b");
		
		ArrayList<String> childList2 = new ArrayList<String>();
		childList2.add("c");
		childList2.add("d");
		
		//将子集合添加至父集合
		list.add(childList1);
		list.add(childList2);
		
		//遍历集合
		//外层遍历父集合
		for(ArrayList<String> childList : list){
			//里层遍历每一个子集合
			for(String s : childList){
				System.out.print(s+"\t");
			}
			System.out.println();
		}
		
	}
}
