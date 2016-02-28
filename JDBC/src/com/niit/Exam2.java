package com.niit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Exam2 {

	/**
	 * 通过键盘输入员工的编号，查询员工的姓名，薪水，入职时间和所在部门名称
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try {
			//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//获取连接
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl","system","niit");
			//创建处理器
			Statement stmt = con.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入员工的编号：");
			int empId = sc.nextInt();
			//定义SQL语句
			String sql = "select first_name||last_name,salary,hire_date,department_id from emp where employee_id="+empId;
			//执行SQL语句
			ResultSet rs = stmt.executeQuery(sql);
			int depId = -1;
			//读取结果集
			while(rs.next()){
				//获取行中的每一列
				String empName = rs.getString(1);
				double salary = rs.getDouble(2);
				Date hireDate = rs.getDate(3);
				depId = rs.getInt(4);
				System.out.print(empName+"\t"+salary+"\t"+hireDate+"\t");
				//不要在resultset读取过程中对重新获取新的结果集
			}
			rs.close();
			//定义SQL语句
			sql = "select department_name from dep where department_id="+depId;
			//执行SQL语句
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String depName = rs.getString(1);
				System.out.println(depName);
			}
		
			
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
