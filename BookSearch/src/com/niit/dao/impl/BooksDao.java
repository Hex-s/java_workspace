package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IBooksDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entiry.Books;

public class BooksDao implements IBooksDao{

	/**
	 * ������������ͼ��
	 */
	public ArrayList<Books> findBookListByBookName(String bookName) {
		ArrayList<Books> list = DaoHandle.executeQuery("select * from books where upper(bookname) like upper(?)", new Object[]{"%"+bookName+"%"}, Books.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	/**
	 * ����ͼ��������ͼ��
	 */
	public ArrayList<Books> findBookListByBookVarity(int bVid) {
		ArrayList<Books> list = DaoHandle.executeQuery("select * from books where bvarity=?",new Object[]{bVid},Books.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	/**
	 * �������߲���ͼ��
	 */
	public ArrayList<Books> findBookListByBookWriter(int writerId) {
		ArrayList<Books> list = DaoHandle.executeQuery("select * from books where bwriterid=?", new Object[]{writerId}, Books.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	/**
	 * ����ͼ���Ų���ͼ��
	 */
	public Books findBookByBookId(int bookId) {
		ArrayList<Books> list = DaoHandle.executeQuery("select * from books where bookid=?", new Object[]{bookId}, Books.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
