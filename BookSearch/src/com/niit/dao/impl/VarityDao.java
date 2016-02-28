package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IVarityDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entiry.Varity;

public class VarityDao implements IVarityDao{

	/**
	 * ���ݱ�Ų������
	 */
	public Varity findVarityByVarityId(int vid) {
		ArrayList<Varity> list = DaoHandle.executeQuery("select * from bookvarity where vid=?", new Object[]{vid}, Varity.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * ����������Ʋ������
	 */
	public ArrayList<Varity> findVarityListByVarityName(String name) {
		ArrayList<Varity> list = DaoHandle.executeQuery("select * from bookvarity where upper(vname) like upper(?)", new Object[]{"%"+name+"%"}, Varity.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	/**
	 * �������е����
	 */
	public ArrayList<Varity> findAllVarity() {
		
		return null;
	}

}
