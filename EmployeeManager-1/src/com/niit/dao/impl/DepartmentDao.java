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
		//获取连接
		con = DaoUtil.getConnection();
		try {
			pstmt = con.prepareStatement("select department_name from deps where department_id=?");
			//注入参数
			pstmt.setInt(1, depID);
			//执行查询
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
		//获取连接
		con = DaoUtil.getConnection();
		try {
			pstmt = con.prepareStatement("select department_id from deps where department_name=?");
			//注入参数
			pstmt.setString(1, depName);
			//执行查询
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
