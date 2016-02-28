package com.niit.dao;

import java.util.ArrayList;

import com.niit.bean.Student;
import com.niit.data.Data;

public class StudentDao {
	
	private ArrayList<Student> stuData;
	
	public StudentDao(Data data){
		this.stuData = data.getStuData();
	}
	/**
	 * ���ݰ༶��Ų���ѧ��
	 * @param classId
	 * @return
	 */
	public ArrayList<Student> findStudentByClassId(int classId){
		ArrayList<Student> list = new ArrayList<Student>();
		for(Student stu : stuData){
			if(stu.getClassId() == classId){
				list.add(stu);
			}
		}
		return list;
	}
	/**
	 * ���ѧ��
	 * @param stu
	 */
	public void addStudent(Student stu){
		this.stuData.add(stu);
	}
	
	
	/**
	 * ���ݱ�Ų���ѧ��
	 * @param stuId
	 * @return
	 */
	public Student findById(int stuId){
		Student stu = null;
		for(Student s : stuData){
			if(s.getStuId() == stuId){
				stu = s;
				break;
			}
		}
		return stu;
	}
	/**
	 * ɾ��ѧ��
	 * @param stuId
	 */
	public void delete(int stuId){
		Student stu = findById(stuId);
		if(stu != null){
			stuData.remove(stu);
		}
	}
	
	public void modify(Student stu){
		Student student = findById(stu.getStuId());
		if(student != null){
			int index = this.stuData.indexOf(student);
			this.stuData.set(index, stu);
		}
		
	}
	/**
	 * ��������ѧ��
	 * @return
	 */
	public ArrayList<Student> findAll(){
		return stuData;
	}
}
