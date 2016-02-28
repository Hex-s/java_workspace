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
	 * ͨ����������Ա���ı�ţ���ѯԱ����������нˮ����ְʱ������ڲ�������
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try {
			//��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��ȡ����
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl","system","niit");
			//����������
			Statement stmt = con.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("������Ա���ı�ţ�");
			int empId = sc.nextInt();
			//����SQL���
			String sql = "select first_name||last_name,salary,hire_date,department_id from emp where employee_id="+empId;
			//ִ��SQL���
			ResultSet rs = stmt.executeQuery(sql);
			int depId = -1;
			//��ȡ�����
			while(rs.next()){
				//��ȡ���е�ÿһ��
				String empName = rs.getString(1);
				double salary = rs.getDouble(2);
				Date hireDate = rs.getDate(3);
				depId = rs.getInt(4);
				System.out.print(empName+"\t"+salary+"\t"+hireDate+"\t");
				//��Ҫ��resultset��ȡ�����ж����»�ȡ�µĽ����
			}
			rs.close();
			//����SQL���
			sql = "select department_name from dep where department_id="+depId;
			//ִ��SQL���
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
