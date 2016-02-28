package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IReplyDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entity.Reply;

public class ReplyDao implements IReplyDao {

	/**
	 *  新增回帖
	 */
	public void addReply(Reply reply) {
		DaoHandle.executeUpdate("insert into bbsreplys values(sq_bbsreplys_rid.nextval,?,?,?,sysdate)",new Object[]{reply.getrTid(),reply.getrUserid(),reply.getrContent()} );
		
	}

	/**
	 * 根据回帖编号查询回帖
	 */
	public Reply findReplyById(int rid) {
		ArrayList<Reply> list = DaoHandle.executeQuery("select * from bbsreplys where rid=?", new Object[]{rid}, Reply.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	/**
	 * 回帖数量
	 */
	public int findReplyCountByTopicId(int topicId) {
		return DaoHandle.executeQueryForCount("select count(*) from bbsreplys where rtid=?", new Object[]{topicId});
	}

	/**
	 *  根据主贴编号分页查询回帖集合
	 */
	public ArrayList<Reply> findReplyListByTopicId(int topicId, int page) {
		String sql = "select * from (select rownum as topicrow,n.* from (select * from bbsreplys where rtid=? order by rtime desc) n) where topicrow between ? and ? ";
		ArrayList<Reply> list = DaoHandle.executeQuery(sql, new Object[]{topicId,(page-1)*5+1,page*5}, Reply.class);
		return list;
	}

	/**
	 * 删除某主贴的所有回帖
	 */
	public void deleteReplysByTopicId(int topicId) {
		DaoHandle.executeUpdate("delete from bbsreplys where rtid=?", new Object[]{topicId});
		
	}

	/**
	 *  根据回帖编号删除回帖
	 */
	public void deleteReplyByRid(int rid) {
		DaoHandle.executeUpdate("delete from bbsreplys where rid=?", new Object[]{rid});
		
	}

}
