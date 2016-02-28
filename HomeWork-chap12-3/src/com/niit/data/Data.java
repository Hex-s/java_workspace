package com.niit.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.niit.bean.User;
import com.niit.util.CommonUtil;

/**
 * 数据类
 * @author Administrator
 *
 */
public class Data {

	//使用集合存储所有的数据
	//所有的用户信息
	private ArrayList<User> userData;
	
	
	public Data(){
		userData = new ArrayList<User>();
		
		/********初始化用户数据************/
		User user1 = new User("admin", "123", 900000, true);
		User user2 = new User("tom", "123", 90000, false);
		userData.add(user1);
		userData.add(user2);
		
	}

	public ArrayList<User> getUserData() {
		return userData;
	}

}
