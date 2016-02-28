package com.niit.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.impl.BooksDao;
import com.niit.dao.impl.CollectDao;
import com.niit.dao.impl.PublishDao;
import com.niit.dao.impl.VarityDao;
import com.niit.dao.impl.WriterDao;
import com.niit.entity.Books;
import com.niit.entity.Collect;
import com.niit.entity.User;

public class CollectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//设置字符集编码
		req.setCharacterEncoding("UTF-8");
		//创建DAO
		WriterDao writerDao = new WriterDao();
		BooksDao booksDao = new BooksDao();
		VarityDao varityDao = new VarityDao();
		PublishDao publicDao = new PublishDao();
		CollectDao collectDao = new CollectDao();
		//获取登录用户
		User loginUser = (User)req.getSession().getAttribute("loginUser");
		//获取用户收藏列表
		ArrayList<Collect> collectList = collectDao.findCollectByUserId(loginUser.getUserId());
		//图书列表
		ArrayList<Books> bookList = new ArrayList<Books>();
		//循环收藏列表
		if(collectList != null){
			for(Collect collect : collectList){
				Books book = booksDao.findBookByBookId(collect.getcBookId());
				//设置作者姓名
				book.setbWriterName(writerDao.findWriterByWriterId(book.getbWriterId()).getwName());
				//设置出版社名称
				book.setbPublishName(publicDao.findPublishByPublishId(book.getbPublishId()).getpName());
				//设置类别名称
				book.setbVarithName(varityDao.findVarityByVarityId(book.getbVarity()).getvName());
				//添加到图书列表中
				bookList.add(book);
			}
		}
		
		//跳转
		
		req.setAttribute("list", bookList);
		req.getRequestDispatcher("WEB-INF/collectList.jsp").forward(req, resp);
	}
	
	

}
