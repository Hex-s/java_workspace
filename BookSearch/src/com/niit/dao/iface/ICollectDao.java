package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Collect;

public interface ICollectDao {
	
	/**
	 * 根据用户编号查看用户的收藏
	 * @param userId
	 * @return
	 */
	public ArrayList<Collect> findCollectByUserId(int userId);
	
	/**
	 * 添加收藏
	 * @param c
	 */
	public void addCollect(Collect c);
	
	/**
	 * 删除收藏
	 * @param c
	 */
	public void deleteCollect(Collect c);
	
	/**
	 * 查找收藏
	 * @param c
	 * @return
	 */
	public Collect findCollect(Collect c);

}
