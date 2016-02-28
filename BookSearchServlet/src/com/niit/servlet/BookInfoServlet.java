package com.niit.servlet;

import java.io.IOException;

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

public class BookInfoServlet extends HttpServlet{

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
		//获取请求的图书编号
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		//获取请求图书对象
		Books book = booksDao.findBookByBookId(bookId);
		//设置作者姓名
		book.setbWriterName(writerDao.findWriterByWriterId(book.getbWriterId()).getwName());
		//设置出版社名称
		book.setbPublishName(publicDao.findPublishByPublishId(book.getbPublishId()).getpName());
		//设置类别名称
		book.setbVarithName(varityDao.findVarityByVarityId(book.getbVarity()).getvName());
		//判断是否需要进行收藏的操作
		if(req.getParameter("type") != null){
			User loginUser = (User)req.getSession().getAttribute("loginUser");
			Collect collect = new Collect(loginUser.getUserId(), bookId);			
			int type = Integer.parseInt(req.getParameter("type"));
			//新增收藏
			if(type == 1){
				collectDao.addCollect(collect);
			}
			else{
				collectDao.deleteCollect(collect);
			}
		}
		//判断用户是否已经收藏过该书
		if(req.getSession().getAttribute("loginUser") != null){
			User loginUser = (User)req.getSession().getAttribute("loginUser");
			Collect collect = collectDao.findCollect(new Collect(loginUser.getUserId(),bookId));
			if(collect != null){
				req.setAttribute("collectState", collect);
			}
		}
		//设置跳转
		req.setAttribute("book", book);
		req.getRequestDispatcher("WEB-INF/bookInfo.jsp").forward(req, resp);
		
	}

	

}
