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
	 * ͨ����������ѧ�����������Ա����䣬�绰�����䣬����Ϣ����¼�뱣��
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			//��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��ȡ����
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl","system","niit");
			//����������
			//Statement stmt = con.createStatement();
			
			
			//Ԥ���������ŵ㣺
			//1.SQL��䰲ȫ�ɿ�
			//2.�򻯵Ĳ���ע�룬ʹ�ø�����
			//3.Ԥ�ȱ���SQL��䣬����һ�α�����ִ��
			//����Ԥ������
			//ʹ��?���в�����ռλ
			String sql = "insert into student(stuname,sex,age,tel,email) values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("������������");
			String stuName = sc.next();
			System.out.println("�������Ա�");
			String sex = sc.next();
			System.out.println("���������䣺");
			int age = sc.nextInt();
			System.out.println("������绰��");
			String tel = sc.next();
			System.out.println("���������䣺");
			String email = sc.next();
			
			//ע�����
			pstmt.setString(1, stuName);
			pstmt.setString(2, sex);
			pstmt.setInt(3, age);
			pstmt.setString(4, tel);
			pstmt.setString(5, email);
			//ִ��
			boolean flag = pstmt.executeUpdate() == 1;
			if(flag){
				System.out.println("�����ɹ�");
			}
			else{
				System.out.println("����ʧ��");
			}
			
			//����SQL���
			//String sql = "insert into student(stuname,sex,age,tel,email) values('"+stuName+"','"+sex+"',"+age+",'"+tel+"','"+email+"')";
			//ִ��
			//boolean flag = stmt.executeUpdate(sql) == 1;
			//�ر�
			//stmt.close();
//			con.close();
//			if(flag){
//				System.out.println("�����ɹ�");
//			}
//			else{
//				System.out.println("����ʧ��");
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
