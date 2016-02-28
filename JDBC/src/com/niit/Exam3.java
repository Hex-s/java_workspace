package com.niit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.crypto.spec.PSource;

public class Exam3 {

	/**
	 * 通过键盘输入学生的姓名，性别，年龄，电话，邮箱，对信息进行录入保存
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//获取连接
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl","system","niit");
			//创建处理器
			//Statement stmt = con.createStatement();
			
			
			//预处理器的优点：
			//1.SQL语句安全可靠
			//2.简化的参数注入，使用更方便
			//3.预先编译SQL语句，可以一次编译多次执行
			//创建预处理器
			//使用?进行参数的占位
			String sql = "insert into student(stuname,sex,age,tel,email) values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入姓名：");
			String stuName = sc.next();
			System.out.println("请输入性别：");
			String sex = sc.next();
			System.out.println("请输入年龄：");
			int age = sc.nextInt();
			System.out.println("请输入电话：");
			String tel = sc.next();
			System.out.println("请输入邮箱：");
			String email = sc.next();
			
			//注入参数
			pstmt.setString(1, stuName);
			pstmt.setString(2, sex);
			pstmt.setInt(3, age);
			pstmt.setString(4, tel);
			pstmt.setString(5, email);
			//执行
			boolean flag = pstmt.executeUpdate() == 1;
			if(flag){
				System.out.println("新增成功");
			}
			else{
				System.out.println("新增失败");
			}
			
			//定义SQL语句
			//String sql = "insert into student(stuname,sex,age,tel,email) values('"+stuName+"','"+sex+"',"+age+",'"+tel+"','"+email+"')";
			//执行
			//boolean flag = stmt.executeUpdate(sql) == 1;
			//关闭
			//stmt.close();
//			con.close();
//			if(flag){
//				System.out.println("新增成功");
//			}
//			else{
//				System.out.println("新增失败");
//			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
