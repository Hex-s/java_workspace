package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.bean.User;
import com.niit.dao.iface.IUserDao;
import com.niit.data.Data;

public class UserDao implements IUserDao{
	
	private ArrayList<User> userData = new ArrayList<User>();
	
	public UserDao(Data data){
		userData = data.getUserData();
	}

	/**
	 * 添加用户
	 */
	@Override
	public void add(User user) {
		userData.add(user);
	}

	/**
	 * 根据用户名查找用户
	 */
	@Override
	public User findUserByName(String name) {
		for(User user: userData){
			if(user.getUserName().equals(name)){
				return user;
			}
		}
		return null;
	}

	/**
	 * 根据用户编号查找用户对象
	 */
	@Override
	public User findUserById(int userId) {
		//遍历用户集合
		for(User u : userData){
			if(u.getUserId() == userId){
				return u;
			}
		}
		return null;
	}
	
	/**
	 * 根据用户编号修改用户信息
	 */
	@Override
	public void modify(int userId,User user) {
		User u = findUserById(userId);
		if(u != null){
			int index = userData.indexOf(u);
			userData.set(index, user);
		}
		
	}

	/**
	 * 查找所有用户
	 */
	@Override
	public ArrayList<User> findAll() {
		return userData;
	}

	

}
