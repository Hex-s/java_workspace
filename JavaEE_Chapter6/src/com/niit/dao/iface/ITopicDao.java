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
	public void modifyTopicById(Topic topic);

	/**
	 * ���ݰ���ŷ�ҳ��ѯ��������
	 * @param boardId
	 * @return
	 */
	public ArrayList<Topic> findTopicListByBoardId(int boardId, int page);
	
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
	public int findTopicCountByBoardId(int boardId);
	
	/**
	 * ���ݰ���Ų�ѯ���η���
	 * @param boardId
	 * @return
	 */
	public Topic findLastTopicByBoardId(int boardId);
}
