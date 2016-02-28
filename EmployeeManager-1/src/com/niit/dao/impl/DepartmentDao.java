package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.niit.dao.iface.IDepartmentDao;
import com.niit.util.DaoUtil;

public class DepartmentDao implements IDepartmentDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public String findDepNameByDepId(int depID) {
		String depName = "";
		//��ȡ����
		con = DaoUtil.getConnection();
		try {
			pstmt = con.prepareStatement("select department_name from deps where department_id=?");
			//ע�����
			pstmt.setInt(1, depID);
			//ִ�в�ѯ
			rs = pstmt.executeQuery();
			while(rs.next()){
				depName = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoUtil.closeAll(con, pstmt, rs);
		}
		
		return depName;
	}

	@Override
	public int findDepIdByDepName(String depName) {
		int depId = -1;
		//��ȡ����
		con = DaoUtil.getConnection();
		try {
			pstmt = con.prepareStatement("select department_id from deps where department_name=?");
			//ע�����
			pstmt.setString(1, depName);
			//ִ�в�ѯ
			rs = pstmt.executeQuery();
			while(rs.next()){
				depId = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoUtil.closeAll(con, pstmt, rs);
		}
		
		return depId;
	}
	

}
