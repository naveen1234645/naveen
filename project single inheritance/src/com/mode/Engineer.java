package com.model;

public class Engineer extends Employee{
private String course;

public Engineer() {
    super();
}
public Engineer(String EmployeeName,double EmployeeSalary,String course)
{
super(EmployeeSalary,EmployeeName);
this.course = course;
}
public String getcourse(){
    return course;
}
public void setcourse(String course){
    this.course =course;
}
public String getDetails(){
    return super.getDetails()+ "course :"+getcourse();
}

}