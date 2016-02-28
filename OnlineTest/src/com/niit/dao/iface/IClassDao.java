package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Classes;

public interface IClassDao {
	
	/**
	 * ��ȡ���еİ༶
	 * @return
	 */
	public ArrayList<Classes> findAllClasses();
	
	/**
	 * ���ݰ༶����ð༶��Ϣ
	 * @return
	 */
	public Classes findClassByName(String className);
	
	/**
	 * ���ݰ༶��Ż�ð༶��Ϣ
	 * @param classId
	 * @return
	 */
	public Classes findClassById(int classId);

}
