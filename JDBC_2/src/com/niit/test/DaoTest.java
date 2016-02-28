package com.niit.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.niit.dao.impl.EmpDao;
import com.niit.dao.impl.UserDao;
import com.niit.entity.Employee;
import com.niit.entity.User;
import com.niit.util.DaoHandle;

public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		
//		userDao.save(new User(2, "jack", "jack123", new Timestamp(new Date().getTime())));
		
//		User user = new User();
//		user.setUserId(1);
//		user.setUserPwd("0000");
//		userDao.modify(user);
		
//		userDao.delete(1);
		
//		DaoHandle.executeQuery("select * from emp", null, User.class);
		
//		ArrayList<User> list = userDao.findAll();
//		for(User u : list){
//			System.out.println(u.getUserName()+"\t"+u.getUserPwd());
//		}
		
//		EmpDao empDao = new EmpDao();
//		ArrayList<Employee> list = empDao.findAll();
//		for(Employee emp : list){
//			System.out.println(emp.getEmpId()+"\t"+emp.getEmpName()+"\t"+emp.getHireDate());
//		}
		
		User user = userDao.findById(2);
		if(user != null){
			System.out.println(user.getUserName()+"\t"+user.getRegTime());
		}
	}
	
	

}
