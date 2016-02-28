package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.ITopicDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entity.Topic;

public class TopicDao implements ITopicDao {

	/**
	 * ��������
	 */
	public void addTopic(Topic topic) {
		DaoHandle.executeUpdate("insert into bbstopics values(sq_bbstopics_tid.nextval,?,?,?,?,sysdate,sysdate,0,0)", new Object[]{topic.getTbId(),topic.gettUserId(),topic.gettTitle(),topic.gettContent()});
	}

	/**
	 * ���ݰ���Ų�ѯ���η���
	 */
	public Topic findLastTopicByBlockdId(int boardId) {
		ArrayList<Topic> list = DaoHandle.executeQuery("select * from (select * from bbstopics where tbid=? order by tlastedit desc) where rownum=1", new Object[]{boardId}, Topic.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * ����������Ų�ѯ����
	 */
	public Topic findTopicById(int topicId) {
		ArrayList<Topic> list = DaoHandle.executeQuery("select * from bbstopics where tid=?",new Object[]{topicId},Topic.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * ���ݰ���Ų�ѯ��������
	 */
	public int findTopicCountByBlockdId(int boardId) {
		
		return DaoHandle.executeQueryForCount("select count(*) from bbstopics where tbid=?", new Object[]{boardId});
	}
	/**
	 * ��ҳ��ѯ����е������б�
	 */
	public ArrayList<Topic> findTopicListByBlockId(int boardId, int page) {
		String sql = "select * from (select rownum as topicrow,n.* from (select * from bbstopics where tbid=? order by tlastedit desc) n) where topicrow between ? and ? ";
		ArrayList<Topic> list = DaoHandle.executeQuery(sql, new Object[]{boardId,(page-1)*5+1,page*5}, Topic.class);
		return list;
	}
	
	/**
	 * ������������޸������Ƿ�Ϊ������
	 */
	public void modifyTopicFlag(int tid, int flag) {
		DaoHandle.executeUpdate("update bbstopics set tflag=? where tid=?", new Object[]{flag,tid});
		
	}

	/**
	 * ���������
	 */
	public void addClickCount(int topicId) {
		DaoHandle.executeUpdate("update bbstopics set tclickcount=tclickcount+1 where tid=?", new Object[]{topicId});
		
	}


	/**
	 * ������������޸�����
	 */
	public void modifyTopicById(int topicId, String title, String content) {
		DaoHandle.executeUpdate("update bbstopics set ttitle=?,tcontent=?,tlastedit=sysdate where tid=?", new Object[]{title,content,topicId});
		
	}


	/**
	 * �������ӱ��ɾ������
	 */
	public void deleteTopicByTopicId(int topicId) {
		DaoHandle.executeUpdate("delete from bbstopics where tid=?", new Object[]{topicId});
		
	}
	
	/**
	 * �����û���ŷ�ҳ�����û����е�����
	 */
	public ArrayList<Topic> findTopicListByUserId(int userId, int page) {
		String sql = "select * from (select rownum as topicrow,n.* from (select * from bbstopics where tuserid=? order by tlastedit desc) n) where topicrow between ? and ? ";
		ArrayList<Topic> list = DaoHandle.executeQuery(sql, new Object[]{userId,(page-1)*5+1,page*5}, Topic.class);
		return list;
	}

	/**
	 * �����û���Ų�����������
	 */
	public int findTopicCountByUserId(int userId) {
		return DaoHandle.executeQueryForCount("select count(*) from bbstopics where tuserid=?", new Object[]{userId});
	}

	
	
}
