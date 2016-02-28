package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Topic;

/**
 * 主贴数据操作接口
 * @author Administrator
 *
 */
public interface ITopicDao {
	/**
	 * 新增主贴
	 * @param topic
	 */
	public void addTopic(Topic topic);
	
	/**
	 * 根据主贴编号修改主贴
	 * @param topic
	 */
	public void modifyTopicById(int topicId,String title,String content);

	/**
	 * 根据板块编号分页查询主贴集合
	 * @param boardId
	 * @return
	 */
	public ArrayList<Topic> findTopicListByBlockId(int boardId, int page);
	
	/**
	 * 根据主贴编号查询主贴
	 * @param topicId
	 * @return
	 */
	public Topic findTopicById(int topicId);
	
	/**
	 * 根据板块编号查询主贴数量
	 * @param boardId
	 * @return
	 */
	public int findTopicCountByBlockdId(int boardId);
	
	/**
	 * 根据板块编号查询最后次发帖
	 * @param boardId
	 * @return
	 */
	public Topic findLastTopicByBlockdId(int boardId);
	
	/**
	 * 根据主贴编号修改主贴是否为精华帖
	 * @param tid
	 * @param flag
	 */
	public void modifyTopicFlag(int tid,int flag);
	
	/**
	 * 新增点击量
	 * @param topicId
	 */
	public void addClickCount(int topicId);
	
	
	/**
	 * 根据帖子编号删除主贴
	 * @param topicId
	 */
	public void deleteTopicByTopicId(int topicId);
	
	/**
	 * 根据用户编号分页查找用户所有的帖子
	 * @param userId
	 */
	public ArrayList<Topic> findTopicListByUserId(int userId,int page);
	
	/**
	 * 根据用户编号查找主贴数量
	 * @param userId
	 * @return
	 */
	public int findTopicCountByUserId(int userId);
}
