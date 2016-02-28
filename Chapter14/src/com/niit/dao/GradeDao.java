package com.niit.dao;

import java.util.ArrayList;

import com.niit.bean.Grade;
import com.niit.data.Data;

public class GradeDao {
	
	private ArrayList<Grade> gradeData;
	
	public GradeDao(Data data){
		this.gradeData = data.getGradeData();
	}
	public ArrayList<Grade> findAllGrade(){
		return this.gradeData;
	}
}
