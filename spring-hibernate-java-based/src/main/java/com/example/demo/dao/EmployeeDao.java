package com.example.demo.dao;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.ui.EmployeeRequestModel;
import com.example.demo.ui.EmployeeResponseModel;

public interface EmployeeDao {
	
	public EmployeeResponseModel createEmployee(EmployeeDto employeeDetails);

}