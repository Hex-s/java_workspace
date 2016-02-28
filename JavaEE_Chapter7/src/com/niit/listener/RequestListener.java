package com.niit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * 请求对象生命周期的监听器
 * @author Administrator
 *
 */
public class RequestListener implements ServletRequestListener {
	/**
	 * 监听请求的销毁
	 */
	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stu
		//获取请求
		HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
		//System.out.println(request.getLocalAddr()+"发起了请求，请求位置是："+request.getRequestURI());
		//获取请求的会话
		HttpSession session = request.getSession();
		//获取servlet上下文对象
		ServletContext application = event.getServletContext();
		//System.out.println("destroy request");
	}
	/**
	 * 监听请求的初始化
	 */
	public void requestInitialized(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		//System.out.println("init request");
		
	}
	
}
