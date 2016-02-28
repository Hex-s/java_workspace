package com.niit.dao.iface;

import com.niit.entity.Job;

public interface IJobDao {
	
	/**
	 * 根据岗位编号查找岗位
	 * @param jobId
	 * @return
	 */
	public Job findJobTitleByJobId(String jobId);

}
