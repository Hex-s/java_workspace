package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.bean.Ware;
import com.niit.dao.iface.IWareDao;
import com.niit.dao.util.DaoHandle;
/**
 * 商品数据操作类
 * @author Administrator
 *
 */
public class WareDao implements IWareDao {

	public ArrayList<Ware> findAll() {
		ArrayList<Ware> list = DaoHandle.executeQuery("select * from ware", null, Ware.class);
		return list;
	}

	public Ware findWareById(int wareId) {
		ArrayList<Ware> list = DaoHandle.executeQuery("select * from ware where wareId=?", new Object[]{wareId}, Ware.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	public void modifyWare(Ware ware) {
		DaoHandle.executeUpdate("update ware set num=? where wareId=?", new Object[]{ware.getNum(),ware.getWareId()});
	}

}
