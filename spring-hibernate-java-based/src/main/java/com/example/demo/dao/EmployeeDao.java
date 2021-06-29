package com.example.demo.dao;


import java.util.List;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.ui.EmployeeRequestModel;
import com.example.demo.ui.EmployeeResponseModel;

public interface EmployeeDao {
	
	public EmployeeResponseModel createEmployee(EmployeeDto employeeDetails);
	
	public List<EmployeeResponseModel> displayAllEmployee();
	
	public EmployeeResponseModel findByEmployeeId(String employeeId);

}