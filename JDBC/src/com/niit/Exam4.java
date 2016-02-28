package com.niit;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import oracle.jdbc.driver.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class Exam4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/************************带有输入参数的存储过程的调用*************************/
//		try {
//			//加载驱动
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			//获取连接
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
//			//执行存储过程的处理器CallableStatement
//			CallableStatement cstmt = con.prepareCall("{call p_modify_salary(?,?)}");
//			//注入参数
//			cstmt.setInt(1, 103);
//			cstmt.setDouble(2, 10000);
//			//执行
//			cstmt.execute();
//			//关闭对象
//			cstmt.close();
//			con.close();
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/************************带有单行输出参数的存储过程的调用*************************/
//		try {
//			//加载驱动
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			//获取连接
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
//			//创建处理器
//			//无论参数是输入参数还是输出参数都使用？占位
//			CallableStatement cstmt = con.prepareCall("{call p_findname(?,?)}");
//			//注入输入参数的值
//			cstmt.setInt(1, 103);
//			//注册输出参数
//			cstmt.registerOutParameter(2, OracleTypes.VARCHAR);
//			//执行存储过程
//			cstmt.execute();
//			//获取输出参数
//			String empName = cstmt.getString(2);
//			System.out.println(empName);
//			cstmt.close();
//			con.close();
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		/************************输出参数为游标的存储过程的调用*************************/
		try {
			//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//获取连接
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
			//获取处理器
			CallableStatement cstmt = con.prepareCall("{call p_findemps(?,?)}");
			//注入输入参数
			cstmt.setInt(1, 100);
			//注册输出参数
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			//执行
			cstmt.execute();
			//获取输出参数的值,如果输出参数是游标，则需要拆箱成ResultSet
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			while(rs.next()){
				String empName = rs.getString(1);
				Date date = rs.getDate(2);
				double salary = rs.getDouble(3);
				System.out.println(empName+"\t"+date+"\t"+salary);
			}
			//关闭
			cstmt.close();
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
