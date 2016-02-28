package com.niit.dao.iface;

import com.niit.entity.User;

/**
 * 用户数据操作接口
 * @author Administrator
 *
 */
public interface IUserDao {
	
	/**
	 * 根据用户名查询用户
	 * @param userName
	 * @return
	 */
	public User findUserByName(String userName);
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 根据用户编号查询用户
	 * @param userId
	 * @return
	 */
	public User findUserById(int userId);
}
