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

	/**
	 * 添加用户
	 */
	public void addUser(User user) {
		DaoHandle.executeUpdate("insert into bbsuser values(sq_bbsuser_userid.nextval,?,?,?,?,?,?,sysdate,1,?,?)", new Object[]{user.getuName(),user.getuPwd(),user.getuSex(),user.getuEmail(),user.getuBirthday(),user.getuStatement(),user.getuHead(),user.getAddress()});
	}

	/**
	 * 根据用户编号查询用户
	 */
	public User findUserById(int userId) {
		ArrayList<User> list = DaoHandle.executeQuery("select * from bbsuser where userid=?", new Object[]{userId}, User.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据用户名查询用户
	 */
	public User findUserByName(String userName) {
		ArrayList<User> list = DaoHandle.executeQuery("select * from bbsuser where uname=?", new Object[]{userName}, User.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
