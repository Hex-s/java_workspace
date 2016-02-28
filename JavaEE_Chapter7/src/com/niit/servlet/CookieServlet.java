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
		//获取当前的cookie信息
		Cookie[] cookies = req.getCookies();
		//遍历cookie
		for(Cookie cookie : cookies){
			//cookie以键值对进行存储
			//System.out.println(cookie.getName()+":"+cookie.getValue());
			System.out.println(cookie.getName()+":"+URLDecoder.decode(cookie.getValue(),"gbk"));
		}
		//创建cookie对象
		//cookie不允许写中文
		Cookie cookie = new Cookie("userName", URLEncoder.encode("杰克","gbk"));
		Cookie cookie2 = new Cookie("password","jack123");
		//设置cookie的保留时间,单位为秒 0表示删除当前的cookie,负数表示关闭浏览器的同时销毁cookie,正数则表示cookie的保存时间
		//cookie.setMaxAge(Integer.MAX_VALUE);
		//setPath表示在容器范围中进行cookie共享的设置
		//cookie.setPath("/");
		//setDomain用来设置跨域访问的共享
		//cookie.setDomain(".niit.com");
		//颁发cookie
		resp.addCookie(cookie);
		resp.addCookie(cookie2);
		req.getRequestDispatcher("WEB-INF/success.jsp").forward(req, resp);
	}
	
}
