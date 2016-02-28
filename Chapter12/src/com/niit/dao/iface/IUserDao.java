package com.niit.dao.iface;

import java.util.List;

import com.niit.bean.User;

/**
 * 用户数据操作对象，封装了和User信息有关的数据操作方法
 * DAO中封装所有方法和业务逻辑无关
 * @author Administrator
 *
 */
public interface IUserDao {
	
	/**
	 * 添加用户信息
	 * @param user
	 */
	public void add(User user);
	
	/**
	 * 根据用户名查找用户对象
	 * @param name
	 * @return
	 */
	public User findUserByName(String name);
	
	/**
	 * 根据用户编号查找用户对象
	 * @param userId
	 * @return
	 */
	public User findUserById(int userId);
	
	/**
	 * 根据编号删除用户
	 * @param userId
	 */
	public void delete(int userId);
	
	/**
	 * 根据用户编号修改用户信息
	 * @param userId 被修改的用户编号
	 * @param user 封装了新的用户信息的对象
	 */
	public void modify(int userId, User user);
	
	/**
	 * 查找所有用户对象
	 * @return
	 */
	public List<User> findAll();
}
