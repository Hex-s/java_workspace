package com.niit.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JNDI_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//����Ŀ¼�����������Ķ���
			Context ctx = new InitialContext();
			//����Ŀ¼���ƽ���Զ����Դ����ķ���,��ȡ������tomcat�����ӳض���
			DataSource dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/source");
			Connection con = dataSource.getConnection();
			System.out.println("���ӻ�ȡ�ɹ�");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
