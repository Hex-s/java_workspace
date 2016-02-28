package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IWriterDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entiry.Writer;

public class WriterDao implements IWriterDao{

	/**
	 * 根据作者编号查找作者
	 */
	public Writer findWriterByWriterId(int wId) {
		ArrayList<Writer> list = DaoHandle.executeQuery("select * from bookwriter where writerid=?", new Object[]{wId}, Writer.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据作者姓名查找作者
	 */
	public ArrayList<Writer> findWriterByWriterName(String wName) {
		ArrayList<Writer> list = DaoHandle.executeQuery("select * from bookwriter where upper(wname) like upper(?)", new Object[]{"%"+wName+"%"}, Writer.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

}
