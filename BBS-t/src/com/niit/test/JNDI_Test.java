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
			//创建目录检索的上下文对象
			Context ctx = new InitialContext();
			//基于目录名称进行远程资源对象的访问,获取创建于tomcat的连接池对象
			DataSource dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/source");
			Connection con = dataSource.getConnection();
			System.out.println("连接获取成功");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
