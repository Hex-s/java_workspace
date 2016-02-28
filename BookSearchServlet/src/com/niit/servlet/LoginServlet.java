package com.niit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.impl.UserDao;
import com.niit.entity.User;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//�����ַ�������
		req.setCharacterEncoding("UTF-8");
		//����DAO
		UserDao userDao = new UserDao();
		//��ȡ������û���������
		String userName = req.getParameter("userName");
		String pwd = req.getParameter("password");
		//��ȡ�û�
		User user = userDao.findUserByUserName(userName);
		//�ж��û��Ƿ����
		if(user != null){
			//�ж������Ƿ���ȷ
			if(pwd.equals(user.getuPwd())){
				req.getSession().setAttribute("loginUser",user);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
				return;
			}
			else{
				req.setAttribute("name", userName);
				req.setAttribute("pwdError", "�������");
			}		
		}
		else{
			req.setAttribute("nameError", "�û���������");	
		}
		req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
	}


}
