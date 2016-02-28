package com.niit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.impl.CollectDao;
import com.niit.entity.Collect;
import com.niit.entity.User;

public class CancleCollectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//����DAO
		CollectDao collectDao = new CollectDao();
		//��ȡ��¼�û�
		User loginUser = (User)req.getSession().getAttribute("loginUser");
		//��ȡȡ���ղ��鼮
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		//�����ղض���
		Collect collect = new Collect(loginUser.getUserId(), bookId);
		//ɾ���ղ�
		collectDao.deleteCollect(collect);
		//��ת
		req.getRequestDispatcher("collect.do").forward(req, resp);
	}
	
	

}
