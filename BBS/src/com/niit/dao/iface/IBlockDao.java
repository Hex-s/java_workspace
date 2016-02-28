package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Block;

/**
 * 板块数据操作接口
 * @author Administrator
 *
 */
public interface IBlockDao {
	/**
	 * 根据板块编号查询板块
	 * @param boardId
	 * @return
	 */
	public Block findBlockById(int boardId);
	
	/**
	 * 根据父板块编号查询板块集合 
	 * @param parentId  0表示查询所有的父板块  其余情况表示查询父板块对应的子版块
	 * @return
	 */
	public ArrayList<Block> findBlockListById(int parentId);
	
}
