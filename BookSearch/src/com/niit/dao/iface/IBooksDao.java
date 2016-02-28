package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Books;

public interface IBooksDao {
	
	/**
	 * ����ͼ��������ͼ��
	 * @return
	 */
	public ArrayList<Books> findBookListByBookVarity(int bVid);
	
	/**
	 * ������������ͼ��
	 * @param bookName
	 * @return
	 */
	public ArrayList<Books> findBookListByBookName(String bookName);
	
	/**
	 * �������߲���ͼ��
	 * @param writerId
	 * @return
	 */
	public ArrayList<Books> findBookListByBookWriter(int writerId);
	
	/**
	 * ����ͼ���Ų���ͼ��
	 * @param bookId
	 * @return
	 */
	public Books findBookByBookId(int bookId);

}
