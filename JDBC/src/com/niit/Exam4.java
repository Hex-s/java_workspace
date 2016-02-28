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
		
		/************************������������Ĵ洢���̵ĵ���*************************/
//		try {
//			//��������
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			//��ȡ����
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
//			//ִ�д洢���̵Ĵ�����CallableStatement
//			CallableStatement cstmt = con.prepareCall("{call p_modify_salary(?,?)}");
//			//ע�����
//			cstmt.setInt(1, 103);
//			cstmt.setDouble(2, 10000);
//			//ִ��
//			cstmt.execute();
//			//�رն���
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
		
		/************************���е�����������Ĵ洢���̵ĵ���*************************/
//		try {
//			//��������
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			//��ȡ����
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
//			//����������
//			//���۲�������������������������ʹ�ã�ռλ
//			CallableStatement cstmt = con.prepareCall("{call p_findname(?,?)}");
//			//ע�����������ֵ
//			cstmt.setInt(1, 103);
//			//ע���������
//			cstmt.registerOutParameter(2, OracleTypes.VARCHAR);
//			//ִ�д洢����
//			cstmt.execute();
//			//��ȡ�������
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
		
		
		/************************�������Ϊ�α�Ĵ洢���̵ĵ���*************************/
		try {
			//��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��ȡ����
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
			//��ȡ������
			CallableStatement cstmt = con.prepareCall("{call p_findemps(?,?)}");
			//ע���������
			cstmt.setInt(1, 100);
			//ע���������
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			//ִ��
			cstmt.execute();
			//��ȡ���������ֵ,�������������α꣬����Ҫ�����ResultSet
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			while(rs.next()){
				String empName = rs.getString(1);
				Date date = rs.getDate(2);
				double salary = rs.getDouble(3);
				System.out.println(empName+"\t"+date+"\t"+salary);
			}
			//�ر�
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
