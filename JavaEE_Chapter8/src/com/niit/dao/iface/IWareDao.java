package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.bean.Ware;

/**
 * 商品数据操作接口
 * @author Administrator
 *
 */
public interface IWareDao {
	/**
	 * 查询所有商品信息
	 * @return
	 */
	public ArrayList<Ware> findAll();
	/**
	 * 根据编号查询商品信息
	 * @param wareId
	 * @return
	 */
	public Ware findWareById(int wareId);
	/**
	 * 修改商品信息
	 * @param ware
	 */
	public void modifyWare(Ware ware);
}
