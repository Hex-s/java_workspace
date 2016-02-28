package com.niit.test;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.niit.dao.impl.DepartmentDao;
import com.niit.dao.impl.EmployeeDao;
import com.niit.dao.impl.JobDao;
import com.niit.dao.impl.UserDao;
import com.niit.entity.Employee;
import com.niit.entity.Job;
import com.niit.entity.User;

public class DaoTest {
	
	public static void main(String[] args) {
		
//		UserDao userDao = new UserDao();
//		
//		User user = userDao.findUserByName("Admin");
//		if(user != null){
//			System.out.println(user.getUserName());
//		}
//		else{
//			System.out.println("没有用户");
//		}
//		System.out.println();
		
		EmployeeDao empDao = new EmployeeDao();
		Employee emp = empDao.findEmpByEmpId(200);
		System.out.println(emp.getEmpName());
		
		emp.setSalary(100);
		empDao.modifyEmp(emp);
		
//		ArrayList<Employee> emps= empDao.findAll();
//		System.out.println(emps.get(0).getEmpName());
		
//		String name = empDao.findEmpNameByManagerId(100);
//		System.out.println(name);
		
//		empDao.deleteEmp(206);
		
//		JobDao jobDao = new JobDao();
//		String jobName = jobDao.findJobNameByJobId("AD_PRES");
//		String jobId = jobDao.findJobIdByJobName("President");
//		System.out.println(jobName);
//		System.out.println(jobId);
//		
//		DepartmentDao depDao = new DepartmentDao();
//		String depName = depDao.findDepNameByDepId(20);
//		int depId = depDao.findDepIdByDepName("Marketing");
//		System.out.println(depName);
//		System.out.println(depId);
		
//		JobDao jobDao = new JobDao();
//		ArrayList<Job> all = jobDao.findAllJob();
//		System.out.println(all.size());
//		
		
		
		
	}
}
