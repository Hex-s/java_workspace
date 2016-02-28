package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.niit.dao.iface.ITestDao;
import com.niit.entiry.Test;
import com.niit.util.DaoHandle;
import com.niit.util.DaoUtil;

public class TestDao  implements ITestDao{

	/**
	 * 查找学生可以进行的测试
	 */
	@Override
	public ArrayList<Test> findTestByStu(int classId,int stuId) {
		ArrayList<Test> list = DaoHandle.executeQuery("select * from test where classid=? and isend=0 and starttime+totaltime/1440>sysdate and testid not in(select testid from score where stuid=?)", new Object[]{classId,stuId}, Test.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	/**
	 * 添加试题
	 */
	@Override
	public void addTest(Test t) {
		DaoHandle.executeUpdate("insert into test values(seq_testid.nextval,?,?,?,?,?,?,?,?,?,0)", new Object[]{t.getTestName(),t.getCourseId(),t.getStartTime(),t.getTotalTime(),t.getClassId(),t.getSingleCount(),t.getSingleScore(),t.getMultiCount(),t.getMultiScore()});
	}

	/**
	 * 根据测试编号查找测试信息
	 */
	@Override
	public Test findTestByTestId(int testId) {
		ArrayList<Test> list = DaoHandle.executeQuery("select * from test where testid=?", new Object[]{testId}, Test.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 查找所有的测试
	 */
	@Override
	public ArrayList<Test> findAllTests() {
		ArrayList<Test> list = DaoHandle.executeQuery("select * from test where isend=0 order by starttime", null, Test.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	/**
	 * 删除测试
	 */
	@Override
	public void deleteTestByTestId(int testId) {
		DaoHandle.executeUpdate("update test set isend=1 where testid=?", new Object[]{testId});
	}

	

}
