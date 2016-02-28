package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Board;

/**
 * ������ݲ����ӿ�
 * @author Administrator
 *
 */
public interface IBoardDao {
	/**
	 * ���ݰ���Ų�ѯ���
	 * @param boardId
	 * @return
	 */
	public Board findBoardById(int boardId);
	
	/**
	 * ���ݸ�����Ų�ѯ��鼯�� 
	 * @param parentId  0��ʾ��ѯ���еĸ����  ���������ʾ��ѯ������Ӧ���Ӱ��
	 * @return
	 */
	public ArrayList<Board> findBoardListById(int parentId);
}
