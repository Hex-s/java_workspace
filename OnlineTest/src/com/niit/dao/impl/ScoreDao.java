package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.niit.dao.iface.IScoreDao;
import com.niit.entiry.Score;
import com.niit.util.DaoHandle;
import com.niit.util.DaoUtil;

public class ScoreDao implements IScoreDao{

	/**
	 * ����ѧ����Ų���ѧ���ɼ�
	 */
	@Override
	public ArrayList<Score> findScoreByStuId(int stuId) {
		ArrayList<Score> list = DaoHandle.executeQuery("select * from score where stuid=? order by scid", new Object[]{stuId}, Score.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	/**
	 * ���ݰ༶��Ų��ҳɼ�
	 */
	@Override
	public ArrayList<Score> findScoreByClassId(int classId) {
		
		
		ArrayList<Score> list = DaoHandle.executeQuery("select * from score where testid in (select testid from test where classid=?) and stuid in (select stuid from student where classid=?)", new Object[]{classId,classId}, Score.class);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	/**
	 * ���ݲ��Ա�źͰ༶��Ų���ƽ���ɼ�
	 */
	@Override
	public Double findClassTestAvg(int classId, int testId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		double avgScore = 0;
		//��ȡ����
		Connection con = DaoUtil.getConnection();
		
		try {
			//��ȡ������
			pstmt = con.prepareStatement("select round(avg(tscore)) as avgscore from score where testid=? and stuid in (select stuid from student where classid=?)");
			//ע�����
			pstmt.setInt(1, testId);
			pstmt.setInt(2, classId);
			//ִ��
			rs = pstmt.executeQuery();
			while(rs.next()){
				avgScore = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoUtil.closeAll(con, pstmt, rs);
		}
		
		return avgScore;
	}

	/**
	 * ����ɼ�
	 */
	@Override
	public void addScore(Score s) {
		DaoHandle.executeUpdate("insert into score values(seq_scid.nextval,?,?,?)", new Object[]{s.getStuId(),s.getTestId(),s.gettScore()});
		
	}

	/**
	 * ����ѧ�źͲ��Ա���ж��Ƿ��й����Լ�¼
	 */
	@Override
	public Score findScoreByTidSid(int testId, int stuId) {
		ArrayList<Score> list = DaoHandle.executeQuery("select * from score where stuid=? and testid=?", new Object[]{stuId,testId}, Score.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
		
	}

	/**
	 * ��ѯ�༶ƽ���ɼ�
	 */
	@Override
	public ArrayList<Score> findAvgScore(int classId) {
		ArrayList<Score> list = new ArrayList<Score>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//��ȡ����
		Connection con = DaoUtil.getConnection();
		
		try {
			//��ȡ������
			pstmt = con.prepareStatement("select testid,round(avg(tscore)) from score where stuid in(select stuid from student where classid=?) group by testid");
			//ע�����
			pstmt.setInt(1, classId);
			//ִ��
			rs = pstmt.executeQuery();
			while(rs.next()){
				Score s = new Score();
				s.setTestId(rs.getInt(1));
				s.settScore(rs.getInt(2));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoUtil.closeAll(con, pstmt, rs);
		}
		
		return list;
	}
	
	

}
