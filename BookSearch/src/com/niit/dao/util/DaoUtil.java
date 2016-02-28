package com.niit.dao.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * DAO工具类，封装了数据库连接的获取和数据库对象的关闭方法
 * @author Administrator
 *
 */
public class DaoUtil {
	private static ComboPooledDataSource comboSource;
	/**
	 * 静态块
	 */
	static{
		comboSource = new ComboPooledDataSource();
	}
	
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection con = null;
		//使用C3P0获取连接
		try {
			con = comboSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * 关闭数据库对象
	 * @param con
	 * @param stmt
	 * @param rs
	 * @throws SQLException 
	 */
	public static void closeAll(Connection con, Statement stmt, ResultSet rs){
		try {
			//判断数据库对象是否为空
			if(rs != null){
				rs.close();
				rs = null;
			}
			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(con != null){
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
