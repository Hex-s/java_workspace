package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.niit.dao.iface.IUserDao;
import com.niit.entity.User;
import com.niit.util.DaoUtil;

public class UserDao implements IUserDao {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public User findUserByName(String userName) {
		User user = null;
		//��ȡ����
		con = DaoUtil.getConnection();
		try {
			//��ȡ������
			pstmt = con.prepareStatement("select * from users where username=?");
			//ע�����
			pstmt.setString(1, userName);
			//ִ�в�ѯ
			rs = pstmt.executeQuery();
			//��ȡ��ѯ�Ľ��
			while(rs.next()){
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPwd(rs.getString(3));
				user.setRegTime(rs.getTimestamp(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DaoUtil.closeAll(con, pstmt, rs);
		}
		return user;
	}

	@Override
	public void saveUser(User user) {
		
	}
	
}
