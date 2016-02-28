package com.niit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

public class Exam1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//通过驱动管理器获取数据库连接对象
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
			//System.out.println(con);
			System.out.println("数据库连接成功！");
			//通过连接对象创建处理器对象
			Statement stmt = con.createStatement();
			
			/*******************增删改操作*********************/
			//定义SQL语句
			//String sql = "delete from student where stuid=34";
//			String sql = "insert into student(stuid,stuname,birthday) values(34,'A',sysdate)";
//			//executeUpdate执行增删改操作,返回受影响的行数
//			int count = stmt.executeUpdate(sql);
//			if(count == 1){
//				System.out.println("删除成功");
//			}
//			else{
//				System.out.println("删除失败");
//			}
			
			
			/********************** 查询数据************************/
			String sql = "select stuname as sname,stuid,birthday from student";
			//executeQuery执行查询，返回ResultSet结果集
			ResultSet rs = stmt.executeQuery(sql);
			//循环读取结果集的每一行数据
			//next方法表示读取下一行数据，并判断数据是否存在
			while(rs.next()){
				/************通过列索引查询，索引从1开始，列的顺序取决于查询后结果集的顺序***************/
				//通过getXXX方法获取行中的每一个列，调用取决于数据列的类型
//				String stuName = rs.getString(1);
//				int stuId = rs.getInt(2);
//				//getDate返回java.sql.Date 该类型只包含年月日信息
//				//Date birthday = rs.getDate(3);
//				//如果时间需要包含时分秒则使用getTimestamp方法
//				Timestamp birthday = rs.getTimestamp(3);
//				System.out.println(stuId+"\t"+stuName+"\t"+birthday);
				
				/*******************通过列名查询,列的名称取决于查询结果中的列名********************/
				int stuId = rs.getInt("stuId");
				String stuName = rs.getString("sname");
				Timestamp birthday = rs.getTimestamp("birthday");
				System.out.println(stuId+"\t"+stuName+"\t"+birthday);
			}
			
			//关闭数据库对象
			//rs.close();
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
