package com.niit.dao.iface;

import com.niit.entiry.Publish;

public interface IPublishDao {
	
	/**
	 * 根据出版社编号查找出版出版社
	 * @param pId
	 * @return
	 */
	public Publish findPublishByPublishId(int pId);

}
