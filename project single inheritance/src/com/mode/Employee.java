package com.model;

import java.util.Random;
import java.util.UUID;
public class Employee {
    private String EmployeeName;
    private double EmployeeSalary;
    private String EmployeebirthDate;

    public Employee(){

    }
    public Employee(double EmployeeSalary,String EmployeebirthDate) {
        this.EmployeeName = UUID.randomUUID().toString();
        Random random = new Random();
        int a = random.nextInt(10000);
        System.out.println(a);
        this.EmployeeSalary = EmployeeSalary;
        this.EmployeebirthDate = EmployeebirthDate;

    }
    public String getEmployeeName() {

        return EmployeeName;
    }
    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }
    public double getEmployeeSalary() {

        return EmployeeSalary;
    }
    public void setEmployeeSalary(double EmployeeSalary) {

        this.EmployeeSalary =EmployeeSalary;
    }
    public String getEmployeebirthDate() {

        return EmployeebirthDate;
    }
    public void SetEmployeebirthDate(String EmployeebirthDate) {

        this.EmployeebirthDate =EmployeebirthDate;
    }
    public String getDetails(){
        return "Name:"+getEmployeeName()+"Salary:"+getEmployeeSalary()+"date :"+getEmployeebirthDate();
    }
} 
