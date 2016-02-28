package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.niit.dao.iface.IEmployeeDao;
import com.niit.entity.Employee;
import com.niit.util.DaoUtil;

public class EmployeeDao implements IEmployeeDao{
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private JobDao jobDao;
	private DepartmentDao depDao;
	private EmployeeDao empDao;
	/**
	 * ��������Ա����Ϣ
	 * @return
	 */
	@Override
	public ArrayList<Employee> findAll() {
		ArrayList<Employee> emps = new ArrayList<Employee>();
		Employee emp = null;
		//��ȡ����
		con = DaoUtil.getConnection();
		try {
			//��ȡ������
			pstmt = con.prepareStatement("select emp_id,emp_name,salary,hire_date,(select department_name from deps where deps.department_id=employees.dep_id),(select emp_name from employees e where e.emp_id=employees.manager_id) from employees;");
			//ִ�в�ѯ
			rs = pstmt.executeQuery();
			while(rs.next()){
				emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				emp.setHireDate(rs.getDate(4));
				emp.setJobName(rs.getString(5));
				emp.setDepName(rs.getString(6));
				emp.setMagName(rs.getString(7));
				emps.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoUtil.closeAll(con, pstmt, rs);
		}
		
		
		return emps;
	}

	
	/**
	 * ����Ա����Ų�ѯԱ������
	 * @param managerId
	 * @return
	 */
	@Override
	public String findEmpNameByEmpId(int empId) {
		
		String name = "";
		//��ȡ����
		con = DaoUtil.getConnection();
		try {
			//��ȡ������
			pstmt = con.prepareStatement("select emp_name from employees where emp_id=?");
			//ע�����
			pstmt.setInt(1, empId);
			//ִ�в�ѯ����
			rs = pstmt.executeQuery();
			while(rs.next()){
				name = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoUtil.closeAll(con, pstmt, rs);
		}
		return name;
	}

	/**
	 * �޸�Ա����Ϣ
	 * @param emp
	 */
	@Override
	public void modifyEmp(Employee emp) {
		con = DaoUtil.getConnection();
		jobDao = new JobDao();
		try {
			pstmt = con.prepareStatement("update employees set salary=?,job_id=? where emp_id=?");
			pstmt.setDouble(1,emp.getSalary());
			String jobName = jobDao.findJobIdByJobName(emp.getJobName());
			pstmt.setString(2, jobName);
			pstmt.setInt(3, emp.getEmpId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoUtil.closeAll(con, pstmt, null);
		}
		
	}

	/**
	 * ɾ��Ա����Ϣ
	 * @param emp
	 */
	@Override
	public void deleteEmp(int empId) {
		//��ȡ����
		con = DaoUtil.getConnection();
		
		try {
			//��ȡ������
			pstmt = con.prepareStatement("delete from employees where emp_id=?");
			//ע�����
			pstmt.setInt(1, empId);
			//ִ��
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoUtil.closeAll(con, pstmt, null);
		}
		
	}


	/**
	 * ����Ա����Ų���Ա����Ϣ
	 */
	@Override
	public Employee findEmpByEmpId(int empid) {
		Employee emp = null;
		//��ȡ����
		con = DaoUtil.getConnection();
		jobDao = new JobDao();
		depDao = new DepartmentDao();
		empDao = new EmployeeDao();
		try {
			//��ȡ������
			pstmt = con.prepareStatement("select emp_id,emp_name,salary,hire_date,(select department_name from deps where deps.department_id=employees.dep_id),(select emp_name from employees e where e.emp_id=employees.manager_id) from employees where emp_id=?");
			//ע�����
			pstmt.setInt(1, empid);
			//ִ�в�ѯ
			rs = pstmt.executeQuery();
			while(rs.next()){
				emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				emp.setHireDate(rs.getDate(4));
				emp.setJobName(rs.getString(5));
				emp.setDepName(rs.getString(6));
				emp.setMagName(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoUtil.closeAll(con, pstmt, rs);
		}
		
		return emp;
	}

}
