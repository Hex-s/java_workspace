package com.niit.dao.iface;

import com.niit.entiry.Teacher;

public interface ITeacherDao {
	
	/**
	 * ���ݽ�ʦ��Ų��ҽ�ʦ��Ϣ
	 * @param tId
	 * @return
	 */
	public Teacher findTeacherBytId(int tId);

}
