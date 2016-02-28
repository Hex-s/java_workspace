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
		
		/***************�������****************/
		try {
			//��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��ȡ����
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
			//Ĭ�������JDBC�������������execute�����Զ�ʵ���ύ
			//���ʵ��JDBC���ֶ��������Ҫ�����Զ������ύ
			con.setAutoCommit(false);
			String sql = "update emp set salary=20000 where employee_id=100";
			//����Ԥ������
			PreparedStatement pstmt = con.prepareStatement(sql);
			//ִ���޸�
			int count = pstmt.executeUpdate();
			if(count == 1){
				//�ֶ��ύ����
				con.commit();
			}
			else{
				con.rollback();
			}
			//�رն���
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
