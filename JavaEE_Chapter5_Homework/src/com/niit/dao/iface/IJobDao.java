package com.niit.dao.iface;

import com.niit.entity.Job;

public interface IJobDao {
	
	/**
	 * ���ݸ�λ��Ų��Ҹ�λ
	 * @param jobId
	 * @return
	 */
	public Job findJobTitleByJobId(String jobId);

}
