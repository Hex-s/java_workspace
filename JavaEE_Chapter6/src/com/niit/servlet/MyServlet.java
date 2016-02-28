package com.niit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 自定义servlet
 * @author Administrator
 *
 */
public class MyServlet extends HttpServlet{

	/**
	 * 处理get请求
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("处理了get请求");
		//super.doGet(req, resp);
		doPost(req, resp);
	}
	/**
	 *  处理post请求
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("处理了post请求");
		//获取当前servlet的name
		System.out.println(getServletName());
		//获取当前servlet的上下文对象
		//该对象相当于jsp中的application对象
		ServletContext context = getServletContext();
		//获取session
		HttpSession session = req.getSession();
		//获取全局参数
		String value = context.getInitParameter("key");
		System.out.println(value);
		//获取局部参数
		String encode = getInitParameter("encode");
		System.out.println(encode);
		//获取项目的跟路径
		String path = context.getContextPath();
		System.out.println(path);
		//获取当前项目所在服务器的绝对路径
		String realPath = context.getRealPath("/");
		System.out.println(realPath);
		//req.getRequestDispatcher("success.jsp").forward(req, resp);
		resp.setCharacterEncoding("gbk");
		//获取输出流
		PrintWriter out = resp.getWriter();
		out.write("进入了myServlet");	
	}
	/**
	 * servlet的核心方法，用来对客户端的请求进行响应，在该方法中会调用doGet以及doPost
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("接收了客户端的请求，并开始执行响应");
		super.service(request, response);
	}
	/**
	 * 销毁方法
	 */
	@Override
	public void destroy() {
		System.out.println("servlet被销毁");
		super.destroy();
	}
	/**
	 * 初始化方法
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("servlet初始化");
		super.init();
	}
	
}
