package com.niit.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.impl.BooksDao;
import com.niit.dao.impl.PublishDao;
import com.niit.dao.impl.VarityDao;
import com.niit.dao.impl.WriterDao;
import com.niit.entity.Books;
import com.niit.entity.Varity;
import com.niit.entity.Writer;

public class SearchBookServlet extends HttpServlet{

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
		//��ȡ�������������
		String searchContent = req.getParameter("searchContent");
		//��ȡ�������
    	String[] types = req.getParameterValues("searchType");
    	String type = "";
    	if(types != null){
    		for(String str : types){
    			if(!str.equals("")){
    				type += str;
    				break;
    			}	
    		}
    	}
    	ArrayList<Books> bookList = new ArrayList<Books>();
    	//����ͼ�����������
    	if(type.equals("bookName")){
    		ArrayList<Books> list = booksDao.findBookListByBookName(searchContent);
    		if(list != null){
    			for(Books book : list){
    				bookList.add(book);
    			}
    		}
    	}
    	//����ͼ�����Ͳ���
    	else if(type.equals("bookVarity")){
    		//�������
    		ArrayList<Varity> varityList = varityDao.findVarityListByVarityName(searchContent);
    		if(varityList != null){
    			//ѭ����ѯ������������Ӧͼ��
    			for(Varity v : varityList){
    				ArrayList<Books> list = booksDao.findBookListByBookVarity(v.getvId());
    				if(list != null){
    					for(Books book : list){
			   				bookList.add(book);
			   			}
    				}
    			}
    		}
    	}
    	//�������Ҳ���
    	else{
    		//��������
    		ArrayList<Writer> writerList = writerDao.findWriterByWriterName(searchContent);
    		if(writerList != null){
    			//ѭ�����е����Ҳ�����д��ͼ��
    			for(Writer w : writerList){
    				ArrayList<Books> list = booksDao.findBookListByBookWriter(w.getWriterId());
    				if(list != null){
    					for(Books book : list){
			   				bookList.add(book);
			   			}
    				}
    			}
    		}
    	}
    	for(Books book : bookList){
    		//��������
    		book.setbWriterName(writerDao.findWriterByWriterId(book.getbWriterId()).getwName());
    		//���ó�����
    		book.setbPublishName(publicDao.findPublishByPublishId(book.getbPublishId()).getpName());
    		//�������
    		book.setbVarithName(varityDao.findVarityByVarityId(book.getbVarity()).getvName());
    		
    	}
    	//��ֵ���ݸ���һ��ҳ��
    	req.setAttribute("list", bookList);
    	//��תҳ��
    	req.getRequestDispatcher("WEB-INF/searchList.jsp").forward(req, resp);
	}

}
