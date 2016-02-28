package com.niit.entity;

public class Department {
	
	private int department_id;
	private String department_name;
	private int manager_id;
	
	public Department(){
		
	}
	
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int departmentId) {
		department_id = departmentId;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String departmentName) {
		department_name = departmentName;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int managerId) {
		manager_id = managerId;
	}
	
	

}
