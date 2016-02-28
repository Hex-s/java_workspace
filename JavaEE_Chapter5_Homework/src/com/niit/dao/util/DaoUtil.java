package com.niit.dao.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * DAO�����࣬��װ�����ݿ����ӵĻ�ȡ�����ݿ����Ĺرշ���
 * @author Administrator
 *
 */
public class DaoUtil {
	private static ComboPooledDataSource comboSource;
	/**
	 * ��̬��
	 */
	static{
		comboSource = new ComboPooledDataSource();
	}
	
	/**
	 * ��ȡ����
	 * @return
	 */
	public static Connection getConnection(){
		Connection con = null;
		//ʹ��C3P0��ȡ����
		try {
			con = comboSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * �ر����ݿ����
	 * @param con
	 * @param stmt
	 * @param rs
	 * @throws SQLException 
	 */
	public static void closeAll(Connection con, Statement stmt, ResultSet rs){
		try {
			//�ж����ݿ�����Ƿ�Ϊ��
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
