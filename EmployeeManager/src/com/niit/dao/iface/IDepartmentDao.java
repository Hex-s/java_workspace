package com.niit.dao.iface;

public interface IDepartmentDao {

	//ͨ�����ű�Ų��Ҳ�������
	public String findDepNameByDepId(int depID);

	//ͨ���������Ʋ��Ҳ��ű��
	public int findDepIdByDepName(String depName);

}
