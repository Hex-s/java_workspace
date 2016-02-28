package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.ICollectDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entiry.Collect;

public class CollectDao implements ICollectDao{

	/**
	 * 添加收藏
	 */
	public void addCollect(Collect c) {
		DaoHandle.executeUpdate("insert into bookcollect values(sq_bookcollect_collectid.nextval,?,?,sysdate)", new Object[]{c.getcUserId(),c.getcBookId()});
		
	}

	/**
	 * 删除收藏
	 */
	public void deleteCollect(Collect c) {
		DaoHandle.executeUpdate("delete from bookcollect where cuserid=? and cbookid=?", new Object[]{c.getcUserId(),c.getcBookId()});
		
	}

	/**
	 * 根据用户编号查看用户的收藏
	 */
	public ArrayList<Collect> findCollectByUserId(int userId) {
		ArrayList<Collect> list = DaoHandle.executeQuery("select * from bookcollect where cuserid=?", new Object[]{userId}, Collect.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	/**
	 * 查找收藏
	 */
	public Collect findCollect(Collect c) {
		ArrayList<Collect> list = DaoHandle.executeQuery("select * from bookcollect where cuserid=? and cbookid=?", new Object[]{c.getcUserId(),c.getcBookId()}, Collect.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
