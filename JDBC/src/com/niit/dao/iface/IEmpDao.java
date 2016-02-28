package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Employee;

public interface IEmpDao {
	
	/**
	 * 查找所有员工信息
	 * @return
	 */
	public ArrayList<Employee> findAll();
	
	/**
	 * 根据经理编号查询员工信息
	 * @param managerId
	 * @return
	 */
	public Employee findEmpByManagerId(int managerId);
	
	/**
	 * 修改员工信息
	 * @param emp
	 */
	public void modifyEmp(Employee emp);
	
	/**
	 * 根据编号删除员工
	 * @param empId
	 */
	public void deleteEmp(int empId);
}
