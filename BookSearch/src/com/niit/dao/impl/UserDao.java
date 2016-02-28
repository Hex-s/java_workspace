package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IUserDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entiry.User;

public class UserDao implements IUserDao{

	/**
	 * 根据用户编号查找用户
	 */
	public User findUserByUserId(int userId) {
		ArrayList<User> list = DaoHandle.executeQuery("select * from bookuser where userid=?", new Object[]{userId}, User.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据用户姓名查找用户
	 */
	public User findUserByUserName(String name) {
		ArrayList<User> list = DaoHandle.executeQuery("select * from bookuser where upper(uname)=upper(?)", new Object[]{name}, User.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
