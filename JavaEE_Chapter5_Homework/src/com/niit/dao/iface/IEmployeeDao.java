package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Employee;

public interface IEmployeeDao {
	
	/**
	 * 根据员工编号查找员工
	 * @param empId
	 * @return
	 */
	public Employee findEmployeeById(int empId);
	
	/**
	 * 根据部门编号查找该部门下的所有员工
	 * @param depId
	 * @return
	 */
	public ArrayList<Employee> findEmployeeListByDepId(int depId);

}
