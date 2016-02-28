package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IUserDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entity.User;
/**
 * �û����ݲ�����
 * @author Administrator
 *
 */
public class UserDao implements IUserDao {

	/**
	 * ����û�
	 */
	public void addUser(User user) {
		DaoHandle.executeUpdate("insert into bbsuser values(sq_bbsuser_userid.nextval,?,?,?,?,?,?,sysdate,1,?,?)", new Object[]{user.getuName(),user.getuPwd(),user.getuSex(),user.getuEmail(),user.getuBirthday(),user.getuStatement(),user.getuHead(),user.getAddress()});
	}

	/**
	 * �����û���Ų�ѯ�û�
	 */
	public User findUserById(int userId) {
		ArrayList<User> list = DaoHandle.executeQuery("select * from bbsuser where userid=?", new Object[]{userId}, User.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * �����û�����ѯ�û�
	 */
	public User findUserByName(String userName) {
		ArrayList<User> list = DaoHandle.executeQuery("select * from bbsuser where uname=?", new Object[]{userName}, User.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
