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
			//��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//ͨ��������������ȡ���ݿ����Ӷ���
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
			//System.out.println(con);
			System.out.println("���ݿ����ӳɹ���");
			//ͨ�����Ӷ��󴴽�����������
			Statement stmt = con.createStatement();
			
			/*******************��ɾ�Ĳ���*********************/
			//����SQL���
			//String sql = "delete from student where stuid=34";
//			String sql = "insert into student(stuid,stuname,birthday) values(34,'A',sysdate)";
//			//executeUpdateִ����ɾ�Ĳ���,������Ӱ�������
//			int count = stmt.executeUpdate(sql);
//			if(count == 1){
//				System.out.println("ɾ���ɹ�");
//			}
//			else{
//				System.out.println("ɾ��ʧ��");
//			}
			
			
			/********************** ��ѯ����************************/
			String sql = "select stuname as sname,stuid,birthday from student";
			//executeQueryִ�в�ѯ������ResultSet�����
			ResultSet rs = stmt.executeQuery(sql);
			//ѭ����ȡ�������ÿһ������
			//next������ʾ��ȡ��һ�����ݣ����ж������Ƿ����
			while(rs.next()){
				/************ͨ����������ѯ��������1��ʼ���е�˳��ȡ���ڲ�ѯ��������˳��***************/
				//ͨ��getXXX������ȡ���е�ÿһ���У�����ȡ���������е�����
//				String stuName = rs.getString(1);
//				int stuId = rs.getInt(2);
//				//getDate����java.sql.Date ������ֻ������������Ϣ
//				//Date birthday = rs.getDate(3);
//				//���ʱ����Ҫ����ʱ������ʹ��getTimestamp����
//				Timestamp birthday = rs.getTimestamp(3);
//				System.out.println(stuId+"\t"+stuName+"\t"+birthday);
				
				/*******************ͨ��������ѯ,�е�����ȡ���ڲ�ѯ����е�����********************/
				int stuId = rs.getInt("stuId");
				String stuName = rs.getString("sname");
				Timestamp birthday = rs.getTimestamp("birthday");
				System.out.println(stuId+"\t"+stuName+"\t"+birthday);
			}
			
			//�ر����ݿ����
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
