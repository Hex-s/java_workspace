package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Collect;

public interface ICollectDao {
	
	/**
	 * �����û���Ų鿴�û����ղ�
	 * @param userId
	 * @return
	 */
	public ArrayList<Collect> findCollectByUserId(int userId);
	
	/**
	 * ����ղ�
	 * @param c
	 */
	public void addCollect(Collect c);
	
	/**
	 * ɾ���ղ�
	 * @param c
	 */
	public void deleteCollect(Collect c);
	
	/**
	 * �����ղ�
	 * @param c
	 * @return
	 */
	public Collect findCollect(Collect c);

}
