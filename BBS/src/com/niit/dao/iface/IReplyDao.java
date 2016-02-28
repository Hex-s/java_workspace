package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Reply;

/**
 * 回帖数据操作接口
 * @author Administrator
 *
 */
public interface IReplyDao {
	
	/**
	 * 新增回帖
	 * @param reply
	 */
	public void addReply(Reply reply);
	
	/**
	 * 根据回帖编号查询回帖
	 * @param reply
	 * @return
	 */
	public Reply findReplyById(int reply);
	
	/**
	 * 根据主贴编号分页查询回帖集合
	 * @param topicId
	 * @param page
	 * @return
	 */
	public ArrayList<Reply> findReplyListByTopicId(int topicId, int page);
	
	/**
	 * 根据主贴编号查询回帖数量
	 * @param topicId
	 * @return
	 */
	public int findReplyCountByTopicId(int topicId);
	
	/**
	 * 删除某主贴的所有回帖
	 * @param topicId
	 */
	public void deleteReplysByTopicId(int topicId);
	
	/**
	 * 根据回帖编号删除回帖
	 * @param tid
	 */
	public void deleteReplyByRid(int rid);
	
}
