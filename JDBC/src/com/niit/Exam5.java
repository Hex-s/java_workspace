package com.niit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exam5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/***************事务控制****************/
		try {
			//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//获取连接
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
			//默认情况下JDBC的事务操作是在execute语句后自动实现提交
			//因此实现JDBC的手动事务就需要禁用自动事务提交
			con.setAutoCommit(false);
			String sql = "update emp set salary=20000 where employee_id=100";
			//创建预处理器
			PreparedStatement pstmt = con.prepareStatement(sql);
			//执行修改
			int count = pstmt.executeUpdate();
			if(count == 1){
				//手动提交事务
				con.commit();
			}
			else{
				con.rollback();
			}
			//关闭对象
			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
