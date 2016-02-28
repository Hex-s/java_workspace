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
	 * ����û�
	 */
	@Override
	public void add(User user) {
		userData.add(user);
	}

	/**
	 * �����û��������û�
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
	 * �����û���Ų����û�����
	 */
	@Override
	public User findUserById(int userId) {
		//�����û�����
		for(User u : userData){
			if(u.getUserId() == userId){
				return u;
			}
		}
		return null;
	}
	
	/**
	 * �����û�����޸��û���Ϣ
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
	 * ���������û�
	 */
	@Override
	public ArrayList<User> findAll() {
		return userData;
	}

	

}
