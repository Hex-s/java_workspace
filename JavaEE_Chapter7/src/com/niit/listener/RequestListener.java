package com.niit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * ��������������ڵļ�����
 * @author Administrator
 *
 */
public class RequestListener implements ServletRequestListener {
	/**
	 * �������������
	 */
	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stu
		//��ȡ����
		HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
		//System.out.println(request.getLocalAddr()+"��������������λ���ǣ�"+request.getRequestURI());
		//��ȡ����ĻỰ
		HttpSession session = request.getSession();
		//��ȡservlet�����Ķ���
		ServletContext application = event.getServletContext();
		//System.out.println("destroy request");
	}
	/**
	 * ��������ĳ�ʼ��
	 */
	public void requestInitialized(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		//System.out.println("init request");
		
	}
	
}
