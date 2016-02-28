package com.niit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.impl.UserDao;
import com.niit.entity.User;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//设置字符集编码
		req.setCharacterEncoding("UTF-8");
		//创建DAO
		UserDao userDao = new UserDao();
		//获取请求的用户名和密码
		String userName = req.getParameter("userName");
		String pwd = req.getParameter("password");
		//获取用户
		User user = userDao.findUserByUserName(userName);
		//判断用户是否存在
		if(user != null){
			//判断密码是否正确
			if(pwd.equals(user.getuPwd())){
				req.getSession().setAttribute("loginUser",user);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
				return;
			}
			else{
				req.setAttribute("name", userName);
				req.setAttribute("pwdError", "密码错误");
			}		
		}
		else{
			req.setAttribute("nameError", "用户名不存在");	
		}
		req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
	}


}
