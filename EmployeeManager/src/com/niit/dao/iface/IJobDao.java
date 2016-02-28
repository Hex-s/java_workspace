package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Job;

public interface IJobDao {

	/**
	 * 通过部门编号查找部门名称
	 */
	public String findJobNameByJobId(String jobId);

	/**
	 * 通过部门名称查找部门编号
	 * @param jobName
	 * @return
	 */
	public String findJobIdByJobName(String jobName);
	
	/**
	 * 查找所有的岗位
	 * @return
	 */
	public ArrayList<Job> findAllJob();
}
