package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.ITeacherDao;
import com.niit.entiry.Teacher;
import com.niit.util.DaoHandle;

public class TeacherDao implements ITeacherDao{

	@Override
	public Teacher findTeacherBytId(int tId) {
		ArrayList<Teacher> list = DaoHandle.executeQuery("select * from teacher where tid=?", new Object[]{tId}, Teacher.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
