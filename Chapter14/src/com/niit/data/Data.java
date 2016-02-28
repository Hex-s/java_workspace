package com.niit.data;

import java.util.ArrayList;

import com.niit.bean.Class;
import com.niit.bean.Grade;
import com.niit.bean.Student;

public class Data {

	private ArrayList<Student> stuData;
	private ArrayList<Grade> gradeData;
	private ArrayList<Class> classData;
	
	public Data(){
		stuData = new ArrayList<Student>();
		gradeData = new ArrayList<Grade>();
		classData = new ArrayList<Class>();
//		Student stu1 = new Student(1, "tom", 20, "男");
//		Student stu2 = new Student(2, "jack", 23, "男");
//		Student stu3 = new Student(3, "marry", 21, "女");
//		stuData.add(stu1);
//		stuData.add(stu2);
//		stuData.add(stu3);
		
		
		
		//初始化年级信息
		Grade grade1 = new Grade(1, "年级A");
		Grade grade2 = new Grade(2, "年级B");
		Grade grade3 = new Grade(3, "年级C");
		//初始化班级
		Class class1 = new Class(1, "班级A", 1);
		Class class2 = new Class(2, "班级B", 1);
		Class class3 = new Class(3, "班级C", 2);
		Class class4 = new Class(4, "班级D", 2);
		Class class5 = new Class(5, "班级E", 2);
		Class class6 = new Class(6, "班级F", 3);
		//初始化学生信息
		Student stu1 = new Student(1, "student A", 20, "男", 1);
		Student stu3 = new Student(3, "student C", 20, "男", 1);
		Student stu4 = new Student(4, "student D", 20, "男", 1);
		Student stu5 = new Student(5, "student E", 20, "女", 2);
		Student stu6 = new Student(6, "student F", 20, "男", 2);
		Student stu7 = new Student(7, "student I", 20, "女", 2);
		Student stu8 = new Student(8, "student J", 20, "男", 3);
		Student stu9 = new Student(9, "student K", 20, "男", 3);
		Student stu10 = new Student(10, "student L", 20, "女", 3);
		Student stu11 = new Student(11, "student M", 20, "男", 4);
		Student stu12 = new Student(12, "student N", 20, "男", 4);
		Student stu13 = new Student(13, "student O", 20, "女", 5);
		Student stu14 = new Student(14, "student P", 20, "男", 5);
		Student stu15 = new Student(15, "student Q", 20, "男", 6);
		Student stu16 = new Student(16, "student R", 20, "男", 6);
		
		//添加年级
		gradeData.add(grade1);
		gradeData.add(grade2);
		gradeData.add(grade3);
		//班级班级
		classData.add(class1);
		classData.add(class2);
		classData.add(class3);
		classData.add(class4);
		classData.add(class5);
		classData.add(class6);
		//添加学生
		stuData.add(stu1);
		stuData.add(stu3);
		stuData.add(stu4);
		stuData.add(stu5);
		stuData.add(stu6);
		stuData.add(stu7);
		stuData.add(stu8);
		stuData.add(stu9);
		stuData.add(stu10);
		stuData.add(stu11);
		stuData.add(stu12);
		stuData.add(stu13);
		stuData.add(stu14);
		stuData.add(stu15);
		stuData.add(stu16);
		
		
	}

	public ArrayList<Grade> getGradeData() {
		return gradeData;
	}

	public void setGradeData(ArrayList<Grade> gradeData) {
		this.gradeData = gradeData;
	}

	public ArrayList<Class> getClassData() {
		return classData;
	}

	public void setClassData(ArrayList<Class> classData) {
		this.classData = classData;
	}

	public void setStuData(ArrayList<Student> stuData) {
		this.stuData = stuData;
	}

	public ArrayList<Student> getStuData() {
		return stuData;
	}
	
}
