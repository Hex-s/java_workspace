package com.niit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
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
		//��ȡ�ֲ��������޷���ȡд��myServlet�еĲ���
		//String value = getInitParameter("endoce");
		//System.out.println(value);
		//��ȡȫ�ֲ���������servlet���������
		//String value = getServletContext().getInitParameter("key");
		//System.out.println(value);
		
		//���������ַ�����ʽ
		req.setCharacterEncoding("gbk");
		//��ȡ������û���������
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		//�ж��û����Ƿ����
		if(userName.equals("admin")){
			if(password.equals("admin123")){
				//���û���������session
				req.getSession().setAttribute("loginUser", userName);
				req.getRequestDispatcher("WEB-INF/success.jsp").forward(req, resp);
				return;
			}
			else{
				req.setAttribute("userName", userName);
				req.setAttribute("pwdError", "password is invalidate");
			}
		}
		else{
			req.setAttribute("nameError", "name is invalidate");
		}
		//��ת����½ҳ��
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
}
