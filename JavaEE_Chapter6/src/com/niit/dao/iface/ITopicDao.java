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
	public void modifyTopicById(Topic topic);

	/**
	 * 根据板块编号分页查询主贴集合
	 * @param boardId
	 * @return
	 */
	public ArrayList<Topic> findTopicListByBoardId(int boardId, int page);
	
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
	public int findTopicCountByBoardId(int boardId);
	
	/**
	 * 根据板块编号查询最后次发帖
	 * @param boardId
	 * @return
	 */
	public Topic findLastTopicByBoardId(int boardId);
}
