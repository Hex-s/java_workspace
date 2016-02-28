package com.niit.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	/**
	 * session创建
	 */
	public void sessionCreated(HttpSessionEvent event) {
		//获取session对象
		HttpSession session = event.getSession();
		//获取事件源
		//System.out.println(event.getSource());
		//System.out.println("session created");
	}
	/**
	 * session销毁
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		//System.out.println("session destroyed");
	}

}
