package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Student;

public interface IStudentDao {
	
	/**
	 * ����ѧ����Ų���ѧ����Ϣ
	 * @param stuId
	 * @return
	 */
	public Student findStuByStuid(int stuId);
	
	
	/**
	 * ����ѧ����������ѧ����Ϣ
	 * @param name
	 * @return
	 */
	public Student findStuByStuName(String name);

}
