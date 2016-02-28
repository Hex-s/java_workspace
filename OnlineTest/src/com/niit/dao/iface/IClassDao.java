package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Classes;

public interface IClassDao {
	
	/**
	 * 获取所有的班级
	 * @return
	 */
	public ArrayList<Classes> findAllClasses();
	
	/**
	 * 根据班级名获得班级信息
	 * @return
	 */
	public Classes findClassByName(String className);
	
	/**
	 * 根据班级编号获得班级信息
	 * @param classId
	 * @return
	 */
	public Classes findClassById(int classId);

}
