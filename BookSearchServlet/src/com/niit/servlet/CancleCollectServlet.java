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
		
		//创建DAO
		CollectDao collectDao = new CollectDao();
		//获取登录用户
		User loginUser = (User)req.getSession().getAttribute("loginUser");
		//获取取消收藏书籍
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		//创建收藏对象
		Collect collect = new Collect(loginUser.getUserId(), bookId);
		//删除收藏
		collectDao.deleteCollect(collect);
		//跳转
		req.getRequestDispatcher("collect.do").forward(req, resp);
	}
	
	

}
