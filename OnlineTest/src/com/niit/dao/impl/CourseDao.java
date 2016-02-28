package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.ICourseDao;
import com.niit.entiry.Course;
import com.niit.util.DaoHandle;

public class CourseDao implements ICourseDao{

	/**
	 * 查找所有的课程
	 */
	@Override
	public ArrayList<Course> findAllCourse() {
		ArrayList<Course> list = DaoHandle.executeQuery("select * from course where coursestate=1", null, Course.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	/**
	  * 添加科目
	 */
	@Override
	public void addCourse(String name) {
		DaoHandle.executeUpdate("insert into course values(seq_courseid.nextval,?,1)", new Object[]{name});
		
	}

	/**
	 * 修改科目信息
	 */
	@Override
	public void modifyCourse(int courseId,String name) {
		DaoHandle.executeUpdate("update course set coursename=? where courseid=?", new Object[]{name,courseId});
		
	}

	/**
	 * 删除科目
	 */
	@Override
	public void deleteCourse(int courseId) {
		
		DaoHandle.executeUpdate("update course set coursestate=0  where courseid=?", new Object[]{courseId});
	}

	

	/**
	 *  根据课程名称查找课程
	 */
	@Override
	public Course findCourseByCourseName(String name) {
		ArrayList<Course> list = DaoHandle.executeQuery("select * from course where coursename=?", new Object[]{name}, Course.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据课程编号查找课程
	 */
	@Override
	public Course findCourseById(int id) {
		ArrayList<Course> list = DaoHandle.executeQuery("select * from course where courseid=?", new Object[]{id}, Course.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 将关闭的课程重新打开
	 */
	@Override
	public void modifyCourseState(int courseId) {
		DaoHandle.executeUpdate("update course set coursestate=1 where courseid=?", new Object[]{courseId});
		
	}

	

	
	

}
