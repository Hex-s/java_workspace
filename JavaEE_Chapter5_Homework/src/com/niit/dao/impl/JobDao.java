package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.dao.iface.IJobDao;
import com.niit.dao.util.DaoHandle;
import com.niit.entity.Job;

public class JobDao implements IJobDao{

	/**
	 * ���ݸ�λ��Ų��Ҹ�λ
	 */
	public Job findJobTitleByJobId(String jobId) {
		ArrayList<Job> list = DaoHandle.executeQuery("select * from job where upper(job_id)=upper(?)", new Object[]{jobId}, Job.class);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
