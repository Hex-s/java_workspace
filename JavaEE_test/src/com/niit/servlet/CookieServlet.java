package com.niit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//获取当前cookie信息
		Cookie[] cookies = req.getCookies();
		//循环cookie
		for(Cookie cook : cookies){
			
			if(cook.getName().equals("userName")){
				req.setAttribute("userName", cook.getValue());
			}
			if(cook.getName().equals("password")){
				req.setAttribute("password", cook.getValue());
			}
		}
		
		req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
	}
	
	

}
