package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Employee;

public interface IEmployeeDao {
	
	/**
	 * ����Ա����Ų���Ա��
	 * @param empId
	 * @return
	 */
	public Employee findEmployeeById(int empId);
	
	/**
	 * ���ݲ��ű�Ų��Ҹò����µ�����Ա��
	 * @param depId
	 * @return
	 */
	public ArrayList<Employee> findEmployeeListByDepId(int depId);

}
