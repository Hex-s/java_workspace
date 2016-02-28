package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IDepartmentDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entity.Department;

public class DepartmentDao implements IDepartmentDao{

	/**
	 * 根据部门编号查找部门
	 */
	public Department findDepartmentById(int depId) {
		ArrayList<Department> list = DaoHandle.executeQuery("select * from deps where department_id=?", new Object[]{depId}, Department.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 查询所有的部门
	 */
	public ArrayList<Department> findAllDepartment() {
		ArrayList<Department> list = DaoHandle.executeQuery("select * from deps", null, Department.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

}
