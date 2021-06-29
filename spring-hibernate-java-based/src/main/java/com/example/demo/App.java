package com.example.demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.ApplicationConfig;
import com.example.demo.service.EmployeeService;
import com.example.demo.ui.EmployeeRequestModel;
import com.example.demo.ui.EmployeeResponseModel;

public class App 
{
    public static void main( String[] args )
    {
       try {
    	   
    	   @SuppressWarnings("resource")
		ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationConfig.class);
    	   
    	   EmployeeService service=context.getBean("employeeServiceImpl",EmployeeService.class);
    	   EmployeeResponseModel model=service.createEmployee(new EmployeeRequestModel("John", "Doe", "john@email.com"));
    	   System.out.println(model);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
    }
}
