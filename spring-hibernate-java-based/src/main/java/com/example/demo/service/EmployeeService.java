package com.example.demo.service;

import com.example.demo.ui.EmployeeRequestModel;
import com.example.demo.ui.EmployeeResponseModel;

public interface EmployeeService {

	public EmployeeResponseModel createEmployee(EmployeeRequestModel employeeDetails);

}