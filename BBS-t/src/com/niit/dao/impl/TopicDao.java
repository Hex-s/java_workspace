package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.ITopicDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entity.Topic;

public class TopicDao implements ITopicDao {

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
	}

	public Topic findLastTopicByBoardId(int boardId) {
		ArrayList<Topic> list = DaoHandle.executeQuery("select * from (select * from topic where boardid=? order by modifyTime desc) where rownum=1", new Object[]{boardId}, Topic.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	public Topic findTopicById(int topicId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int findTopicCountByBoardId(int boardId) {
		
		return DaoHandle.executeQueryForCount("select count(*) from topic where boardid=?", new Object[]{boardId});
	}
	/**
	 * 分页查询板块中的主贴列表
	 */
	public ArrayList<Topic> findTopicListByBoardId(int boardId, int page) {
		String sql = "select * from (select rownum as topicrow,n.* from (select * from topic where boardid=? order by modifytime desc) n) where topicrow between ? and ? ";
		ArrayList<Topic> list = DaoHandle.executeQuery(sql, new Object[]{boardId,(page-1)*5+1,page*5}, Topic.class);
		return list;
	}

	public void modifyTopicById(Topic topic) {
		// TODO Auto-generated method stub
		
	}

}
