package com.niit;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleTypes;

public class Exam7 {

	public static void main(String[] args) {
		
		/*********************结果集元数据的访问***********************/
		try {
			//加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//获取连接
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
			//获取处理器
			PreparedStatement pstmt = con.prepareStatement("select * from emp");
			//执行查询
			ResultSet rs = pstmt.executeQuery();
			
//			while(rs.next()){
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(4));
//				//clob可以直接通过getString方法访问
//				//System.out.println(rs.getString(9));
//				Clob clob = rs.getClob(9);
//				if(clob != null){
//					//获取clob的输入流
//					BufferedReader reader = new BufferedReader(clob.getCharacterStream());
//					String s;
//					String str = "";
//					
//					while((s = reader.readLine()) != null){
//						str+=s;
//					}
//					reader.close();
//					System.out.println(str);
//				}	
//			}
			//获取元数据，元数据可以获取结果集的列的数量，列的名称，以及列的数据类型
			ResultSetMetaData metaData = rs.getMetaData();
			//获取列的数量
			int colNum = metaData.getColumnCount();
			System.out.println(colNum);
			//循环所有的列
			for(int i = 1; i <= colNum; i++){
				//获取列的名称
				System.out.print(metaData.getColumnName(i));
				//获取列的数据类型
				System.out.println(metaData.getColumnType(i));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("数据库字段的数据类型：");
		System.out.println(OracleTypes.TIMESTAMP);
	}
}
