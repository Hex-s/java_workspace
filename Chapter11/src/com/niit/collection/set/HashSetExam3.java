package com.niit.collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExam3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//创建Set集合
		Set<User> set = new HashSet<User>();
		User user1 = new User(1, "tom");
		User user2 = new User(2, "jack");
		User user3 = new User(3, "jerry");
		User user4 = new User(4, "tony");
		//set添加重复元素是基于内存地址来判断
		//如果在Set集合要避免存入以下逻辑上是相同的数据，物理上是不同的数据时，就必须重写要添加对象的hashCode方法和equals方法
		User user5 = new User(2, "jack");
		
		set.add(user1);
		set.add(user2);
		set.add(user3);
		set.add(user4);
		set.add(user5);
		
		User u = null;
		//遍历集合
//		for(User user : set){
//			//获取编号为2的User对象
//			if(user.getUserId() == 2){
//				u = user;
//			}
//			//System.out.println(user.getUserId()+"\t"+user.getName());
//		}
		//将获取的编号为2的用户姓名进行修改
		//u.setName("lucy");
		//添加修改后的用户
		//set.add(u);
		
		for(User user : set){
			System.out.println(user.getUserId()+"\t"+user.getName());
		}
	}

}
