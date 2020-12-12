package com.cg.emppayroll.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.emppayroll.dto.EmployeePayrollDTO;

@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollData implements Serializable{
	
	private static final long serialVersionUID = -8900492704842756948L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="basic_pay")
	private String basic_pay;
	
	public EmployeePayrollData() {}
	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.setId(empPayrollDTO.getId());
		this.setName(empPayrollDTO.getName());
		this.setBasic_pay(empPayrollDTO.getBasic_pay());
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long employeeId) {
		this.id = employeeId;
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
	public void setBasic_pay(String salary){
		this.basic_pay = salary;
	}
	
	public EmployeePayrollData(String name,String salary) {
		this.name = name;
		this.basic_pay = salary;
	}
}
