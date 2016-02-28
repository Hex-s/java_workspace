package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Student;

public interface IStudentDao {
	
	/**
	 * 根据学生编号查找学生信息
	 * @param stuId
	 * @return
	 */
	public Student findStuByStuid(int stuId);
	
	
	/**
	 * 根据学生姓名查找学生信息
	 * @param name
	 * @return
	 */
	public Student findStuByStuName(String name);

}
