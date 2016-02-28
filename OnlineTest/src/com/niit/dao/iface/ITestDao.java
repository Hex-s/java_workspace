package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Test;

public interface ITestDao {
	
	/**
	 * ����ѧ�����Խ��еĲ���
	 * @param classId
	 * @return
	 */
	public ArrayList<Test> findTestByStu(int classId,int stuId);
	
	/**
	 * �������
	 * @param t
	 */
	public void addTest(Test t);
	
	/**
	 * ���ݲ��Ա�Ų��Ҳ�����Ϣ
	 * @param testId
	 * @return
	 */
	public Test findTestByTestId(int testId);
	
	
	/**
	 * �������еĲ���
	 */
	public ArrayList<Test> findAllTests();
	
	/**
	 * ɾ������
	 */
	public void deleteTestByTestId(int testId);
	

}
