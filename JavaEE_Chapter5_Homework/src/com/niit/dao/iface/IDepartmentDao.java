package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Department;

public interface IDepartmentDao {
	
	/**
	 * 根据部门编号查找部门
	 * @param depId
	 * @return
	 */
	public Department findDepartmentById(int depId);
	
	
	/**
	 * 查询所有的部门
	 * @return
	 */
	public ArrayList<Department> findAllDepartment();
}
