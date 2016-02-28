package com.niit.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ��ǰ��cookie��Ϣ
		Cookie[] cookies = req.getCookies();
		//����cookie
		for(Cookie cookie : cookies){
			//cookie�Լ�ֵ�Խ��д洢
			//System.out.println(cookie.getName()+":"+cookie.getValue());
			System.out.println(cookie.getName()+":"+URLDecoder.decode(cookie.getValue(),"gbk"));
		}
		//����cookie����
		//cookie������д����
		Cookie cookie = new Cookie("userName", URLEncoder.encode("�ܿ�","gbk"));
		Cookie cookie2 = new Cookie("password","jack123");
		//����cookie�ı���ʱ��,��λΪ�� 0��ʾɾ����ǰ��cookie,������ʾ�ر��������ͬʱ����cookie,�������ʾcookie�ı���ʱ��
		//cookie.setMaxAge(Integer.MAX_VALUE);
		//setPath��ʾ��������Χ�н���cookie���������
		//cookie.setPath("/");
		//setDomain�������ÿ�����ʵĹ���
		//cookie.setDomain(".niit.com");
		//�䷢cookie
		resp.addCookie(cookie);
		resp.addCookie(cookie2);
		req.getRequestDispatcher("WEB-INF/success.jsp").forward(req, resp);
	}
	
}
