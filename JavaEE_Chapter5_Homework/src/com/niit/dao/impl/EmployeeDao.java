package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IEmployeeDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entity.Employee;

public class EmployeeDao implements IEmployeeDao{

	/**
	 * ����Ա����Ų���Ա��
	 */
	public Employee findEmployeeById(int empId) {
		ArrayList<Employee> list = DaoHandle.executeQuery("select * from employees where emp_id=?", new Object[]{empId}, Employee.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * ���ݲ��ű�Ų��Ҹò����µ�����Ա��
	 */
	public ArrayList<Employee> findEmployeeListByDepId(int depId) {
		ArrayList<Employee> list = DaoHandle.executeQuery("select * from employees where dep_id=?",new Object[]{depId}, Employee.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

}
