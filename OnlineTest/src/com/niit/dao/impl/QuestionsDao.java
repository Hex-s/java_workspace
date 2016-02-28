package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IQuestionsDao;
import com.niit.entiry.Question;
import com.niit.entiry.Student;
import com.niit.util.DaoHandle;

public class QuestionsDao  implements IQuestionsDao{

	/**
	 * �������е�����
	 */
	@Override
	public ArrayList<Question> findAllQuestions() {
		ArrayList<Question> list = DaoHandle.executeQuery("select * from questions order by courseid,qtype", null, Question.class);
		return list;
	}

	/**
	 * �޸�����
	 */
	@Override
	public void modifyQuestions(Question q) {
		DaoHandle.executeUpdate("update questions set courseid=?,qtitle=?,qtype=?,qanswer=?,qchoices=? where qid=?", new Object[]{q.getCourseId(),q.getqTitle(),q.getqType(),q.getqAnswer(),q.getqChoices(),q.getQid()});
	}

	/**
	 *  ɾ������
	 */
	@Override
	public void deleteQuestions(int qId) {
		DaoHandle.executeUpdate("delete from questions where qid=?", new Object[]{qId});
	}

	/**
	 * ���������Ų�������
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
	 * �������
	 */
	@Override
	public void addQuestion(Question q) {
		DaoHandle.executeUpdate("insert into questions values(seq_qtid.nextval,?,?,?,?,?)", new Object[]{q.getCourseId(),q.getqType(),q.getqTitle(),q.getqChoices(),q.getqAnswer()});
		
	}

	/**
	 * ���ݿγ̱�Ų�������
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
