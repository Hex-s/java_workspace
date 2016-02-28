package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Score;

public interface IScoreDao {
	
	/**
	 * ����ѧ����Ų���ѧ���ɼ�
	 * @return
	 */
	public ArrayList<Score> findScoreByStuId(int stuId);
	
	/**
	 * ���ݰ༶��Ų��ҳɼ�
	 * @param classId
	 * @return
	 */
	public ArrayList<Score> findScoreByClassId(int classId);

	
	/**
	 * ���ݲ��Ա�źͰ༶��Ų���ƽ���ɼ�
	 * @param classId
	 * @param testId
	 * @return
	 */
	public Double findClassTestAvg(int classId,int testId);
	
	/**
	 * ����ɼ�
	 * @param s
	 */
	public void addScore(Score s);
	
	/**
	 * ����ѧ�źͲ��Ա���ж��Ƿ��й����Լ�¼
	 * @param testId
	 * @param stuId
	 */
	public Score findScoreByTidSid(int testId,int stuId);
	
	/**
	 * ��ѯ�༶ƽ���ɼ�
	 * @return
	 */
	public ArrayList<Score> findAvgScore(int classId);
}
