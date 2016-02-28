package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.niit.dao.iface.IUserDao;
import com.niit.entity.User;
import com.niit.util.DaoUtil;

public class UserDao implements IUserDao{
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	/**
	 * 根据用户名查询用户对象
	 * @param userName
	 * @return
	 */
	@Override
	public User findUserByName(String userName) {
		
		User user = null;
		//获取连接
		con = DaoUtil.getConnection();
		try {
			//获取处理器
			pstmt = con.prepareStatement("select * from users where user_name=?");
			//注入参数
			pstmt.setString(1, userName);
			//执行查询
			rs = pstmt.executeQuery();
			//获取查询结果
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

	/**
	 * 添加保存用户
	 * @param user
	 */
	@Override
	public boolean saveUser(User user) {

		int count = 0;
		//获取连接
		con = DaoUtil.getConnection();
		try {
			//获取处理器
			pstmt = con.prepareStatement("insert into users(user_name,user_pwd) values(?,?)");
			//注入参数
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPwd());
			//执行插入
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DaoUtil.closeAll(con, pstmt, null);
		}
		//插入结果
		if(count == 1){
			return true;
		}
		return false;
		
	}

}
