package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.ICourseDao;
import com.niit.entiry.Course;
import com.niit.util.DaoHandle;

public class CourseDao implements ICourseDao{

	/**
	 * �������еĿγ�
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
	  * ��ӿ�Ŀ
	 */
	@Override
	public void addCourse(String name) {
		DaoHandle.executeUpdate("insert into course values(seq_courseid.nextval,?,1)", new Object[]{name});
		
	}

	/**
	 * �޸Ŀ�Ŀ��Ϣ
	 */
	@Override
	public void modifyCourse(int courseId,String name) {
		DaoHandle.executeUpdate("update course set coursename=? where courseid=?", new Object[]{name,courseId});
		
	}

	/**
	 * ɾ����Ŀ
	 */
	@Override
	public void deleteCourse(int courseId) {
		
		DaoHandle.executeUpdate("update course set coursestate=0  where courseid=?", new Object[]{courseId});
	}

	

	/**
	 *  ���ݿγ����Ʋ��ҿγ�
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
	 * ���ݿγ̱�Ų��ҿγ�
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
	 * ���رյĿγ����´�
	 */
	@Override
	public void modifyCourseState(int courseId) {
		DaoHandle.executeUpdate("update course set coursestate=1 where courseid=?", new Object[]{courseId});
		
	}

	

	
	

}
