package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Reply;

/**
 * �������ݲ����ӿ�
 * @author Administrator
 *
 */
public interface IReplyDao {
	
	/**
	 * ��������
	 * @param reply
	 */
	public void addReply(Reply reply);
	
	/**
	 * ���ݻ�����Ų�ѯ����
	 * @param reply
	 * @return
	 */
	public Reply findReplyById(int reply);
	
	/**
	 * ����������ŷ�ҳ��ѯ��������
	 * @param topicId
	 * @param page
	 * @return
	 */
	public ArrayList<Reply> findReplyListByTopicId(int topicId, int page);
	
	/**
	 * ����������Ų�ѯ��������
	 * @param topicId
	 * @return
	 */
	public int findReplyCountByTopicId(int topicId);
	
	/**
	 * ���ݻ�������޸Ļ���
	 * @param reply
	 */
	public void modifyReplyById(Reply reply);
	
	
}
