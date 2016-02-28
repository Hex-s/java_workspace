package com.niit.dao.iface;

import com.niit.entity.User;

public interface IUserDao {
	
	/**
	 * �����û���Ų����û�
	 * @param userId
	 * @return
	 */
	public User findUserByUserId(int userId);
	
	/**
	 * �����û����������û�
	 * @param name
	 * @return
	 */
	public User findUserByUserName(String name);

}
