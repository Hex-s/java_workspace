package com.niit.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	/**
	 * session����
	 */
	public void sessionCreated(HttpSessionEvent event) {
		//��ȡsession����
		HttpSession session = event.getSession();
		//��ȡ�¼�Դ
		//System.out.println(event.getSource());
		//System.out.println("session created");
	}
	/**
	 * session����
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		//System.out.println("session destroyed");
	}

}
