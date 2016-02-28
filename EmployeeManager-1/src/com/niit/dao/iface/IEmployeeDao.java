package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Employee;

public interface IEmployeeDao {
	/**
	 * ��������Ա����Ϣ
	 * @return
	 */
	public ArrayList<Employee> findAll();
	
	/**
	 * ����Ա����Ų�ѯԱ������
	 * @param managerId
	 * @return
	 */
	public String findEmpNameByEmpId(int empId);
	
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
	
	/**
	 * ����Ա����Ų���Ա����Ϣ
	 * @param empid
	 * @return
	 */
	public Employee findEmpByEmpId(int empid);
}
