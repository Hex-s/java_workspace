package com.niit.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0_test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection con;
		try {
			con = dataSource.getConnection();
			System.out.println("连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
