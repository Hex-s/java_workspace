package com.niit.studentList;

import java.util.ArrayList;


public class Test {

	public static void main(String[] args) {
		//所有学生信息
		Student stu1 = new Student(1, "A");
		Student stu2 = new Student(2, "B");
		Student stu3 = new Student(1, "C");
		Student stu4 = new Student(2, "D");
		Student stu5 = new Student(1, "E");
		Student stu6 = new Student(2, "F");
		Student stu7 = new Student(1, "G");
		Student stu8 = new Student(2, "H");
		
		//A班
		ArrayList<Student> stuclassA = new ArrayList<Student>();
		if(!stuclassA.contains(stu1)){
			stuclassA.add(stu1);
		}
		if(!stuclassA.contains(stu2)){
			stuclassA.add(stu2);
		}
		//B班
		ArrayList<Student> stuclassB = new ArrayList<Student>();
		if(!stuclassB.contains(stu3)){
			stuclassB.add(stu3);
		}
		if(!stuclassB.contains(stu4)){
			stuclassB.add(stu4);
		}
		//C班
		ArrayList<Student> stuclassC = new ArrayList<Student>();
		if(!stuclassC.contains(stu5)){
			stuclassC.add(stu5);
		}
		if(!stuclassC.contains(stu6)){
			stuclassC.add(stu6);
		}
		//D班
		ArrayList<Student> stuclassD = new ArrayList<Student>();
		if(!stuclassD.contains(stu7)){
			stuclassD.add(stu7);
		}
		if(!stuclassD.contains(stu8)){
			stuclassD.add(stu8);
		}
		//所有班级信息
		Class class1 = new Class("A班", stuclassA);
		Class class2 = new Class("B班", stuclassB);
		Class class3 = new Class("C班", stuclassC);
		Class class4 = new Class("D班", stuclassD);
		
		ArrayList<Class> classList1 = new ArrayList<Class>();
		if(!classList1.contains(class1)){
			classList1.add(class1);
		}
		if(!classList1.contains(class2)){
			classList1.add(class2);
		}
		
		ArrayList<Class> classList2 = new ArrayList<Class>();
		if(!classList2.contains(class3)){
			classList2.add(class3);
		}
		if(!classList2.contains(class4)){
			classList2.add(class4);
		}
		
		Grade grade1 = new Grade("一年级", classList1);
		Grade grade2 = new Grade("二年级", classList2);
		ArrayList<Grade> gradeList = new ArrayList<Grade>();
		if(!gradeList.contains(grade1)){
			gradeList.add(grade1);
		}
		if(!gradeList.contains(grade2)){
			gradeList.add(grade2);
		}
		

		for(Grade grade: gradeList){
			System.out.println(grade.getGradeName());
			for(Class classList: grade.getClasses()){
				System.out.println("\t"+classList.getClassName());
				System.out.println("\t"+"\t"+"学号"+"\t"+"姓名"+"\t");
				for(Student stuList: classList.getStudents()){
					System.out.println("\t\t"+stuList.getStuId()+"\t"+stuList.getStuName());
				}
			}
		}
	}
}
