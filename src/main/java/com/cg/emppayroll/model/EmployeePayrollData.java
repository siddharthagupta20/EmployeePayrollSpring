package com.cg.emppayroll.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

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
	
	@Column(name="salary")
	private String salary;
	
	@Column(name="gender")
	private String gender;
	
	@Column
	private LocalDate startDate;
	
	@Column(name="profile_pic")
	private String profilePic;

	@Column(name="note")
	private String note;

	@ElementCollection
	@CollectionTable(name="employee_department",joinColumns = @JoinColumn(name="id"))
	@Column(name="department")       
	private List<String> departments;


	
	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.setId(empPayrollDTO.getId());
		this.setName(empPayrollDTO.getName());
		this.setSalary(empPayrollDTO.getSalary());
		this.updateEmployeePayrollData(empPayrollDTO);
	}
	
	private void updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.name = empPayrollDTO.getName();
		this.salary = empPayrollDTO.getSalary();
		this.gender = empPayrollDTO.getGender();
		this.startDate = empPayrollDTO.getStartDate();
		this.profilePic = empPayrollDTO.getProfilePic();
		this.note = empPayrollDTO.getNote();
		this.departments = empPayrollDTO.getDepartments();
	}

	public EmployeePayrollData(String name,String salary,String gender, LocalDate startDate) {
		this.name = name;
		this.salary = salary;
		this.gender=gender;
		this.startDate=startDate;
	}
}
