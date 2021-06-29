package com.example.demo.service;



import java.util.List;

import com.example.demo.ui.EmployeeRequestModel;
import com.example.demo.ui.EmployeeResponseModel;

public interface EmployeeService {
	public EmployeeResponseModel createEmployee(EmployeeRequestModel employeeDetails);
    public List<EmployeeResponseModel> displayAllEmployee();
    public EmployeeResponseModel findByEmployeeId(String employeeId);
    public EmployeeResponseModel updatebyId(String employeeId);
    public void deleteEmployee(String employeeId);

}