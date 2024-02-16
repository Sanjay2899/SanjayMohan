package com.gl.dbModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String employeeName;
	private String employeeAddress;
	private String employeePhone;
	private double employeeSalary;
	
	public Employee() {
		
	}
	

	public Employee(int empId, String employeeName, String employeeAddress, String employeePhone,
			double employeeSalary) {
		super();
		this.empId = empId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeePhone = employeePhone;
		this.employeeSalary = employeeSalary;
	}


	public Employee(String employeeName, String employeeAddress, String employeePhone,
			double employeeSalary) {
		super();
		
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeePhone = employeePhone;
		this.employeeSalary = employeeSalary;
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	

}
