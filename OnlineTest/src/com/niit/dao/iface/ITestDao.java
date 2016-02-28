package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Test;

public interface ITestDao {
	
	/**
	 * 查找学生可以进行的测试
	 * @param classId
	 * @return
	 */
	public ArrayList<Test> findTestByStu(int classId,int stuId);
	
	/**
	 * 添加试题
	 * @param t
	 */
	public void addTest(Test t);
	
	/**
	 * 根据测试编号查找测试信息
	 * @param testId
	 * @return
	 */
	public Test findTestByTestId(int testId);
	
	
	/**
	 * 查找所有的测试
	 */
	public ArrayList<Test> findAllTests();
	
	/**
	 * 删除测试
	 */
	public void deleteTestByTestId(int testId);
	

}
