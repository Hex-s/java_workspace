package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Course;

public interface ICourseDao {
	
	/**
	 * �������еĿ�Ŀ
	 * @return
	 */
	public ArrayList<Course>  findAllCourse();
	
	
	/**
	 * ��ӿ�Ŀ
	 * @param name
	 */
	public void addCourse(String name);

	/**
	 * �޸Ŀ�Ŀ��Ϣ
	 * @param courseId
	 */
	public void modifyCourse(int courseId,String name);
	
	/**
	 * ɾ����Ŀ
	 * @param courseId
	 */
	public void deleteCourse(int courseId);
	
	/**
	 * ���ݿγ̱�Ų��ҿγ�
	 * @param id
	 * @return
	 */
	public Course findCourseById(int id);
	
	/**
	 * ���ݿγ����Ʋ��ҿγ�
	 * @param name
	 * @return
	 */
	public Course findCourseByCourseName(String name);
	
	/**
	 * ���رյĿγ����´�
	 * @param courseId
	 */
	public void modifyCourseState(int courseId);
}
