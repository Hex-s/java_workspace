package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IReplyDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entity.Reply;

public class ReplyDao implements IReplyDao {

	public void addReply(Reply reply) {
		// TODO Auto-generated method stub
		
	}

	public Reply findReplyById(int reply) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * »ØÌûÊýÁ¿
	 */
	public int findReplyCountByTopicId(int topicId) {
		return DaoHandle.executeQueryForCount("select count(*) from reply where topicid=?", new Object[]{topicId});
	}

	public ArrayList<Reply> findReplyListByTopicId(int topicId, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	public void modifyReplyById(Reply reply) {
		// TODO Auto-generated method stub
		
	}

}
