package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IStudentDao;
import com.niit.entiry.Student;
import com.niit.util.DaoHandle;

public class StudentDao implements IStudentDao{

	/**
	 * ����ѧ����Ų���ѧ����Ϣ
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
	 * ����ѧ����������ѧ����Ϣ
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
