package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IUserDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entity.User;
/**
 * 用户数据操作类
 * @author Administrator
 *
 */
public class UserDao implements IUserDao {

	public void addUser(User user) {
		DaoHandle.executeUpdate("insert into users values(userid.nextval,?,?,?,?,?)", new Object[]{user.getUserName(),user.getUserPwd(),user.getHead(),user.getRegTime(),user.getSex()});
	}

	public User findUserById(int userId) {
		ArrayList<User> list = DaoHandle.executeQuery("select * from users where userid=?", new Object[]{userId}, User.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	public User findUserByName(String userName) {
		ArrayList<User> list = DaoHandle.executeQuery("select * from users where username=?", new Object[]{userName}, User.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
