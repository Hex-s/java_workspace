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
		
		/*********************�����Ԫ���ݵķ���***********************/
		try {
			//��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��ȡ����
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.100:1521:orcl", "system", "niit");
			//��ȡ������
			PreparedStatement pstmt = con.prepareStatement("select * from emp");
			//ִ�в�ѯ
			ResultSet rs = pstmt.executeQuery();
			
//			while(rs.next()){
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(4));
//				//clob����ֱ��ͨ��getString��������
//				//System.out.println(rs.getString(9));
//				Clob clob = rs.getClob(9);
//				if(clob != null){
//					//��ȡclob��������
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
			//��ȡԪ���ݣ�Ԫ���ݿ��Ի�ȡ��������е��������е����ƣ��Լ��е���������
			ResultSetMetaData metaData = rs.getMetaData();
			//��ȡ�е�����
			int colNum = metaData.getColumnCount();
			System.out.println(colNum);
			//ѭ�����е���
			for(int i = 1; i <= colNum; i++){
				//��ȡ�е�����
				System.out.print(metaData.getColumnName(i));
				//��ȡ�е���������
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
		System.out.println("���ݿ��ֶε��������ͣ�");
		System.out.println(OracleTypes.TIMESTAMP);
	}
}
