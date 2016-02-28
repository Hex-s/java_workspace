package com.niit.entity;

import java.sql.Timestamp;

public class Employee {

	private int emp_id;
	private String emp_name;
	private double salary;
	private Timestamp hire_date;
	private String job_id;
	private int dep_id;
	
	public Employee(){
		
	}
	
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int empId) {
		emp_id = empId;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String empName) {
		emp_name = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Timestamp getHire_date() {
		return hire_date;
	}
	public void setHire_date(Timestamp hireDate) {
		hire_date = hireDate;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String jobId) {
		job_id = jobId;
	}
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int depId) {
		dep_id = depId;
	}
	
	
	
}
