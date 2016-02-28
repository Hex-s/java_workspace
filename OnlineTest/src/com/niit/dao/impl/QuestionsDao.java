package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IQuestionsDao;
import com.niit.entiry.Question;
import com.niit.entiry.Student;
import com.niit.util.DaoHandle;

public class QuestionsDao  implements IQuestionsDao{

	/**
	 * 查找所有的试题
	 */
	@Override
	public ArrayList<Question> findAllQuestions() {
		ArrayList<Question> list = DaoHandle.executeQuery("select * from questions order by courseid,qtype", null, Question.class);
		return list;
	}

	/**
	 * 修改试题
	 */
	@Override
	public void modifyQuestions(Question q) {
		DaoHandle.executeUpdate("update questions set courseid=?,qtitle=?,qtype=?,qanswer=?,qchoices=? where qid=?", new Object[]{q.getCourseId(),q.getqTitle(),q.getqType(),q.getqAnswer(),q.getqChoices(),q.getQid()});
	}

	/**
	 *  删除试题
	 */
	@Override
	public void deleteQuestions(int qId) {
		DaoHandle.executeUpdate("delete from questions where qid=?", new Object[]{qId});
	}

	/**
	 * 根据试题编号查找试题
	 */
	@Override
	public Question findQtByQtId(int qId) {
		ArrayList<Question> list = DaoHandle.executeQuery("select * from questions where qid=?", new Object[]{qId}, Question.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 添加试题
	 */
	@Override
	public void addQuestion(Question q) {
		DaoHandle.executeUpdate("insert into questions values(seq_qtid.nextval,?,?,?,?,?)", new Object[]{q.getCourseId(),q.getqType(),q.getqTitle(),q.getqChoices(),q.getqAnswer()});
		
	}

	/**
	 * 根据课程编号查找试题
	 */
	@Override
	public ArrayList<Question> findQuestionsByCourseId(int courseId,int qType) {
		ArrayList<Question> list = DaoHandle.executeQuery("select * from questions where courseid=? and qtype=?", new Object[]{courseId,qType}, Question.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

}
