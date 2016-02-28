package com.niit.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("进入了init Servlet");
		// TODO Auto-generated method stub
		//获取当前网站已经颁发的cookie
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			//遍历cookies
			for(Cookie cookie : cookies){
				//通过键判断是否有记录过用户名
				if(cookie.getName().equals("loginName")){
					//获取对应的值并传递给下一个页面
					req.setAttribute("userName", cookie.getValue());
					req.setAttribute("chk", "checked");
					break;
				}
			}
		}
		//获取application
		ServletContext application = getServletContext();
		application.setAttribute("userName", "admin");
		application.setAttribute("userName", "tom");
		application.removeAttribute("userName");
		req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
	}
	
}	
