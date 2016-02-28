package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IBoardDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entity.Board;

/**
 * 板块数据操作类
 * @author Administrator
 *
 */
public class BoardDao implements IBoardDao {

	public Board findBoardById(int boardId) {
		ArrayList<Board> list = DaoHandle.executeQuery("select * from board where boardid=?", new Object[]{boardId}, Board.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	public ArrayList<Board> findBoardListById(int parentId) {
		return DaoHandle.executeQuery("select * from board where parentid=?", new Object[]{parentId}, Board.class);
	}
	
}
