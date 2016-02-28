package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Books;

public interface IBooksDao {
	
	/**
	 * 根据图书类别查找图书
	 * @return
	 */
	public ArrayList<Books> findBookListByBookVarity(int bVid);
	
	/**
	 * 根据书名查找图书
	 * @param bookName
	 * @return
	 */
	public ArrayList<Books> findBookListByBookName(String bookName);
	
	/**
	 * 根据作者查找图书
	 * @param writerId
	 * @return
	 */
	public ArrayList<Books> findBookListByBookWriter(int writerId);
	
	/**
	 * 根据图书编号查找图书
	 * @param bookId
	 * @return
	 */
	public Books findBookByBookId(int bookId);

}
