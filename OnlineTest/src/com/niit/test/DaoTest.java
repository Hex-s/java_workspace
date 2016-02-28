package com.niit.test;

import java.security.Timestamp;
import java.sql.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.crypto.Data;

import com.niit.dao.impl.CourseDao;
import com.niit.dao.impl.QuestionsDao;
import com.niit.dao.impl.ScoreDao;
import com.niit.dao.impl.StudentDao;
import com.niit.dao.impl.TeacherDao;
import com.niit.dao.impl.TestDao;
import com.niit.entiry.Course;
import com.niit.entiry.Question;
import com.niit.entiry.Score;
import com.niit.entiry.Student;
import com.niit.entiry.Teacher;
import com.niit.entiry.Test;
import com.niit.util.CommonUtil;
import java.sql.*;

public class DaoTest {
	
	/**
	 * 编写方法产生值是0-任意数不重复的数组
	 */
	private int[] randomArray(int length,int max){
		int[] array = new int[length];
		//产生第一个随机数
		array[0] = (int)(Math.random() * max);
		int temp;
		//产生剩余的随机数
		//从第二个随机数开始产生
		for(int i = 1; i < array.length; i++){
			//产生一个随机数，与已经产生的随机数进行比较，如果重复，则重新产生一个随机数
			temp =  (int)(Math.random() * max);
			//与已经产生的随机数进行比较
			for(int j = 0; j < i; j++){
				if(temp == array[j]){
					//如果重复，则重新产生一个随机数
					temp = (int)(Math.random() * max);
					j = -1;
				}
			}
			array[i] = temp;
		}
		return array;
	}
	
	
	public static void main(String[] args) {
		
		DaoTest t = new DaoTest();
		int[] array = t.randomArray(4, 50);
		for(Integer i : array){
			System.out.println(i);
		}
		
//		StudentDao stuDao = new StudentDao();
//		Student stu = stuDao.findStuByStuid(0);
//		if(stu != null){
//			System.out.println(stu.getStuName());
//		}
//		else{
//			System.out.println("wu");
//		}
		
//		TeacherDao teaDao = new TeacherDao();
//		Teacher tea = teaDao.findTeacherBytId(1);
//		if(tea != null){
//			System.out.println(tea.gettName());
//		}
//		else{
//			System.out.println("wu");
//		}
//		
//		TestDao testDao = new TestDao();
//		ArrayList<Test> list = testDao.findTestByClassId(1);
////		System.out.println(list.size());
//		if(list!= null){
//			for(Test t : list){
//				System.out.println(t.getTestName());
//			}
//		}
//		else{
//			System.out.println("无");
//		}
//		
//		CourseDao csDao = new CourseDao();
//		Course name = csDao.findCourseById(1);
//		System.out.println(name.getCourseName());
//		ArrayList<Course> list = csDao.findAllCourse();
//		for(Course c : list){
//			System.out.println(c.getCourseId()+c.getCourseName());
//		}
		
//		CourseDao csDao = new CourseDao();
//		Course c = csDao.findCourseById(1);
//		System.out.println(c.getCourseName());
//		System.out.println(c.getCourseId());
//		System.out.println(c.getCourseState());
		
//		QuestionsDao qDao = new QuestionsDao();
//		Question q = qDao.findQtByQtId(2);
//		System.out.println(q.getqType());
//		System.out.println(q.getqChoices());
//		System.out.println(q.getqAnswer());
		
//		QuestionsDao qDao = new QuestionsDao();
//		ArrayList<Question> list = qDao.findAllQuestions();
//		for(Question q : list){
//			System.out.println(q.getCourseId()+q.getqAnswer()+q.getqChoices());
//		}
		
//		QuestionsDao qdao = new QuestionsDao();
//		Question q = qdao.findQtByQtId(2);
//		System.out.println(q.getqChoices());
//		String[] choices = q.getqChoices().split("#");
//		System.out.println(choices.length);
//		for(int i = 0; i < choices.length; i++){
//			//int index = choices[i].charAt('.');
//			choices[i] = choices[i].substring(2); 
//			System.out.println(choices[i]);
//			
//		}
//		
		
//		TestDao testDao = new TestDao();	
//		Test test = new Test();
//		test.setClassId(1);
//		test.setCourseId(1);
//		test.setTestName("js考试");
//		test.setMultiCount(10);
//		test.setMultiScore(50);
//		test.setSingleCount(10);
//		test.setSingleScore(50);
//		test.setTotalTime(90);
//		String time = "2014-12-11 14:20:00";
////		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		//Calendar cal = CommonUtil.getCalendar(2014, 11, 13, 11, 30, 00);
//		java.sql.Timestamp ts = new java.sql.Timestamp(2014, 12, 1, 9, 30, 0, 0);
//		test.setStartTime(ts);
//		//System.out.println(ts);
//		testDao.addTest(test);
//		
		
		//test.setStartTime(d);
		
		//testDao.addTest(test);
		
//		ScoreDao scDao = new ScoreDao();
////		ArrayList<Score> list = scDao.findScoreByClassId(1);
////		for(Score s : list){
////			System.out.println(s.getTestId());
////		}
//		double s = scDao.findClassTestAvg(1, 1);
//		System.out.println(s);
//		Calendar cal = Calendar.getInstance();
//		java.sql.Timestamp ts = new java.sql.Timestamp(2014, 12, 1, 9, 30, 0, 0);
//		if(){
//			
//		}
//		System.out.println(CommonUtil.formatDate(cal));
		
//		java.sql.Timestamp ts = new java.sql.Timestamp(2014, 12, 1, 9, 30, 0, 0);
//		System.out.println(ts.getTime());
//		
//		java.util.Date date = new java.util.Date();
//		System.out.println(date.getTime());
		
//		QuestionsDao quDao = new QuestionsDao();
//		ArrayList<Question> list = quDao.findQuestionsByCourseId(1, 0);
//		for(Question q : list){
//			System.out.println(q.getqChoices());
//			System.out.println(q.getqAnswer());
//			System.out.println(q.getqTitle());
//		}
		
		
		
	}

}
