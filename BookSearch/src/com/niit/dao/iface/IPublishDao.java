package com.niit.dao.iface;

import com.niit.entiry.Publish;

public interface IPublishDao {
	
	/**
	 * ���ݳ������Ų��ҳ��������
	 * @param pId
	 * @return
	 */
	public Publish findPublishByPublishId(int pId);

}
