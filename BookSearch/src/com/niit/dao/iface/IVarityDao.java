package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Varity;

public interface IVarityDao {
	
	/**
	 * ���ݱ�Ų������
	 * @param vid
	 * @return
	 */
	public Varity findVarityByVarityId(int vid);
	
	/**
	 * ����������Ʋ������
	 * @param name
	 * @return
	 */
	public ArrayList<Varity> findVarityListByVarityName(String name);

	/**
	 * �������е����
	 * @return
	 */
	public ArrayList<Varity> findAllVarity();
}
