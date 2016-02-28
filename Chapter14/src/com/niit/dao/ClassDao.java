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
	 * 根据班级编号查找班级
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
	 * 根据年级编号查找班级
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
