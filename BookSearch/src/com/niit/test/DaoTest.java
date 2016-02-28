package com.niit.test;

import java.util.ArrayList;

import com.niit.dao.impl.BooksDao;
import com.niit.dao.impl.CollectDao;
import com.niit.dao.impl.PublishDao;
import com.niit.dao.impl.UserDao;
import com.niit.dao.impl.VarityDao;
import com.niit.dao.impl.WriterDao;
import com.niit.entiry.Books;
import com.niit.entiry.Collect;
import com.niit.entiry.Publish;
import com.niit.entiry.User;
import com.niit.entiry.Varity;
import com.niit.entiry.Writer;

public class DaoTest {
	
	public static void main(String[] args) {
		
		WriterDao writerDao = new WriterDao();
		BooksDao booksDao = new BooksDao();
		PublishDao publishDao = new PublishDao();
		UserDao userDao = new UserDao();
		VarityDao varityDao = new VarityDao();
		CollectDao collectDao = new CollectDao();
//		Writer w = writerDao.findWriterByWriterId(2);
//		System.out.println(w.getwName());
		
		ArrayList<Writer> list = writerDao.findWriterByWriterName("marry");
		System.out.println(list.size());
		for(Writer wr : list){
			System.out.println(wr.getwName());
		}
		
//		ArrayList<Books> list = booksDao.findBookListByBookName("Java");
//		ArrayList<Books> list = booksDao.findBookListByBookVarity(2);
//		ArrayList<Books> list = booksDao.findBookListByBookWriter(2);
//		if(list != null){
//			for(Books b : list){
//				System.out.println(b.getBookName());
//				System.out.println(b.getbVarity());
//			}
//		}
//		
//		Publish p = publishDao.findPublishByPublishId(1);
//		System.out.println(p.getpName());
		
//		User user = userDao.findUserByUserId(1);
//		User user = userDao.findUserByUserName("Tom");
//		System.out.println(user.getuName());
		
//		Varity v = varityDao.findVarityByVarityId(1);
//		System.out.println(v.getvName());
		
//		ArrayList<Varity> list = varityDao.findVarityListByVarityName("java");
//		for(Varity va : list){
//			System.out.println(va.getvName());
//		}
//		Collect c = new Collect(1, 1);
//		collectDao.addCollect(c);
//		collectDao.deleteCollect(c);
//		ArrayList<Collect> list = collectDao.findCollectByUserId(1);
//		for(Collect cl : list){
//			System.out.println(cl.getcBookId());
//		}
		
	}

}
