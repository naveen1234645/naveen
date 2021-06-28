package org.example.spring_jdbc;

import org.example.spring_jdbc.config.MyConfig;
import org.example.spring_jdbc.dao.EmployeeDao;
import org.example.spring_jdbc.dao.EmployeeDaoImpl;
import org.example.spring_jdbc.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       try {
    	   @SuppressWarnings("resource")
		ApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
    	   EmployeeDao employeeDao=context.getBean("employeeDaoImpl",EmployeeDaoImpl.class);
    	   Employee employee=new Employee(1, "John", "Doe", "john@email.com");
    	   System.out.println("employee Created\n"+employeeDao.createEmployee(employee));


	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
    }
}