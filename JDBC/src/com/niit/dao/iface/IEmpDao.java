package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Employee;

public interface IEmpDao {
	
	/**
	 * ��������Ա����Ϣ
	 * @return
	 */
	public ArrayList<Employee> findAll();
	
	/**
	 * ���ݾ����Ų�ѯԱ����Ϣ
	 * @param managerId
	 * @return
	 */
	public Employee findEmpByManagerId(int managerId);
	
	/**
	 * �޸�Ա����Ϣ
	 * @param emp
	 */
	public void modifyEmp(Employee emp);
	
	/**
	 * ���ݱ��ɾ��Ա��
	 * @param empId
	 */
	public void deleteEmp(int empId);
}
