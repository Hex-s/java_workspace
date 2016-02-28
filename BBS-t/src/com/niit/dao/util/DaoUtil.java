package com.niit.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * DAO�����࣬��װ�����ݿ����ӵĻ�ȡ�����ݿ����Ĺرշ���
 * @author Administrator
 *
 */
public class DaoUtil {
//	private static String driver;
//	private static String url;
//	private static String user;
//	private static String pwd;
	private static Context ctx;
	private static DataSource dataSource;
//	private static ComboPooledDataSource comboSource;
	/**
	 * ��̬��
	 */
	static{
//		//������Դ�ļ���ȡ��
//		ResourceBundle bundle = ResourceBundle.getBundle("DBConfig");
//		//��ȡ��Դ�ļ�����Ϣ
//		driver = bundle.getString("driver");
//		url = bundle.getString("url");
//		user = bundle.getString("user");
//		pwd = bundle.getString("pwd");
		
		try {
			ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/source");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//comboSource = new ComboPooledDataSource();
	}
	/**
	 * ��ȡ����
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection getConnection(){
		Connection con = null;
		
		//ͨ��JNDI���ݳػ�ȡ���Ӷ���
		if(dataSource != null){
			try {
				con = dataSource.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//ʹ��C3P0��ȡ����
//		try {
//			con = comboSource.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			//��������
//			Class.forName(driver);
//			//��ȡ����
//			con = DriverManager.getConnection(url,user,pwd);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
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
