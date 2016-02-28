package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Department;

public interface IDepartmentDao {
	
	/**
	 * ���ݲ��ű�Ų��Ҳ���
	 * @param depId
	 * @return
	 */
	public Department findDepartmentById(int depId);
	
	
	/**
	 * ��ѯ���еĲ���
	 * @return
	 */
	public ArrayList<Department> findAllDepartment();
}
