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
		
		//�����ַ�������
		req.setCharacterEncoding("UTF-8");
		//����DAO 
		WriterDao writerDao = new WriterDao();
		BooksDao booksDao = new BooksDao();
		VarityDao varityDao = new VarityDao();
		PublishDao publicDao = new PublishDao();
		CollectDao collectDao = new CollectDao();
		//��ȡ�����ͼ����
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		//��ȡ����ͼ�����
		Books book = booksDao.findBookByBookId(bookId);
		//������������
		book.setbWriterName(writerDao.findWriterByWriterId(book.getbWriterId()).getwName());
		//���ó���������
		book.setbPublishName(publicDao.findPublishByPublishId(book.getbPublishId()).getpName());
		//�����������
		book.setbVarithName(varityDao.findVarityByVarityId(book.getbVarity()).getvName());
		//�ж��Ƿ���Ҫ�����ղصĲ���
		if(req.getParameter("type") != null){
			User loginUser = (User)req.getSession().getAttribute("loginUser");
			Collect collect = new Collect(loginUser.getUserId(), bookId);			
			int type = Integer.parseInt(req.getParameter("type"));
			//�����ղ�
			if(type == 1){
				collectDao.addCollect(collect);
			}
			else{
				collectDao.deleteCollect(collect);
			}
		}
		//�ж��û��Ƿ��Ѿ��ղع�����
		if(req.getSession().getAttribute("loginUser") != null){
			User loginUser = (User)req.getSession().getAttribute("loginUser");
			Collect collect = collectDao.findCollect(new Collect(loginUser.getUserId(),bookId));
			if(collect != null){
				req.setAttribute("collectState", collect);
			}
		}
		//������ת
		req.setAttribute("book", book);
		req.getRequestDispatcher("WEB-INF/bookInfo.jsp").forward(req, resp);
		
	}

	

}
