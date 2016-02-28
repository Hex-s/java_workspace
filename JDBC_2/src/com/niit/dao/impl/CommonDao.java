package com.niit.dao.impl;

import com.niit.util.DaoHandle;

public class CommonDao<T> {

	public void add(T t){
		//可以根据泛型T获取模板来反射出该类的名称和属性名称，由此构建SQL语句
		//DaoHandle.executeUpdate("", params)
	}
	public T findById(int id){
		return null;
	}
	
	public void update(T t){
		
	}
	public void delete(int id){
		
	}
}
