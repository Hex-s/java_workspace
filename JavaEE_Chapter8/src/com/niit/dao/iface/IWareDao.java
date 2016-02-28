package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.bean.Ware;

/**
 * ��Ʒ���ݲ����ӿ�
 * @author Administrator
 *
 */
public interface IWareDao {
	/**
	 * ��ѯ������Ʒ��Ϣ
	 * @return
	 */
	public ArrayList<Ware> findAll();
	/**
	 * ���ݱ�Ų�ѯ��Ʒ��Ϣ
	 * @param wareId
	 * @return
	 */
	public Ware findWareById(int wareId);
	/**
	 * �޸���Ʒ��Ϣ
	 * @param ware
	 */
	public void modifyWare(Ware ware);
}
