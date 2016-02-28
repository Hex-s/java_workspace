package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.niit.dao.iface.IEmpDao;
import com.niit.entity.Employee;
import com.niit.util.DaoUtil;

public class EmpDao implements IEmpDao {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public void deleteEmp(int empId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmpByManagerId(int managerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyEmp(Employee emp) {
		//获取连接
		con = DaoUtil.getConnection();
		try {
			//获取处理器
			pstmt = con.prepareStatement("update emp set salary=?,job_id=? where employee_id=?");
			//注入参数
			pstmt.setDouble(1, emp.getSalary());
			pstmt.setString(2, emp.getJobId());
			pstmt.setInt(3, emp.getEmpId());
			//执行
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//关闭对象
			DaoUtil.closeAll(con, pstmt, null);
		}
	}

}
