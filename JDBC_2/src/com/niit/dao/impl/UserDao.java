package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IUserDao;
import com.niit.entity.User;
import com.niit.util.DaoHandle;

public class UserDao implements IUserDao {

	@Override
	public void delete(int userId) {
		DaoHandle.executeUpdate("delete from users where userid=?", new Object[]{userId});
	}

	@Override
	public ArrayList<User> findAll() {
		ArrayList<User> list = DaoHandle.executeQuery("select * from users", null, User.class);
		return list;
	}

	@Override
	public User findById(int userId) {
		ArrayList<User> list = DaoHandle.executeQuery("select * from users where userid=?", new Object[]{userId}, User.class);
		if(!list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}

	@Override
	public void modify(User user) {
		// TODO Auto-generated method stub
		DaoHandle.executeUpdate("update users set userpwd=? where userid=?", new Object[]{user.getUserPwd(),user.getUserId()});
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		DaoHandle.executeUpdate("insert into users values(?,?,?,?)", new Object[]{user.getUserId(),user.getUserName(),user.getUserPwd(),user.getRegTime()});
		
	}
	
}
