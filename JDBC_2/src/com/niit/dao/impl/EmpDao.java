package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.entity.Employee;
import com.niit.util.DaoHandle;

public class EmpDao {

	public ArrayList<Employee> findAll(){
		String sql = "select employee_id as empId,first_name||last_name as empName,hire_date as hireDate from emp";
		ArrayList<Employee> list = DaoHandle.executeQuery(sql, null, Employee.class);
		return list;
	}
}
