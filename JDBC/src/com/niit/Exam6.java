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
		
		/*******************SQL������**********************/
		try {
			//��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��ȡ����
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
			//����������
			Statement stmt = con.createStatement();
			//����SQL���
			String sql1 = "insert into student(stuname,age) values('john',28)";
			String sql2 = "update emp set salary=24000 where employee_id=100";
			//������������
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			//������ִ��
			stmt.executeBatch();
			//�ر�
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
