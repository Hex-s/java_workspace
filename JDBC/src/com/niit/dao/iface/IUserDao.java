package com.niit.dao.iface;

import com.niit.entity.User;

public interface IUserDao {
	
	/**
	 * �����û�����ѯ�û�����
	 * @param userName
	 * @return
	 */
	public User findUserByName(String userName);
	
	/**
	 * ��ӱ����û�
	 * @param user
	 */
	public void saveUser(User user);
}
