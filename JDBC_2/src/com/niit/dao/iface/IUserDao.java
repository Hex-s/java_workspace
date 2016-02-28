package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.User;

public interface IUserDao {
	
	public User findById(int userId);
	
	public ArrayList<User> findAll();
	
	public void save(User user);
	
	public void modify(User user);
	
	public void delete(int userId);
}
