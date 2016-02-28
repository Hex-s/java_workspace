package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Course;

public interface ICourseDao {
	
	/**
	 * 查找所有的科目
	 * @return
	 */
	public ArrayList<Course>  findAllCourse();
	
	
	/**
	 * 添加科目
	 * @param name
	 */
	public void addCourse(String name);

	/**
	 * 修改科目信息
	 * @param courseId
	 */
	public void modifyCourse(int courseId,String name);
	
	/**
	 * 删除科目
	 * @param courseId
	 */
	public void deleteCourse(int courseId);
	
	/**
	 * 根据课程编号查找课程
	 * @param id
	 * @return
	 */
	public Course findCourseById(int id);
	
	/**
	 * 根据课程名称查找课程
	 * @param name
	 * @return
	 */
	public Course findCourseByCourseName(String name);
	
	/**
	 * 将关闭的课程重新打开
	 * @param courseId
	 */
	public void modifyCourseState(int courseId);
}
