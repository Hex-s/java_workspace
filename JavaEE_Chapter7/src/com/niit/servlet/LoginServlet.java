package com.niit.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		// TODO Auto-generated method stub
		//��ȡ�û���������
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		//��ȡ�Ƿ��¼�û����ı�ʶ
		String flag = req.getParameter("chk");
		//�����Ҫ��¼��½��
		if(flag != null){
			Cookie cookie = new Cookie("loginName",URLEncoder.encode(userName,"gbk"));
			//�䷢cookie
			resp.addCookie(cookie);
		}
		req.getRequestDispatcher("WEB-INF/success.jsp").forward(req, resp);
	}
	
}
