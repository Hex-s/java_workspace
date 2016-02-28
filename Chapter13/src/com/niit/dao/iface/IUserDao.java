package com.niit.dao.iface;

import java.util.List;

import com.niit.bean.User;

/**
 * �û����ݲ������󣬷�װ�˺�User��Ϣ�йص����ݲ�������
 * DAO�з�װ���з�����ҵ���߼��޹�
 * @author Administrator
 *
 */
public interface IUserDao {
	
	/**
	 * ����û���Ϣ
	 * @param user
	 */
	public void add(User user);
	
	/**
	 * �����û��������û�����
	 * @param name
	 * @return
	 */
	public User findUserByName(String name);
	
	/**
	 * �����û���Ų����û�����
	 * @param userId
	 * @return
	 */
	public User findUserById(int userId);
	
	/**
	 * ���ݱ��ɾ���û�
	 * @param userId
	 */
	public void delete(int userId);
	
	/**
	 * �����û�����޸��û���Ϣ
	 * @param userId ���޸ĵ��û����
	 * @param user ��װ���µ��û���Ϣ�Ķ���
	 */
	public void modify(int userId, User user);
	
	/**
	 * ���������û�����
	 * @return
	 */
	public List<User> findAll();
}
