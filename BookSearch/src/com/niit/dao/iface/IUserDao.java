package com.niit.dao.iface;

import com.niit.entiry.User;

public interface IUserDao {
	
	/**
	 * 根据用户编号查找用户
	 * @param userId
	 * @return
	 */
	public User findUserByUserId(int userId);
	
	/**
	 * 根据用户姓名查找用户
	 * @param name
	 * @return
	 */
	public User findUserByUserName(String name);

}
