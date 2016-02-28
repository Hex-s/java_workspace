package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IBlockDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entity.Block;

/**
 * 板块数据操作类
 * @author Administrator
 *
 */
public class BlockDao implements IBlockDao {

	/**
	 * 根据板块编号查询板块
	 */
	public Block findBlockById(int boardId) {
		ArrayList<Block> list = DaoHandle.executeQuery("select * from bbsblock where bid=?", new Object[]{boardId}, Block.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	public ArrayList<Block> findBlockListById(int parentId) {
		return DaoHandle.executeQuery("select * from bbsblock where prarentid=?", new Object[]{parentId}, Block.class);
	}
	
}
