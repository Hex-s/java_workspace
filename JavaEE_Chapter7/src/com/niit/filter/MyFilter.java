package com.niit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
	/**
	 *  过滤器销毁
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("过滤器被销毁");
	}
	/**
	 * 执行过滤器
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/*
		 * 过滤器只能对重定向的地址进行过滤，请求跳转将不会触发过滤器
		 * */
		System.out.println("执行了过滤动作");
		//过滤链的转发,将原本请求的路径继续进行跳转
		chain.doFilter(request, response);
	}

	/**
	 * 初始化过滤器
	 */
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器被初始化");
		
	}

}
