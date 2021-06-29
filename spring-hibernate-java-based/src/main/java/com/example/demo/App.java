package com.example.demo;


import java.util.List;

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
			/*
			 * EmployeeResponseModel model=service.createEmployee(new
			 * EmployeeRequestModel("Marry", "Public", "marry@email.com"));
			 * System.out.println(model);
			 * 
			 * List<EmployeeResponseModel> responseModels=service.displayAllEmployee();
			 * for(EmployeeResponseModel m: responseModels) { System.out.println(m); }
			 */
    	   EmployeeResponseModel model=service.findByEmployeeId("09ed6209-dfca-6f9-95fe-70a383e379dc");
    	   if(model==null)
    	   {
    		   System.out.println("no such employee found");
    	   }
    	   else
    	   {
    		   System.out.println(model);
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
    }
}