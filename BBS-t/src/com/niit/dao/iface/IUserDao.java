package com.niit.dao.iface;

import com.niit.entity.User;

/**
 * �û����ݲ����ӿ�
 * @author Administrator
 *
 */
public interface IUserDao {
	
	/**
	 * �����û�����ѯ�û�
	 * @param userName
	 * @return
	 */
	public User findUserByName(String userName);
	
	/**
	 * ����û�
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * �����û���Ų�ѯ�û�
	 * @param userId
	 * @return
	 */
	public User findUserById(int userId);
}
