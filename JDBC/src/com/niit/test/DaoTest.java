package com.niit.test;

import com.niit.dao.impl.EmpDao;
import com.niit.dao.impl.UserDao;
import com.niit.entity.Employee;
import com.niit.entity.User;

public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		UserDao userDao = new UserDao();
//		User user = userDao.findUserByName("admin");
//		if(user != null){
//			System.out.println(user.getUserPwd()+"\t"+user.getRegTime());
//		}
//		else{
//			System.out.println("û�и��û���Ϣ��");
//		}
		
		EmpDao empDao = new EmpDao();
		Employee emp = new Employee();
		emp.setEmpId(103);
		emp.setSalary(13000);
		emp.setJobId("FI_MGR");
		//ִ���޸�
		empDao.modifyEmp(emp);
	}

}
