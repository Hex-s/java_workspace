package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Topic;

/**
 * �������ݲ����ӿ�
 * @author Administrator
 *
 */
public interface ITopicDao {
	/**
	 * ��������
	 * @param topic
	 */
	public void addTopic(Topic topic);
	
	/**
	 * ������������޸�����
	 * @param topic
	 */
	public void modifyTopicById(int topicId,String title,String content);

	/**
	 * ���ݰ���ŷ�ҳ��ѯ��������
	 * @param boardId
	 * @return
	 */
	public ArrayList<Topic> findTopicListByBlockId(int boardId, int page);
	
	/**
	 * ����������Ų�ѯ����
	 * @param topicId
	 * @return
	 */
	public Topic findTopicById(int topicId);
	
	/**
	 * ���ݰ���Ų�ѯ��������
	 * @param boardId
	 * @return
	 */
	public int findTopicCountByBlockdId(int boardId);
	
	/**
	 * ���ݰ���Ų�ѯ���η���
	 * @param boardId
	 * @return
	 */
	public Topic findLastTopicByBlockdId(int boardId);
	
	/**
	 * ������������޸������Ƿ�Ϊ������
	 * @param tid
	 * @param flag
	 */
	public void modifyTopicFlag(int tid,int flag);
	
	/**
	 * ���������
	 * @param topicId
	 */
	public void addClickCount(int topicId);
	
	
	/**
	 * �������ӱ��ɾ������
	 * @param topicId
	 */
	public void deleteTopicByTopicId(int topicId);
	
	/**
	 * �����û���ŷ�ҳ�����û����е�����
	 * @param userId
	 */
	public ArrayList<Topic> findTopicListByUserId(int userId,int page);
	
	/**
	 * �����û���Ų�����������
	 * @param userId
	 * @return
	 */
	public int findTopicCountByUserId(int userId);
}
