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
		
		//�����ַ�������
		req.setCharacterEncoding("UTF-8");
		//����DAO
		WriterDao writerDao = new WriterDao();
		BooksDao booksDao = new BooksDao();
		VarityDao varityDao = new VarityDao();
		PublishDao publicDao = new PublishDao();
		CollectDao collectDao = new CollectDao();
		//��ȡ��¼�û�
		User loginUser = (User)req.getSession().getAttribute("loginUser");
		//��ȡ�û��ղ��б�
		ArrayList<Collect> collectList = collectDao.findCollectByUserId(loginUser.getUserId());
		//ͼ���б�
		ArrayList<Books> bookList = new ArrayList<Books>();
		//ѭ���ղ��б�
		if(collectList != null){
			for(Collect collect : collectList){
				Books book = booksDao.findBookByBookId(collect.getcBookId());
				//������������
				book.setbWriterName(writerDao.findWriterByWriterId(book.getbWriterId()).getwName());
				//���ó���������
				book.setbPublishName(publicDao.findPublishByPublishId(book.getbPublishId()).getpName());
				//�����������
				book.setbVarithName(varityDao.findVarityByVarityId(book.getbVarity()).getvName());
				//��ӵ�ͼ���б���
				bookList.add(book);
			}
		}
		
		//��ת
		
		req.setAttribute("list", bookList);
		req.getRequestDispatcher("WEB-INF/collectList.jsp").forward(req, resp);
	}
	
	

}
