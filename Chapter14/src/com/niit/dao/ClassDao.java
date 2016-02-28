package com.niit.dao;

import java.util.ArrayList;

import com.niit.bean.Class;
import com.niit.data.Data;

public class ClassDao {
	
	private ArrayList<Class> classData;
	
	public ClassDao(Data data){
		this.classData = data.getClassData();
	}
	/**
	 * ���ݰ༶��Ų��Ұ༶
	 * @param classId
	 * @return
	 */
	public Class findClassById(int classId){
		for(Class clazz : classData){
			if(clazz.getClassId() == classId){
				return clazz;
			}
		}
		return null;
	}
	/**
	 * �����꼶��Ų��Ұ༶
	 * @param gradeId
	 * @return
	 */
	public ArrayList<Class> findClassByGradeId(int gradeId){
		ArrayList<Class> list = new ArrayList<Class>();
		for(Class clazz : classData){
			if(clazz.getGradeId() == gradeId){
				list.add(clazz);
			}
		}
		return list;
	}
}
