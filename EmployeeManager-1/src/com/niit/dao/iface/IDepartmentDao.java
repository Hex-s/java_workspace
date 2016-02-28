package com.niit.dao.iface;

public interface IDepartmentDao {

	//通过部门编号查找部门名称
	public String findDepNameByDepId(int depID);

	//通过部门名称查找部门编号
	public int findDepIdByDepName(String depName);

}
