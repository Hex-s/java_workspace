package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Varity;

public interface IVarityDao {
	
	/**
	 * 根据编号查找类别
	 * @param vid
	 * @return
	 */
	public Varity findVarityByVarityId(int vid);
	
	/**
	 * 根据类别名称查找类别
	 * @param name
	 * @return
	 */
	public ArrayList<Varity> findVarityListByVarityName(String name);

	/**
	 * 查找所有的类别
	 * @return
	 */
	public ArrayList<Varity> findAllVarity();
}
