package com.niit.entiry;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("gbk");
		String name = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		String nameFlag = req.getParameter("remberName");
		String pwdFlag = req.getParameter("remeberPwd");
		if(nameFlag != null){
			Cookie cookie = new Cookie("loginName", name);
			
			resp.addCookie(cookie);
		}
		if(pwdFlag != null){
			Cookie cookie = new Cookie("loginPwd",pwd);
			resp.addCookie(cookie);
		}
		req.getRequestDispatcher("WEB-INF/success.jsp").forward(req, resp);
	}
	
	

}
