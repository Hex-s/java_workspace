package com.niit.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.niit.bean.User;
import com.niit.dao.iface.IUserDao;
import com.niit.data.Data;
/**
 * 用户数据操作访问对象 实现了IUserDao数据操作接口
 * @author Administrator
 *
 */
public class UserDao implements IUserDao {
	//存储的用户数据集合
	private ArrayList<User> userData;
	
	
	public UserDao(Data data){
		this.userData = data.getUserData();
	}
	
	/**
	 * 添加用户
	 */
	@Override
	public void add(User user) {
		userData.add(user);
	}

	/**
	 * 删除用户
	 */
	@Override
	public void delete(int userId) {
		//根据用户编号找到用户
		User user = findUserById(userId);
		//判断是否查找到用户
		if(user != null){
			//从集合中删除
			userData.remove(user);
		}
	}
	/**
	 * 查找所有用户
	 */
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userData;
	}

	/**
	 * 根据编号查找用户
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
	 * 根据用户姓名查找用户
	 */
	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		for(User user : userData){
			if(user.getUserName().equals(name)){
				return user;
			}
		}
		return null;
	}

	/**
	 * 根据用户编号修改用户
	 */
	@Override
	public void modify(int userId, User user) {
		// TODO Auto-generated method stub
		//根据编号查找对象
		User u = findUserById(userId);
		//判断用户是否存在
		if(u != null){
			//查找用户在集合中的索引
			int index = userData.indexOf(u);
			userData.set(index, user);
		}
		
	}

}
