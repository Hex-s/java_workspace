package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.ITopicDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entity.Topic;

public class TopicDao implements ITopicDao {

	/**
	 * 新增主贴
	 */
	public void addTopic(Topic topic) {
		DaoHandle.executeUpdate("insert into bbstopics values(sq_bbstopics_tid.nextval,?,?,?,?,sysdate,sysdate,0,0)", new Object[]{topic.getTbId(),topic.gettUserId(),topic.gettTitle(),topic.gettContent()});
	}

	/**
	 * 根据板块编号查询最后次发帖
	 */
	public Topic findLastTopicByBlockdId(int boardId) {
		ArrayList<Topic> list = DaoHandle.executeQuery("select * from (select * from bbstopics where tbid=? order by tlastedit desc) where rownum=1", new Object[]{boardId}, Topic.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据主贴编号查询主贴
	 */
	public Topic findTopicById(int topicId) {
		ArrayList<Topic> list = DaoHandle.executeQuery("select * from bbstopics where tid=?",new Object[]{topicId},Topic.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据板块编号查询主贴数量
	 */
	public int findTopicCountByBlockdId(int boardId) {
		
		return DaoHandle.executeQueryForCount("select count(*) from bbstopics where tbid=?", new Object[]{boardId});
	}
	/**
	 * 分页查询板块中的主贴列表
	 */
	public ArrayList<Topic> findTopicListByBlockId(int boardId, int page) {
		String sql = "select * from (select rownum as topicrow,n.* from (select * from bbstopics where tbid=? order by tlastedit desc) n) where topicrow between ? and ? ";
		ArrayList<Topic> list = DaoHandle.executeQuery(sql, new Object[]{boardId,(page-1)*5+1,page*5}, Topic.class);
		return list;
	}
	
	/**
	 * 根据主贴编号修改主贴是否为精华帖
	 */
	public void modifyTopicFlag(int tid, int flag) {
		DaoHandle.executeUpdate("update bbstopics set tflag=? where tid=?", new Object[]{flag,tid});
		
	}

	/**
	 * 新增点击量
	 */
	public void addClickCount(int topicId) {
		DaoHandle.executeUpdate("update bbstopics set tclickcount=tclickcount+1 where tid=?", new Object[]{topicId});
		
	}


	/**
	 * 根据主贴编号修改主贴
	 */
	public void modifyTopicById(int topicId, String title, String content) {
		DaoHandle.executeUpdate("update bbstopics set ttitle=?,tcontent=?,tlastedit=sysdate where tid=?", new Object[]{title,content,topicId});
		
	}


	/**
	 * 根据帖子编号删除主贴
	 */
	public void deleteTopicByTopicId(int topicId) {
		DaoHandle.executeUpdate("delete from bbstopics where tid=?", new Object[]{topicId});
		
	}
	
	/**
	 * 根据用户编号分页查找用户所有的帖子
	 */
	public ArrayList<Topic> findTopicListByUserId(int userId, int page) {
		String sql = "select * from (select rownum as topicrow,n.* from (select * from bbstopics where tuserid=? order by tlastedit desc) n) where topicrow between ? and ? ";
		ArrayList<Topic> list = DaoHandle.executeQuery(sql, new Object[]{userId,(page-1)*5+1,page*5}, Topic.class);
		return list;
	}

	/**
	 * 根据用户编号查找主贴数量
	 */
	public int findTopicCountByUserId(int userId) {
		return DaoHandle.executeQueryForCount("select count(*) from bbstopics where tuserid=?", new Object[]{userId});
	}

	
	
}
