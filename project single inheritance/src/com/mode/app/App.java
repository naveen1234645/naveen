package com.model.app;

import com.model.Employee;
import com.model.Engineer;
import com.model.Manager;
import com.model.Secretary;
import com.model.Director;
public class App {
    public static void main(String[] args)
    {
        Employee myEmployee=null;
        myEmployee =new Engineer("John",2000.00,"CSE");
        System.out.println(myEmployee.getDetails());
        myEmployee =new Manager("sam",456900.0,"IT");
        System.out.println(myEmployee.getDetails());
        myEmployee =new Secretary("gosh",45670.0,"ENV");
        System.out.println(myEmployee.getDetails());
        myEmployee =new Director(1400.0);
        System.out.println(myEmployee.getDetails());
    }
}