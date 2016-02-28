package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Question;

public interface IQuestionsDao {
	
	/**
	 * �������е�����
	 * @return
	 */
	public ArrayList<Question> findAllQuestions();

	
	/**
	 * �޸�����
	 * @param qt
	 */
	public void modifyQuestions(Question qt);
	
	/**
	 * ɾ������
	 * @param qId
	 */
	public void deleteQuestions(int qId);

	/**
	 * ���������Ų�������
	 * @param qid
	 * @return
	 */
	public Question findQtByQtId(int qid);
	
	/**
	 * �������
	 * @param q
	 */
	public void addQuestion(Question q);
	
	/**
	 * ���ݿγ̱�ź����Ͳ�������
	 * @param courseId
	 * @return
	 */
	public ArrayList<Question> findQuestionsByCourseId(int courseId,int qType);
}
