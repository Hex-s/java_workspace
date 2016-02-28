package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IClassDao;
import com.niit.entiry.Classes;
import com.niit.util.DaoHandle;

public class ClassDao implements IClassDao{

	/**
	 * ��ȡ���еİ༶
	 */
	@Override
	public ArrayList<Classes> findAllClasses() {
		ArrayList<Classes> list = DaoHandle.executeQuery("select * from classes order by classid", null, Classes.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	/**
	 * ���ݰ༶����ð༶��Ϣ
	 */
	@Override
	public Classes findClassByName(String className) {
		ArrayList<Classes> list = DaoHandle.executeQuery("select * from classes where classname=?", new Object[]{className}, Classes.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * ���ݰ༶��Ż�ð༶��Ϣ
	 */
	@Override
	public Classes findClassById(int classId) {
		ArrayList<Classes> list = DaoHandle.executeQuery("select * from classes where classid=?", new Object[]{classId}, Classes.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
