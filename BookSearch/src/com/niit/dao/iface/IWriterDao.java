package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Writer;

public interface IWriterDao {
	
	/**
	 * 根据作者姓名查找作者
	 * @param wName
	 * @return
	 */
	public ArrayList<Writer> findWriterByWriterName(String wName);
	
	/**
	 * 根据作者编号查找作者
	 * @param wId
	 * @return
	 */
	public Writer findWriterByWriterId(int wId);

}
