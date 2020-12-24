package com.cg.emppayroll.services;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.emppayroll.dto.EmployeePayrollDTO;
import com.cg.emppayroll.exceptions.DetailsNotProvidedExceptions;
import com.cg.emppayroll.exceptions.UserNotFound;
import com.cg.emppayroll.model.EmployeePayrollData;
import com.cg.emppayroll.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{	
	@Autowired
    private EmployeePayrollRepository employeePayrollRepository;
	
	@Override
	public List<EmployeePayrollDTO> getAllUser(){
		log.trace("Getting all users at service layer.");
		return employeePayrollRepository.findAll().stream()
				.map(employeePayroll -> new EmployeePayrollDTO(employeePayroll))
				.collect(Collectors.toList());
    }
	
	@Override
	public EmployeePayrollDTO createUser(EmployeePayrollDTO employeePayrollDTO) {
		log.trace("Creating user at service layer.");
		if(Objects.nonNull(employeePayrollDTO.getName()) && Objects.nonNull(employeePayrollDTO.getBasicPay())){
			EmployeePayrollData employeePayroll = new EmployeePayrollData(employeePayrollDTO.getName(), employeePayrollDTO.getBasicPay(),employeePayrollDTO.getGender(),employeePayrollDTO.getStartDate());
			return new EmployeePayrollDTO(employeePayrollRepository.save(employeePayroll));
		}
		throw new DetailsNotProvidedExceptions("Invalid Data");
	}
	
	@Override
	public EmployeePayrollDTO updateUser(EmployeePayrollDTO employeePayrollDTO) {
		log.trace("Updating user at service layer.");
		return employeePayrollRepository.findById(employeePayrollDTO.getId()).map(employeePayroll -> {
			if(Objects.nonNull(employeePayrollDTO.getName())) {
				employeePayroll.setName(employeePayrollDTO.getName());
			}
			if(Objects.nonNull(employeePayrollDTO.getBasicPay())) {
				employeePayroll.setBasicPay(employeePayrollDTO.getBasicPay());
			}
			return new EmployeePayrollDTO(employeePayrollRepository.save(employeePayroll));
		}).orElseThrow(() -> new UserNotFound("UserNotFound"));
	}
	
	@Override
	public EmployeePayrollDTO deleteUser(Long id) {
		log.trace("Deleting user with id {} at service layer.",id);
		return employeePayrollRepository.findById(id).map(employeePayroll -> {
			employeePayrollRepository.deleteById(employeePayroll.getId());
			return new EmployeePayrollDTO(employeePayroll);
		}).orElseThrow(() -> new UserNotFound("UserNOtFound"));
	}
}
