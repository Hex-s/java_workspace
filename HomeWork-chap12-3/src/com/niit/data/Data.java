package com.niit.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.niit.bean.User;
import com.niit.util.CommonUtil;

/**
 * ������
 * @author Administrator
 *
 */
public class Data {

	//ʹ�ü��ϴ洢���е�����
	//���е��û���Ϣ
	private ArrayList<User> userData;
	
	
	public Data(){
		userData = new ArrayList<User>();
		
		/********��ʼ���û�����************/
		User user1 = new User("admin", "123", 900000, true);
		User user2 = new User("tom", "123", 90000, false);
		userData.add(user1);
		userData.add(user2);
		
	}

	public ArrayList<User> getUserData() {
		return userData;
	}

}
