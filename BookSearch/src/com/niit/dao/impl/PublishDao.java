package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IPublishDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entiry.Publish;

public class PublishDao implements IPublishDao{

	/**
	 *  ���ݳ������Ų��ҳ��������
	 */
	public Publish findPublishByPublishId(int pId) {
		ArrayList<Publish> list = DaoHandle.executeQuery("select * from bookpublish where publishid=?", new Object[]{pId}, Publish.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	

}
