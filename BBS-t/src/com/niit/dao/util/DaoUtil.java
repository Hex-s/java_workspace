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
 * DAO工具类，封装了数据库连接的获取和数据库对象的关闭方法
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
	 * 静态块
	 */
	static{
//		//创建资源文件读取器
//		ResourceBundle bundle = ResourceBundle.getBundle("DBConfig");
//		//获取资源文件的信息
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
	 * 获取连接
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection getConnection(){
		Connection con = null;
		
		//通过JNDI数据池获取连接对象
		if(dataSource != null){
			try {
				con = dataSource.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//使用C3P0获取连接
//		try {
//			con = comboSource.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			//加载驱动
//			Class.forName(driver);
//			//获取连接
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
