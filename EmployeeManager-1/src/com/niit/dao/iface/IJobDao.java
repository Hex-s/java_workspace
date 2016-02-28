package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Job;

public interface IJobDao {

	/**
	 * ͨ�����ű�Ų��Ҳ�������
	 */
	public String findJobNameByJobId(String jobId);

	/**
	 * ͨ���������Ʋ��Ҳ��ű��
	 * @param jobName
	 * @return
	 */
	public String findJobIdByJobName(String jobName);
	
	/**
	 * �������еĸ�λ
	 * @return
	 */
	public ArrayList<Job> findAllJob();
}
