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
		
		//设置字符集编码
		req.setCharacterEncoding("UTF-8");
		//创建DAO 
		WriterDao writerDao = new WriterDao();
		BooksDao booksDao = new BooksDao();
		VarityDao varityDao = new VarityDao();
		PublishDao publicDao = new PublishDao();
		//获取请求的搜索内容
		String searchContent = req.getParameter("searchContent");
		//获取搜索类别
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
    	//根据图书的名称搜索
    	if(type.equals("bookName")){
    		ArrayList<Books> list = booksDao.findBookListByBookName(searchContent);
    		if(list != null){
    			for(Books book : list){
    				bookList.add(book);
    			}
    		}
    	}
    	//根据图书类型查找
    	else if(type.equals("bookVarity")){
    		//查找类别
    		ArrayList<Varity> varityList = varityDao.findVarityListByVarityName(searchContent);
    		if(varityList != null){
    			//循环查询到的类别查找相应图书
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
    	//根据作家查找
    	else{
    		//查找作家
    		ArrayList<Writer> writerList = writerDao.findWriterByWriterName(searchContent);
    		if(writerList != null){
    			//循环所有的作家查找所写的图书
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
    		//设置作者
    		book.setbWriterName(writerDao.findWriterByWriterId(book.getbWriterId()).getwName());
    		//设置出版社
    		book.setbPublishName(publicDao.findPublishByPublishId(book.getbPublishId()).getpName());
    		//设置类别
    		book.setbVarithName(varityDao.findVarityByVarityId(book.getbVarity()).getvName());
    		
    	}
    	//将值传递给下一个页面
    	req.setAttribute("list", bookList);
    	//跳转页面
    	req.getRequestDispatcher("WEB-INF/searchList.jsp").forward(req, resp);
	}

}
