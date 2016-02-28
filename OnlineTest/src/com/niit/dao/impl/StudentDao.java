package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IStudentDao;
import com.niit.entiry.Student;
import com.niit.util.DaoHandle;

public class StudentDao implements IStudentDao{

	/**
	 * 根据学生编号查找学生信息
	 */
	@Override
	public Student findStuByStuid(int stuId) {
		ArrayList<Student> list = DaoHandle.executeQuery("select * from student where stuid=?", new Object[]{stuId}, Student.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据学生姓名查找学生信息
	 */
	@Override
	public Student findStuByStuName(String name) {
		ArrayList<Student> list = DaoHandle.executeQuery("select * from student where stuname=?", new Object[]{name}, Student.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
