package com.cg.emppayroll.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.emppayroll.dto.EmployeePayrollDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollData implements Serializable{
	
	private static final long serialVersionUID = -8900492704842756948L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String basicPay;
	
	@Column(name="gender")
	private Character gender;
	
	@Column
	private LocalDate startDate;
	
	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.setId(empPayrollDTO.getId());
		this.setName(empPayrollDTO.getName());
		this.setBasicPay(empPayrollDTO.getBasicPay());
	}

	public EmployeePayrollData(String name,String salary,Character gender, LocalDate startDate) {
		this.name = name;
		this.basicPay = salary;
		this.gender=gender;
		this.startDate=startDate;
	}
}
