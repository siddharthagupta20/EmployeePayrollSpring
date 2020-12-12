package com.cg.emppayroll.dto;

import com.cg.emppayroll.model.EmployeePayrollData;

public class EmployeePayrollDTO {
	
	private Long id;
	private String name;
	private String basic_pay;
	
	public EmployeePayrollDTO(EmployeePayrollData employeePayroll) {
		this.setId(employeePayroll.getId());
		this.setName(employeePayroll.getName());
		this.setSalary(employeePayroll.getBasic_pay());
	}
	
	public EmployeePayrollDTO() {}
	
	public String toString() {
		return "Name ="+this.name+", salary="+this.basic_pay; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBasic_pay() {
		return basic_pay;
	}

	public void setSalary(String salary) {
		this.basic_pay = salary;
	}
}
