package com.cg.emppayroll.services;

import java.util.List;

import com.cg.emppayroll.dto.EmployeePayrollDTO;
import com.cg.emppayroll.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	List<EmployeePayrollDTO> getAllUser();

	EmployeePayrollDTO createUser(EmployeePayrollDTO user);

	EmployeePayrollDTO updateUser(EmployeePayrollDTO user);

	EmployeePayrollDTO deleteUser(Long id);
}
