package com.niit.test;

import java.util.ArrayList;

import com.niit.dao.impl.DepartmentDao;
import com.niit.dao.impl.EmployeeDao;
import com.niit.dao.impl.JobDao;
import com.niit.entity.Department;
import com.niit.entity.Employee;
import com.niit.entity.Job;

public class DaoTest {
	
	public static void main(String[] args) {
		
//		JobDao jobDao = new JobDao();
//		Job job = jobDao.findJobTitleByJobId("AD_VP");
//		System.out.println(job.getJob_title());
		
		DepartmentDao departmentDao = new DepartmentDao();
//		Department dep = departmentDao.findDepartmentById(120);
//		System.out.println(dep.getManager_id());
		
		ArrayList<Department> list = departmentDao.findAllDepartment();
		for(Department dep : list){
			System.out.println(dep.getDepartment_id());
			System.out.println(dep.getDepartment_name());
		}
		
//		EmployeeDao employeeDao = new EmployeeDao();
//		Employee emp = employeeDao.findEmployeeById(100);
//		System.out.println(emp.getEmp_name());
//		System.out.println(emp.getSalary());
//		System.out.println(emp.getHire_date());
//		System.out.println(emp.getJob_id());
//		System.out.println(emp.getDep_id());
		
//		ArrayList<Employee> list = employeeDao.findEmployeeListByDepId(90);
//		for(Employee emp : list){
//			System.out.println(emp.getEmp_name());
//		}
	}

}
