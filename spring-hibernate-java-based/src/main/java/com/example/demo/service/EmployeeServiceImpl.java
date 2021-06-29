package com.example.demo.service;


import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.ui.EmployeeRequestModel;
import com.example.demo.ui.EmployeeResponseModel;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDaoImpl;
	private ModelMapper modelMapper;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDaoImpl, ModelMapper modelMapper) {
		this.employeeDaoImpl = employeeDaoImpl;
		this.modelMapper = modelMapper;
	}


	//@Override
	public EmployeeResponseModel createEmployee(EmployeeRequestModel employeeDetails) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		EmployeeDto dto=modelMapper.map(employeeDetails, EmployeeDto.class);
		dto.setEmployeeId(UUID.randomUUID().toString());
		return employeeDaoImpl.createEmployee(dto);
	}

}
