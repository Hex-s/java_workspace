package com.niit.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.niit.bean.User;
import com.niit.dao.iface.IUserDao;
import com.niit.data.Data;
/**
 * �û����ݲ������ʶ��� ʵ����IUserDao���ݲ����ӿ�
 * @author Administrator
 *
 */
public class UserDao implements IUserDao {
	//�洢���û����ݼ���
	private ArrayList<User> userData;
	
	
	public UserDao(Data data){
		this.userData = data.getUserData();
	}
	
	/**
	 * ����û�
	 */
	@Override
	public void add(User user) {
		userData.add(user);
	}

	/**
	 * ɾ���û�
	 */
	@Override
	public void delete(int userId) {
		//�����û�����ҵ��û�
		User user = findUserById(userId);
		//�ж��Ƿ���ҵ��û�
		if(user != null){
			//�Ӽ�����ɾ��
			userData.remove(user);
		}
	}
	/**
	 * ���������û�
	 */
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userData;
	}

	/**
	 * ���ݱ�Ų����û�
	 */
	@Override
	public User findUserById(int userId) {
		//�����û�����
		for(User u : userData){
			if(u.getUserId() == userId){
				return u;
			}
		}
		return null;
	}

	/**
	 * �����û����������û�
	 */
	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		for(User user : userData){
			if(user.getUserName().equals(name)){
				return user;
			}
		}
		return null;
	}

	/**
	 * �����û�����޸��û�
	 */
	@Override
	public void modify(int userId, User user) {
		// TODO Auto-generated method stub
		//���ݱ�Ų��Ҷ���
		User u = findUserById(userId);
		//�ж��û��Ƿ����
		if(u != null){
			//�����û��ڼ����е�����
			int index = userData.indexOf(u);
			userData.set(index, user);
		}
		
	}

}
