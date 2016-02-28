package com.niit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Exam6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*******************SQL批处理**********************/
		try {
			//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//获取连接
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
			//创建处理器
			Statement stmt = con.createStatement();
			//创建SQL语句
			String sql1 = "insert into student(stuname,age) values('john',28)";
			String sql2 = "update emp set salary=24000 where employee_id=100";
			//添加批处理语句
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			//批处理执行
			stmt.executeBatch();
			//关闭
			stmt.close();
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
