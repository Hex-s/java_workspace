package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.niit.dao.iface.IJobDao;
import com.niit.entity.Employee;
import com.niit.entity.Job;
import com.niit.util.DaoUtil;

public class JobDao implements IJobDao{
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public String findJobNameByJobId(String jobId) {
		String jobName = "";
		//获取连接
		con = DaoUtil.getConnection();
		try {
			pstmt = con.prepareStatement("select job_title from job where job_id=?");
			//注入参数
			pstmt.setString(1, jobId);
			//执行查询
			rs = pstmt.executeQuery();
			while(rs.next()){
				jobName = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoUtil.closeAll(con, pstmt, rs);
		}
		
		return jobName;
	}

	@Override
	public String findJobIdByJobName(String jobName) {
		String jobId = "";
		//获取连接
		con = DaoUtil.getConnection();
		try {
			pstmt = con.prepareStatement("select job_id from job where job_title=?");
			//注入参数
			pstmt.setString(1, jobName);
			//执行查询
			rs = pstmt.executeQuery();
			while(rs.next()){
				jobId = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoUtil.closeAll(con, pstmt, rs);
		}
		
		return jobId;
	}

	/**
	 * 查找所有的岗位
	 */
	@Override
	public ArrayList<Job> findAllJob() {
		ArrayList<Job> allJobs = new ArrayList<Job>();
		Job job = null;
		//获取连接
		con = DaoUtil.getConnection();
		try {
			//获取处理器
			pstmt = con.prepareStatement("select job_id,job_title from job");
			//执行查询
			rs = pstmt.executeQuery();
			while(rs.next()){
				job = new Job();
				job.setJobId(rs.getString(1));
				job.setJobName(rs.getString(2));
				allJobs.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoUtil.closeAll(con, pstmt, rs);
		}
		
		return allJobs;
	}

}
