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
		
		System.out.println("������init Servlet");
		// TODO Auto-generated method stub
		//��ȡ��ǰ��վ�Ѿ��䷢��cookie
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			//����cookies
			for(Cookie cookie : cookies){
				//ͨ�����ж��Ƿ��м�¼���û���
				if(cookie.getName().equals("loginName")){
					//��ȡ��Ӧ��ֵ�����ݸ���һ��ҳ��
					req.setAttribute("userName", cookie.getValue());
					req.setAttribute("chk", "checked");
					break;
				}
			}
		}
		//��ȡapplication
		ServletContext application = getServletContext();
		application.setAttribute("userName", "admin");
		application.setAttribute("userName", "tom");
		application.removeAttribute("userName");
		req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
	}
	
}	
