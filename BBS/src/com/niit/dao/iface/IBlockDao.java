package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Block;

/**
 * ������ݲ����ӿ�
 * @author Administrator
 *
 */
public interface IBlockDao {
	/**
	 * ���ݰ���Ų�ѯ���
	 * @param boardId
	 * @return
	 */
	public Block findBlockById(int boardId);
	
	/**
	 * ���ݸ�����Ų�ѯ��鼯�� 
	 * @param parentId  0��ʾ��ѯ���еĸ����  ���������ʾ��ѯ������Ӧ���Ӱ��
	 * @return
	 */
	public ArrayList<Block> findBlockListById(int parentId);
	
}
