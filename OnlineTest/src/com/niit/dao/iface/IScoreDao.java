package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entiry.Score;

public interface IScoreDao {
	
	/**
	 * 根据学生编号查找学生成绩
	 * @return
	 */
	public ArrayList<Score> findScoreByStuId(int stuId);
	
	/**
	 * 根据班级编号查找成绩
	 * @param classId
	 * @return
	 */
	public ArrayList<Score> findScoreByClassId(int classId);

	
	/**
	 * 根据测试编号和班级编号查找平均成绩
	 * @param classId
	 * @param testId
	 * @return
	 */
	public Double findClassTestAvg(int classId,int testId);
	
	/**
	 * 插入成绩
	 * @param s
	 */
	public void addScore(Score s);
	
	/**
	 * 根据学号和测试编号判断是否有过考试记录
	 * @param testId
	 * @param stuId
	 */
	public Score findScoreByTidSid(int testId,int stuId);
	
	/**
	 * 查询班级平均成绩
	 * @return
	 */
	public ArrayList<Score> findAvgScore(int classId);
}
