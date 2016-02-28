package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Writer;

public interface IWriterDao {
	
	/**
	 * ��������������������
	 * @param wName
	 * @return
	 */
	public ArrayList<Writer> findWriterByWriterName(String wName);
	
	/**
	 * �������߱�Ų�������
	 * @param wId
	 * @return
	 */
	public Writer findWriterByWriterId(int wId);

}
