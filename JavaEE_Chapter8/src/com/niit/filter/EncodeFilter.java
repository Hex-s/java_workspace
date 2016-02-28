package com.niit.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 * 字符集转换的过滤器
 * @author Administrator
 *
 */
public class EncodeFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		//System.out.println("进入encode filter");
		//判断请求的方式
		//post请求
		if(request.getMethod().equalsIgnoreCase("post")){
			request.setCharacterEncoding("utf-8");
		}
		//get请求
		else{
			//获取请求中的所有参数
			Enumeration<String> keys = request.getParameterNames();
			//迭代
			while(keys.hasMoreElements()){
				//获取每一个参数
				//String values = request.getParameter(keys.nextElement());
				//对参数进行字符集重构
				//value = new String(value.getBytes("iso-8859-1"),"utf-8");
				//System.out.println(value);
				String[] values = request.getParameterValues(keys.nextElement());
				for(int i = 0; i < values.length; i++){
					values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
		}
		//继续进入请求
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
