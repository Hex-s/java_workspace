package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Employee;

public interface IEmployeeDao {
	/**
	 * 查找所有员工信息
	 * @return
	 */
	public ArrayList<Employee> findAll();
	
	/**
	 * 根据员工编号查询员工姓名
	 * @param managerId
	 * @return
	 */
	public String findEmpNameByEmpId(int empId);
	
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
	
	/**
	 * 根据员工编号查找员工信息
	 * @param empid
	 * @return
	 */
	public Employee findEmpByEmpId(int empid);
}
