package com.niit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取局部参数，无法获取写在myServlet中的参数
		//String value = getInitParameter("endoce");
		//System.out.println(value);
		//获取全局参数，所有servlet共享的数据
		//String value = getServletContext().getInitParameter("key");
		//System.out.println(value);
		
		//设置请求字符集格式
		req.setCharacterEncoding("gbk");
		//获取请求的用户名和密码
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		//判断用户名是否存在
		if(userName.equals("admin")){
			if(password.equals("admin123")){
				//将用户名保存至session
				req.getSession().setAttribute("loginUser", userName);
				req.getRequestDispatcher("WEB-INF/success.jsp").forward(req, resp);
				return;
			}
			else{
				req.setAttribute("userName", userName);
				req.setAttribute("pwdError", "password is invalidate");
			}
		}
		else{
			req.setAttribute("nameError", "name is invalidate");
		}
		//跳转至登陆页面
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
}
