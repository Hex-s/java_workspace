package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Question;

public interface IQuestionsDao {
	
	/**
	 * 查找所有的试题
	 * @return
	 */
	public ArrayList<Question> findAllQuestions();

	
	/**
	 * 修改试题
	 * @param qt
	 */
	public void modifyQuestions(Question qt);
	
	/**
	 * 删除试题
	 * @param qId
	 */
	public void deleteQuestions(int qId);

	/**
	 * 根据试题编号查找试题
	 * @param qid
	 * @return
	 */
	public Question findQtByQtId(int qid);
	
	/**
	 * 添加试题
	 * @param q
	 */
	public void addQuestion(Question q);
	
	/**
	 * 根据课程编号和题型查找试题
	 * @param courseId
	 * @return
	 */
	public ArrayList<Question> findQuestionsByCourseId(int courseId,int qType);
}
