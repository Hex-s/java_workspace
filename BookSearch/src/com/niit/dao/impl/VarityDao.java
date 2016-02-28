package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IVarityDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entiry.Varity;

public class VarityDao implements IVarityDao{

	/**
	 * 根据编号查找类别
	 */
	public Varity findVarityByVarityId(int vid) {
		ArrayList<Varity> list = DaoHandle.executeQuery("select * from bookvarity where vid=?", new Object[]{vid}, Varity.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据类别名称查找类别
	 */
	public ArrayList<Varity> findVarityListByVarityName(String name) {
		ArrayList<Varity> list = DaoHandle.executeQuery("select * from bookvarity where upper(vname) like upper(?)", new Object[]{"%"+name+"%"}, Varity.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	/**
	 * 查找所有的类别
	 */
	public ArrayList<Varity> findAllVarity() {
		
		return null;
	}

}
