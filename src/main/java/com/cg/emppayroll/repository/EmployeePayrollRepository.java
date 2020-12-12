package com.cg.emppayroll.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.emppayroll.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Long>{
	
}
