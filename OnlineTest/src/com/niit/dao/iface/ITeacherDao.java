package com.niit.dao.iface;

import com.niit.entiry.Teacher;

public interface ITeacherDao {
	
	/**
	 * 根据教师编号查找教师信息
	 * @param tId
	 * @return
	 */
	public Teacher findTeacherBytId(int tId);

}
