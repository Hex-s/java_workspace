package com.niit.entity;

import java.util.Date;

public class Employee {
	
	private int empId;
	private String empName;
	private double salary;
	private Date hireDate;
//	private String jobId;
//	private int depId;
//	private int magId;
	private String jobName;
	private String depName;
	private String magName;
	
	
	public Employee(){
		
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

//	public String getJobId() {
//		return jobId;
//	}
//
//	public void setJobId(String jobId) {
//		this.jobId = jobId;
//	}
//
//	public int getDepId() {
//		return depId;
//	}
//
//	public void setDepId(int depId) {
//		this.depId = depId;
//	}
//
//	public int getMagId() {
//		return magId;
//	}
//
//	public void setMagId(int magId) {
//		this.magId = magId;
//	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getMagName() {
		return magName;
	}

	public void setMagName(String magName) {
		this.magName = magName;
	}

	
	
	
	

}
