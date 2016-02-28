package com.niit.dao.iface;

import com.niit.entity.User;

public interface IUserDao {
	
	/**
	 * 根据用户名查询用户对象
	 * @param userName
	 * @return
	 */
	public User findUserByName(String userName);
	
	/**
	 * 添加保存用户
	 * @param user
	 */
	public void saveUser(User user);
}
